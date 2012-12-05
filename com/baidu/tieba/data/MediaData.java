package com.baidu.tieba.data;

import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MediaData {
    private int type = -1;
    private String pic_url = null;
    private String video_url = null;

    public int getType() {
        return this.type;
    }

    public String getPicUrl() {
        return this.pic_url;
    }

    public String getSmallUrl() {
        return this.pic_url;
    }

    public String getVideoUrl() {
        return this.video_url;
    }

    public void setType(int t) {
        this.type = t;
    }

    public void setPic(String url) {
        this.pic_url = url;
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.type = json.optInt(MentionActivity.TYPE);
                if (this.type == 3) {
                    this.pic_url = json.optString("big_pic");
                } else if (this.type == 5) {
                    this.pic_url = json.optString("vpic");
                    this.video_url = json.optString("vsrc");
                }
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
