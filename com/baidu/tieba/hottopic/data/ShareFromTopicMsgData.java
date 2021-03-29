package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.ShareBaseMsgData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareFromTopicMsgData extends ShareBaseMsgData {
    public String content;
    public String hotTopicID;
    public String hotTopicName;
    public String imageUrl;
    public String linkUrl;
    public String title;

    public String getContent() {
        return this.content;
    }

    public String getHotTopicID() {
        return this.hotTopicID;
    }

    public String getHotTopicName() {
        return this.hotTopicName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setHotTopicID(String str) {
        this.hotTopicID = str;
    }

    public void setHotTopicName(String str) {
        this.hotTopicName = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

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
        } catch (JSONException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
