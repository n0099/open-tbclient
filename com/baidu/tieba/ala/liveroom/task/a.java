package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public int hOu;
    public String hOv;
    public int hOw;
    public int hOx;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hOu = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hOv = jSONObject.optString("righttips");
            this.hOw = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hOx = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
