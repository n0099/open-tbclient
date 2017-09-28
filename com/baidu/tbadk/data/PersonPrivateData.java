package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int azv = 1;
    private int azw = 1;
    private int azx = 1;
    private int azy = 1;
    private int azz = 1;
    private int azA = 1;

    public int BV() {
        return this.azw;
    }

    public int BW() {
        return this.azy;
    }

    public int BX() {
        return this.azA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azv = jSONObject.optInt("location", 1);
            this.azw = jSONObject.optInt("like", 1);
            this.azx = jSONObject.optInt("group", 1);
            this.azy = jSONObject.optInt("post", 1);
            this.azz = jSONObject.optInt("friend", 1);
            this.azA = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.azv = privSets.location.intValue();
                this.azw = privSets.like.intValue();
                this.azx = privSets.group.intValue();
                this.azy = privSets.post.intValue();
                this.azz = privSets.friend.intValue();
                this.azA = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
