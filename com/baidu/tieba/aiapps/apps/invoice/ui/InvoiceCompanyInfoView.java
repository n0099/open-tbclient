package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dnX;
    private InvoiceInfoItemView dnY;
    private InvoiceInfoItemView dnZ;
    private InvoiceInfoItemView doa;
    private InvoiceInfoItemView dob;
    private InvoiceInfoItemView dod;

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
        this.dnX = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gm(true).gn(true).sk(context.getString(R.string.invoice_desc_name)).sl(context.getString(R.string.invoice_hint_name)).sm("\\S+$").sn(context.getString(R.string.invoice_err_msg_name)));
        this.dnY = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gm(true).sk(context.getString(R.string.invoice_desc_tax_number)).gn(true).lQ(2).so(context.getString(R.string.alphabet_and_number)).sl(context.getString(R.string.invoice_hint_tax_number)).sm("\\S+$").sn(context.getString(R.string.invoice_err_msg_tax_number)));
        this.dnZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gn(true).sk(context.getString(R.string.invoice_desc_company_address)).sl(context.getString(R.string.invoice_hint_company_address)));
        this.doa = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sk(context.getString(R.string.invoice_desc_mobile)).gn(true).lQ(2).sl(context.getString(R.string.invoice_hint_mobile)));
        this.dob = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gn(true).sk(context.getString(R.string.invoice_desc_bank)).sl(context.getString(R.string.invoice_hint_bank)));
        this.dod = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sk(context.getString(R.string.invoice_desc_bank_account)).gn(true).lQ(2).sl(context.getString(R.string.invoice_hint_bank_account)));
        this.dnW = new InvoiceInfoItemView[]{this.dnX, this.dnY, this.dnZ, this.doa, this.dob, this.dod};
        for (int i = 0; i < this.dnW.length; i++) {
            addView(this.dnW[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.dnX.getContent(), this.dnY.getContent(), this.dnZ.getContent(), this.doa.getContent(), this.dob.getContent(), this.dod.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dnX.setContent(invoiceInfo.mTitle);
            this.dnY.setContent(invoiceInfo.dnN);
            this.dnZ.setContent(invoiceInfo.dnO);
            this.doa.setContent(invoiceInfo.dnP);
            this.dob.setContent(invoiceInfo.dnQ);
            this.dod.setContent(invoiceInfo.dnR);
        }
    }
}
