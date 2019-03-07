package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int chj = 1;
    private int chk = 1;
    private int chl = 1;
    private int chm = 1;
    private int chn = 1;
    private int cho = 1;

    public int als() {
        return this.chk;
    }

    public int alt() {
        return this.cho;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chj = jSONObject.optInt(Headers.LOCATION, 1);
            this.chk = jSONObject.optInt("like", 1);
            this.chl = jSONObject.optInt("group", 1);
            this.chm = jSONObject.optInt("post", 1);
            this.chn = jSONObject.optInt("friend", 1);
            this.cho = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.chj = privSets.location.intValue();
                this.chk = privSets.like.intValue();
                this.chl = privSets.group.intValue();
                this.chm = privSets.post.intValue();
                this.chn = privSets.friend.intValue();
                this.cho = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
