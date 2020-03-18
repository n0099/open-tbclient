package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int dvI = 1;
    private int dvJ = 1;
    private int dvK = 1;
    private int dvL = 1;
    private int dvM = 1;
    private int dvN = 1;

    public int aNT() {
        return this.dvJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dvI = jSONObject.optInt("location", 1);
            this.dvJ = jSONObject.optInt("like", 1);
            this.dvK = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.dvL = jSONObject.optInt("post", 1);
            this.dvM = jSONObject.optInt("friend", 1);
            this.dvN = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.dvI = privSets.location.intValue();
                this.dvJ = privSets.like.intValue();
                this.dvK = privSets.group.intValue();
                this.dvL = privSets.post.intValue();
                this.dvM = privSets.friend.intValue();
                this.dvN = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
