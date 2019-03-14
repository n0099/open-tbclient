package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTB;
    private InvoiceInfoItemView cTC;
    private InvoiceInfoItemView cTD;
    private InvoiceInfoItemView cTE;
    private InvoiceInfoItemView cTF;
    private InvoiceInfoItemView cTG;

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
        this.cTB = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).fU(true).rz(context.getString(d.j.invoice_desc_name)).rA(context.getString(d.j.invoice_hint_name)).rB("\\S+$").rC(context.getString(d.j.invoice_err_msg_name)));
        this.cTC = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rz(context.getString(d.j.invoice_desc_tax_number)).fU(true).lO(2).rD(context.getString(d.j.alphabet_and_number)).rA(context.getString(d.j.invoice_hint_tax_number)).rB("\\S+$").rC(context.getString(d.j.invoice_err_msg_tax_number)));
        this.cTD = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rz(context.getString(d.j.invoice_desc_company_address)).rA(context.getString(d.j.invoice_hint_company_address)));
        this.cTE = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rz(context.getString(d.j.invoice_desc_mobile)).fU(true).lO(2).rA(context.getString(d.j.invoice_hint_mobile)));
        this.cTF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rz(context.getString(d.j.invoice_desc_bank)).rA(context.getString(d.j.invoice_hint_bank)));
        this.cTG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rz(context.getString(d.j.invoice_desc_bank_account)).fU(true).lO(2).rA(context.getString(d.j.invoice_hint_bank_account)));
        this.cTA = new InvoiceInfoItemView[]{this.cTB, this.cTC, this.cTD, this.cTE, this.cTF, this.cTG};
        for (int i = 0; i < this.cTA.length; i++) {
            addView(this.cTA[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cTB.getContent(), this.cTC.getContent(), this.cTD.getContent(), this.cTE.getContent(), this.cTF.getContent(), this.cTG.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTB.setContent(invoiceInfo.mTitle);
            this.cTC.setContent(invoiceInfo.cTs);
            this.cTD.setContent(invoiceInfo.cTt);
            this.cTE.setContent(invoiceInfo.cTu);
            this.cTF.setContent(invoiceInfo.cTv);
            this.cTG.setContent(invoiceInfo.cTw);
        }
    }
}
