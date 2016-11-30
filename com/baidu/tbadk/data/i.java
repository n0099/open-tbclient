package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.b.a.a.i {
    private int atu = 1;
    private int atv = 1;
    private int atw = 1;
    private int atx = 1;
    private int aty = 1;

    public int Cj() {
        return this.atv;
    }

    public int Ck() {
        return this.atw;
    }

    public int Cl() {
        return this.atx;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.atu = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.atv = jSONObject.optInt("like", 1);
            this.atw = jSONObject.optInt("group", 1);
            this.atx = jSONObject.optInt("post", 1);
            this.aty = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.atu = privSets.location.intValue();
                this.atv = privSets.like.intValue();
                this.atw = privSets.group.intValue();
                this.atx = privSets.post.intValue();
                this.aty = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
