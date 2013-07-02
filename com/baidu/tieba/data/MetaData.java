package com.baidu.tieba.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = -2969858506144441193L;
    private String id = null;
    private int type = 0;
    private String name = null;
    private String name_show = null;
    private String portrait = null;

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName_show(String str) {
        this.name_show = str;
    }

    public String getName_show() {
        return this.name_show;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MetaData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.type = jSONObject.optInt("type", 0);
                this.name = jSONObject.optString("name");
                if (this.name != null && this.name.length() <= 0) {
                    this.name = null;
                }
                this.name_show = jSONObject.optString("name_show");
                this.portrait = jSONObject.optString("portrait");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("MetaData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.tieba.util.z.d("MetaData", "logPrint", "id = " + this.id);
        com.baidu.tieba.util.z.d("MetaData", "logPrint", "type = " + String.valueOf(this.type));
        com.baidu.tieba.util.z.d("MetaData", "logPrint", "name = " + this.name);
        com.baidu.tieba.util.z.d("MetaData", "logPrint", "name_show = " + this.name_show);
        com.baidu.tieba.util.z.d("MetaData", "logPrint", "portrait = " + this.portrait);
    }
}
