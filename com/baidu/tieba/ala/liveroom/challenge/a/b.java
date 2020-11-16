package com.baidu.tieba.ala.liveroom.challenge.a;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String bgurl;
    public String file;
    public int gZN;
    public int gZO;
    public int gZP;
    public int gZQ;
    public String gZR;
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
            this.gZN = jSONObject.optInt(FuFaceItem.JK_ABILITY);
            this.gZO = jSONObject.optInt("control_mode");
            this.gZP = jSONObject.optInt(FuFaceItem.JK_MIN_SDK_VERSION);
            this.gZQ = jSONObject.optInt(FuFaceItem.JK_MAX_SDK_VERSION);
            this.gZR = jSONObject.optString("file_md5");
            this.sk = jSONObject.optString("sk");
        }
    }
}
