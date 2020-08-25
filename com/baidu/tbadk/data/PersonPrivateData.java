package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes2.dex */
public class PersonPrivateData extends OrmObject {
    private int eJt = 1;
    private int eJu = 1;
    private int eJv = 1;
    private int eJw = 1;
    private int eJx = 1;
    private int eJy = 1;

    public int bqU() {
        return this.eJu;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eJt = jSONObject.optInt("location", 1);
            this.eJu = jSONObject.optInt("like", 1);
            this.eJv = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.eJw = jSONObject.optInt("post", 1);
            this.eJx = jSONObject.optInt("friend", 1);
            this.eJy = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.eJt = privSets.location.intValue();
                this.eJu = privSets.like.intValue();
                this.eJv = privSets.group.intValue();
                this.eJw = privSets.post.intValue();
                this.eJx = privSets.friend.intValue();
                this.eJy = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
