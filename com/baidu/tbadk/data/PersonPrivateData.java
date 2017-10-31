package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int azU = 1;
    private int azV = 1;
    private int azW = 1;
    private int azX = 1;
    private int azY = 1;
    private int azZ = 1;

    public int Ce() {
        return this.azV;
    }

    public int Cf() {
        return this.azX;
    }

    public int Cg() {
        return this.azZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.azU = jSONObject.optInt("location", 1);
            this.azV = jSONObject.optInt("like", 1);
            this.azW = jSONObject.optInt("group", 1);
            this.azX = jSONObject.optInt("post", 1);
            this.azY = jSONObject.optInt("friend", 1);
            this.azZ = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.azU = privSets.location.intValue();
                this.azV = privSets.like.intValue();
                this.azW = privSets.group.intValue();
                this.azX = privSets.post.intValue();
                this.azY = privSets.friend.intValue();
                this.azZ = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
