package com.baidu.tbadk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareFromGameCenterMsgData extends ShareFromPBMsgData {
    protected String button;
    protected String shareSource;
    protected String shareSourceIcon;
    protected String shareSourceUrl;
    protected String shareUrl;

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData, com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TbTitleActivityConfig.FORUM_NAME, this.forumName);
            jSONObject.put("postID", this.postId);
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeID", this.threadId);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
            jSONObject.put("button", this.button);
            jSONObject.put("shareSource", this.shareSource);
            jSONObject.put("shareSourceIcon", this.shareSourceIcon);
            jSONObject.put("shareSourceUrl", this.shareSourceUrl);
            jSONObject.put(WBConstants.SDK_WEOYOU_SHAREURL, this.shareUrl);
            JSONArray jSONArray = new JSONArray();
            String str = "";
            if (!TextUtils.isEmpty(this.title)) {
                str = "【" + this.title + "】";
            }
            if (!TextUtils.isEmpty(this.content)) {
                str = str + this.content;
            }
            jSONArray.put(str);
            jSONArray.put("1");
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public String getShareSourceIcon() {
        return this.shareSourceIcon;
    }

    public void setShareSourceIcon(String str) {
        this.shareSourceIcon = str;
    }

    public String getShareSource() {
        return this.shareSource;
    }

    public void setShareSource(String str) {
        this.shareSource = str;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public String getShareSourceUrl() {
        return this.shareSourceUrl;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public void setShareSourceUrl(String str) {
        this.shareSourceUrl = str;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public String getButton() {
        return this.button;
    }

    public void setButton(String str) {
        this.button = str;
    }
}
