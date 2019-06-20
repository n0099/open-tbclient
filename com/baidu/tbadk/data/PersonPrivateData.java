package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cpv = 1;
    private int cpw = 1;
    private int cpx = 1;
    private int cpy = 1;
    private int cpz = 1;
    private int cpA = 1;

    public int aqr() {
        return this.cpw;
    }

    public int aqs() {
        return this.cpA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cpv = jSONObject.optInt(Headers.LOCATION, 1);
            this.cpw = jSONObject.optInt("like", 1);
            this.cpx = jSONObject.optInt("group", 1);
            this.cpy = jSONObject.optInt("post", 1);
            this.cpz = jSONObject.optInt("friend", 1);
            this.cpA = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cpv = privSets.location.intValue();
                this.cpw = privSets.like.intValue();
                this.cpx = privSets.group.intValue();
                this.cpy = privSets.post.intValue();
                this.cpz = privSets.friend.intValue();
                this.cpA = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
