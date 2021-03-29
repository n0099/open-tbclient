package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.t.e.b.c;
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
                    c cVar = new c();
                    a2 a2Var = new a2();
                    a2Var.P2(optJSONObject2);
                    cVar.f60686e = a2Var;
                    this.liveList.add(cVar);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    c cVar2 = new c();
                    a2 a2Var2 = new a2();
                    a2Var2.P2(optJSONObject3);
                    cVar2.f60686e = a2Var2;
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
