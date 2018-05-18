package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aBD = 1;
    private int aBE = 1;
    private int aBF = 1;
    private int aBG = 1;
    private int aBH = 1;
    private int aBI = 1;

    public int De() {
        return this.aBE;
    }

    public int Df() {
        return this.aBI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBD = jSONObject.optInt(Headers.LOCATION, 1);
            this.aBE = jSONObject.optInt("like", 1);
            this.aBF = jSONObject.optInt("group", 1);
            this.aBG = jSONObject.optInt("post", 1);
            this.aBH = jSONObject.optInt("friend", 1);
            this.aBI = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aBD = privSets.location.intValue();
                this.aBE = privSets.like.intValue();
                this.aBF = privSets.group.intValue();
                this.aBG = privSets.post.intValue();
                this.aBH = privSets.friend.intValue();
                this.aBI = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
