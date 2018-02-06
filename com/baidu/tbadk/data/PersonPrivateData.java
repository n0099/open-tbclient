package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int brn = 1;
    private int bro = 1;
    private int brp = 1;
    private int brq = 1;
    private int brr = 1;
    private int brs = 1;

    public int KA() {
        return this.bro;
    }

    public int KB() {
        return this.brs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.brn = jSONObject.optInt(Headers.LOCATION, 1);
            this.bro = jSONObject.optInt("like", 1);
            this.brp = jSONObject.optInt("group", 1);
            this.brq = jSONObject.optInt("post", 1);
            this.brr = jSONObject.optInt("friend", 1);
            this.brs = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.brn = privSets.location.intValue();
                this.bro = privSets.like.intValue();
                this.brp = privSets.group.intValue();
                this.brq = privSets.post.intValue();
                this.brr = privSets.friend.intValue();
                this.brs = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
