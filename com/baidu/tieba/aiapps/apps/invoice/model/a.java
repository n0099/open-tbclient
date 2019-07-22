package com.baidu.tieba.aiapps.apps.invoice.model;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements c {
    public List<InvoiceInfo> ddp;

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(IntentConfig.LIST)) != null) {
            this.ddp = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                InvoiceInfo invoiceInfo = new InvoiceInfo();
                invoiceInfo.bh(optJSONObject);
                this.ddp.add(invoiceInfo);
            }
        }
    }
}
