package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAT = 1;
    private int aAU = 1;
    private int aAV = 1;
    private int aAW = 1;
    private int aAX = 1;
    private int aAY = 1;

    public int Cx() {
        return this.aAU;
    }

    public int Cy() {
        return this.aAY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAT = jSONObject.optInt("location", 1);
            this.aAU = jSONObject.optInt("like", 1);
            this.aAV = jSONObject.optInt("group", 1);
            this.aAW = jSONObject.optInt("post", 1);
            this.aAX = jSONObject.optInt("friend", 1);
            this.aAY = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAT = privSets.location.intValue();
                this.aAU = privSets.like.intValue();
                this.aAV = privSets.group.intValue();
                this.aAW = privSets.post.intValue();
                this.aAX = privSets.friend.intValue();
                this.aAY = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
