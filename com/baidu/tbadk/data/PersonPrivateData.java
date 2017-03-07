package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int axx = 1;
    private int axy = 1;
    private int axz = 1;
    private int axA = 1;
    private int axB = 1;
    private int axC = 1;

    public int Ck() {
        return this.axy;
    }

    public int Cl() {
        return this.axz;
    }

    public int Cm() {
        return this.axA;
    }

    public int Cn() {
        return this.axC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axx = jSONObject.optInt("location", 1);
            this.axy = jSONObject.optInt("like", 1);
            this.axz = jSONObject.optInt("group", 1);
            this.axA = jSONObject.optInt("post", 1);
            this.axB = jSONObject.optInt("friend", 1);
            this.axC = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.axx = privSets.location.intValue();
                this.axy = privSets.like.intValue();
                this.axz = privSets.group.intValue();
                this.axA = privSets.post.intValue();
                this.axB = privSets.friend.intValue();
                this.axC = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
