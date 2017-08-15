package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAS = 1;
    private int aAT = 1;
    private int aAU = 1;
    private int aAV = 1;
    private int aAW = 1;
    private int aAX = 1;

    public int Cx() {
        return this.aAT;
    }

    public int Cy() {
        return this.aAX;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAS = jSONObject.optInt("location", 1);
            this.aAT = jSONObject.optInt("like", 1);
            this.aAU = jSONObject.optInt("group", 1);
            this.aAV = jSONObject.optInt("post", 1);
            this.aAW = jSONObject.optInt("friend", 1);
            this.aAX = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAS = privSets.location.intValue();
                this.aAT = privSets.like.intValue();
                this.aAU = privSets.group.intValue();
                this.aAV = privSets.post.intValue();
                this.aAW = privSets.friend.intValue();
                this.aAX = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
