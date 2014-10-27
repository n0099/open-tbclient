package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class c extends i {
    private int Qr = 1;
    private int Qs = 1;
    private int Qt = 1;
    private int Qu = 1;
    private int Qv = 1;

    public int qR() {
        return this.Qr;
    }

    public int qS() {
        return this.Qs;
    }

    public int qT() {
        return this.Qt;
    }

    public int qU() {
        return this.Qu;
    }

    public int qV() {
        return this.Qv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Qr = jSONObject.optInt("location", 1);
            this.Qs = jSONObject.optInt("like", 1);
            this.Qt = jSONObject.optInt("group", 1);
            this.Qu = jSONObject.optInt("post", 1);
            this.Qv = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.Qr = privSets.location.intValue();
                this.Qs = privSets.like.intValue();
                this.Qt = privSets.group.intValue();
                this.Qu = privSets.post.intValue();
                this.Qv = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
