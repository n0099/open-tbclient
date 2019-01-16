package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aXO = 1;
    private int aXP = 1;
    private int aXQ = 1;
    private int aXR = 1;
    private int aXS = 1;
    private int aXT = 1;

    public int LQ() {
        return this.aXP;
    }

    public int LR() {
        return this.aXT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aXO = jSONObject.optInt(Headers.LOCATION, 1);
            this.aXP = jSONObject.optInt("like", 1);
            this.aXQ = jSONObject.optInt("group", 1);
            this.aXR = jSONObject.optInt("post", 1);
            this.aXS = jSONObject.optInt("friend", 1);
            this.aXT = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aXO = privSets.location.intValue();
                this.aXP = privSets.like.intValue();
                this.aXQ = privSets.group.intValue();
                this.aXR = privSets.post.intValue();
                this.aXS = privSets.friend.intValue();
                this.aXT = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
