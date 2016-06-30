package com.baidu.tbadk.data;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.TailInfo;
/* loaded from: classes.dex */
public class b {
    private int aom;
    private String content;
    private String icon_link;
    private String icon_url;

    public void parserJson(JSONObject jSONObject) {
        try {
            this.icon_url = jSONObject.optString("icon_url");
            this.icon_link = jSONObject.optString("icon_link");
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.aom = jSONObject.optInt("tail_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(TailInfo tailInfo) {
        try {
            this.icon_url = tailInfo.icon_url;
            this.icon_link = tailInfo.icon_link;
            this.content = tailInfo.content;
            this.aom = tailInfo.tail_type.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String Az() {
        return this.icon_link;
    }

    public String getContent() {
        return this.content;
    }

    public int AA() {
        return this.aom;
    }
}
