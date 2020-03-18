package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubJoinListHttpResponseMessage extends JsonHttpResponsedMessage {
    public int count;
    public List<d> eHw;
    public int eHx;
    public boolean hasMore;

    public GuardClubJoinListHttpResponseMessage() {
        super(1021139);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eHx = optJSONObject.optInt(Config.PACKAGE_NAME);
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.count = optJSONObject.optInt("count");
            JSONArray optJSONArray = optJSONObject.optJSONArray("guard_club_lists");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eHw = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    d dVar = new d();
                    dVar.parseJson(optJSONObject2);
                    this.eHw.add(dVar);
                }
            }
        }
    }
}
