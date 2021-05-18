package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.j0.r.q.a2;
import d.a.k0.t.d.f.c.b;
import d.a.k0.t.d.f.c.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSpecialRecommendResponse extends JsonHttpResponsedMessage {
    public boolean hasMore;
    public List<a2> livesList;
    public c mSpecialActivityListData;

    public AlaSpecialRecommendResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_RECOMMEND_TAB);
        this.hasMore = false;
        this.livesList = new ArrayList();
        this.mSpecialActivityListData = new c();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject != null) {
            this.hasMore = jSONObject.optInt("has_more") == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("lives");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            a2 a2Var = new a2();
                            a2Var.S2(optJSONObject2);
                            this.livesList.add(a2Var);
                        }
                    }
                } else {
                    this.hasMore = false;
                }
            } else {
                this.hasMore = false;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("activity_info_detail");
            c cVar = this.mSpecialActivityListData;
            if (cVar != null && cVar.f61432e == null) {
                cVar.f61432e = new ArrayList();
            }
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject3 != null) {
                        b bVar = new b();
                        bVar.h(optJSONObject3);
                        this.mSpecialActivityListData.f61432e.add(bVar);
                    }
                }
            }
        }
    }
}
