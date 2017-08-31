package com.baidu.tbadk.img;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String Qq;
    public int height;
    public String picId;
    public String picUrl;
    public String pkgId;
    public String thumbnail;
    public int width;

    public static c h(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.picId = jSONObject.optString("pic_id");
            cVar.width = jSONObject.optInt("width");
            cVar.height = jSONObject.optInt("height");
            cVar.picUrl = jSONObject.optString("pic_url");
            cVar.thumbnail = jSONObject.optString("thumbnail");
            cVar.Qq = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception e) {
            return null;
        }
    }
}
