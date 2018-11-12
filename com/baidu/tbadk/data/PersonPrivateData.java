package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aTG = 1;
    private int aTH = 1;
    private int aTI = 1;
    private int aTJ = 1;
    private int aTK = 1;
    private int aTL = 1;

    public int Kw() {
        return this.aTH;
    }

    public int Kx() {
        return this.aTL;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTG = jSONObject.optInt(Headers.LOCATION, 1);
            this.aTH = jSONObject.optInt("like", 1);
            this.aTI = jSONObject.optInt("group", 1);
            this.aTJ = jSONObject.optInt("post", 1);
            this.aTK = jSONObject.optInt("friend", 1);
            this.aTL = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aTG = privSets.location.intValue();
                this.aTH = privSets.like.intValue();
                this.aTI = privSets.group.intValue();
                this.aTJ = privSets.post.intValue();
                this.aTK = privSets.friend.intValue();
                this.aTL = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
