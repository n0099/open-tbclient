package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int esB = 1;
    private int esC = 1;
    private int esD = 1;
    private int esE = 1;
    private int esF = 1;
    private int esG = 1;

    public int bez() {
        return this.esC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.esB = jSONObject.optInt("location", 1);
            this.esC = jSONObject.optInt("like", 1);
            this.esD = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.esE = jSONObject.optInt("post", 1);
            this.esF = jSONObject.optInt("friend", 1);
            this.esG = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.esB = privSets.location.intValue();
                this.esC = privSets.like.intValue();
                this.esD = privSets.group.intValue();
                this.esE = privSets.post.intValue();
                this.esF = privSets.friend.intValue();
                this.esG = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
