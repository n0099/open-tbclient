package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.b.a.a.i {
    private int aoU = 1;
    private int aoV = 1;
    private int aoW = 1;
    private int aoX = 1;
    private int aoY = 1;

    public int AL() {
        return this.aoV;
    }

    public int AM() {
        return this.aoW;
    }

    public int AN() {
        return this.aoX;
    }

    public int AO() {
        return this.aoY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoU = jSONObject.optInt(ThActivityDetailActivityConfig.LOCATION, 1);
            this.aoV = jSONObject.optInt("like", 1);
            this.aoW = jSONObject.optInt("group", 1);
            this.aoX = jSONObject.optInt("post", 1);
            this.aoY = jSONObject.optInt("friend", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aoU = privSets.location.intValue();
                this.aoV = privSets.like.intValue();
                this.aoW = privSets.group.intValue();
                this.aoX = privSets.post.intValue();
                this.aoY = privSets.friend.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
