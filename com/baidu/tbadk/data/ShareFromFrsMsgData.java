package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareFromFrsMsgData extends ShareBaseMsgData {
    public String content;
    public String imageUrl;
    public int memberNum;
    public String name;
    public int postNum;

    public String getContent() {
        return this.content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getName() {
        return this.name;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPostNum(int i) {
        this.postNum = i;
    }

    @Override // com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forumName", this.name);
            jSONObject.put("memberNum", this.memberNum);
            jSONObject.put("postNum", this.postNum);
            jSONObject.put("themeContent", this.name + "\n关注：" + this.memberNum + " 帖子：" + this.postNum);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("【" + this.name + "吧】 " + this.content + " " + TbConfig.HTTPS_FRS_PREFIX + this.name);
            jSONArray.put("4");
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }
}
