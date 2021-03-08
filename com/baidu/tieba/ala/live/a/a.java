package com.baidu.tieba.ala.live.a;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String channel;
    public String iconUrl;
    public boolean isDefault;
    public String prompt;
    public String tag;
    public String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.channel = jSONObject.optString("channel");
            this.title = jSONObject.optString("title");
            this.iconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            this.tag = jSONObject.optString("tag_name");
            this.prompt = jSONObject.optString("prompt_text");
            this.isDefault = jSONObject.optInt("is_default") == 1;
        }
    }
}
