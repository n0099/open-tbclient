package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import d.b.c.j.e.n;
import d.b.i0.t.j.g.d.d.a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetEnterEffectResponsedMessage extends JsonHttpResponsedMessage {
    public List<n> mEffectList;
    public int mEnterEffectCount;
    public String mNickName;
    public String mPortrait;
    public String mUserName;

    public AlaGetEnterEffectResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.mEffectList = new LinkedList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.mEnterEffectCount = optJSONObject.optInt("own_count");
        String optString = optJSONObject.optString("portrait");
        this.mPortrait = optString;
        if (StringUtils.isNull(optString)) {
            this.mPortrait = TbadkCoreApplication.getCurrentPortrait();
        }
        String optString2 = optJSONObject.optString("user_name");
        this.mUserName = optString2;
        if (StringUtils.isNull(optString2)) {
            this.mUserName = TbadkCoreApplication.getCurrentAccountNameShow();
        }
        String optString3 = optJSONObject.optString("user_nickname");
        this.mNickName = optString3;
        if (StringUtils.isNull(optString3)) {
            this.mNickName = this.mUserName;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("effect_info");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.mEffectList.clear();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                a aVar = new a();
                aVar.a(optJSONObject2);
                this.mEffectList.add(aVar);
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("effect_list");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            AlaEnterEffectData alaEnterEffectData = new AlaEnterEffectData();
                            alaEnterEffectData.parserJson(optJSONObject3);
                            this.mEffectList.add(alaEnterEffectData);
                        }
                    }
                }
            }
        }
    }

    public List<n> getEffectList() {
        return this.mEffectList;
    }

    public int getEnterEffectCount() {
        return this.mEnterEffectCount;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getUserName() {
        if (!StringUtils.isNull(this.mNickName)) {
            return this.mNickName;
        }
        return this.mUserName;
    }
}
