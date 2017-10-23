package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int azj = 1;
    private int azk = 1;
    private int azl = 1;
    private int azm = 1;
    private int azn = 1;
    private int azo = 1;

    public int BP() {
        return this.azk;
    }

    public int BQ() {
        return this.azm;
    }

    public int BR() {
        return this.azo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azj = jSONObject.optInt("location", 1);
            this.azk = jSONObject.optInt("like", 1);
            this.azl = jSONObject.optInt("group", 1);
            this.azm = jSONObject.optInt("post", 1);
            this.azn = jSONObject.optInt("friend", 1);
            this.azo = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.azj = privSets.location.intValue();
                this.azk = privSets.like.intValue();
                this.azl = privSets.group.intValue();
                this.azm = privSets.post.intValue();
                this.azn = privSets.friend.intValue();
                this.azo = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
