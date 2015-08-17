package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class g extends i {
    private int anr = 1;
    private int ans = 1;
    private int ant = 1;
    private int anu = 1;
    private int anv = 1;

    public int Aa() {
        return this.anr;
    }

    public int Ab() {
        return this.ans;
    }

    public int Ac() {
        return this.ant;
    }

    public int Ad() {
        return this.anu;
    }

    public int Ae() {
        return this.anv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anr = jSONObject.optInt("location", 1);
            this.ans = jSONObject.optInt("like", 1);
            this.ant = jSONObject.optInt("group", 1);
            this.anu = jSONObject.optInt("post", 1);
            this.anv = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.anr = privSets.location.intValue();
                this.ans = privSets.like.intValue();
                this.ant = privSets.group.intValue();
                this.anu = privSets.post.intValue();
                this.anv = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
