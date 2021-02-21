package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public int hOA;
    public String hOB;
    public int hOC;
    public int hOD;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hOA = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hOB = jSONObject.optString("righttips");
            this.hOC = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hOD = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
