package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int anE = 1;
    private int anF = 1;
    private int anG = 1;
    private int anH = 1;
    private int anI = 1;

    public int zV() {
        return this.anE;
    }

    public int zW() {
        return this.anF;
    }

    public int zX() {
        return this.anG;
    }

    public int zY() {
        return this.anH;
    }

    public int zZ() {
        return this.anI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.anE = jSONObject.optInt("location", 1);
            this.anF = jSONObject.optInt("like", 1);
            this.anG = jSONObject.optInt("group", 1);
            this.anH = jSONObject.optInt("post", 1);
            this.anI = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.anE = privSets.location.intValue();
                this.anF = privSets.like.intValue();
                this.anG = privSets.group.intValue();
                this.anH = privSets.post.intValue();
                this.anI = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
