package com.baidu.tieba.aiapps.apps.invoice;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.invoice.IAiAppChooseInvoiceIoc;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity;
/* loaded from: classes4.dex */
public class a implements IAiAppChooseInvoiceIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.invoice.IAiAppChooseInvoiceIoc
    public Intent getInvoiceChooseIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, InvoiceListActivity.class);
        intent.putExtra("bar_position", 0);
        intent.putExtra("source", "source_ai_app");
        intent.putExtra("ai_app_id", str);
        intent.putExtra("ai_app_key", str2);
        return intent;
    }
}
