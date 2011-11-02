package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoodData {
    private String class_name = null;
    private int class_id = 0;

    public void setClass_name(String name) {
        this.class_name = name;
    }

    public String getClass_name() {
        return this.class_name;
    }

    public void setClass_id(int id) {
        this.class_id = id;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("GoodData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.class_id = json.optInt("class_id", 0);
                this.class_name = json.optString("class_name");
            } catch (Exception ex) {
                TiebaLog.e("GoodData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }
}
