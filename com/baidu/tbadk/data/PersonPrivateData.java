package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int aKV = 1;
    private int aKW = 1;
    private int aKX = 1;
    private int aKY = 1;
    private int aKZ = 1;
    private int aLa = 1;

    public int GZ() {
        return this.aKW;
    }

    public int Ha() {
        return this.aLa;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKV = jSONObject.optInt(Headers.LOCATION, 1);
            this.aKW = jSONObject.optInt("like", 1);
            this.aKX = jSONObject.optInt("group", 1);
            this.aKY = jSONObject.optInt("post", 1);
            this.aKZ = jSONObject.optInt("friend", 1);
            this.aLa = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.aKV = privSets.location.intValue();
                this.aKW = privSets.like.intValue();
                this.aKX = privSets.group.intValue();
                this.aKY = privSets.post.intValue();
                this.aKZ = privSets.friend.intValue();
                this.aLa = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
