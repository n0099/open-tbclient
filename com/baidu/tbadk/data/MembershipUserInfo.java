package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes3.dex */
public class MembershipUserInfo extends OrmObject implements Serializable {
    public static final long serialVersionUID = 1;
    public String mContent;
    public String mLink;
    public String mTitle;
    public String mVipIcon;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mVipIcon = jSONObject.optString("vip_icon");
        this.mLink = jSONObject.optString("link");
        this.mContent = jSONObject.optString("content");
        this.mTitle = jSONObject.optString("title");
    }

    public void parserProtobuf(VipShowInfo vipShowInfo) {
        if (vipShowInfo == null) {
            return;
        }
        this.mVipIcon = vipShowInfo.vip_icon;
        this.mLink = vipShowInfo.link;
        this.mContent = vipShowInfo.content;
        this.mTitle = vipShowInfo.title;
    }
}
