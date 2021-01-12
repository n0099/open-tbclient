package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fxJ = 1;
    private int fxK = 1;
    private int fxL = 1;
    private int fxM = 1;
    private int fxN = 1;
    private int fxO = 1;

    public int bAj() {
        return this.fxK;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fxJ = jSONObject.optInt(Headers.LOCATION, 1);
            this.fxK = jSONObject.optInt("like", 1);
            this.fxL = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fxM = jSONObject.optInt("post", 1);
            this.fxN = jSONObject.optInt("friend", 1);
            this.fxO = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fxJ = privSets.location.intValue();
                this.fxK = privSets.like.intValue();
                this.fxL = privSets.group.intValue();
                this.fxM = privSets.post.intValue();
                this.fxN = privSets.friend.intValue();
                this.fxO = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
