package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fPH;
    public String fPI;
    public int fPJ;
    public int fPK;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fPH = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.fPI = jSONObject.optString("righttips");
            this.fPJ = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fPK = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
