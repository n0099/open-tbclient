package com.baidu.tieba.ala.liveroom.challenge.a;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String bgurl;
    public String file;
    public int gqB;
    public int gqC;
    public int gqD;
    public int gqE;
    public String gqF;
    public String id;
    public String name;
    public String sk;
    public int subType;
    public String tip;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.file = jSONObject.optString("file");
            this.bgurl = jSONObject.optString("bgurl");
            this.subType = jSONObject.optInt(FuFaceItem.JK_SUB_TYPE);
            this.tip = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            this.gqB = jSONObject.optInt(FuFaceItem.JK_ABILITY);
            this.gqC = jSONObject.optInt("control_mode");
            this.gqD = jSONObject.optInt(FuFaceItem.JK_MIN_SDK_VERSION);
            this.gqE = jSONObject.optInt(FuFaceItem.JK_MAX_SDK_VERSION);
            this.gqF = jSONObject.optString("file_md5");
            this.sk = jSONObject.optString("sk");
        }
    }
}
