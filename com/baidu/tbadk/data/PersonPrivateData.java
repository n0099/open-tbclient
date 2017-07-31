package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAR = 1;
    private int aAS = 1;
    private int aAT = 1;
    private int aAU = 1;
    private int aAV = 1;
    private int aAW = 1;

    public int Cx() {
        return this.aAS;
    }

    public int Cy() {
        return this.aAW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAR = jSONObject.optInt("location", 1);
            this.aAS = jSONObject.optInt("like", 1);
            this.aAT = jSONObject.optInt("group", 1);
            this.aAU = jSONObject.optInt("post", 1);
            this.aAV = jSONObject.optInt("friend", 1);
            this.aAW = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAR = privSets.location.intValue();
                this.aAS = privSets.like.intValue();
                this.aAT = privSets.group.intValue();
                this.aAU = privSets.post.intValue();
                this.aAV = privSets.friend.intValue();
                this.aAW = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
