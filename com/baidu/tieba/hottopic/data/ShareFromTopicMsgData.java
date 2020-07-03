package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareBaseMsgData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ShareFromTopicMsgData extends ShareBaseMsgData {
    protected String content;
    protected String hotTopicID;
    protected String hotTopicName;
    protected String imageUrl;
    protected String linkUrl;
    protected String title;

    @Override // com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("themeContent", this.content);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            jSONObject.put("themeTitle", this.title);
            jSONObject.put("hotTopicID", this.hotTopicID);
            jSONObject.put("hotTopicName", this.hotTopicName);
            jSONObject.put("shareSourceUrl", this.linkUrl);
            jSONObject.put("type", "5");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.title + " http://tieba.baidu.com/p/?share=9105");
            jSONArray.put("1");
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
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

    public String getHotTopicID() {
        return this.hotTopicID;
    }

    public void setHotTopicID(String str) {
        this.hotTopicID = str;
    }

    public String getHotTopicName() {
        return this.hotTopicName;
    }

    public void setHotTopicName(String str) {
        this.hotTopicName = str;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }
}
