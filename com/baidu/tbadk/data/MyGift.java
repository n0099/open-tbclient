package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.GiftInfo;
/* loaded from: classes3.dex */
public class MyGift extends OrmObject implements Serializable {
    public static final long serialVersionUID = 1;
    public String mGiftIcon;
    public String mGiftName;
    public int mGiftNum;
    public String mSender;

    public String getGiftIcon() {
        return this.mGiftIcon;
    }

    public String getGiftName() {
        return this.mGiftName;
    }

    public int getGiftNum() {
        return this.mGiftNum;
    }

    public String getSender() {
        return this.mSender;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mGiftIcon = jSONObject.optString("icon");
        this.mGiftNum = jSONObject.optInt("num");
    }

    public void parserProtobuf(GiftInfo giftInfo) {
        if (giftInfo == null) {
            return;
        }
        this.mGiftIcon = giftInfo.icon;
        this.mGiftNum = giftInfo.num.intValue();
        this.mGiftName = giftInfo.gift_name;
        this.mSender = giftInfo.sender_name;
    }

    public void setGiftIcon(String str) {
        this.mGiftIcon = str;
    }

    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    public void setGiftNum(int i) {
        this.mGiftNum = i;
    }

    public void setSender(String str) {
        this.mSender = str;
    }
}
