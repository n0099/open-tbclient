package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IconData implements Serializable {
    public static String meizhi_icon_name = "meizhi_level";
    private static final long serialVersionUID = 5554483396003492966L;
    private String icon = null;
    private String name = null;

    public String getIconUrl() {
        return this.icon;
    }

    public String getIconName() {
        return this.name;
    }

    public void setIconUrl(String str) {
        this.icon = str;
    }

    public void setIconName(String str) {
        this.name = str;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.icon = jSONObject.optString("icon");
                this.name = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
