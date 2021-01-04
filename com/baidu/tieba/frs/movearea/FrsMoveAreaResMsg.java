package com.baidu.tieba.frs.movearea;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FrsMoveAreaResMsg extends JsonHttpResponsedMessage {
    public FrsMoveAreaResMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            setError(-1);
            setErrorString(TbadkCoreApplication.getInst().getApp().getString(R.string.error_unkown_try_again));
        }
    }
}
