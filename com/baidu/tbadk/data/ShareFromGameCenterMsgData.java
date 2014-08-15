package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
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

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forumName", this.forumName);
            jSONObject.put("postID", this.postId);
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeID", this.threadId);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
            jSONObject.put("button", this.button);
            jSONObject.put("shareSource", this.shareSource);
            jSONObject.put("shareSourceIcon", this.shareSourceIcon);
            jSONObject.put("shareSourceUrl", this.shareSourceUrl);
            jSONObject.put("shareUrl", this.shareUrl);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(String.valueOf(this.title) + " http://tieba.baidu.com/p/" + this.threadId + "?share=9105");
            jSONArray.put(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
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

    public String getShareSourceUrl() {
        return this.shareSourceUrl;
    }

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
