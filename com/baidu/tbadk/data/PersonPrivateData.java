package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aOo = 1;
    private int aOp = 1;
    private int aOq = 1;
    private int aOr = 1;
    private int aOs = 1;
    private int aOt = 1;

    public int Il() {
        return this.aOp;
    }

    public int Im() {
        return this.aOt;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOo = jSONObject.optInt(Headers.LOCATION, 1);
            this.aOp = jSONObject.optInt("like", 1);
            this.aOq = jSONObject.optInt("group", 1);
            this.aOr = jSONObject.optInt("post", 1);
            this.aOs = jSONObject.optInt("friend", 1);
            this.aOt = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aOo = privSets.location.intValue();
                this.aOp = privSets.like.intValue();
                this.aOq = privSets.group.intValue();
                this.aOr = privSets.post.intValue();
                this.aOs = privSets.friend.intValue();
                this.aOt = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
