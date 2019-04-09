package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTE;
    private InvoiceInfoItemView cTH;

    public InvoicePersonalInfoView(Context context) {
        this(context, null);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.cTE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rA(context.getString(d.j.invoice_desc_name)).fU(true).rB(context.getString(d.j.invoice_hint_personal_name)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_personal_name)));
        this.cTH = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_mobile)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_mobile)));
        this.cTD = new InvoiceInfoItemView[]{this.cTE, this.cTH};
        for (int i = 0; i < this.cTD.length; i++) {
            addView(this.cTD[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cTE.getContent(), this.cTH.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTE.setContent(invoiceInfo.mTitle);
            this.cTH.setContent(invoiceInfo.cTx);
        }
    }
}
