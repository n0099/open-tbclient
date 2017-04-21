package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int axP = 1;
    private int axQ = 1;
    private int axR = 1;
    private int axS = 1;
    private int axT = 1;
    private int axU = 1;

    public int CI() {
        return this.axQ;
    }

    public int CJ() {
        return this.axR;
    }

    public int CK() {
        return this.axS;
    }

    public int CL() {
        return this.axU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axP = jSONObject.optInt("location", 1);
            this.axQ = jSONObject.optInt("like", 1);
            this.axR = jSONObject.optInt("group", 1);
            this.axS = jSONObject.optInt("post", 1);
            this.axT = jSONObject.optInt("friend", 1);
            this.axU = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.axP = privSets.location.intValue();
                this.axQ = privSets.like.intValue();
                this.axR = privSets.group.intValue();
                this.axS = privSets.post.intValue();
                this.axT = privSets.friend.intValue();
                this.axU = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
