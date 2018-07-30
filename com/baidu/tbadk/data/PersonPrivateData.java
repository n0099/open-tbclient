package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aLb = 1;
    private int aLc = 1;
    private int aLd = 1;
    private int aLe = 1;
    private int aLf = 1;
    private int aLg = 1;

    public int GV() {
        return this.aLc;
    }

    public int GW() {
        return this.aLg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLb = jSONObject.optInt(Headers.LOCATION, 1);
            this.aLc = jSONObject.optInt("like", 1);
            this.aLd = jSONObject.optInt("group", 1);
            this.aLe = jSONObject.optInt("post", 1);
            this.aLf = jSONObject.optInt("friend", 1);
            this.aLg = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aLb = privSets.location.intValue();
                this.aLc = privSets.like.intValue();
                this.aLd = privSets.group.intValue();
                this.aLe = privSets.post.intValue();
                this.aLf = privSets.friend.intValue();
                this.aLg = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
