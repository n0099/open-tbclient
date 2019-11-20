package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public c dKm;
    public int dNA;
    public long dNB;
    public boolean dNC;
    public int dNz;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.dNC = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.dNz = optJSONObject.optInt("guard_club_id");
            this.dNA = optJSONObject.optInt("guard_club_member_id");
            this.dNB = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.dNB;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof f)) {
                this.dKm = ((f) getOrginalMessage()).aLB();
            }
        }
    }
}
