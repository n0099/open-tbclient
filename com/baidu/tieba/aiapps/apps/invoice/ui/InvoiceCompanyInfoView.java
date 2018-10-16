package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bCZ;
    private InvoiceInfoItemView bDa;
    private InvoiceInfoItemView bDb;
    private InvoiceInfoItemView bDc;
    private InvoiceInfoItemView bDd;
    private InvoiceInfoItemView bDe;

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
        this.bCZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dg(true).dh(true).kf(context.getString(e.j.invoice_desc_name)).kg(context.getString(e.j.invoice_hint_name)).kh("\\S+$").ki(context.getString(e.j.invoice_err_msg_name)));
        this.bDa = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dg(true).kf(context.getString(e.j.invoice_desc_tax_number)).dh(true).hv(2).kj(context.getString(e.j.alphabet_and_number)).kg(context.getString(e.j.invoice_hint_tax_number)).kh("\\S+$").ki(context.getString(e.j.invoice_err_msg_tax_number)));
        this.bDb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dh(true).kf(context.getString(e.j.invoice_desc_company_address)).kg(context.getString(e.j.invoice_hint_company_address)));
        this.bDc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kf(context.getString(e.j.invoice_desc_mobile)).dh(true).hv(2).kg(context.getString(e.j.invoice_hint_mobile)));
        this.bDd = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dh(true).kf(context.getString(e.j.invoice_desc_bank)).kg(context.getString(e.j.invoice_hint_bank)));
        this.bDe = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kf(context.getString(e.j.invoice_desc_bank_account)).dh(true).hv(2).kg(context.getString(e.j.invoice_hint_bank_account)));
        this.bCY = new InvoiceInfoItemView[]{this.bCZ, this.bDa, this.bDb, this.bDc, this.bDd, this.bDe};
        for (int i = 0; i < this.bCY.length; i++) {
            addView(this.bCY[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bCZ.getContent(), this.bDa.getContent(), this.bDb.getContent(), this.bDc.getContent(), this.bDd.getContent(), this.bDe.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bCZ.setContent(invoiceInfo.mTitle);
            this.bDa.setContent(invoiceInfo.bCQ);
            this.bDb.setContent(invoiceInfo.bCR);
            this.bDc.setContent(invoiceInfo.bCS);
            this.bDd.setContent(invoiceInfo.bCT);
            this.bDe.setContent(invoiceInfo.bCU);
        }
    }
}
