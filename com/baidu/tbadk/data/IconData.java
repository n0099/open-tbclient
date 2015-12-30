package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Icon;
import tbclient.TshowInfo;
/* loaded from: classes.dex */
public class IconData extends i implements Serializable {
    public static String meizhi_icon_name = "meizhi_level";
    public static String redi_icon_name = "is_verify";
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
                BdLog.e(e.toString());
            }
        }
    }

    public void parserProtobuf(Icon icon) {
        if (icon != null) {
            this.icon = icon.icon;
            this.name = icon.name;
            this.url = icon.url;
        }
    }

    public void parserProtobuf(TshowInfo tshowInfo) {
        if (tshowInfo != null) {
            this.icon = tshowInfo.icon;
            this.name = tshowInfo.name;
            this.url = tshowInfo.url;
        }
    }
}
