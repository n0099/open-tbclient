package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.v.e.b.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveThreadsRespMessage extends JsonHttpResponsedMessage {
    public boolean hasMore;
    public int liveCount;
    public List<n> liveList;
    public List<n> recommandList;

    public AlaGameFrsLiveThreadsRespMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
        this.liveList = new ArrayList();
        this.recommandList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
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
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    c cVar = new c();
                    a2 a2Var = new a2();
                    a2Var.T2(optJSONObject2);
                    cVar.f61871e = a2Var;
                    this.liveList.add(cVar);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                if (optJSONObject3 != null) {
                    c cVar2 = new c();
                    a2 a2Var2 = new a2();
                    a2Var2.T2(optJSONObject3);
                    cVar2.f61871e = a2Var2;
                    this.recommandList.add(cVar2);
                }
            }
        }
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<n> getLiveList() {
        return this.liveList;
    }

    public List<n> getRecommandList() {
        return this.recommandList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
