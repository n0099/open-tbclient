package com.baidu.tieba.data;

import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData {
    private String id = null;
    private int type = 0;
    private String name = null;
    private String name_show = null;
    private String portrait = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName_show(String name_show) {
        this.name_show = name_show;
    }

    public String getName_show() {
        return this.name_show;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("MetaData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.type = json.optInt(MentionActivity.TYPE, 0);
                this.name = json.optString(PersonInfoActivity.TAG_NAME);
                this.name_show = json.optString("name_show");
                this.portrait = json.optString("portrait");
            } catch (Exception ex) {
                TiebaLog.e("MetaData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("MetaData", "logPrint", "id = " + this.id);
        TiebaLog.v("MetaData", "logPrint", "type = " + String.valueOf(this.type));
        TiebaLog.v("MetaData", "logPrint", "name = " + this.name);
        TiebaLog.v("MetaData", "logPrint", "name_show = " + this.name_show);
        TiebaLog.v("MetaData", "logPrint", "portrait = " + this.portrait);
    }
}
