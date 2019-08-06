package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView ddI;
    private InvoiceInfoItemView ddJ;
    private InvoiceInfoItemView ddK;
    private InvoiceInfoItemView ddL;
    private InvoiceInfoItemView ddM;
    private InvoiceInfoItemView ddN;

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
        this.ddI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gu(true).gv(true).tc(context.getString(R.string.invoice_desc_name)).td(context.getString(R.string.invoice_hint_name)).te("\\S+$").tf(context.getString(R.string.invoice_err_msg_name)));
        this.ddJ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gu(true).tc(context.getString(R.string.invoice_desc_tax_number)).gv(true).mI(2).tg(context.getString(R.string.alphabet_and_number)).td(context.getString(R.string.invoice_hint_tax_number)).te("\\S+$").tf(context.getString(R.string.invoice_err_msg_tax_number)));
        this.ddK = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gv(true).tc(context.getString(R.string.invoice_desc_company_address)).td(context.getString(R.string.invoice_hint_company_address)));
        this.ddL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tc(context.getString(R.string.invoice_desc_mobile)).gv(true).mI(2).td(context.getString(R.string.invoice_hint_mobile)));
        this.ddM = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gv(true).tc(context.getString(R.string.invoice_desc_bank)).td(context.getString(R.string.invoice_hint_bank)));
        this.ddN = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tc(context.getString(R.string.invoice_desc_bank_account)).gv(true).mI(2).td(context.getString(R.string.invoice_hint_bank_account)));
        this.ddH = new InvoiceInfoItemView[]{this.ddI, this.ddJ, this.ddK, this.ddL, this.ddM, this.ddN};
        for (int i = 0; i < this.ddH.length; i++) {
            addView(this.ddH[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.ddI.getContent(), this.ddJ.getContent(), this.ddK.getContent(), this.ddL.getContent(), this.ddM.getContent(), this.ddN.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.ddI.setContent(invoiceInfo.mTitle);
            this.ddJ.setContent(invoiceInfo.ddy);
            this.ddK.setContent(invoiceInfo.ddz);
            this.ddL.setContent(invoiceInfo.ddA);
            this.ddM.setContent(invoiceInfo.ddB);
            this.ddN.setContent(invoiceInfo.ddC);
        }
    }
}
