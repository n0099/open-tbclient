package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int WX = 1;
    private int WY = 1;
    private int WZ = 1;
    private int Xa = 1;
    private int Xb = 1;

    public int uG() {
        return this.WX;
    }

    public int uH() {
        return this.WY;
    }

    public int uI() {
        return this.WZ;
    }

    public int uJ() {
        return this.Xa;
    }

    public int uK() {
        return this.Xb;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.WX = jSONObject.optInt("location", 1);
            this.WY = jSONObject.optInt("like", 1);
            this.WZ = jSONObject.optInt("group", 1);
            this.Xa = jSONObject.optInt("post", 1);
            this.Xb = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.WX = privSets.location.intValue();
                this.WY = privSets.like.intValue();
                this.WZ = privSets.group.intValue();
                this.Xa = privSets.post.intValue();
                this.Xb = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
