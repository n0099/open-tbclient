package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements q {
    public static final BdUniqueId gWJ = BdUniqueId.gen();
    public String aDf;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gWJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDf = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
