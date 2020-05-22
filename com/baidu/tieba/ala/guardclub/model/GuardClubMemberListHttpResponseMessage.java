package com.baidu.tieba.ala.guardclub.model;

import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GuardClubMemberListHttpResponseMessage extends JsonHttpResponsedMessage {
    public boolean aOJ;
    public boolean aOK;
    public com.baidu.live.guardclub.f aOM;
    public int fzA;
    public List<com.baidu.live.guardclub.f> fzH;
    public boolean hasMore;
    public int memberCount;

    public GuardClubMemberListHttpResponseMessage() {
        super(1021138);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aOJ = optJSONObject.optInt(GuardClubInfoActivityConfig.IS_CLUB_MEMBER) == 1;
            this.memberCount = optJSONObject.optInt("total_count");
            this.aOK = optJSONObject.optInt("is_anchor") == 1;
            this.hasMore = optJSONObject.optInt("has_more") == 1;
            this.fzA = optJSONObject.optInt(Config.PACKAGE_NAME);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("login_member_info");
            if (optJSONObject2 != null) {
                this.aOM = new com.baidu.live.guardclub.f();
                this.aOM.parseJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("member_rank_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fzH = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    com.baidu.live.guardclub.f fVar = new com.baidu.live.guardclub.f();
                    fVar.parseJson(optJSONObject3);
                    this.fzH.add(fVar);
                }
            }
        }
    }
}
