package com.baidu.tieba.ala.alasquare.live_tab.my_concern.data;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveTabMyConcernResponse extends JsonHttpResponsedMessage {
    public List<b> followCloseList;
    public int followCloseNum;
    public List<bk> followList;
    public int followStatus;
    public boolean hasMore;
    public int pn;
    public List<bk> recommendList;
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
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.followStatus = optJSONObject.optInt("follow_status");
            this.followCloseNum = optJSONObject.optInt("follow_close_num");
            this.pn = optJSONObject.optInt(Config.PACKAGE_NAME);
            this.totalFollowCount = optJSONObject.optInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
            JSONArray optJSONArray = optJSONObject.optJSONArray("follow_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        bk bkVar = new bk();
                        bkVar.parserJson(optJSONObject2);
                        this.followList.add(bkVar);
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("follow_close_list");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject3 != null) {
                        b bVar = new b();
                        bVar.parseJson(optJSONObject3);
                        this.followCloseList.add(bVar);
                    }
                }
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("recommend_list");
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i4);
                    if (optJSONObject4 != null) {
                        bk bkVar2 = new bk();
                        bkVar2.parserJson(optJSONObject4);
                        this.recommendList.add(bkVar2);
                    }
                }
            }
        }
    }
}
