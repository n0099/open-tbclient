package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.f;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IconData implements Serializable {
    public static String meizhi_icon_name = "meizhi_level";
    private static final long serialVersionUID = 5554483396003492966L;
    private String icon;
    private String name;
    private String url;

    public IconData() {
        this.icon = null;
        this.name = null;
        this.url = null;
    }

    public IconData(String str, String str2, String str3) {
        this.icon = str;
        this.name = str2;
        this.url = str3;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconName(String str) {
        this.name = str;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.icon = jSONObject.optString("icon");
                this.name = jSONObject.optString("name");
                this.url = jSONObject.optString("url");
            } catch (Exception e) {
                f.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
