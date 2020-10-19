package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int hbs;
    public String hbt;
    public int hbu;
    public int hbv;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hbs = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hbt = jSONObject.optString("righttips");
            this.hbu = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hbv = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
