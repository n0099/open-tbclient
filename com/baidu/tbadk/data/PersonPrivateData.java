package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAc = 1;
    private int aAd = 1;
    private int aAe = 1;
    private int aAf = 1;
    private int aAg = 1;
    private int aAh = 1;

    public int Cq() {
        return this.aAd;
    }

    public int Cr() {
        return this.aAf;
    }

    public int Cs() {
        return this.aAh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAc = jSONObject.optInt("location", 1);
            this.aAd = jSONObject.optInt("like", 1);
            this.aAe = jSONObject.optInt("group", 1);
            this.aAf = jSONObject.optInt("post", 1);
            this.aAg = jSONObject.optInt("friend", 1);
            this.aAh = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAc = privSets.location.intValue();
                this.aAd = privSets.like.intValue();
                this.aAe = privSets.group.intValue();
                this.aAf = privSets.post.intValue();
                this.aAg = privSets.friend.intValue();
                this.aAh = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
