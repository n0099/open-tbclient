package com.baidu.tieba.discover;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DiscoverResponsedMessage extends JsonHttpResponsedMessage {
    p mData;

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

    public static p parseJson(JSONObject jSONObject) {
        p pVar = new p();
        pVar.afd = jSONObject.optInt("errno");
        pVar.mErrMsg = jSONObject.optString("errmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("banner");
        if (optJSONObject != null) {
            pVar.aoe = new o(optJSONObject.optString("link"), optJSONObject.optString("pic_url"), optJSONObject.optString("title"));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("menu_list");
        if (optJSONArray != null) {
            pVar.anB = new ArrayList(optJSONArray.length());
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                pVar.anB.add(new s(jSONObject2.optString("icon_url"), jSONObject2.optString("title"), jSONObject2.optString("link_url"), jSONObject2.optInt("is_new")));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("msign");
        if (optJSONObject2 != null) {
            pVar.anx = new r(optJSONObject2.optString("msign_text"), optJSONObject2.optInt("can_msign", 0));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("game_center");
        if (optJSONObject3 != null) {
            pVar.aof = new q(optJSONObject3.optLong("game_last_launchtime", 0L), optJSONObject3.optString("link_url"));
        }
        return pVar;
    }
}
