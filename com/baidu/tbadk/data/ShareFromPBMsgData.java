package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareFromPBMsgData extends ShareBaseMsgData {
    public String content;
    public String forumName;
    public String imageUrl;
    public String postId;
    public String shareSourceUrl;
    public String theNewThemeId;
    public String threadId;
    public int threadType;
    public String title;

    public String getContent() {
        return this.content;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getShareSourceUrl() {
        return this.shareSourceUrl;
    }

    public String getTheNewThemeId() {
        return this.theNewThemeId;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setShareSourceUrl(String str) {
        this.shareSourceUrl = str;
    }

    public void setTheNewThemeId(String str) {
        this.theNewThemeId = str;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forumName", this.forumName);
            jSONObject.put("postID", this.postId);
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeID", this.threadId);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
            jSONObject.put("theNewThemeID", this.theNewThemeId);
            jSONObject.put("threadType", this.threadType);
            if (!StringUtils.isNull(this.shareSourceUrl)) {
                jSONObject.put("shareSourceUrl", this.shareSourceUrl);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.title + " http://tieba.baidu.com/p/" + this.threadId + "?share=9105");
            jSONArray.put("1");
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
