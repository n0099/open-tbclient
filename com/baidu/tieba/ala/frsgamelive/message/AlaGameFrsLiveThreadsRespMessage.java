package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.frsgamelive.b.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveThreadsRespMessage extends JsonHttpResponsedMessage {
    private boolean hasMore;
    private int liveCount;
    private List<o> liveList;
    private List<o> recommandList;

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
                    bk bkVar = new bk();
                    bkVar.parserJson(optJSONObject2);
                    cVar.dEA = bkVar;
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
                    bk bkVar2 = new bk();
                    bkVar2.parserJson(optJSONObject3);
                    cVar2.dEA = bkVar2;
                    this.recommandList.add(cVar2);
                }
            }
        }
    }

    public List<o> getLiveList() {
        return this.liveList;
    }

    public List<o> getRecommandList() {
        return this.recommandList;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public int getLiveCount() {
        return this.liveCount;
    }
}
