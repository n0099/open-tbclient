package com.baidu.tieba.discover;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DiscoverResponsedMessage extends JsonHttpResponsedMessage {
    v mData;

    public DiscoverResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = parseJson(jSONObject);
        }
    }

    public static v parseJson(JSONObject jSONObject) {
        v vVar = new v();
        vVar.amt = jSONObject.optInt("errno");
        vVar.mErrMsg = jSONObject.optString("errmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("banner");
        if (optJSONObject != null) {
            vVar.atg = new u(optJSONObject.optString("link"), optJSONObject.optString("pic_url"), optJSONObject.optString("title"));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
        if (optJSONArray != null) {
            vVar.atf = new ArrayList(optJSONArray.length());
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                vVar.atf.add(new y(jSONObject2.optString("icon_url"), jSONObject2.optString("title"), jSONObject2.optString("link_url"), jSONObject2.optInt("is_new")));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("msign");
        if (optJSONObject2 != null) {
            vVar.ath = new x(optJSONObject2.optString("msign_text"), optJSONObject2.optInt("can_msign", 0));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("game_center");
        if (optJSONObject3 != null) {
            vVar.ati = new w(optJSONObject3.optLong("gameLastLaunchtime", 0L), optJSONObject3.optString("link_url"));
        }
        return vVar;
    }
}
