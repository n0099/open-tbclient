package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aJY = 1;
    private int aJZ = 1;
    private int aKa = 1;
    private int aKb = 1;
    private int aKc = 1;
    private int aKd = 1;

    public int GH() {
        return this.aJZ;
    }

    public int GI() {
        return this.aKd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJY = jSONObject.optInt(Headers.LOCATION, 1);
            this.aJZ = jSONObject.optInt("like", 1);
            this.aKa = jSONObject.optInt("group", 1);
            this.aKb = jSONObject.optInt("post", 1);
            this.aKc = jSONObject.optInt("friend", 1);
            this.aKd = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aJY = privSets.location.intValue();
                this.aJZ = privSets.like.intValue();
                this.aKa = privSets.group.intValue();
                this.aKb = privSets.post.intValue();
                this.aKc = privSets.friend.intValue();
                this.aKd = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
