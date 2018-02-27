package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int bra = 1;
    private int brb = 1;
    private int brc = 1;
    private int brd = 1;
    private int bre = 1;
    private int brf = 1;

    public int Kz() {
        return this.brb;
    }

    public int KA() {
        return this.brf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bra = jSONObject.optInt(Headers.LOCATION, 1);
            this.brb = jSONObject.optInt("like", 1);
            this.brc = jSONObject.optInt("group", 1);
            this.brd = jSONObject.optInt("post", 1);
            this.bre = jSONObject.optInt("friend", 1);
            this.brf = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.bra = privSets.location.intValue();
                this.brb = privSets.like.intValue();
                this.brc = privSets.group.intValue();
                this.brd = privSets.post.intValue();
                this.bre = privSets.friend.intValue();
                this.brf = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
