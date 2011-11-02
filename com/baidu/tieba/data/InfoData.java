package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class InfoData implements Serializable {
    private static final long serialVersionUID = 6267023967260890640L;
    private String pic_id = null;
    private int width = 0;
    private int height = 0;

    public String getPic_id() {
        return this.pic_id;
    }

    public void setPic_id(String pic_id) {
        this.pic_id = pic_id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("InfoData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.pic_id = json.optString("pic_id");
                this.width = json.optInt("width", 0);
                this.height = json.optInt("height", 0);
            } catch (Exception ex) {
                TiebaLog.e("InfoData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("InfoData", "logPrint", "pic_id = " + this.pic_id);
        TiebaLog.v("InfoData", "logPrint", "width = " + String.valueOf(this.width));
        TiebaLog.v("InfoData", "logPrint", "height = " + String.valueOf(this.height));
    }
}
