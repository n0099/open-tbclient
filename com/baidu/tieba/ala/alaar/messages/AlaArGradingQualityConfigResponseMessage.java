package com.baidu.tieba.ala.alaar.messages;

import android.util.Log;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaArGradingQualityConfigResponseMessage extends JsonHttpResponsedMessage {
    private JSONObject gpI;

    public AlaArGradingQualityConfigResponseMessage() {
        super(1021204);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (isDebug()) {
            Log.d("GradingQualityConfig", "onResponse: " + jSONObject);
        }
        if (jSONObject != null && !hasError()) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (isDebug()) {
                Log.d("GradingQualityConfig", "onResponse: " + optJSONObject);
            }
            if (optJSONObject != null && optJSONObject.length() != 0) {
                if (isDebug()) {
                    Log.e("GradingQualityConfig", "onResponse data >>>> " + optJSONObject.toString());
                }
                JSONObject dE = com.baidu.tieba.ala.alaar.a.b.bOY().dE(optJSONObject);
                if (isDebug() && dE != null) {
                    Log.e("GradingQualityConfig", "reStructData >>>> " + dE.toString());
                }
                this.gpI = dE;
                com.baidu.tieba.ala.alaar.a.b.bOY().f(dE, true);
            }
        }
    }

    private boolean isDebug() {
        return com.baidu.minivideo.arface.b.isDebug();
    }
}
