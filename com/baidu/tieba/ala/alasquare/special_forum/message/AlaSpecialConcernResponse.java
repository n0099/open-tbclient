package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.v.d.f.c.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSpecialConcernResponse extends JsonHttpResponsedMessage {
    public List<d> followList;
    public boolean hasMore;
    public int pn;
    public List<d> recommendList;
    public int totalFollowCount;

    public AlaSpecialConcernResponse() {
        super(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        this.hasMore = false;
        this.followList = new ArrayList();
        this.recommendList = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject != null) {
            this.hasMore = jSONObject.optInt("has_more") == 1;
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.totalFollowCount = jSONObject.optInt("total_follow_num");
            JSONArray optJSONArray = jSONObject.optJSONArray("follow_list");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("user");
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("ala_live_info");
                    if (optJSONObject != null && optJSONObject2 != null) {
                        d dVar = new d();
                        dVar.a(optJSONObject, optJSONObject2);
                        this.followList.add(dVar);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("recommend_list");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject jSONObject3 = (JSONObject) optJSONArray2.get(i4);
                    JSONObject optJSONObject3 = jSONObject3.optJSONObject("user");
                    JSONObject optJSONObject4 = jSONObject3.optJSONObject("ala_live_info");
                    if (optJSONObject3 != null && optJSONObject4 != null) {
                        d dVar2 = new d();
                        dVar2.a(optJSONObject3, optJSONObject4);
                        this.recommendList.add(dVar2);
                    }
                }
            }
        }
    }
}
