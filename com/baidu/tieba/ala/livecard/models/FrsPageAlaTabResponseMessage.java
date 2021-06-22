package com.baidu.tieba.ala.livecard.models;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.r0.c1;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsPageAlaTabResponseMessage extends JsonHttpResponsedMessage {
    public int alaLiveCount;
    public int errCode;
    public String errMsg;
    public ArrayList<n> mAltList;
    public ArrayList<n> mThreadList;
    public c1 pageInfo;

    public FrsPageAlaTabResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("error_code");
        this.errMsg = jSONObject.optString("errmsg");
        this.alaLiveCount = jSONObject.optInt("ala_live_count");
        JSONObject optJSONObject = jSONObject.optJSONObject("page");
        c1 c1Var = new c1();
        this.pageInfo = c1Var;
        c1Var.f62225g = optJSONObject.optInt("has_more") == 1;
        this.pageInfo.f63687c = optJSONObject.optInt(Config.PACKAGE_NAME);
        if (getOrginalMessage() instanceof FrsPageAlaTabRequestMessage) {
            FrsPageAlaTabRequestMessage frsPageAlaTabRequestMessage = (FrsPageAlaTabRequestMessage) getOrginalMessage();
            this.pageInfo.f63685a = frsPageAlaTabRequestMessage.getForumName();
            this.pageInfo.f63686b = frsPageAlaTabRequestMessage.getForumId();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray.length() > 0) {
            this.mThreadList = new ArrayList<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                a2 a2Var = new a2();
                a2Var.F3(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                a2Var.U2(jSONObject2);
                this.mThreadList.add(a2Var);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
        if (optJSONArray2.length() > 0) {
            this.mAltList = new ArrayList<>();
            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i4);
                a2 a2Var2 = new a2();
                a2Var2.F3(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                a2Var2.U2(jSONObject3);
                this.mAltList.add(a2Var2);
            }
        }
    }
}
