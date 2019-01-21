package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aXP = 1;
    private int aXQ = 1;
    private int aXR = 1;
    private int aXS = 1;
    private int aXT = 1;
    private int aXU = 1;

    public int LQ() {
        return this.aXQ;
    }

    public int LR() {
        return this.aXU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXP = jSONObject.optInt(Headers.LOCATION, 1);
            this.aXQ = jSONObject.optInt("like", 1);
            this.aXR = jSONObject.optInt("group", 1);
            this.aXS = jSONObject.optInt("post", 1);
            this.aXT = jSONObject.optInt("friend", 1);
            this.aXU = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aXP = privSets.location.intValue();
                this.aXQ = privSets.like.intValue();
                this.aXR = privSets.group.intValue();
                this.aXS = privSets.post.intValue();
                this.aXT = privSets.friend.intValue();
                this.aXU = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
