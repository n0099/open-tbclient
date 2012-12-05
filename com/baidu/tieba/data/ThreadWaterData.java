package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ThreadWaterData {
    private String mTid = null;
    private String mAuthor = null;
    private String mTitle = null;
    private int mReplyNum = 0;
    private WaterFallImageData mImage = new WaterFallImageData();

    public String getName() {
        return this.mAuthor;
    }

    public WaterFallImageData getImage() {
        return this.mImage;
    }

    public void setName(String name) {
        this.mAuthor = name;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setTid(String tid) {
        this.mTid = tid;
    }

    public String getTid() {
        return this.mTid;
    }

    public int getReplyNum() {
        return this.mReplyNum;
    }

    public void setReplyNum(int replyNum) {
        this.mReplyNum = replyNum;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.mTid = json.optString("tid");
                this.mTitle = json.optString("title");
                this.mReplyNum = json.optInt("reply_amount", 0);
                JSONObject user = json.optJSONObject("user");
                if (user != null) {
                    this.mAuthor = user.optString("name_show");
                }
                this.mImage.parserJson(json.optJSONObject("photo"));
            } catch (Exception ex) {
                TiebaLog.e("HotspotData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("InfoData", "parserJson", "error = " + ex.getMessage());
        }
    }
}
