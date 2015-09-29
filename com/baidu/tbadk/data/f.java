package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int anD = 1;
    private int anE = 1;
    private int anF = 1;
    private int anG = 1;
    private int anH = 1;

    public int zY() {
        return this.anD;
    }

    public int zZ() {
        return this.anE;
    }

    public int Aa() {
        return this.anF;
    }

    public int Ab() {
        return this.anG;
    }

    public int Ac() {
        return this.anH;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anD = jSONObject.optInt("location", 1);
            this.anE = jSONObject.optInt("like", 1);
            this.anF = jSONObject.optInt("group", 1);
            this.anG = jSONObject.optInt("post", 1);
            this.anH = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.anD = privSets.location.intValue();
                this.anE = privSets.like.intValue();
                this.anF = privSets.group.intValue();
                this.anG = privSets.post.intValue();
                this.anH = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
