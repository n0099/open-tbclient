package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bHr;
    private InvoiceInfoItemView bHs;
    private InvoiceInfoItemView bHt;
    private InvoiceInfoItemView bHu;
    private InvoiceInfoItemView bHv;
    private InvoiceInfoItemView bHw;

    public InvoiceCompanyInfoView(Context context) {
        this(context, null);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.bHr = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).dz(true).kC(context.getString(e.j.invoice_desc_name)).kD(context.getString(e.j.invoice_hint_name)).kE("\\S+$").kF(context.getString(e.j.invoice_err_msg_name)));
        this.bHs = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kC(context.getString(e.j.invoice_desc_tax_number)).dz(true).hX(2).kG(context.getString(e.j.alphabet_and_number)).kD(context.getString(e.j.invoice_hint_tax_number)).kE("\\S+$").kF(context.getString(e.j.invoice_err_msg_tax_number)));
        this.bHt = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dz(true).kC(context.getString(e.j.invoice_desc_company_address)).kD(context.getString(e.j.invoice_hint_company_address)));
        this.bHu = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kC(context.getString(e.j.invoice_desc_mobile)).dz(true).hX(2).kD(context.getString(e.j.invoice_hint_mobile)));
        this.bHv = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dz(true).kC(context.getString(e.j.invoice_desc_bank)).kD(context.getString(e.j.invoice_hint_bank)));
        this.bHw = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kC(context.getString(e.j.invoice_desc_bank_account)).dz(true).hX(2).kD(context.getString(e.j.invoice_hint_bank_account)));
        this.bHq = new InvoiceInfoItemView[]{this.bHr, this.bHs, this.bHt, this.bHu, this.bHv, this.bHw};
        for (int i = 0; i < this.bHq.length; i++) {
            addView(this.bHq[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bHr.getContent(), this.bHs.getContent(), this.bHt.getContent(), this.bHu.getContent(), this.bHv.getContent(), this.bHw.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bHr.setContent(invoiceInfo.mTitle);
            this.bHs.setContent(invoiceInfo.bHi);
            this.bHt.setContent(invoiceInfo.bHj);
            this.bHu.setContent(invoiceInfo.bHk);
            this.bHv.setContent(invoiceInfo.bHl);
            this.bHw.setContent(invoiceInfo.bHm);
        }
    }
}
