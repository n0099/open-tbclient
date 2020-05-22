package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaNewSquareSubListResponseMessage extends JsonHttpResponsedMessage {
    private boolean hasMore;
    private int liveCount;
    private List<bk> liveList;
    private List<String> sortType;

    public AlaNewSquareSubListResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        this.liveList = new ArrayList();
        this.sortType = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hasMore = jSONObject.optInt("has_more") == 1;
            this.liveCount = jSONObject.optInt("count");
            JSONArray optJSONArray = jSONObject.optJSONArray("live");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bk bkVar = new bk();
                        bkVar.parserJson(optJSONObject);
                        this.liveList.add(bkVar);
                    }
                }
            } else {
                this.hasMore = false;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("live_tab_type");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String optString = optJSONArray2.optString(i3);
                    if (!StringUtils.isNull(optString)) {
                        this.sortType.add(optString);
                    }
                }
            }
        }
    }

    public List<bk> getLiveList() {
        return this.liveList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public List<String> getSortTypeList() {
        return this.sortType;
    }
}
