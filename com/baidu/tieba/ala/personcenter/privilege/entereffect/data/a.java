package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements o {
    public static final BdUniqueId grS = BdUniqueId.gen();
    public String auI;
    public int categoryType;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return grS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auI = jSONObject.optString("effect_type_name");
            this.categoryType = jSONObject.optInt("effect_type");
        }
    }
}
