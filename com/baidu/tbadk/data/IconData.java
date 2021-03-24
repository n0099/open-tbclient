package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Icon;
import tbclient.TshowInfo;
/* loaded from: classes3.dex */
public class IconData extends OrmObject implements Serializable {
    public static String meizhi_icon_name = "meizhi_level";
    public static String redi_icon_name = "is_verify";
    public static final long serialVersionUID = 5554483396003492966L;
    public String icon;
    public String name;
    public String url;

    public IconData() {
        this.icon = null;
        this.name = null;
        this.url = null;
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

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.icon = jSONObject.optString("icon");
            this.name = jSONObject.optString("name");
            this.url = jSONObject.optString("url");
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void parserProtobuf(Icon icon) {
        if (icon == null) {
            return;
        }
        this.icon = icon.icon;
        this.name = icon.name;
        this.url = icon.url;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void parserProtobuf(TshowInfo tshowInfo) {
        if (tshowInfo == null) {
            return;
        }
        this.icon = tshowInfo.icon;
        this.name = tshowInfo.name;
        this.url = tshowInfo.url;
    }

    public IconData(String str, String str2, String str3) {
        this.icon = str;
        this.name = str2;
        this.url = str3;
    }
}
