package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int ejQ = 1;
    private int ejR = 1;
    private int ejS = 1;
    private int ejT = 1;
    private int ejU = 1;
    private int ejV = 1;

    public int bcx() {
        return this.ejR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ejQ = jSONObject.optInt("location", 1);
            this.ejR = jSONObject.optInt("like", 1);
            this.ejS = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.ejT = jSONObject.optInt("post", 1);
            this.ejU = jSONObject.optInt("friend", 1);
            this.ejV = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.ejQ = privSets.location.intValue();
                this.ejR = privSets.like.intValue();
                this.ejS = privSets.group.intValue();
                this.ejT = privSets.post.intValue();
                this.ejU = privSets.friend.intValue();
                this.ejV = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
