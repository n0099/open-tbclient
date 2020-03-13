package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dvv = 1;
    private int dvw = 1;
    private int dvx = 1;
    private int dvy = 1;
    private int dvz = 1;
    private int dvA = 1;

    public int aNP() {
        return this.dvw;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvv = jSONObject.optInt("location", 1);
            this.dvw = jSONObject.optInt("like", 1);
            this.dvx = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dvy = jSONObject.optInt("post", 1);
            this.dvz = jSONObject.optInt("friend", 1);
            this.dvA = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dvv = privSets.location.intValue();
                this.dvw = privSets.like.intValue();
                this.dvx = privSets.group.intValue();
                this.dvy = privSets.post.intValue();
                this.dvz = privSets.friend.intValue();
                this.dvA = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
