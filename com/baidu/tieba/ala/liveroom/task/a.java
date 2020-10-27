package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int hni;
    public String hnj;
    public int hnk;
    public int hnl;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hni = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hnj = jSONObject.optString("righttips");
            this.hnk = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hnl = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
