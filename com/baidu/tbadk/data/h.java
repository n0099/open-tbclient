package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int ahl = 1;
    private int ahm = 1;
    private int ahn = 1;
    private int aho = 1;
    private int ahp = 1;

    public int yc() {
        return this.ahl;
    }

    public int yd() {
        return this.ahm;
    }

    public int ye() {
        return this.ahn;
    }

    public int yf() {
        return this.aho;
    }

    public int yg() {
        return this.ahp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ahl = jSONObject.optInt("location", 1);
            this.ahm = jSONObject.optInt("like", 1);
            this.ahn = jSONObject.optInt("group", 1);
            this.aho = jSONObject.optInt("post", 1);
            this.ahp = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.ahl = privSets.location.intValue();
                this.ahm = privSets.like.intValue();
                this.ahn = privSets.group.intValue();
                this.aho = privSets.post.intValue();
                this.ahp = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
