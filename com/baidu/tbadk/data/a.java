package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes.dex */
public class a {
    private int aAl;
    private String content;
    private String icon_link;
    private String icon_url;

    public void parserJson(JSONObject jSONObject) {
        try {
            this.icon_url = jSONObject.optString("icon_url");
            this.icon_link = jSONObject.optString("icon_link");
            this.content = jSONObject.optString("content");
            this.aAl = jSONObject.optInt("tail_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(TailInfo tailInfo) {
        try {
            this.icon_url = tailInfo.icon_url;
            this.icon_link = tailInfo.icon_link;
            this.content = tailInfo.content;
            this.aAl = tailInfo.tail_type.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String Cq() {
        return this.icon_link;
    }
}
