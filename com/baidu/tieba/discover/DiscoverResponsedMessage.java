package com.baidu.tieba.discover;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DiscoverResponsedMessage extends JsonHttpResponsedMessage {
    j a;

    public DiscoverResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        int d = d();
        int e = e();
        if (d == 200 && e == 0 && jSONObject != null) {
            this.a = new j();
            this.a.a = jSONObject.optInt("errno");
            this.a.b = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("banner");
            if (optJSONObject != null) {
                this.a.d = new i(optJSONObject.optString("link"), optJSONObject.optString("pic_url"), optJSONObject.optString("title"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
            if (optJSONArray != null) {
                this.a.c = new ArrayList(optJSONArray.length());
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    this.a.c.add(new l(jSONObject2.optString("icon_url"), jSONObject2.optString("title"), jSONObject2.optString("link_url"), jSONObject2.optInt("is_new")));
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("msign");
            this.a.e = new k(optJSONObject2.optString("msign_text"), optJSONObject2.optInt("can_msign", 0));
        }
    }
}
