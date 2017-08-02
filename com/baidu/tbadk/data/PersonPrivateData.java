package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int azA = 1;
    private int azB = 1;
    private int azC = 1;
    private int azD = 1;
    private int azE = 1;
    private int azF = 1;

    public int Cp() {
        return this.azB;
    }

    public int Cq() {
        return this.azF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azA = jSONObject.optInt("location", 1);
            this.azB = jSONObject.optInt("like", 1);
            this.azC = jSONObject.optInt("group", 1);
            this.azD = jSONObject.optInt("post", 1);
            this.azE = jSONObject.optInt("friend", 1);
            this.azF = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.azA = privSets.location.intValue();
                this.azB = privSets.like.intValue();
                this.azC = privSets.group.intValue();
                this.azD = privSets.post.intValue();
                this.azE = privSets.friend.intValue();
                this.azF = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
