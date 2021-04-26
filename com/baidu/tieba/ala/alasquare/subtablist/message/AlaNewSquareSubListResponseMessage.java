package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListResponseMessage extends JsonHttpResponsedMessage {
    public boolean hasMore;
    public int liveCount;
    public List<a2> liveList;
    public List<String> sortType;

    public AlaNewSquareSubListResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        this.liveList = new ArrayList();
        this.sortType = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.hasMore = jSONObject.optInt("has_more") == 1;
        this.liveCount = jSONObject.optInt("count");
        JSONArray optJSONArray = jSONObject.optJSONArray("live");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    a2 a2Var = new a2();
                    a2Var.Q2(optJSONObject);
                    this.liveList.add(a2Var);
                }
            }
        } else {
            this.hasMore = false;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("live_tab_type");
        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length2 = optJSONArray2.length();
        for (int i4 = 0; i4 < length2; i4++) {
            String optString = optJSONArray2.optString(i4);
            if (!StringUtils.isNull(optString)) {
                this.sortType.add(optString);
            }
        }
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<a2> getLiveList() {
        return this.liveList;
    }

    public List<String> getSortTypeList() {
        return this.sortType;
    }

    public boolean hasMore() {
        return this.hasMore;
    }
}
