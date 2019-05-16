package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cpt = 1;
    private int cpv = 1;
    private int cpw = 1;
    private int cpx = 1;
    private int cpy = 1;
    private int cpz = 1;

    public int aqr() {
        return this.cpv;
    }

    public int aqs() {
        return this.cpz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cpt = jSONObject.optInt(Headers.LOCATION, 1);
            this.cpv = jSONObject.optInt("like", 1);
            this.cpw = jSONObject.optInt("group", 1);
            this.cpx = jSONObject.optInt("post", 1);
            this.cpy = jSONObject.optInt("friend", 1);
            this.cpz = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cpt = privSets.location.intValue();
                this.cpv = privSets.like.intValue();
                this.cpw = privSets.group.intValue();
                this.cpx = privSets.post.intValue();
                this.cpy = privSets.friend.intValue();
                this.cpz = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
