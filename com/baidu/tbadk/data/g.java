package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class g extends i {
    private int aso = 1;
    private int asp = 1;
    private int asq = 1;
    private int asr = 1;
    private int ass = 1;

    public int CH() {
        return this.asp;
    }

    public int CI() {
        return this.asq;
    }

    public int CJ() {
        return this.asr;
    }

    public int CK() {
        return this.ass;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aso = jSONObject.optInt("location", 1);
            this.asp = jSONObject.optInt("like", 1);
            this.asq = jSONObject.optInt("group", 1);
            this.asr = jSONObject.optInt("post", 1);
            this.ass = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aso = privSets.location.intValue();
                this.asp = privSets.like.intValue();
                this.asq = privSets.group.intValue();
                this.asr = privSets.post.intValue();
                this.ass = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
