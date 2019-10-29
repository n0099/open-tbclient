package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cDT = 1;
    private int cDU = 1;
    private int cDV = 1;
    private int cDW = 1;
    private int cDX = 1;
    private int cDY = 1;

    public int aty() {
        return this.cDU;
    }

    public int atz() {
        return this.cDY;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cDT = jSONObject.optInt(Headers.LOCATION, 1);
            this.cDU = jSONObject.optInt("like", 1);
            this.cDV = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.cDW = jSONObject.optInt("post", 1);
            this.cDX = jSONObject.optInt("friend", 1);
            this.cDY = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cDT = privSets.location.intValue();
                this.cDU = privSets.like.intValue();
                this.cDV = privSets.group.intValue();
                this.cDW = privSets.post.intValue();
                this.cDX = privSets.friend.intValue();
                this.cDY = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
