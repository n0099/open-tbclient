package com.baidu.tieba.aiapps.apps.invoice.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements c {
    public List<InvoiceInfo> doE;

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bE(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
            this.doE = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                InvoiceInfo invoiceInfo = new InvoiceInfo();
                invoiceInfo.bE(optJSONObject);
                this.doE.add(invoiceInfo);
            }
        }
    }
}
