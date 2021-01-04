package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GuardClubRankHttpResponseMessage extends JsonHttpResponsedMessage {
    public boolean bkL;
    public com.baidu.live.guardclub.f bkN;
    public boolean hasMore;
    public List<k> hcD;
    public com.baidu.live.guardclub.a hcE;
    public int pageIndex;

    public GuardClubRankHttpResponseMessage() {
        super(1021146);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (i == 1021146 && jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.hcE = new com.baidu.live.guardclub.a();
                this.hcE.parseJson(optJSONObject2);
            }
            this.pageIndex = optJSONObject.optInt(Config.PACKAGE_NAME);
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.bkL = optJSONObject.optInt("is_anchor") == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("club_rank_list");
            if (optJSONArray != null) {
                this.hcD = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    k dN = new k().dN(optJSONArray.optJSONObject(i2));
                    if (dN != null) {
                        this.hcD.add(dN);
                    }
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.bkN = new com.baidu.live.guardclub.f();
                this.bkN.parseJson(optJSONObject3);
            }
        }
    }
}
