package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fBy = 1;
    private int fBz = 1;
    private int fBA = 1;
    private int fBB = 1;
    private int fBC = 1;
    private int fBD = 1;

    public int bAE() {
        return this.fBz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fBy = jSONObject.optInt(Headers.LOCATION, 1);
            this.fBz = jSONObject.optInt("like", 1);
            this.fBA = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fBB = jSONObject.optInt("post", 1);
            this.fBC = jSONObject.optInt("friend", 1);
            this.fBD = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fBy = privSets.location.intValue();
                this.fBz = privSets.like.intValue();
                this.fBA = privSets.group.intValue();
                this.fBB = privSets.post.intValue();
                this.fBC = privSets.friend.intValue();
                this.fBD = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
