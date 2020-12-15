package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements q {
    public static final BdUniqueId hQz = BdUniqueId.gen();
    public String aIU;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hQz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIU = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
