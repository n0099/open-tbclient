package com.baidu.tieba.applist;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApplistResponse extends JsonHttpResponsedMessage {
    private static final int ERROR_CODE_PARAM = 1130029;
    private static final int ERROR_CODE_SERVER = 110003;

    public ApplistResponse(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
    }

    public boolean isNeedRetry() {
        return getError() == ERROR_CODE_PARAM;
    }
}
