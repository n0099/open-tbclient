package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LivePrepareListHttpResponseMessage extends JsonHttpResponsedMessage {
    public String hFn;
    public String hFo;
    public List<String> hFp;

    public LivePrepareListHttpResponseMessage() {
        super(1021147);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hFn = optJSONObject.optString(LogConfig.LIVE_SHARE_HK_WEIBO);
            this.hFo = optJSONObject.optString("tencent");
            JSONArray optJSONArray = optJSONObject.optJSONArray("title");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.hFp = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        this.hFp.add(optString);
                    }
                }
            }
        }
    }
}
