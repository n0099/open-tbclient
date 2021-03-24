package com.baidu.tbadk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareFromGameCenterMsgData extends ShareFromPBMsgData {
    public String button;
    public String shareSource;
    public String shareSourceIcon;
    public String shareSourceUrl;
    public String shareUrl;

    public String getButton() {
        return this.button;
    }

    public String getShareSource() {
        return this.shareSource;
    }

    public String getShareSourceIcon() {
        return this.shareSourceIcon;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public String getShareSourceUrl() {
        return this.shareSourceUrl;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setShareSource(String str) {
        this.shareSource = str;
    }

    public void setShareSourceIcon(String str) {
        this.shareSourceIcon = str;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData
    public void setShareSourceUrl(String str) {
        this.shareSourceUrl = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    @Override // com.baidu.tbadk.data.ShareFromPBMsgData, com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forumName", this.forumName);
            jSONObject.put("postID", this.postId);
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeID", this.threadId);
            String str = "";
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
            jSONObject.put("button", this.button);
            jSONObject.put("shareSource", this.shareSource);
            jSONObject.put("shareSourceIcon", this.shareSourceIcon);
            jSONObject.put("shareSourceUrl", this.shareSourceUrl);
            jSONObject.put("shareUrl", this.shareUrl);
            JSONArray jSONArray = new JSONArray();
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
        } catch (JSONException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
