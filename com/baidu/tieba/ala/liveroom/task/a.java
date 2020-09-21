package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int gMv;
    public String gMw;
    public int gMx;
    public int gMy;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gMv = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.gMw = jSONObject.optString("righttips");
            this.gMx = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.gMy = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
