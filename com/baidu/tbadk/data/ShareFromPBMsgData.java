package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShareFromPBMsgData extends ShareBaseMsgData {
    protected String content;
    protected String forumName;
    protected String imageUrl;
    protected String postId;
    protected String shareSourceUrl;
    protected String theNewThemeId;
    protected String threadId;
    protected int threadType;
    protected String title;

    @Override // com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TbTitleActivityConfig.FORUM_NAME, this.forumName);
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
        } catch (JSONException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getTheNewThemeId() {
        return this.theNewThemeId;
    }

    public void setTheNewThemeId(String str) {
        this.theNewThemeId = str;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setShareSourceUrl(String str) {
        this.shareSourceUrl = str;
    }

    public String getShareSourceUrl() {
        return this.shareSourceUrl;
    }
}
