package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bIf;
    private InvoiceInfoItemView bIg;
    private InvoiceInfoItemView bIh;
    private InvoiceInfoItemView bIi;
    private InvoiceInfoItemView bIj;
    private InvoiceInfoItemView bIk;

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
        this.bIf = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dB(true).dC(true).kS(context.getString(e.j.invoice_desc_name)).kT(context.getString(e.j.invoice_hint_name)).kU("\\S+$").kV(context.getString(e.j.invoice_err_msg_name)));
        this.bIg = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dB(true).kS(context.getString(e.j.invoice_desc_tax_number)).dC(true).hX(2).kW(context.getString(e.j.alphabet_and_number)).kT(context.getString(e.j.invoice_hint_tax_number)).kU("\\S+$").kV(context.getString(e.j.invoice_err_msg_tax_number)));
        this.bIh = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dC(true).kS(context.getString(e.j.invoice_desc_company_address)).kT(context.getString(e.j.invoice_hint_company_address)));
        this.bIi = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kS(context.getString(e.j.invoice_desc_mobile)).dC(true).hX(2).kT(context.getString(e.j.invoice_hint_mobile)));
        this.bIj = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dC(true).kS(context.getString(e.j.invoice_desc_bank)).kT(context.getString(e.j.invoice_hint_bank)));
        this.bIk = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kS(context.getString(e.j.invoice_desc_bank_account)).dC(true).hX(2).kT(context.getString(e.j.invoice_hint_bank_account)));
        this.bIe = new InvoiceInfoItemView[]{this.bIf, this.bIg, this.bIh, this.bIi, this.bIj, this.bIk};
        for (int i = 0; i < this.bIe.length; i++) {
            addView(this.bIe[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bIf.getContent(), this.bIg.getContent(), this.bIh.getContent(), this.bIi.getContent(), this.bIj.getContent(), this.bIk.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bIf.setContent(invoiceInfo.mTitle);
            this.bIg.setContent(invoiceInfo.bHW);
            this.bIh.setContent(invoiceInfo.bHX);
            this.bIi.setContent(invoiceInfo.bHY);
            this.bIj.setContent(invoiceInfo.bHZ);
            this.bIk.setContent(invoiceInfo.bIa);
        }
    }
}
