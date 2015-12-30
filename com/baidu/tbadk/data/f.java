package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int arb = 1;
    private int arc = 1;
    private int ard = 1;
    private int are = 1;
    private int arf = 1;

    public int AM() {
        return this.arc;
    }

    public int AN() {
        return this.ard;
    }

    public int AO() {
        return this.are;
    }

    public int AP() {
        return this.arf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arb = jSONObject.optInt("location", 1);
            this.arc = jSONObject.optInt("like", 1);
            this.ard = jSONObject.optInt("group", 1);
            this.are = jSONObject.optInt("post", 1);
            this.arf = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.arb = privSets.location.intValue();
                this.arc = privSets.like.intValue();
                this.ard = privSets.group.intValue();
                this.are = privSets.post.intValue();
                this.arf = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
