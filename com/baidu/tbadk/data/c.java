package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class c extends i {
    private int Qv = 1;
    private int Qw = 1;
    private int Qx = 1;
    private int Qy = 1;
    private int Qz = 1;

    public int qT() {
        return this.Qv;
    }

    public int qU() {
        return this.Qw;
    }

    public int qV() {
        return this.Qx;
    }

    public int qW() {
        return this.Qy;
    }

    public int qX() {
        return this.Qz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Qv = jSONObject.optInt("location", 1);
            this.Qw = jSONObject.optInt("like", 1);
            this.Qx = jSONObject.optInt("group", 1);
            this.Qy = jSONObject.optInt("post", 1);
            this.Qz = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.Qv = privSets.location.intValue();
                this.Qw = privSets.like.intValue();
                this.Qx = privSets.group.intValue();
                this.Qy = privSets.post.intValue();
                this.Qz = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
