package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int grE;
    public String grF;
    public int grG;
    public int grH;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.grE = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.grF = jSONObject.optString("righttips");
            this.grG = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.grH = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
