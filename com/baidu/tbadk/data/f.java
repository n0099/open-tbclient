package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class f extends i {
    private int apy = 1;
    private int apz = 1;
    private int apA = 1;
    private int apB = 1;
    private int apC = 1;

    public int AW() {
        return this.apz;
    }

    public int AX() {
        return this.apA;
    }

    public int AY() {
        return this.apB;
    }

    public int AZ() {
        return this.apC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.apy = jSONObject.optInt("location", 1);
            this.apz = jSONObject.optInt("like", 1);
            this.apA = jSONObject.optInt("group", 1);
            this.apB = jSONObject.optInt("post", 1);
            this.apC = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.apy = privSets.location.intValue();
                this.apz = privSets.like.intValue();
                this.apA = privSets.group.intValue();
                this.apB = privSets.post.intValue();
                this.apC = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
