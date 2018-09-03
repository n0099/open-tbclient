package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aKY = 1;
    private int aKZ = 1;
    private int aLa = 1;
    private int aLb = 1;
    private int aLc = 1;
    private int aLd = 1;

    public int GV() {
        return this.aKZ;
    }

    public int GW() {
        return this.aLd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKY = jSONObject.optInt(Headers.LOCATION, 1);
            this.aKZ = jSONObject.optInt("like", 1);
            this.aLa = jSONObject.optInt("group", 1);
            this.aLb = jSONObject.optInt("post", 1);
            this.aLc = jSONObject.optInt("friend", 1);
            this.aLd = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aKY = privSets.location.intValue();
                this.aKZ = privSets.like.intValue();
                this.aLa = privSets.group.intValue();
                this.aLb = privSets.post.intValue();
                this.aLc = privSets.friend.intValue();
                this.aLd = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
