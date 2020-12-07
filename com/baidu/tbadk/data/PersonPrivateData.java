package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fsM = 1;
    private int fsN = 1;
    private int fsO = 1;
    private int fsP = 1;
    private int fsQ = 1;
    private int fsR = 1;

    public int bBH() {
        return this.fsN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsM = jSONObject.optInt("location", 1);
            this.fsN = jSONObject.optInt("like", 1);
            this.fsO = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fsP = jSONObject.optInt("post", 1);
            this.fsQ = jSONObject.optInt("friend", 1);
            this.fsR = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fsM = privSets.location.intValue();
                this.fsN = privSets.like.intValue();
                this.fsO = privSets.group.intValue();
                this.fsP = privSets.post.intValue();
                this.fsQ = privSets.friend.intValue();
                this.fsR = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
