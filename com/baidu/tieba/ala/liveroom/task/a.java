package com.baidu.tieba.ala.liveroom.task;

import com.baidu.android.imsdk.db.TableDefine;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int geA;
    public int gex;
    public String gey;
    public int gez;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gex = jSONObject.optInt("istip");
            this.tips = jSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.gey = jSONObject.optString("righttips");
            this.gez = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.geA = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
