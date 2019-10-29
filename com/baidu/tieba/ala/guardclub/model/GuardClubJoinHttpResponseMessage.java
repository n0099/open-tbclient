package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public c dLd;
    public int dOq;
    public int dOr;
    public long dOs;
    public boolean dOt;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.dOt = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.dOq = optJSONObject.optInt("guard_club_id");
            this.dOr = optJSONObject.optInt("guard_club_member_id");
            this.dOs = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.dOs;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof f)) {
                this.dLd = ((f) getOrginalMessage()).aLD();
            }
        }
    }
}
