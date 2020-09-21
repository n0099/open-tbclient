package com.baidu.tieba.ala.person.messages;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.person.a.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlaybacksResponseMessage extends JsonHttpResponsedMessage {
    public int errCode;
    public String errMsg;
    public d gUO;

    public PlaybacksResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            try {
                this.errCode = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.errMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                if (!TextUtils.isEmpty(jSONObject.optString("data"))) {
                    this.gUO = new d();
                    this.gUO.parserJson(jSONObject.optString("data"));
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
