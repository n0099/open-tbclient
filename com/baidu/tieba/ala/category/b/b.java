package com.baidu.tieba.ala.category.b;

import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private List<IAdapterData> fSE;

    public void dl(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
            this.fSE = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                c cVar = new c();
                cVar.dl(optJSONObject);
                this.fSE.add(cVar);
            }
        }
    }

    public List<IAdapterData> bJg() {
        return this.fSE;
    }
}
