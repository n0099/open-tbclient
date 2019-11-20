package com.baidu.tbadk.data;

import android.net.http.Headers;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.util.TbEnum;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes.dex */
public class PersonPrivateData extends OrmObject {
    private int cDc = 1;
    private int cDd = 1;
    private int cDe = 1;
    private int cDf = 1;
    private int cDg = 1;
    private int cDh = 1;

    public int atw() {
        return this.cDd;
    }

    public int atx() {
        return this.cDh;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cDc = jSONObject.optInt(Headers.LOCATION, 1);
            this.cDd = jSONObject.optInt("like", 1);
            this.cDe = jSONObject.optInt(TbEnum.ParamKey.GROUP, 1);
            this.cDf = jSONObject.optInt("post", 1);
            this.cDg = jSONObject.optInt("friend", 1);
            this.cDh = jSONObject.optInt("live", 1);
        }
    }

    public void a(PrivSets privSets) {
        if (privSets != null) {
            try {
                this.cDc = privSets.location.intValue();
                this.cDd = privSets.like.intValue();
                this.cDe = privSets.group.intValue();
                this.cDf = privSets.post.intValue();
                this.cDg = privSets.friend.intValue();
                this.cDh = privSets.live.intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
