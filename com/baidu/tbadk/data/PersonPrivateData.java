package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAI = 1;
    private int aAJ = 1;
    private int aAK = 1;
    private int aAL = 1;
    private int aAM = 1;
    private int aAN = 1;

    public int CB() {
        return this.aAJ;
    }

    public int CC() {
        return this.aAN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAI = jSONObject.optInt("location", 1);
            this.aAJ = jSONObject.optInt("like", 1);
            this.aAK = jSONObject.optInt("group", 1);
            this.aAL = jSONObject.optInt("post", 1);
            this.aAM = jSONObject.optInt("friend", 1);
            this.aAN = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAI = privSets.location.intValue();
                this.aAJ = privSets.like.intValue();
                this.aAK = privSets.group.intValue();
                this.aAL = privSets.post.intValue();
                this.aAM = privSets.friend.intValue();
                this.aAN = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
