package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LivePrepareListHttpResponseMessage extends JsonHttpResponsedMessage {
    public String gse;
    public String gsf;
    public List<String> gsg;

    public LivePrepareListHttpResponseMessage() {
        super(1021147);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gse = optJSONObject.optString(LogConfig.LIVE_SHARE_HK_WEIBO);
            this.gsf = optJSONObject.optString("tencent");
            JSONArray optJSONArray = optJSONObject.optJSONArray("title");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gsg = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        this.gsg.add(optString);
                    }
                }
            }
        }
    }
}
