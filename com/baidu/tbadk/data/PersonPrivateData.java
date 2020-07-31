package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int eyV = 1;
    private int eyW = 1;
    private int eyX = 1;
    private int eyY = 1;
    private int eyZ = 1;
    private int eza = 1;

    public int bii() {
        return this.eyW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eyV = jSONObject.optInt("location", 1);
            this.eyW = jSONObject.optInt("like", 1);
            this.eyX = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.eyY = jSONObject.optInt("post", 1);
            this.eyZ = jSONObject.optInt("friend", 1);
            this.eza = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.eyV = privSets.location.intValue();
                this.eyW = privSets.like.intValue();
                this.eyX = privSets.group.intValue();
                this.eyY = privSets.post.intValue();
                this.eyZ = privSets.friend.intValue();
                this.eza = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
