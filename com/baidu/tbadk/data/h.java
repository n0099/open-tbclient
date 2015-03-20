package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int ahd = 1;
    private int ahe = 1;
    private int ahf = 1;
    private int ahg = 1;
    private int ahh = 1;

    public int xW() {
        return this.ahd;
    }

    public int xX() {
        return this.ahe;
    }

    public int xY() {
        return this.ahf;
    }

    public int xZ() {
        return this.ahg;
    }

    public int ya() {
        return this.ahh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ahd = jSONObject.optInt("location", 1);
            this.ahe = jSONObject.optInt("like", 1);
            this.ahf = jSONObject.optInt("group", 1);
            this.ahg = jSONObject.optInt("post", 1);
            this.ahh = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.ahd = privSets.location.intValue();
                this.ahe = privSets.like.intValue();
                this.ahf = privSets.group.intValue();
                this.ahg = privSets.post.intValue();
                this.ahh = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
