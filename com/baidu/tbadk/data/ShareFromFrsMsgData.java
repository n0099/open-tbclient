package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareFromFrsMsgData extends ShareBaseMsgData {
    protected String content;
    protected String imageUrl;
    protected int memberNum;
    protected String name;
    protected int postNum;

    @Override // com.baidu.tbadk.data.ShareBaseMsgData
    public String toChatMessageContent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TbTitleActivityConfig.FORUM_NAME, this.name);
            jSONObject.put("memberNum", this.memberNum);
            jSONObject.put("postNum", this.postNum);
            jSONObject.put("themeContent", this.name + "\n关注：" + this.memberNum + " 帖子：" + this.postNum);
            jSONObject.put("themeImageUrl", this.imageUrl == null ? "" : this.imageUrl);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("【" + this.name + "吧】 " + this.content + " " + TbConfig.HTTPS_FRS_PREFIX + this.name);
            jSONArray.put("4");
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public int getPostNum() {
        return this.postNum;
    }

    public void setPostNum(int i) {
        this.postNum = i;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
