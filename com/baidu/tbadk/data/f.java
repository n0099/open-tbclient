package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int anJ = 1;
    private int anK = 1;
    private int anL = 1;
    private int anM = 1;
    private int anN = 1;

    public int Aa() {
        return this.anJ;
    }

    public int Ab() {
        return this.anK;
    }

    public int Ac() {
        return this.anL;
    }

    public int Ad() {
        return this.anM;
    }

    public int Ae() {
        return this.anN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anJ = jSONObject.optInt("location", 1);
            this.anK = jSONObject.optInt("like", 1);
            this.anL = jSONObject.optInt("group", 1);
            this.anM = jSONObject.optInt("post", 1);
            this.anN = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.anJ = privSets.location.intValue();
                this.anK = privSets.like.intValue();
                this.anL = privSets.group.intValue();
                this.anM = privSets.post.intValue();
                this.anN = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
