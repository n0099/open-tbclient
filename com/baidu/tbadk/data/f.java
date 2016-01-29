package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int arU = 1;
    private int arV = 1;
    private int arW = 1;
    private int arX = 1;
    private int arY = 1;

    public int Cc() {
        return this.arV;
    }

    public int Cd() {
        return this.arW;
    }

    public int Ce() {
        return this.arX;
    }

    public int Cf() {
        return this.arY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.arU = jSONObject.optInt("location", 1);
            this.arV = jSONObject.optInt("like", 1);
            this.arW = jSONObject.optInt("group", 1);
            this.arX = jSONObject.optInt("post", 1);
            this.arY = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.arU = privSets.location.intValue();
                this.arV = privSets.like.intValue();
                this.arW = privSets.group.intValue();
                this.arX = privSets.post.intValue();
                this.arY = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
