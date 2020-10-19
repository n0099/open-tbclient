package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int eXM = 1;
    private int eXN = 1;
    private int eXO = 1;
    private int eXP = 1;
    private int eXQ = 1;
    private int eXR = 1;

    public int buz() {
        return this.eXN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eXM = jSONObject.optInt("location", 1);
            this.eXN = jSONObject.optInt("like", 1);
            this.eXO = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.eXP = jSONObject.optInt("post", 1);
            this.eXQ = jSONObject.optInt("friend", 1);
            this.eXR = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.eXM = privSets.location.intValue();
                this.eXN = privSets.like.intValue();
                this.eXO = privSets.group.intValue();
                this.eXP = privSets.post.intValue();
                this.eXQ = privSets.friend.intValue();
                this.eXR = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
