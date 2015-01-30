package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int Xa = 1;
    private int Xb = 1;
    private int Xc = 1;
    private int Xd = 1;
    private int Xe = 1;

    public int uM() {
        return this.Xa;
    }

    public int uN() {
        return this.Xb;
    }

    public int uO() {
        return this.Xc;
    }

    public int uP() {
        return this.Xd;
    }

    public int uQ() {
        return this.Xe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Xa = jSONObject.optInt("location", 1);
            this.Xb = jSONObject.optInt("like", 1);
            this.Xc = jSONObject.optInt("group", 1);
            this.Xd = jSONObject.optInt("post", 1);
            this.Xe = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.Xa = privSets.location.intValue();
                this.Xb = privSets.like.intValue();
                this.Xc = privSets.group.intValue();
                this.Xd = privSets.post.intValue();
                this.Xe = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
