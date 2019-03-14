package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTB;
    private InvoiceInfoItemView cTE;

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
        this.cTB = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rz(context.getString(d.j.invoice_desc_name)).fU(true).rA(context.getString(d.j.invoice_hint_personal_name)).rB("\\S+$").rC(context.getString(d.j.invoice_err_msg_personal_name)));
        this.cTE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rz(context.getString(d.j.invoice_desc_mobile)).fU(true).lO(2).rA(context.getString(d.j.invoice_hint_mobile)));
        this.cTA = new InvoiceInfoItemView[]{this.cTB, this.cTE};
        for (int i = 0; i < this.cTA.length; i++) {
            addView(this.cTA[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cTB.getContent(), this.cTE.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTB.setContent(invoiceInfo.mTitle);
            this.cTE.setContent(invoiceInfo.cTu);
        }
    }
}
