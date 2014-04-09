package com.baidu.tieba.discover;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DiscoverResponsedMessage extends JsonHttpResponsedMessage {
    n a;

    public DiscoverResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        int d = d();
        int e = e();
        if (d == 200 && e == 0 && jSONObject != null) {
            this.a = b(jSONObject);
        }
    }

    public static n b(JSONObject jSONObject) {
        n nVar = new n();
        nVar.a = jSONObject.optInt("errno");
        nVar.b = jSONObject.optString("errmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("banner");
        if (optJSONObject != null) {
            nVar.d = new m(optJSONObject.optString("link"), optJSONObject.optString("pic_url"), optJSONObject.optString("title"));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
        if (optJSONArray != null) {
            nVar.c = new ArrayList(optJSONArray.length());
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                nVar.c.add(new p(jSONObject2.optString("icon_url"), jSONObject2.optString("title"), jSONObject2.optString("link_url"), jSONObject2.optInt("is_new")));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("msign");
        if (optJSONObject2 != null) {
            nVar.e = new o(optJSONObject2.optString("msign_text"), optJSONObject2.optInt("can_msign", 0));
        }
        return nVar;
    }
}
