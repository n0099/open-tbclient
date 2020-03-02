package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dvi = 1;
    private int dvj = 1;
    private int dvk = 1;
    private int dvl = 1;
    private int dvm = 1;
    private int dvn = 1;

    public int aNO() {
        return this.dvj;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvi = jSONObject.optInt("location", 1);
            this.dvj = jSONObject.optInt("like", 1);
            this.dvk = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dvl = jSONObject.optInt("post", 1);
            this.dvm = jSONObject.optInt("friend", 1);
            this.dvn = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dvi = privSets.location.intValue();
                this.dvj = privSets.like.intValue();
                this.dvk = privSets.group.intValue();
                this.dvl = privSets.post.intValue();
                this.dvm = privSets.friend.intValue();
                this.dvn = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
