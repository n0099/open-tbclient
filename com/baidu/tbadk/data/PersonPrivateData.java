package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aXg = 1;
    private int aXh = 1;
    private int aXi = 1;
    private int aXj = 1;
    private int aXk = 1;
    private int aXl = 1;

    public int LB() {
        return this.aXh;
    }

    public int LC() {
        return this.aXl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXg = jSONObject.optInt(Headers.LOCATION, 1);
            this.aXh = jSONObject.optInt("like", 1);
            this.aXi = jSONObject.optInt("group", 1);
            this.aXj = jSONObject.optInt("post", 1);
            this.aXk = jSONObject.optInt("friend", 1);
            this.aXl = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aXg = privSets.location.intValue();
                this.aXh = privSets.like.intValue();
                this.aXi = privSets.group.intValue();
                this.aXj = privSets.post.intValue();
                this.aXk = privSets.friend.intValue();
                this.aXl = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
