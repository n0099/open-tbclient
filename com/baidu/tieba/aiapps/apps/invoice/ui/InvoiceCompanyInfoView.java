package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dbZ;
    private InvoiceInfoItemView dca;
    private InvoiceInfoItemView dcb;
    private InvoiceInfoItemView dcc;
    private InvoiceInfoItemView dcd;
    private InvoiceInfoItemView dcf;

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
        this.dbZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).gr(true).sJ(context.getString(R.string.invoice_desc_name)).sK(context.getString(R.string.invoice_hint_name)).sL("\\S+$").sM(context.getString(R.string.invoice_err_msg_name)));
        this.dca = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).sJ(context.getString(R.string.invoice_desc_tax_number)).gr(true).mA(2).sN(context.getString(R.string.alphabet_and_number)).sK(context.getString(R.string.invoice_hint_tax_number)).sL("\\S+$").sM(context.getString(R.string.invoice_err_msg_tax_number)));
        this.dcb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gr(true).sJ(context.getString(R.string.invoice_desc_company_address)).sK(context.getString(R.string.invoice_hint_company_address)));
        this.dcc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sJ(context.getString(R.string.invoice_desc_mobile)).gr(true).mA(2).sK(context.getString(R.string.invoice_hint_mobile)));
        this.dcd = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gr(true).sJ(context.getString(R.string.invoice_desc_bank)).sK(context.getString(R.string.invoice_hint_bank)));
        this.dcf = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sJ(context.getString(R.string.invoice_desc_bank_account)).gr(true).mA(2).sK(context.getString(R.string.invoice_hint_bank_account)));
        this.dbY = new InvoiceInfoItemView[]{this.dbZ, this.dca, this.dcb, this.dcc, this.dcd, this.dcf};
        for (int i = 0; i < this.dbY.length; i++) {
            addView(this.dbY[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.dbZ.getContent(), this.dca.getContent(), this.dcb.getContent(), this.dcc.getContent(), this.dcd.getContent(), this.dcf.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dbZ.setContent(invoiceInfo.mTitle);
            this.dca.setContent(invoiceInfo.dbP);
            this.dcb.setContent(invoiceInfo.dbQ);
            this.dcc.setContent(invoiceInfo.dbR);
            this.dcd.setContent(invoiceInfo.dbS);
            this.dcf.setContent(invoiceInfo.dbT);
        }
    }
}
