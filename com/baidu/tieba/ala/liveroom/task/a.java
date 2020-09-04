package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int gJe;
    public String gJf;
    public int gJg;
    public int gJh;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gJe = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.gJf = jSONObject.optString("righttips");
            this.gJg = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.gJh = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
