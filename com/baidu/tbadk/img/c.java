package com.baidu.tbadk.img;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String bTb;
    public int height;
    public String picId;
    public String picUrl;
    public String pkgId;
    public String thumbnail;
    public int width;

    public static c bB(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.picId = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.width = jSONObject.optInt("width");
            cVar.height = jSONObject.optInt("height");
            cVar.picUrl = jSONObject.optString("pic_url");
            cVar.thumbnail = jSONObject.optString("thumbnail");
            cVar.bTb = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception e) {
            return null;
        }
    }
}
