package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareFromPBMsgData implements Serializable {
    private String content;
    private String forumName;
    private String imageUrl;
    private String postId;
    private String threadId;
    private String title;

    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forumName", this.forumName);
            jSONObject.put("postID", this.postId);
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeID", this.threadId);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
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
}
