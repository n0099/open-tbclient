package com.baidu.tbadk.data;

import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes.dex */
public class c {
    private String content;
    private int dVx;
    private String icon_link;
    private String icon_url;

    public void parserJson(JSONObject jSONObject) {
        try {
            this.icon_url = jSONObject.optString("icon_url");
            this.icon_link = jSONObject.optString("icon_link");
            this.content = jSONObject.optString("content");
            this.dVx = jSONObject.optInt("tail_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(TailInfo tailInfo) {
        try {
            this.icon_url = tailInfo.icon_url;
            this.icon_link = tailInfo.icon_link;
            this.content = tailInfo.content;
            this.dVx = tailInfo.tail_type.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
