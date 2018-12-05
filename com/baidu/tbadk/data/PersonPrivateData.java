package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aXd = 1;
    private int aXe = 1;
    private int aXf = 1;
    private int aXg = 1;
    private int aXh = 1;
    private int aXi = 1;

    public int LA() {
        return this.aXe;
    }

    public int LB() {
        return this.aXi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXd = jSONObject.optInt(Headers.LOCATION, 1);
            this.aXe = jSONObject.optInt("like", 1);
            this.aXf = jSONObject.optInt("group", 1);
            this.aXg = jSONObject.optInt("post", 1);
            this.aXh = jSONObject.optInt("friend", 1);
            this.aXi = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aXd = privSets.location.intValue();
                this.aXe = privSets.like.intValue();
                this.aXf = privSets.group.intValue();
                this.aXg = privSets.post.intValue();
                this.aXh = privSets.friend.intValue();
                this.aXi = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
