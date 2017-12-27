package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int boH = 1;
    private int boI = 1;
    private int boJ = 1;
    private int boK = 1;
    private int boL = 1;
    private int boM = 1;

    public int Kd() {
        return this.boI;
    }

    public int Ke() {
        return this.boM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.boH = jSONObject.optInt(Headers.LOCATION, 1);
            this.boI = jSONObject.optInt("like", 1);
            this.boJ = jSONObject.optInt("group", 1);
            this.boK = jSONObject.optInt("post", 1);
            this.boL = jSONObject.optInt("friend", 1);
            this.boM = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.boH = privSets.location.intValue();
                this.boI = privSets.like.intValue();
                this.boJ = privSets.group.intValue();
                this.boK = privSets.post.intValue();
                this.boL = privSets.friend.intValue();
                this.boM = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
