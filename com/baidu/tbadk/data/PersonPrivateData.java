package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int chl = 1;
    private int chm = 1;
    private int chn = 1;
    private int cho = 1;
    private int chp = 1;
    private int chq = 1;

    public int alo() {
        return this.chm;
    }

    public int alp() {
        return this.chq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chl = jSONObject.optInt(Headers.LOCATION, 1);
            this.chm = jSONObject.optInt("like", 1);
            this.chn = jSONObject.optInt("group", 1);
            this.cho = jSONObject.optInt("post", 1);
            this.chp = jSONObject.optInt("friend", 1);
            this.chq = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.chl = privSets.location.intValue();
                this.chm = privSets.like.intValue();
                this.chn = privSets.group.intValue();
                this.cho = privSets.post.intValue();
                this.chp = privSets.friend.intValue();
                this.chq = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
