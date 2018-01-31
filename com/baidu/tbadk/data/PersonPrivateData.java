package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int boZ = 1;
    private int bpa = 1;
    private int bpb = 1;
    private int bpc = 1;
    private int bpd = 1;
    private int bpe = 1;

    public int JU() {
        return this.bpa;
    }

    public int JV() {
        return this.bpe;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.boZ = jSONObject.optInt(Headers.LOCATION, 1);
            this.bpa = jSONObject.optInt("like", 1);
            this.bpb = jSONObject.optInt("group", 1);
            this.bpc = jSONObject.optInt("post", 1);
            this.bpd = jSONObject.optInt("friend", 1);
            this.bpe = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.boZ = privSets.location.intValue();
                this.bpa = privSets.like.intValue();
                this.bpb = privSets.group.intValue();
                this.bpc = privSets.post.intValue();
                this.bpd = privSets.friend.intValue();
                this.bpe = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
