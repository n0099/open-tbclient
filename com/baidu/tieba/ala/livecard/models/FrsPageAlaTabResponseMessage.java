package com.baidu.tieba.ala.livecard.models;

import com.baidu.adp.widget.ListView.m;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.aq;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FrsPageAlaTabResponseMessage extends JsonHttpResponsedMessage {
    public int alaLiveCount;
    public int errCode;
    public String errMsg;
    public ArrayList<m> mAltList;
    public ArrayList<m> mThreadList;
    public aq pageInfo;

    public FrsPageAlaTabResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.errCode = jSONObject.optInt("error_code");
            this.errMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            this.alaLiveCount = jSONObject.optInt("ala_live_count");
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            this.pageInfo = new aq();
            this.pageInfo.hasMore = optJSONObject.optInt("has_more") == 1;
            this.pageInfo.pn = optJSONObject.optInt(Config.PACKAGE_NAME);
            if (getOrginalMessage() instanceof FrsPageAlaTabRequestMessage) {
                FrsPageAlaTabRequestMessage frsPageAlaTabRequestMessage = (FrsPageAlaTabRequestMessage) getOrginalMessage();
                this.pageInfo.forumName = frsPageAlaTabRequestMessage.getForumName();
                this.pageInfo.forumId = frsPageAlaTabRequestMessage.getForumId();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray.length() > 0) {
                this.mThreadList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    bj bjVar = new bj();
                    bjVar.sk("frs_live_play");
                    bjVar.parserJson(jSONObject2);
                    this.mThreadList.add(bjVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
            if (optJSONArray2.length() > 0) {
                this.mAltList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                    bj bjVar2 = new bj();
                    bjVar2.sk("frs_live_play");
                    bjVar2.parserJson(jSONObject3);
                    this.mAltList.add(bjVar2);
                }
            }
        }
    }
}
