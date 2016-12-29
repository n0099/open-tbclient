package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int asX = 1;
    private int asY = 1;
    private int asZ = 1;
    private int ata = 1;
    private int atb = 1;

    public int BW() {
        return this.asY;
    }

    public int BX() {
        return this.asZ;
    }

    public int BY() {
        return this.ata;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asX = jSONObject.optInt("location", 1);
            this.asY = jSONObject.optInt("like", 1);
            this.asZ = jSONObject.optInt("group", 1);
            this.ata = jSONObject.optInt("post", 1);
            this.atb = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.asX = privSets.location.intValue();
                this.asY = privSets.like.intValue();
                this.asZ = privSets.group.intValue();
                this.ata = privSets.post.intValue();
                this.atb = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
