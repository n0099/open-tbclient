package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int brd = 1;
    private int bre = 1;
    private int brf = 1;
    private int brg = 1;
    private int brh = 1;
    private int bri = 1;

    public int KA() {
        return this.bre;
    }

    public int KB() {
        return this.bri;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brd = jSONObject.optInt(Headers.LOCATION, 1);
            this.bre = jSONObject.optInt("like", 1);
            this.brf = jSONObject.optInt("group", 1);
            this.brg = jSONObject.optInt("post", 1);
            this.brh = jSONObject.optInt("friend", 1);
            this.bri = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.brd = privSets.location.intValue();
                this.bre = privSets.like.intValue();
                this.brf = privSets.group.intValue();
                this.brg = privSets.post.intValue();
                this.brh = privSets.friend.intValue();
                this.bri = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
