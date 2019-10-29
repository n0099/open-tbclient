package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView doP;
    private InvoiceInfoItemView doQ;
    private InvoiceInfoItemView doR;
    private InvoiceInfoItemView doS;
    private InvoiceInfoItemView doT;
    private InvoiceInfoItemView doU;

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
        this.doP = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gm(true).gn(true).sk(context.getString(R.string.invoice_desc_name)).sl(context.getString(R.string.invoice_hint_name)).sm("\\S+$").sn(context.getString(R.string.invoice_err_msg_name)));
        this.doQ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gm(true).sk(context.getString(R.string.invoice_desc_tax_number)).gn(true).lR(2).so(context.getString(R.string.alphabet_and_number)).sl(context.getString(R.string.invoice_hint_tax_number)).sm("\\S+$").sn(context.getString(R.string.invoice_err_msg_tax_number)));
        this.doR = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gn(true).sk(context.getString(R.string.invoice_desc_company_address)).sl(context.getString(R.string.invoice_hint_company_address)));
        this.doS = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sk(context.getString(R.string.invoice_desc_mobile)).gn(true).lR(2).sl(context.getString(R.string.invoice_hint_mobile)));
        this.doT = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gn(true).sk(context.getString(R.string.invoice_desc_bank)).sl(context.getString(R.string.invoice_hint_bank)));
        this.doU = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sk(context.getString(R.string.invoice_desc_bank_account)).gn(true).lR(2).sl(context.getString(R.string.invoice_hint_bank_account)));
        this.doO = new InvoiceInfoItemView[]{this.doP, this.doQ, this.doR, this.doS, this.doT, this.doU};
        for (int i = 0; i < this.doO.length; i++) {
            addView(this.doO[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.doP.getContent(), this.doQ.getContent(), this.doR.getContent(), this.doS.getContent(), this.doT.getContent(), this.doU.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.doP.setContent(invoiceInfo.mTitle);
            this.doQ.setContent(invoiceInfo.doF);
            this.doR.setContent(invoiceInfo.doG);
            this.doS.setContent(invoiceInfo.doH);
            this.doT.setContent(invoiceInfo.doI);
            this.doU.setContent(invoiceInfo.doJ);
        }
    }
}
