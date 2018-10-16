package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.GiftInfo;
/* loaded from: classes.dex */
public class MyGift extends OrmObject implements Serializable {
    private static final long serialVersionUID = 1;
    private String mGiftIcon;
    private String mGiftName;
    private int mGiftNum;
    private String mSender;

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

    public String getGiftName() {
        return this.mGiftName;
    }

    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    public String getSender() {
        return this.mSender;
    }

    public void setSender(String str) {
        this.mSender = str;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mGiftIcon = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
            this.mGiftNum = jSONObject.optInt("num");
        }
    }

    public void parserProtobuf(GiftInfo giftInfo) {
        if (giftInfo != null) {
            this.mGiftIcon = giftInfo.icon;
            this.mGiftNum = giftInfo.num.intValue();
            this.mGiftName = giftInfo.gift_name;
            this.mSender = giftInfo.sender_name;
        }
    }
}
