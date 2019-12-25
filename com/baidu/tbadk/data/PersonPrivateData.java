package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dqO = 1;
    private int dqP = 1;
    private int dqQ = 1;
    private int dqR = 1;
    private int dqS = 1;
    private int dqT = 1;

    public int aKX() {
        return this.dqP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dqO = jSONObject.optInt("location", 1);
            this.dqP = jSONObject.optInt("like", 1);
            this.dqQ = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dqR = jSONObject.optInt("post", 1);
            this.dqS = jSONObject.optInt("friend", 1);
            this.dqT = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dqO = privSets.location.intValue();
                this.dqP = privSets.like.intValue();
                this.dqQ = privSets.group.intValue();
                this.dqR = privSets.post.intValue();
                this.dqS = privSets.friend.intValue();
                this.dqT = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
