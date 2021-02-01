package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fzZ = 1;
    private int fAa = 1;
    private int fAb = 1;
    private int fAc = 1;
    private int fAd = 1;
    private int fAe = 1;

    public int bAB() {
        return this.fAa;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fzZ = jSONObject.optInt(Headers.LOCATION, 1);
            this.fAa = jSONObject.optInt("like", 1);
            this.fAb = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fAc = jSONObject.optInt("post", 1);
            this.fAd = jSONObject.optInt("friend", 1);
            this.fAe = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fzZ = privSets.location.intValue();
                this.fAa = privSets.like.intValue();
                this.fAb = privSets.group.intValue();
                this.fAc = privSets.post.intValue();
                this.fAd = privSets.friend.intValue();
                this.fAe = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
