package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int chm = 1;
    private int chn = 1;
    private int cho = 1;
    private int chp = 1;
    private int chq = 1;
    private int chr = 1;

    public int alo() {
        return this.chn;
    }

    public int alp() {
        return this.chr;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chm = jSONObject.optInt(Headers.LOCATION, 1);
            this.chn = jSONObject.optInt("like", 1);
            this.cho = jSONObject.optInt("group", 1);
            this.chp = jSONObject.optInt("post", 1);
            this.chq = jSONObject.optInt("friend", 1);
            this.chr = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.chm = privSets.location.intValue();
                this.chn = privSets.like.intValue();
                this.cho = privSets.group.intValue();
                this.chp = privSets.post.intValue();
                this.chq = privSets.friend.intValue();
                this.chr = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
