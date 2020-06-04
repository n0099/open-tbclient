package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int geI;
    public String geJ;
    public int geK;
    public int geL;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.geI = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.geJ = jSONObject.optString("righttips");
            this.geK = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.geL = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
