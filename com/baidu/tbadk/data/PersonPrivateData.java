package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aAe = 1;
    private int aAf = 1;
    private int aAg = 1;
    private int aAh = 1;
    private int aAi = 1;
    private int aAj = 1;

    public int Cs() {
        return this.aAf;
    }

    public int Ct() {
        return this.aAj;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAe = jSONObject.optInt("location", 1);
            this.aAf = jSONObject.optInt("like", 1);
            this.aAg = jSONObject.optInt("group", 1);
            this.aAh = jSONObject.optInt("post", 1);
            this.aAi = jSONObject.optInt("friend", 1);
            this.aAj = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aAe = privSets.location.intValue();
                this.aAf = privSets.like.intValue();
                this.aAg = privSets.group.intValue();
                this.aAh = privSets.post.intValue();
                this.aAi = privSets.friend.intValue();
                this.aAj = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
