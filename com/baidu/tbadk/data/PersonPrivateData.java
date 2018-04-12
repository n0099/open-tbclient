package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aBC = 1;
    private int aBD = 1;
    private int aBE = 1;
    private int aBF = 1;
    private int aBG = 1;
    private int aBH = 1;

    public int Dg() {
        return this.aBD;
    }

    public int Dh() {
        return this.aBH;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBC = jSONObject.optInt(Headers.LOCATION, 1);
            this.aBD = jSONObject.optInt("like", 1);
            this.aBE = jSONObject.optInt("group", 1);
            this.aBF = jSONObject.optInt("post", 1);
            this.aBG = jSONObject.optInt("friend", 1);
            this.aBH = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aBC = privSets.location.intValue();
                this.aBD = privSets.like.intValue();
                this.aBE = privSets.group.intValue();
                this.aBF = privSets.post.intValue();
                this.aBG = privSets.friend.intValue();
                this.aBH = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
