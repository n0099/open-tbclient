package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.b.a.a.i {
    private int apK = 1;
    private int apL = 1;
    private int apM = 1;
    private int apN = 1;
    private int apO = 1;

    public int AL() {
        return this.apL;
    }

    public int AM() {
        return this.apM;
    }

    public int AN() {
        return this.apN;
    }

    public int AO() {
        return this.apO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apK = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.apL = jSONObject.optInt("like", 1);
            this.apM = jSONObject.optInt("group", 1);
            this.apN = jSONObject.optInt("post", 1);
            this.apO = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.apK = privSets.location.intValue();
                this.apL = privSets.like.intValue();
                this.apM = privSets.group.intValue();
                this.apN = privSets.post.intValue();
                this.apO = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
