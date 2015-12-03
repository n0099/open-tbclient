package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes.dex */
public class MembershipUserInfo extends i implements Serializable {
    private static final long serialVersionUID = 1;
    private String mContent;
    private String mLink;
    private String mVipIcon;

    public void setVipIcon(String str) {
        this.mVipIcon = str;
    }

    public String getVipIcon() {
        return this.mVipIcon;
    }

    public void setVipLink(String str) {
        this.mLink = str;
    }

    public String getVipLink() {
        return this.mLink;
    }

    public void setVipContent(String str) {
        this.mContent = str;
    }

    public String getVipContent() {
        return this.mContent;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mVipIcon = jSONObject.optString("vip_icon");
            this.mLink = jSONObject.optString("link");
            this.mContent = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
        }
    }

    public void parserProtobuf(VipShowInfo vipShowInfo) {
        if (vipShowInfo != null) {
            this.mVipIcon = vipShowInfo.vip_icon;
            this.mLink = vipShowInfo.link;
            this.mContent = vipShowInfo.content;
        }
    }
}
