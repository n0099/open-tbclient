package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int asc = 1;
    private int asd = 1;
    private int ase = 1;
    private int asf = 1;
    private int asg = 1;
    private int ash = 1;

    public int BR() {
        return this.asd;
    }

    public int BS() {
        return this.ase;
    }

    public int BT() {
        return this.asf;
    }

    public int BU() {
        return this.ash;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asc = jSONObject.optInt("location", 1);
            this.asd = jSONObject.optInt("like", 1);
            this.ase = jSONObject.optInt("group", 1);
            this.asf = jSONObject.optInt("post", 1);
            this.asg = jSONObject.optInt("friend", 1);
            this.ash = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.asc = privSets.location.intValue();
                this.asd = privSets.like.intValue();
                this.ase = privSets.group.intValue();
                this.asf = privSets.post.intValue();
                this.asg = privSets.friend.intValue();
                this.ash = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
