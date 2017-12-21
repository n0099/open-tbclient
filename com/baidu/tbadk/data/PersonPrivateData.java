package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAL = 1;
    private int aAM = 1;
    private int aAN = 1;
    private int aAO = 1;
    private int aAP = 1;
    private int aAQ = 1;

    public int CB() {
        return this.aAM;
    }

    public int CC() {
        return this.aAQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAL = jSONObject.optInt("location", 1);
            this.aAM = jSONObject.optInt("like", 1);
            this.aAN = jSONObject.optInt("group", 1);
            this.aAO = jSONObject.optInt("post", 1);
            this.aAP = jSONObject.optInt("friend", 1);
            this.aAQ = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAL = privSets.location.intValue();
                this.aAM = privSets.like.intValue();
                this.aAN = privSets.group.intValue();
                this.aAO = privSets.post.intValue();
                this.aAP = privSets.friend.intValue();
                this.aAQ = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
