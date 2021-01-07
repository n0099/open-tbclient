package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fCr = 1;
    private int fCs = 1;
    private int fCt = 1;
    private int fCu = 1;
    private int fCv = 1;
    private int fCw = 1;

    public int bEd() {
        return this.fCs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fCr = jSONObject.optInt("location", 1);
            this.fCs = jSONObject.optInt("like", 1);
            this.fCt = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fCu = jSONObject.optInt("post", 1);
            this.fCv = jSONObject.optInt("friend", 1);
            this.fCw = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fCr = privSets.location.intValue();
                this.fCs = privSets.like.intValue();
                this.fCt = privSets.group.intValue();
                this.fCu = privSets.post.intValue();
                this.fCv = privSets.friend.intValue();
                this.fCw = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
