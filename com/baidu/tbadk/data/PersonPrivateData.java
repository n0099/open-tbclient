package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dqZ = 1;
    private int dra = 1;
    private int drb = 1;
    private int drc = 1;
    private int drd = 1;
    private int dre = 1;

    public int aLq() {
        return this.dra;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dqZ = jSONObject.optInt("location", 1);
            this.dra = jSONObject.optInt("like", 1);
            this.drb = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.drc = jSONObject.optInt("post", 1);
            this.drd = jSONObject.optInt("friend", 1);
            this.dre = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dqZ = privSets.location.intValue();
                this.dra = privSets.like.intValue();
                this.drb = privSets.group.intValue();
                this.drc = privSets.post.intValue();
                this.drd = privSets.friend.intValue();
                this.dre = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
