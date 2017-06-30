package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int ayA = 1;
    private int ayB = 1;
    private int ayC = 1;
    private int ayD = 1;
    private int ayE = 1;
    private int ayF = 1;

    public int Cd() {
        return this.ayB;
    }

    public int Ce() {
        return this.ayF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ayA = jSONObject.optInt("location", 1);
            this.ayB = jSONObject.optInt("like", 1);
            this.ayC = jSONObject.optInt("group", 1);
            this.ayD = jSONObject.optInt("post", 1);
            this.ayE = jSONObject.optInt("friend", 1);
            this.ayF = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.ayA = privSets.location.intValue();
                this.ayB = privSets.like.intValue();
                this.ayC = privSets.group.intValue();
                this.ayD = privSets.post.intValue();
                this.ayE = privSets.friend.intValue();
                this.ayF = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
