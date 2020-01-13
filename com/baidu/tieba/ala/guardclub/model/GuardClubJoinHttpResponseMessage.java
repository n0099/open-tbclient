package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GuardClubJoinHttpResponseMessage extends JsonHttpResponsedMessage {
    public int eCS;
    public int eCT;
    public long eCU;
    public boolean eCV;
    public c ezN;

    public GuardClubJoinHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        this.eCV = false;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eCS = optJSONObject.optInt("guard_club_id");
            this.eCT = optJSONObject.optInt("guard_club_member_id");
            this.eCU = optJSONObject.optLong("left_scores");
            TbadkCoreApplication.getInst().currentAccountTdouNum = this.eCU;
            if (getOrginalMessage() != null && (getOrginalMessage() instanceof f)) {
                this.ezN = ((f) getOrginalMessage()).bdf();
            }
        }
    }
}
