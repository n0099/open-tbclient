package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubInfoRenameResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.live.guardclub.a aOG;

    public GuardClubInfoRenameResponseMessage() {
        super(1021142);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("guard_club_info")) != null) {
                this.aOG = new com.baidu.live.guardclub.a();
                this.aOG.parseJson(optJSONObject);
                return;
            }
            return;
        }
        String optString = jSONObject.optString("message");
        if (!TextUtils.isEmpty(optString)) {
            setErrorString(optString);
        }
    }
}
