package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements n {
    public static final BdUniqueId ieJ = BdUniqueId.gen();
    public String aHS;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ieJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aHS = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
