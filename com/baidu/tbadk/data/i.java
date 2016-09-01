package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int asP = 1;
    private int asQ = 1;
    private int asR = 1;
    private int asS = 1;
    private int asT = 1;

    public int Ca() {
        return this.asQ;
    }

    public int Cb() {
        return this.asR;
    }

    public int Cc() {
        return this.asS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asP = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.asQ = jSONObject.optInt("like", 1);
            this.asR = jSONObject.optInt("group", 1);
            this.asS = jSONObject.optInt("post", 1);
            this.asT = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.asP = privSets.location.intValue();
                this.asQ = privSets.like.intValue();
                this.asR = privSets.group.intValue();
                this.asS = privSets.post.intValue();
                this.asT = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
