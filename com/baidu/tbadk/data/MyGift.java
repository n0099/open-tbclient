package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class MyGift extends i implements Serializable {
    private static final long serialVersionUID = 1;
    private String mGiftIcon;
    private int mGiftNum;

    public String getGiftIcon() {
        return this.mGiftIcon;
    }

    public void setGiftIcon(String str) {
        this.mGiftIcon = str;
    }

    public int getGiftNum() {
        return this.mGiftNum;
    }

    public void setGiftNum(int i) {
        this.mGiftNum = i;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mGiftIcon = jSONObject.optString("icon");
            this.mGiftNum = jSONObject.optInt("num");
        }
    }

    public void parserProtobuf(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.mGiftIcon = giftInfo.icon;
            this.mGiftNum = giftInfo.num.intValue();
        }
    }
}
