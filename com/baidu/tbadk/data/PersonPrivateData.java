package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dVC = 1;
    private int dVD = 1;
    private int dVE = 1;
    private int dVF = 1;
    private int dVG = 1;
    private int dVH = 1;

    public int aWp() {
        return this.dVD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dVC = jSONObject.optInt("location", 1);
            this.dVD = jSONObject.optInt("like", 1);
            this.dVE = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dVF = jSONObject.optInt("post", 1);
            this.dVG = jSONObject.optInt("friend", 1);
            this.dVH = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dVC = privSets.location.intValue();
                this.dVD = privSets.like.intValue();
                this.dVE = privSets.group.intValue();
                this.dVF = privSets.post.intValue();
                this.dVG = privSets.friend.intValue();
                this.dVH = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
