package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes.dex */
public class MembershipUserInfo extends OrmObject implements Serializable {
    private static final long serialVersionUID = 1;
    public String mContent;
    public String mLink;
    public String mTitle;
    public String mVipIcon;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mVipIcon = jSONObject.optString("vip_icon");
            this.mLink = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            this.mContent = jSONObject.optString("content");
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
