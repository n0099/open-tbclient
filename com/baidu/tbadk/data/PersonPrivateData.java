package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dVH = 1;
    private int dVI = 1;
    private int dVJ = 1;
    private int dVK = 1;
    private int dVL = 1;
    private int dVM = 1;

    public int aWn() {
        return this.dVI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dVH = jSONObject.optInt("location", 1);
            this.dVI = jSONObject.optInt("like", 1);
            this.dVJ = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dVK = jSONObject.optInt("post", 1);
            this.dVL = jSONObject.optInt("friend", 1);
            this.dVM = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dVH = privSets.location.intValue();
                this.dVI = privSets.like.intValue();
                this.dVJ = privSets.group.intValue();
                this.dVK = privSets.post.intValue();
                this.dVL = privSets.friend.intValue();
                this.dVM = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
