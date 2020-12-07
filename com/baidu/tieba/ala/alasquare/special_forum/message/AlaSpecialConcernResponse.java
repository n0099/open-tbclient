package com.baidu.tieba.ala.alasquare.special_forum.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alasquare.special_forum.data.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hasMore = jSONObject.optInt("has_more") == 1;
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.totalFollowCount = jSONObject.optInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            JSONArray optJSONArray = jSONObject.optJSONArray("follow_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("user");
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("ala_live_info");
                    if (optJSONObject != null && optJSONObject2 != null) {
                        d dVar = new d();
                        dVar.e(optJSONObject, optJSONObject2);
                        this.followList.add(dVar);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("recommend_list");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject jSONObject3 = (JSONObject) optJSONArray2.get(i3);
                    JSONObject optJSONObject3 = jSONObject3.optJSONObject("user");
                    JSONObject optJSONObject4 = jSONObject3.optJSONObject("ala_live_info");
                    if (optJSONObject3 != null && optJSONObject4 != null) {
                        d dVar2 = new d();
                        dVar2.e(optJSONObject3, optJSONObject4);
                        this.recommendList.add(dVar2);
                    }
                }
            }
        }
    }
}
