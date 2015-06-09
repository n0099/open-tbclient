package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int aim = 1;
    private int ain = 1;
    private int aio = 1;
    private int aip = 1;
    private int aiq = 1;

    public int yQ() {
        return this.aim;
    }

    public int yR() {
        return this.ain;
    }

    public int yS() {
        return this.aio;
    }

    public int yT() {
        return this.aip;
    }

    public int yU() {
        return this.aiq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aim = jSONObject.optInt("location", 1);
            this.ain = jSONObject.optInt("like", 1);
            this.aio = jSONObject.optInt("group", 1);
            this.aip = jSONObject.optInt("post", 1);
            this.aiq = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aim = privSets.location.intValue();
                this.ain = privSets.like.intValue();
                this.aio = privSets.group.intValue();
                this.aip = privSets.post.intValue();
                this.aiq = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
