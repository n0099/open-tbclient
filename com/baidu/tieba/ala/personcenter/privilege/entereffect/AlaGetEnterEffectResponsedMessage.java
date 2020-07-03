package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetEnterEffectResponsedMessage extends JsonHttpResponsedMessage {
    private List<q> mEffectList;
    private int mEnterEffectCount;
    private String mNickName;
    private String mPortrait;
    private String mUserName;

    public AlaGetEnterEffectResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.mEffectList = new LinkedList();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mEnterEffectCount = optJSONObject.optInt("own_count");
            this.mPortrait = optJSONObject.optString("portrait");
            if (StringUtils.isNull(this.mPortrait)) {
                this.mPortrait = TbadkCoreApplication.getCurrentPortrait();
            }
            this.mUserName = optJSONObject.optString("user_name");
            if (StringUtils.isNull(this.mUserName)) {
                this.mUserName = TbadkCoreApplication.getCurrentAccountNameShow();
            }
            this.mNickName = optJSONObject.optString("user_nickname");
            if (StringUtils.isNull(this.mNickName)) {
                this.mNickName = this.mUserName;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("effect_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.mEffectList.clear();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar = new com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a();
                        aVar.parserJson(optJSONObject2);
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
        }
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getUserName() {
        return !StringUtils.isNull(this.mNickName) ? this.mNickName : this.mUserName;
    }

    public int getEnterEffectCount() {
        return this.mEnterEffectCount;
    }

    public List<q> getEffectList() {
        return this.mEffectList;
    }
}
