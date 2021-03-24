package com.baidu.tieba.frs.gamecomment;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsGameCommentResponseMessage extends JsonHttpResponsedMessage {
    public FrsGameCommentResponseMessage(int i) {
        super(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
    }
}
