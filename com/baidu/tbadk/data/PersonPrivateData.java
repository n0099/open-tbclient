package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dvh = 1;
    private int dvi = 1;
    private int dvj = 1;
    private int dvk = 1;
    private int dvl = 1;
    private int dvm = 1;

    public int aNM() {
        return this.dvi;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvh = jSONObject.optInt("location", 1);
            this.dvi = jSONObject.optInt("like", 1);
            this.dvj = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dvk = jSONObject.optInt("post", 1);
            this.dvl = jSONObject.optInt("friend", 1);
            this.dvm = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dvh = privSets.location.intValue();
                this.dvi = privSets.like.intValue();
                this.dvj = privSets.group.intValue();
                this.dvk = privSets.post.intValue();
                this.dvl = privSets.friend.intValue();
                this.dvm = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
