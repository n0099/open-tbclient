package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int fgi = 1;
    private int fgj = 1;
    private int fgk = 1;
    private int fgl = 1;
    private int fgm = 1;
    private int fgn = 1;

    public int bws() {
        return this.fgj;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fgi = jSONObject.optInt("location", 1);
            this.fgj = jSONObject.optInt("like", 1);
            this.fgk = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.fgl = jSONObject.optInt("post", 1);
            this.fgm = jSONObject.optInt("friend", 1);
            this.fgn = jSONObject.optInt("live", 1);
        }
    }

    public void parserProtobuf(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.fgi = privSets.location.intValue();
                this.fgj = privSets.like.intValue();
                this.fgk = privSets.group.intValue();
                this.fgl = privSets.post.intValue();
                this.fgm = privSets.friend.intValue();
                this.fgn = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
