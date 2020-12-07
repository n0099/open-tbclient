package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int hCr;
    public String hCs;
    public int hCt;
    public int hCu;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hCr = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hCs = jSONObject.optString("righttips");
            this.hCt = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hCu = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
