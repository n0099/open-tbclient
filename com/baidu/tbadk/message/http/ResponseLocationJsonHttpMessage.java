package com.baidu.tbadk.message.http;

import com.baidu.adp.lib.e.b;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseLocationJsonHttpMessage extends JsonHttpResponsedMessage {
    public boolean isLocationShared;

    public ResponseLocationJsonHttpMessage(int i) {
        super(i);
        this.isLocationShared = true;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.has("location")) {
            switch (b.a(jSONObject.getString("location"), 1)) {
                case 1:
                    this.isLocationShared = true;
                    return;
                case 2:
                default:
                    this.isLocationShared = true;
                    return;
                case 3:
                    this.isLocationShared = false;
                    return;
            }
        }
    }
}
