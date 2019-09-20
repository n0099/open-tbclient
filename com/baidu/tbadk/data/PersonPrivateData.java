package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int crJ = 1;
    private int crK = 1;
    private int crL = 1;
    private int crM = 1;
    private int crN = 1;
    private int crO = 1;

    public int arK() {
        return this.crK;
    }

    public int arL() {
        return this.crO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.crJ = jSONObject.optInt(Headers.LOCATION, 1);
            this.crK = jSONObject.optInt("like", 1);
            this.crL = jSONObject.optInt("group", 1);
            this.crM = jSONObject.optInt("post", 1);
            this.crN = jSONObject.optInt("friend", 1);
            this.crO = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.crJ = privSets.location.intValue();
                this.crK = privSets.like.intValue();
                this.crL = privSets.group.intValue();
                this.crM = privSets.post.intValue();
                this.crN = privSets.friend.intValue();
                this.crO = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
