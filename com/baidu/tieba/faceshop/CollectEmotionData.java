package com.baidu.tieba.faceshop;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CollectEmotionData extends EmotionData {
    public int height;
    public ImageFileInfo imageFileInfo;
    public String picUrl;
    public String pid;
    public String pkgId;
    public String thumbnail;
    public String uid;
    public int width;
    public String backup = "";
    public boolean isSelect = false;
    public int selectIndex = -1;

    public JSONObject toJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.pid);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
