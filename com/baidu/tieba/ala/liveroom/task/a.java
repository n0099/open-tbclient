package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fPM;
    public String fPN;
    public int fPO;
    public int fPP;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fPM = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.fPN = jSONObject.optString("righttips");
            this.fPO = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fPP = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
