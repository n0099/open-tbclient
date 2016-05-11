package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.a.b.a.a.i {
    private int aoe = 1;
    private int aof = 1;
    private int aog = 1;
    private int aoh = 1;
    private int aoi = 1;

    public int AB() {
        return this.aof;
    }

    public int AC() {
        return this.aog;
    }

    public int AD() {
        return this.aoh;
    }

    public int AE() {
        return this.aoi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoe = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.aof = jSONObject.optInt("like", 1);
            this.aog = jSONObject.optInt("group", 1);
            this.aoh = jSONObject.optInt("post", 1);
            this.aoi = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aoe = privSets.location.intValue();
                this.aof = privSets.like.intValue();
                this.aog = privSets.group.intValue();
                this.aoh = privSets.post.intValue();
                this.aoi = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
