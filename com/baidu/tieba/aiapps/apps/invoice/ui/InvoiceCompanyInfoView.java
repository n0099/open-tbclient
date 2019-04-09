package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTE;
    private InvoiceInfoItemView cTF;
    private InvoiceInfoItemView cTG;
    private InvoiceInfoItemView cTH;
    private InvoiceInfoItemView cTI;
    private InvoiceInfoItemView cTJ;

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
        this.cTE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).fU(true).rA(context.getString(d.j.invoice_desc_name)).rB(context.getString(d.j.invoice_hint_name)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_name)));
        this.cTF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rA(context.getString(d.j.invoice_desc_tax_number)).fU(true).lN(2).rE(context.getString(d.j.alphabet_and_number)).rB(context.getString(d.j.invoice_hint_tax_number)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_tax_number)));
        this.cTG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rA(context.getString(d.j.invoice_desc_company_address)).rB(context.getString(d.j.invoice_hint_company_address)));
        this.cTH = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_mobile)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_mobile)));
        this.cTI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rA(context.getString(d.j.invoice_desc_bank)).rB(context.getString(d.j.invoice_hint_bank)));
        this.cTJ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_bank_account)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_bank_account)));
        this.cTD = new InvoiceInfoItemView[]{this.cTE, this.cTF, this.cTG, this.cTH, this.cTI, this.cTJ};
        for (int i = 0; i < this.cTD.length; i++) {
            addView(this.cTD[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cTE.getContent(), this.cTF.getContent(), this.cTG.getContent(), this.cTH.getContent(), this.cTI.getContent(), this.cTJ.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTE.setContent(invoiceInfo.mTitle);
            this.cTF.setContent(invoiceInfo.cTv);
            this.cTG.setContent(invoiceInfo.cTw);
            this.cTH.setContent(invoiceInfo.cTx);
            this.cTI.setContent(invoiceInfo.cTy);
            this.cTJ.setContent(invoiceInfo.cTz);
        }
    }
}
