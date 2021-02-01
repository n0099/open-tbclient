package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LivePrepareListHttpResponseMessage extends JsonHttpResponsedMessage {
    public String hJA;
    public List<String> hJB;
    public String hJz;

    public LivePrepareListHttpResponseMessage() {
        super(1021147);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hJz = optJSONObject.optString(LogConfig.LIVE_SHARE_HK_WEIBO);
            this.hJA = optJSONObject.optString("tencent");
            JSONArray optJSONArray = optJSONObject.optJSONArray("title");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.hJB = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        this.hJB.add(optString);
                    }
                }
            }
        }
    }
}
