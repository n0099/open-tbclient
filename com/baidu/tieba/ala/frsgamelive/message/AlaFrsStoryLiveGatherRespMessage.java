package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaFrsStoryLiveGatherRespMessage extends JsonHttpResponsedMessage {
    private boolean hasMore;
    private int liveCount;
    private List<bz> liveList;
    private List<bz> recommandList;

    public AlaFrsStoryLiveGatherRespMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        this.liveList = new ArrayList();
        this.recommandList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("page");
        if (optJSONObject != null) {
            this.hasMore = optJSONObject.optInt("has_more") == 1;
        } else {
            this.hasMore = false;
        }
        this.liveCount = jSONObject.optInt("ala_live_count");
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    bz bzVar = new bz();
                    bzVar.parserJson(optJSONObject2);
                    this.liveList.add(bzVar);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    bz bzVar2 = new bz();
                    bzVar2.parserJson(optJSONObject3);
                    this.recommandList.add(bzVar2);
                }
            }
        }
    }

    public List<bz> getLiveList() {
        return this.liveList;
    }

    public List<bz> getRecommandList() {
        return this.recommandList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
