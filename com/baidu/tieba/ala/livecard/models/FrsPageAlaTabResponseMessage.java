package com.baidu.tieba.ala.livecard.models;

import com.baidu.adp.widget.ListView.q;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.bb;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsPageAlaTabResponseMessage extends JsonHttpResponsedMessage {
    public int alaLiveCount;
    public int errCode;
    public String errMsg;
    public ArrayList<q> mAltList;
    public ArrayList<q> mThreadList;
    public bb pageInfo;

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
            this.pageInfo = new bb();
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
                    bv bvVar = new bv();
                    bvVar.wX("frs_live_play");
                    bvVar.parserJson(jSONObject2);
                    this.mThreadList.add(bvVar);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
            if (optJSONArray2.length() > 0) {
                this.mAltList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                    bv bvVar2 = new bv();
                    bvVar2.wX("frs_live_play");
                    bvVar2.parserJson(jSONObject3);
                    this.mAltList.add(bvVar2);
                }
            }
        }
    }
}
