package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int htg;
    public String hth;
    public int hti;
    public int htj;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.htg = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hth = jSONObject.optString("righttips");
            this.hti = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.htj = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
