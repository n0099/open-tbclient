package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cqO = 1;
    private int cqP = 1;
    private int cqQ = 1;
    private int cqR = 1;
    private int cqS = 1;
    private int cqT = 1;

    public int ary() {
        return this.cqP;
    }

    public int arz() {
        return this.cqT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cqO = jSONObject.optInt(Headers.LOCATION, 1);
            this.cqP = jSONObject.optInt("like", 1);
            this.cqQ = jSONObject.optInt("group", 1);
            this.cqR = jSONObject.optInt("post", 1);
            this.cqS = jSONObject.optInt("friend", 1);
            this.cqT = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cqO = privSets.location.intValue();
                this.cqP = privSets.like.intValue();
                this.cqQ = privSets.group.intValue();
                this.cqR = privSets.post.intValue();
                this.cqS = privSets.friend.intValue();
                this.cqT = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
