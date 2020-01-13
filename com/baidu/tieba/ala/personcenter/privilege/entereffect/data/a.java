package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements m {
    public static final BdUniqueId fuN = BdUniqueId.gen();
    public String VG;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fuN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.VG = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
