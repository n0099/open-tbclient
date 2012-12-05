package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrsStarData {
    private int is_star_forum = 0;
    private int is_open = 0;
    private String top_pic_url = null;
    private String photo_url = null;
    private int is_fan = 0;
    private int fan_num = 0;
    private int top_pic_w = 0;
    private int top_pic_h = 0;
    private int photo_w = 0;
    private int photo_h = 0;
    private long left_time = 0;
    private long show_time = 0;

    public int isStarForum() {
        return this.is_star_forum;
    }

    public String getTopPic() {
        return this.top_pic_url;
    }

    public String getPhoto() {
        return this.photo_url;
    }

    public int getTopPicWidth() {
        return this.top_pic_w;
    }

    public int getTopPicHeight() {
        return this.top_pic_h;
    }

    public int getPhotoWidth() {
        return this.photo_w;
    }

    public int getPhotoHeight() {
        return this.photo_h;
    }

    public int isOpen() {
        return this.is_open;
    }

    public void setIsOpen(int i) {
        this.is_open = i;
    }

    public long getLeftTime() {
        return this.left_time;
    }

    public long getShowTime() {
        return this.show_time;
    }

    public void setShowTime(long time) {
        this.show_time = time;
    }

    public void setIsFan(int isFan) {
        this.is_fan = isFan;
    }

    public int isFan() {
        return this.is_fan;
    }

    public void setFanNum(int num) {
        this.fan_num = num;
    }

    public int getFanNum() {
        return this.fan_num;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("FrsStarData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.is_star_forum = json.optInt("has_frs_star", 0);
                if (this.is_star_forum == 1) {
                    this.top_pic_url = json.optString("top", "");
                    this.photo_url = json.optString("head", "");
                    JSONObject fans = json.optJSONObject(Config.BROADCAST_FANS_NUM);
                    this.is_fan = fans.optInt("is_get", 0);
                    this.fan_num = fans.optInt("num", 0);
                    this.is_open = fans.optInt(Config.ST_TYPE_OPEN, 0);
                    this.left_time = fans.optLong("left_time", 0L);
                    this.show_time = this.left_time;
                    JSONObject top_pic_size = json.optJSONObject("top_size");
                    this.top_pic_w = top_pic_size.optInt("width", 0);
                    this.top_pic_h = top_pic_size.optInt("height", 0);
                    JSONObject photo_size = json.optJSONObject("head_size");
                    this.photo_w = photo_size.optInt("width", 0);
                    this.photo_h = photo_size.optInt("height", 0);
                }
            } catch (Exception ex) {
                TiebaLog.e("FrsStarData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("FrsStarData", "logPrint", "is_star_forum = " + String.valueOf(this.is_star_forum));
        TiebaLog.v("FrsStarData", "logPrint", "is_open = " + String.valueOf(this.is_open));
        TiebaLog.v("FrsStarData", "logPrint", "top_pic_url = " + this.top_pic_url);
        TiebaLog.v("FrsStarData", "logPrint", "photo_url = " + this.photo_url);
        TiebaLog.v("FrsStarData", "logPrint", "is_fan = " + String.valueOf(this.is_fan));
        TiebaLog.v("FrsStarData", "logPrint", "fan_num = " + String.valueOf(this.fan_num));
        TiebaLog.v("FrsStarData", "logPrint", "top_pic_w = " + String.valueOf(this.top_pic_w));
        TiebaLog.v("FrsStarData", "logPrint", "top_pic_h = " + String.valueOf(this.top_pic_h));
        TiebaLog.v("FrsStarData", "logPrint", "photo_w = " + String.valueOf(this.photo_w));
        TiebaLog.v("FrsStarData", "logPrint", "photo_h = " + String.valueOf(this.photo_h));
        TiebaLog.v("FrsStarData", "logPrint", "left_time = " + String.valueOf(this.left_time));
    }
}
