package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fmb = 1;
    private int fmc = 1;
    private int fmd = 1;
    private int fme = 1;
    private int fmf = 1;
    private int fmg = 1;

    public int byR() {
        return this.fmc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fmb = jSONObject.optInt("location", 1);
            this.fmc = jSONObject.optInt("like", 1);
            this.fmd = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fme = jSONObject.optInt("post", 1);
            this.fmf = jSONObject.optInt("friend", 1);
            this.fmg = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fmb = privSets.location.intValue();
                this.fmc = privSets.like.intValue();
                this.fmd = privSets.group.intValue();
                this.fme = privSets.post.intValue();
                this.fmf = privSets.friend.intValue();
                this.fmg = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
