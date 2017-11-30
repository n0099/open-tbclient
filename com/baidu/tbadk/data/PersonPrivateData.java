package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAD = 1;
    private int aAE = 1;
    private int aAF = 1;
    private int aAG = 1;
    private int aAH = 1;
    private int aAI = 1;

    public int CA() {
        return this.aAE;
    }

    public int CB() {
        return this.aAI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAD = jSONObject.optInt("location", 1);
            this.aAE = jSONObject.optInt("like", 1);
            this.aAF = jSONObject.optInt("group", 1);
            this.aAG = jSONObject.optInt("post", 1);
            this.aAH = jSONObject.optInt("friend", 1);
            this.aAI = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAD = privSets.location.intValue();
                this.aAE = privSets.like.intValue();
                this.aAF = privSets.group.intValue();
                this.aAG = privSets.post.intValue();
                this.aAH = privSets.friend.intValue();
                this.aAI = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
