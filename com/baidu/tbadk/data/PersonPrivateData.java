package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aSQ = 1;
    private int aSR = 1;
    private int aSS = 1;
    private int aST = 1;
    private int aSU = 1;
    private int aSV = 1;

    public int Kk() {
        return this.aSR;
    }

    public int Kl() {
        return this.aSV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSQ = jSONObject.optInt(Headers.LOCATION, 1);
            this.aSR = jSONObject.optInt("like", 1);
            this.aSS = jSONObject.optInt("group", 1);
            this.aST = jSONObject.optInt("post", 1);
            this.aSU = jSONObject.optInt("friend", 1);
            this.aSV = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aSQ = privSets.location.intValue();
                this.aSR = privSets.like.intValue();
                this.aSS = privSets.group.intValue();
                this.aST = privSets.post.intValue();
                this.aSU = privSets.friend.intValue();
                this.aSV = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
