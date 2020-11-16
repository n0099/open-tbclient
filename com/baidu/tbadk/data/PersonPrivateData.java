package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int flj = 1;
    private int flk = 1;
    private int fll = 1;
    private int flm = 1;
    private int fln = 1;
    private int flo = 1;

    public int byh() {
        return this.flk;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.flj = jSONObject.optInt("location", 1);
            this.flk = jSONObject.optInt("like", 1);
            this.fll = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.flm = jSONObject.optInt("post", 1);
            this.fln = jSONObject.optInt("friend", 1);
            this.flo = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.flj = privSets.location.intValue();
                this.flk = privSets.like.intValue();
                this.fll = privSets.group.intValue();
                this.flm = privSets.post.intValue();
                this.fln = privSets.friend.intValue();
                this.flo = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
