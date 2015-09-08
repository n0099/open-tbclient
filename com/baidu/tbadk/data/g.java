package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class g extends i {
    private int apd = 1;
    private int ape = 1;
    private int apf = 1;
    private int apg = 1;
    private int aph = 1;

    public int An() {
        return this.apd;
    }

    public int Ao() {
        return this.ape;
    }

    public int Ap() {
        return this.apf;
    }

    public int Aq() {
        return this.apg;
    }

    public int Ar() {
        return this.aph;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apd = jSONObject.optInt("location", 1);
            this.ape = jSONObject.optInt("like", 1);
            this.apf = jSONObject.optInt("group", 1);
            this.apg = jSONObject.optInt("post", 1);
            this.aph = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.apd = privSets.location.intValue();
                this.ape = privSets.like.intValue();
                this.apf = privSets.group.intValue();
                this.apg = privSets.post.intValue();
                this.aph = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
