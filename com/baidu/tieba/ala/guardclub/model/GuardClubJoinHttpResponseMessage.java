package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public int eBH;
    public int eBI;
    public long eBJ;
    public boolean eBK;
    public c eyC;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.eBK = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eBH = optJSONObject.optInt("guard_club_id");
            this.eBI = optJSONObject.optInt("guard_club_member_id");
            this.eBJ = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.eBJ;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof f)) {
                this.eyC = ((f) getOrginalMessage()).bcK();
            }
        }
    }
}
