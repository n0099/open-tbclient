package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements m {
    public static final BdUniqueId fxo = BdUniqueId.gen();
    public String Xq;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fxo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Xq = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
