package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.c.f.b.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveTabMyConcernResponse extends JsonHttpResponsedMessage {
    public List<b> followCloseList;
    public int followCloseNum;
    public List<a2> followList;
    public int followStatus;
    public boolean hasMore;
    public int pn;
    public List<a2> recommendList;
    public int totalFollowCount;

    public AlaLiveTabMyConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        this.hasMore = false;
        this.followList = new ArrayList();
        this.recommendList = new ArrayList();
        this.followCloseList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.hasMore = optJSONObject.optInt("has_more") == 1;
        this.followStatus = optJSONObject.optInt(DI.FOLLOW_STATUS);
        this.followCloseNum = optJSONObject.optInt("follow_close_num");
        this.pn = optJSONObject.optInt(Config.PACKAGE_NAME);
        this.totalFollowCount = optJSONObject.optInt("total_follow_num");
        JSONArray optJSONArray = optJSONObject.optJSONArray("follow_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    a2 a2Var = new a2();
                    a2Var.Q2(optJSONObject2);
                    this.followList.add(a2Var);
                }
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("follow_close_list");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    b bVar = new b();
                    bVar.g(optJSONObject3);
                    this.followCloseList.add(bVar);
                }
            }
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("recommend_list");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                if (optJSONObject4 != null) {
                    a2 a2Var2 = new a2();
                    a2Var2.Q2(optJSONObject4);
                    this.recommendList.add(a2Var2);
                }
            }
        }
    }
}
