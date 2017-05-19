package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int axM = 1;
    private int axN = 1;
    private int axO = 1;
    private int axP = 1;
    private int axQ = 1;
    private int axR = 1;

    public int BP() {
        return this.axN;
    }

    public int BQ() {
        return this.axR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axM = jSONObject.optInt("location", 1);
            this.axN = jSONObject.optInt("like", 1);
            this.axO = jSONObject.optInt("group", 1);
            this.axP = jSONObject.optInt("post", 1);
            this.axQ = jSONObject.optInt("friend", 1);
            this.axR = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.axM = privSets.location.intValue();
                this.axN = privSets.like.intValue();
                this.axO = privSets.group.intValue();
                this.axP = privSets.post.intValue();
                this.axQ = privSets.friend.intValue();
                this.axR = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
