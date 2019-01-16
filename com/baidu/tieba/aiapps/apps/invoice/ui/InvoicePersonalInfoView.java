package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bIe;
    private InvoiceInfoItemView bIh;

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
        this.bIe = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dB(true).kS(context.getString(e.j.invoice_desc_name)).dC(true).kT(context.getString(e.j.invoice_hint_personal_name)).kU("\\S+$").kV(context.getString(e.j.invoice_err_msg_personal_name)));
        this.bIh = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kS(context.getString(e.j.invoice_desc_mobile)).dC(true).hX(2).kT(context.getString(e.j.invoice_hint_mobile)));
        this.bId = new InvoiceInfoItemView[]{this.bIe, this.bIh};
        for (int i = 0; i < this.bId.length; i++) {
            addView(this.bId[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bIe.getContent(), this.bIh.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bIe.setContent(invoiceInfo.mTitle);
            this.bIh.setContent(invoiceInfo.bHX);
        }
    }
}
