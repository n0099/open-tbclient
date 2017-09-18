package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAb = 1;
    private int aAc = 1;
    private int aAd = 1;
    private int aAe = 1;
    private int aAf = 1;
    private int aAg = 1;

    public int Cs() {
        return this.aAc;
    }

    public int Ct() {
        return this.aAg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAb = jSONObject.optInt("location", 1);
            this.aAc = jSONObject.optInt("like", 1);
            this.aAd = jSONObject.optInt("group", 1);
            this.aAe = jSONObject.optInt("post", 1);
            this.aAf = jSONObject.optInt("friend", 1);
            this.aAg = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAb = privSets.location.intValue();
                this.aAc = privSets.like.intValue();
                this.aAd = privSets.group.intValue();
                this.aAe = privSets.post.intValue();
                this.aAf = privSets.friend.intValue();
                this.aAg = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
