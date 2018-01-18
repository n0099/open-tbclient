package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int boQ = 1;
    private int boR = 1;
    private int boS = 1;
    private int boT = 1;
    private int boU = 1;
    private int boV = 1;

    public int JS() {
        return this.boR;
    }

    public int JT() {
        return this.boV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.boQ = jSONObject.optInt(Headers.LOCATION, 1);
            this.boR = jSONObject.optInt("like", 1);
            this.boS = jSONObject.optInt("group", 1);
            this.boT = jSONObject.optInt("post", 1);
            this.boU = jSONObject.optInt("friend", 1);
            this.boV = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.boQ = privSets.location.intValue();
                this.boR = privSets.like.intValue();
                this.boS = privSets.group.intValue();
                this.boT = privSets.post.intValue();
                this.boU = privSets.friend.intValue();
                this.boV = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
