package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTD;
    private InvoiceInfoItemView cTE;
    private InvoiceInfoItemView cTF;
    private InvoiceInfoItemView cTG;
    private InvoiceInfoItemView cTH;
    private InvoiceInfoItemView cTI;

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
        this.cTD = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).fU(true).rA(context.getString(d.j.invoice_desc_name)).rB(context.getString(d.j.invoice_hint_name)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_name)));
        this.cTE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rA(context.getString(d.j.invoice_desc_tax_number)).fU(true).lN(2).rE(context.getString(d.j.alphabet_and_number)).rB(context.getString(d.j.invoice_hint_tax_number)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_tax_number)));
        this.cTF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rA(context.getString(d.j.invoice_desc_company_address)).rB(context.getString(d.j.invoice_hint_company_address)));
        this.cTG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_mobile)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_mobile)));
        this.cTH = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rA(context.getString(d.j.invoice_desc_bank)).rB(context.getString(d.j.invoice_hint_bank)));
        this.cTI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_bank_account)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_bank_account)));
        this.cTC = new InvoiceInfoItemView[]{this.cTD, this.cTE, this.cTF, this.cTG, this.cTH, this.cTI};
        for (int i = 0; i < this.cTC.length; i++) {
            addView(this.cTC[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cTD.getContent(), this.cTE.getContent(), this.cTF.getContent(), this.cTG.getContent(), this.cTH.getContent(), this.cTI.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTD.setContent(invoiceInfo.mTitle);
            this.cTE.setContent(invoiceInfo.cTu);
            this.cTF.setContent(invoiceInfo.cTv);
            this.cTG.setContent(invoiceInfo.cTw);
            this.cTH.setContent(invoiceInfo.cTx);
            this.cTI.setContent(invoiceInfo.cTy);
        }
    }
}
