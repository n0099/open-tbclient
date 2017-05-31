package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int axy = 1;
    private int axz = 1;
    private int axA = 1;
    private int axB = 1;
    private int axC = 1;
    private int axD = 1;

    public int BI() {
        return this.axz;
    }

    public int BJ() {
        return this.axB;
    }

    public int BK() {
        return this.axD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axy = jSONObject.optInt("location", 1);
            this.axz = jSONObject.optInt("like", 1);
            this.axA = jSONObject.optInt("group", 1);
            this.axB = jSONObject.optInt("post", 1);
            this.axC = jSONObject.optInt("friend", 1);
            this.axD = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.axy = privSets.location.intValue();
                this.axz = privSets.like.intValue();
                this.axA = privSets.group.intValue();
                this.axB = privSets.post.intValue();
                this.axC = privSets.friend.intValue();
                this.axD = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
