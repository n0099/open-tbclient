package com.baidu.tbadk.img;

import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public String aDX;
    public int height;
    public String picId;
    public String picUrl;
    public String thumbnail;
    public int width;

    public static c m(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.picId = jSONObject.optString(GraffitiVcodeActivityConfig.PIC_ID);
            cVar.width = jSONObject.optInt("width");
            cVar.height = jSONObject.optInt("height");
            cVar.picUrl = jSONObject.optString("pic_url");
            cVar.thumbnail = jSONObject.optString("thumbnail");
            return cVar;
        } catch (Exception e) {
            return null;
        }
    }
}
