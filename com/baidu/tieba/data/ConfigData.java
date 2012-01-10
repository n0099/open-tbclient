package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ConfigData {
    private int pb_max_floor_total_num = 0;
    private int pb_big_image_width = 0;
    private int img_chunk_upload_enable = 1;
    private String big_head_image_host = null;
    private String small_head_image_host = null;
    private String yijianfankui_fname = null;
    private String yijianfankui_fid = null;

    public String getYijianfankui_fname() {
        return this.yijianfankui_fname;
    }

    public void setYijianfankui_fname(String yijianfankui_fname) {
        this.yijianfankui_fname = yijianfankui_fname;
    }

    public String getYijianfankui_fid() {
        return this.yijianfankui_fid;
    }

    public void setYijianfankui_fid(String yijianfankui_fid) {
        this.yijianfankui_fid = yijianfankui_fid;
    }

    public void setPb_max_floor_total_num(int pb_max_floor_total_num) {
        this.pb_max_floor_total_num = pb_max_floor_total_num;
    }

    public int getPb_max_floor_total_num() {
        return this.pb_max_floor_total_num;
    }

    public String getBig_head_image_host() {
        return this.big_head_image_host;
    }

    public void setBig_head_image_host(String big_head_image_host) {
        this.big_head_image_host = big_head_image_host;
    }

    public String getSmall_head_image_host() {
        return this.small_head_image_host;
    }

    public void setSmall_head_image_host(String small_head_image_host) {
        this.small_head_image_host = small_head_image_host;
    }

    public void setPb_big_image_width(int pb_big_image_width) {
        this.pb_big_image_width = pb_big_image_width;
    }

    public int getPb_big_image_width() {
        return this.pb_big_image_width;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.pb_max_floor_total_num = json.optInt("pb_max_floor_total_num", 0);
                this.pb_big_image_width = json.optInt("pb_big_image_width", 0);
                this.big_head_image_host = json.optString("big_head_image_host");
                this.small_head_image_host = json.optString("small_head_image_host");
                this.yijianfankui_fname = json.optString("yijianfankui_fname");
                this.yijianfankui_fid = json.optString("yijianfankui_fid");
                this.img_chunk_upload_enable = json.optInt("img_chunk_upload_enable", 1);
                Config.setPbListNum(this.pb_max_floor_total_num);
                Config.setThreadImageWidth(this.pb_big_image_width);
                Config.setBigPhotoAdress(this.big_head_image_host);
                Config.setSmallPhotoAdress(this.small_head_image_host);
                Config.setFeedBack(this.yijianfankui_fname, this.yijianfankui_fid);
                Config.setImgChunkUploadEnable(this.img_chunk_upload_enable);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "parserJson", ex.getMessage());
            }
        }
    }
}
