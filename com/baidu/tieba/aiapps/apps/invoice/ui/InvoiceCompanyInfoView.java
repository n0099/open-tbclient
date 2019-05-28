package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dbY;
    private InvoiceInfoItemView dbZ;
    private InvoiceInfoItemView dca;
    private InvoiceInfoItemView dcb;
    private InvoiceInfoItemView dcc;
    private InvoiceInfoItemView dcd;

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
        this.dbY = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).gr(true).sK(context.getString(R.string.invoice_desc_name)).sL(context.getString(R.string.invoice_hint_name)).sM("\\S+$").sN(context.getString(R.string.invoice_err_msg_name)));
        this.dbZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).sK(context.getString(R.string.invoice_desc_tax_number)).gr(true).mA(2).sO(context.getString(R.string.alphabet_and_number)).sL(context.getString(R.string.invoice_hint_tax_number)).sM("\\S+$").sN(context.getString(R.string.invoice_err_msg_tax_number)));
        this.dca = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gr(true).sK(context.getString(R.string.invoice_desc_company_address)).sL(context.getString(R.string.invoice_hint_company_address)));
        this.dcb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sK(context.getString(R.string.invoice_desc_mobile)).gr(true).mA(2).sL(context.getString(R.string.invoice_hint_mobile)));
        this.dcc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gr(true).sK(context.getString(R.string.invoice_desc_bank)).sL(context.getString(R.string.invoice_hint_bank)));
        this.dcd = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sK(context.getString(R.string.invoice_desc_bank_account)).gr(true).mA(2).sL(context.getString(R.string.invoice_hint_bank_account)));
        this.dbX = new InvoiceInfoItemView[]{this.dbY, this.dbZ, this.dca, this.dcb, this.dcc, this.dcd};
        for (int i = 0; i < this.dbX.length; i++) {
            addView(this.dbX[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.dbY.getContent(), this.dbZ.getContent(), this.dca.getContent(), this.dcb.getContent(), this.dcc.getContent(), this.dcd.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dbY.setContent(invoiceInfo.mTitle);
            this.dbZ.setContent(invoiceInfo.dbO);
            this.dca.setContent(invoiceInfo.dbP);
            this.dcb.setContent(invoiceInfo.dbQ);
            this.dcc.setContent(invoiceInfo.dbR);
            this.dcd.setContent(invoiceInfo.dbS);
        }
    }
}
