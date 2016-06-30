package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes.dex */
public class MembershipUserInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 1;
    public String mContent;
    public String mLink;
    public String mTitle;
    public String mVipIcon;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mVipIcon = jSONObject.optString("vip_icon");
            this.mLink = jSONObject.optString("link");
            this.mContent = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.mTitle = jSONObject.optString("title");
        }
    }

    public void parserProtobuf(VipShowInfo vipShowInfo) {
        if (vipShowInfo != null) {
            this.mVipIcon = vipShowInfo.vip_icon;
            this.mLink = vipShowInfo.link;
            this.mContent = vipShowInfo.content;
            this.mTitle = vipShowInfo.title;
        }
    }
}
