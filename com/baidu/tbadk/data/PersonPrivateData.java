package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int axN = 1;
    private int axO = 1;
    private int axP = 1;
    private int axQ = 1;
    private int axR = 1;
    private int axS = 1;

    public int CI() {
        return this.axO;
    }

    public int CJ() {
        return this.axP;
    }

    public int CK() {
        return this.axQ;
    }

    public int CL() {
        return this.axS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axN = jSONObject.optInt("location", 1);
            this.axO = jSONObject.optInt("like", 1);
            this.axP = jSONObject.optInt("group", 1);
            this.axQ = jSONObject.optInt("post", 1);
            this.axR = jSONObject.optInt("friend", 1);
            this.axS = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.axN = privSets.location.intValue();
                this.axO = privSets.like.intValue();
                this.axP = privSets.group.intValue();
                this.axQ = privSets.post.intValue();
                this.axR = privSets.friend.intValue();
                this.axS = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
