package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cqH = 1;
    private int cqI = 1;
    private int cqJ = 1;
    private int cqK = 1;
    private int cqL = 1;
    private int cqM = 1;

    public int arw() {
        return this.cqI;
    }

    public int arx() {
        return this.cqM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cqH = jSONObject.optInt(Headers.LOCATION, 1);
            this.cqI = jSONObject.optInt("like", 1);
            this.cqJ = jSONObject.optInt("group", 1);
            this.cqK = jSONObject.optInt("post", 1);
            this.cqL = jSONObject.optInt("friend", 1);
            this.cqM = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cqH = privSets.location.intValue();
                this.cqI = privSets.like.intValue();
                this.cqJ = privSets.group.intValue();
                this.cqK = privSets.post.intValue();
                this.cqL = privSets.friend.intValue();
                this.cqM = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
