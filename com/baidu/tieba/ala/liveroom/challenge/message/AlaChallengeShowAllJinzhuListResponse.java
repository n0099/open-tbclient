package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaChallengeShowAllJinzhuListResponse extends JsonHttpResponsedMessage {
    private int bcY;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hxc;
    private boolean mHasMore;

    public AlaChallengeShowAllJinzhuListResponse() {
        super(1021198);
        this.hxc = new ArrayList();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("rank_info")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        com.baidu.tieba.ala.liveroom.challenge.a.a aVar = new com.baidu.tieba.ala.liveroom.challenge.a.a();
                        aVar.parserJson(optJSONObject2);
                        this.hxc.add(aVar);
                    }
                }
            }
            this.mHasMore = optJSONObject.optInt("hasMore") != 0;
            this.bcY = optJSONObject.optInt("currentPage");
        }
    }

    public List<com.baidu.tieba.ala.liveroom.challenge.a.a> getUserList() {
        return this.hxc;
    }

    public int bJO() {
        return this.bcY;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }
}
