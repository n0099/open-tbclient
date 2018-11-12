package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bDL;
    private InvoiceInfoItemView bDM;
    private InvoiceInfoItemView bDN;
    private InvoiceInfoItemView bDO;
    private InvoiceInfoItemView bDP;
    private InvoiceInfoItemView bDQ;

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
        this.bDL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dx(true).dy(true).kh(context.getString(e.j.invoice_desc_name)).ki(context.getString(e.j.invoice_hint_name)).kj("\\S+$").kk(context.getString(e.j.invoice_err_msg_name)));
        this.bDM = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dx(true).kh(context.getString(e.j.invoice_desc_tax_number)).dy(true).hI(2).kl(context.getString(e.j.alphabet_and_number)).ki(context.getString(e.j.invoice_hint_tax_number)).kj("\\S+$").kk(context.getString(e.j.invoice_err_msg_tax_number)));
        this.bDN = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kh(context.getString(e.j.invoice_desc_company_address)).ki(context.getString(e.j.invoice_hint_company_address)));
        this.bDO = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kh(context.getString(e.j.invoice_desc_mobile)).dy(true).hI(2).ki(context.getString(e.j.invoice_hint_mobile)));
        this.bDP = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kh(context.getString(e.j.invoice_desc_bank)).ki(context.getString(e.j.invoice_hint_bank)));
        this.bDQ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kh(context.getString(e.j.invoice_desc_bank_account)).dy(true).hI(2).ki(context.getString(e.j.invoice_hint_bank_account)));
        this.bDK = new InvoiceInfoItemView[]{this.bDL, this.bDM, this.bDN, this.bDO, this.bDP, this.bDQ};
        for (int i = 0; i < this.bDK.length; i++) {
            addView(this.bDK[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bDL.getContent(), this.bDM.getContent(), this.bDN.getContent(), this.bDO.getContent(), this.bDP.getContent(), this.bDQ.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bDL.setContent(invoiceInfo.mTitle);
            this.bDM.setContent(invoiceInfo.bDC);
            this.bDN.setContent(invoiceInfo.bDD);
            this.bDO.setContent(invoiceInfo.bDE);
            this.bDP.setContent(invoiceInfo.bDF);
            this.bDQ.setContent(invoiceInfo.bDG);
        }
    }
}
