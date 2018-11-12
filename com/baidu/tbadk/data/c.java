package com.baidu.tbadk.data;

import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes.dex */
public class c {
    private int aTn;
    private String content;
    private String icon_link;
    private String icon_url;

    public void parserJson(JSONObject jSONObject) {
        try {
            this.icon_url = jSONObject.optString(AiAppsApsUtils.ICON_URL);
            this.icon_link = jSONObject.optString("icon_link");
            this.content = jSONObject.optString("content");
            this.aTn = jSONObject.optInt("tail_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(TailInfo tailInfo) {
        try {
            this.icon_url = tailInfo.icon_url;
            this.icon_link = tailInfo.icon_link;
            this.content = tailInfo.content;
            this.aTn = tailInfo.tail_type.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
