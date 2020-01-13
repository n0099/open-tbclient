package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GuardClubInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public String eAq;
    public boolean eAt;
    public String[] eCL;
    public boolean eCM;
    public j[] eCN;
    public k eCO;
    public boolean eCP;
    public c ezN;

    public GuardClubInfoHttpResponseMessage() {
        super(1021137);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ezN = new c();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("guard_club_info");
            if (optJSONObject2 != null) {
                this.ezN.parseJson(optJSONObject2);
            }
            this.eAq = optJSONObject.optString("explain_url");
            JSONArray optJSONArray = optJSONObject.optJSONArray("privilege_conf");
            if (optJSONArray != null) {
                this.eCL = new String[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.eCL[i2] = optJSONArray.getString(i2);
                }
            }
            this.eAt = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.eCM = optJSONObject.optInt("isAnchor") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("join_club_privilege");
            if (optJSONArray2 != null) {
                this.eCN = new j[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.eCN[i3] = new j();
                    this.eCN[i3].parseJson(optJSONArray2.optJSONObject(i3));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject3 != null) {
                this.eCO = new k();
                this.eCO.parseJson(optJSONObject3);
            }
            this.eCP = optJSONObject.optInt("has_quit_tips") == 1;
        }
    }
}
