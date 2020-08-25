package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int gJa;
    public String gJb;
    public int gJc;
    public int gJd;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gJa = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.gJb = jSONObject.optString("righttips");
            this.gJc = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.gJd = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
