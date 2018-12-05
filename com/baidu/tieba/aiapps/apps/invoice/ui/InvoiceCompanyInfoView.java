package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bHo;
    private InvoiceInfoItemView bHp;
    private InvoiceInfoItemView bHq;
    private InvoiceInfoItemView bHr;
    private InvoiceInfoItemView bHs;
    private InvoiceInfoItemView bHt;

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
        this.bHo = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).dz(true).kB(context.getString(e.j.invoice_desc_name)).kC(context.getString(e.j.invoice_hint_name)).kD("\\S+$").kE(context.getString(e.j.invoice_err_msg_name)));
        this.bHp = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kB(context.getString(e.j.invoice_desc_tax_number)).dz(true).hW(2).kF(context.getString(e.j.alphabet_and_number)).kC(context.getString(e.j.invoice_hint_tax_number)).kD("\\S+$").kE(context.getString(e.j.invoice_err_msg_tax_number)));
        this.bHq = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dz(true).kB(context.getString(e.j.invoice_desc_company_address)).kC(context.getString(e.j.invoice_hint_company_address)));
        this.bHr = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kB(context.getString(e.j.invoice_desc_mobile)).dz(true).hW(2).kC(context.getString(e.j.invoice_hint_mobile)));
        this.bHs = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dz(true).kB(context.getString(e.j.invoice_desc_bank)).kC(context.getString(e.j.invoice_hint_bank)));
        this.bHt = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kB(context.getString(e.j.invoice_desc_bank_account)).dz(true).hW(2).kC(context.getString(e.j.invoice_hint_bank_account)));
        this.bHn = new InvoiceInfoItemView[]{this.bHo, this.bHp, this.bHq, this.bHr, this.bHs, this.bHt};
        for (int i = 0; i < this.bHn.length; i++) {
            addView(this.bHn[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bHo.getContent(), this.bHp.getContent(), this.bHq.getContent(), this.bHr.getContent(), this.bHs.getContent(), this.bHt.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bHo.setContent(invoiceInfo.mTitle);
            this.bHp.setContent(invoiceInfo.bHf);
            this.bHq.setContent(invoiceInfo.bHg);
            this.bHr.setContent(invoiceInfo.bHh);
            this.bHs.setContent(invoiceInfo.bHi);
            this.bHt.setContent(invoiceInfo.bHj);
        }
    }
}
