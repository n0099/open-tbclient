package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public int hOm;
    public String hOn;
    public int hOo;
    public int hOp;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hOm = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hOn = jSONObject.optString("righttips");
            this.hOo = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.hOp = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
