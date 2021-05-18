package com.baidu.tieba.ala.personcenter.privilege.achievementmark.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.k0.t.j.g.c.c.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAchievementMarkResponsedMessage extends JsonHttpResponsedMessage {
    public List<c> list;
    public AlaUserInfoData user_info;

    public AlaAchievementMarkResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        this.list = new ArrayList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
        if (optJSONObject2 != null) {
            this.user_info = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject2, AlaUserInfoData.class);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("mark_info");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    c cVar = new c();
                    cVar.c(optJSONObject3);
                    this.list.add(cVar);
                }
            }
        }
    }

    public AlaUserInfoData getAlaUserInfoData() {
        return this.user_info;
    }

    public List<c> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }
}
