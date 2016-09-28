package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int asA = 1;
    private int asB = 1;
    private int asC = 1;
    private int asD = 1;
    private int asE = 1;

    public int Cd() {
        return this.asB;
    }

    public int Ce() {
        return this.asC;
    }

    public int Cf() {
        return this.asD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asA = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.asB = jSONObject.optInt("like", 1);
            this.asC = jSONObject.optInt("group", 1);
            this.asD = jSONObject.optInt("post", 1);
            this.asE = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.asA = privSets.location.intValue();
                this.asB = privSets.like.intValue();
                this.asC = privSets.group.intValue();
                this.asD = privSets.post.intValue();
                this.asE = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
