package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int eLF = 1;
    private int eLG = 1;
    private int eLH = 1;
    private int eLI = 1;
    private int eLJ = 1;
    private int eLK = 1;

    public int brP() {
        return this.eLG;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eLF = jSONObject.optInt("location", 1);
            this.eLG = jSONObject.optInt("like", 1);
            this.eLH = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.eLI = jSONObject.optInt("post", 1);
            this.eLJ = jSONObject.optInt("friend", 1);
            this.eLK = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.eLF = privSets.location.intValue();
                this.eLG = privSets.like.intValue();
                this.eLH = privSets.group.intValue();
                this.eLI = privSets.post.intValue();
                this.eLJ = privSets.friend.intValue();
                this.eLK = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
