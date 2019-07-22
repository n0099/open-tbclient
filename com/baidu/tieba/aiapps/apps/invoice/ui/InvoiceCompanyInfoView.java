package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView ddB;
    private InvoiceInfoItemView ddC;
    private InvoiceInfoItemView ddD;
    private InvoiceInfoItemView ddE;
    private InvoiceInfoItemView ddF;
    private InvoiceInfoItemView ddG;

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
        this.ddB = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gu(true).gv(true).tc(context.getString(R.string.invoice_desc_name)).td(context.getString(R.string.invoice_hint_name)).te("\\S+$").tf(context.getString(R.string.invoice_err_msg_name)));
        this.ddC = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gu(true).tc(context.getString(R.string.invoice_desc_tax_number)).gv(true).mH(2).tg(context.getString(R.string.alphabet_and_number)).td(context.getString(R.string.invoice_hint_tax_number)).te("\\S+$").tf(context.getString(R.string.invoice_err_msg_tax_number)));
        this.ddD = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gv(true).tc(context.getString(R.string.invoice_desc_company_address)).td(context.getString(R.string.invoice_hint_company_address)));
        this.ddE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tc(context.getString(R.string.invoice_desc_mobile)).gv(true).mH(2).td(context.getString(R.string.invoice_hint_mobile)));
        this.ddF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gv(true).tc(context.getString(R.string.invoice_desc_bank)).td(context.getString(R.string.invoice_hint_bank)));
        this.ddG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tc(context.getString(R.string.invoice_desc_bank_account)).gv(true).mH(2).td(context.getString(R.string.invoice_hint_bank_account)));
        this.ddA = new InvoiceInfoItemView[]{this.ddB, this.ddC, this.ddD, this.ddE, this.ddF, this.ddG};
        for (int i = 0; i < this.ddA.length; i++) {
            addView(this.ddA[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.ddB.getContent(), this.ddC.getContent(), this.ddD.getContent(), this.ddE.getContent(), this.ddF.getContent(), this.ddG.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.ddB.setContent(invoiceInfo.mTitle);
            this.ddC.setContent(invoiceInfo.ddq);
            this.ddD.setContent(invoiceInfo.ddr);
            this.ddE.setContent(invoiceInfo.dds);
            this.ddF.setContent(invoiceInfo.ddt);
            this.ddG.setContent(invoiceInfo.ddv);
        }
    }
}
