package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends i {
    private int Wv = 1;
    private int Ww = 1;
    private int Wx = 1;
    private int Wy = 1;
    private int Wz = 1;

    public int uv() {
        return this.Wv;
    }

    public int uw() {
        return this.Ww;
    }

    public int ux() {
        return this.Wx;
    }

    public int uy() {
        return this.Wy;
    }

    public int uz() {
        return this.Wz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Wv = jSONObject.optInt("location", 1);
            this.Ww = jSONObject.optInt("like", 1);
            this.Wx = jSONObject.optInt("group", 1);
            this.Wy = jSONObject.optInt("post", 1);
            this.Wz = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.Wv = privSets.location.intValue();
                this.Ww = privSets.like.intValue();
                this.Wx = privSets.group.intValue();
                this.Wy = privSets.post.intValue();
                this.Wz = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
