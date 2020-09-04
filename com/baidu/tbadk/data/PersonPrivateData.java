package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int eJx = 1;
    private int eJy = 1;
    private int eJz = 1;
    private int eJA = 1;
    private int eJB = 1;
    private int eJC = 1;

    public int bqV() {
        return this.eJy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eJx = jSONObject.optInt("location", 1);
            this.eJy = jSONObject.optInt("like", 1);
            this.eJz = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.eJA = jSONObject.optInt("post", 1);
            this.eJB = jSONObject.optInt("friend", 1);
            this.eJC = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.eJx = privSets.location.intValue();
                this.eJy = privSets.like.intValue();
                this.eJz = privSets.group.intValue();
                this.eJA = privSets.post.intValue();
                this.eJB = privSets.friend.intValue();
                this.eJC = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
