package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTF;
    private InvoiceInfoItemView cTG;
    private InvoiceInfoItemView cTH;
    private InvoiceInfoItemView cTI;
    private InvoiceInfoItemView cTJ;
    private InvoiceInfoItemView cTK;

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
        this.cTF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).fU(true).rB(context.getString(d.j.invoice_desc_name)).rC(context.getString(d.j.invoice_hint_name)).rD("\\S+$").rE(context.getString(d.j.invoice_err_msg_name)));
        this.cTG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rB(context.getString(d.j.invoice_desc_tax_number)).fU(true).lO(2).rF(context.getString(d.j.alphabet_and_number)).rC(context.getString(d.j.invoice_hint_tax_number)).rD("\\S+$").rE(context.getString(d.j.invoice_err_msg_tax_number)));
        this.cTH = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rB(context.getString(d.j.invoice_desc_company_address)).rC(context.getString(d.j.invoice_hint_company_address)));
        this.cTI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rB(context.getString(d.j.invoice_desc_mobile)).fU(true).lO(2).rC(context.getString(d.j.invoice_hint_mobile)));
        this.cTJ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fU(true).rB(context.getString(d.j.invoice_desc_bank)).rC(context.getString(d.j.invoice_hint_bank)));
        this.cTK = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rB(context.getString(d.j.invoice_desc_bank_account)).fU(true).lO(2).rC(context.getString(d.j.invoice_hint_bank_account)));
        this.cTE = new InvoiceInfoItemView[]{this.cTF, this.cTG, this.cTH, this.cTI, this.cTJ, this.cTK};
        for (int i = 0; i < this.cTE.length; i++) {
            addView(this.cTE[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cTF.getContent(), this.cTG.getContent(), this.cTH.getContent(), this.cTI.getContent(), this.cTJ.getContent(), this.cTK.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTF.setContent(invoiceInfo.mTitle);
            this.cTG.setContent(invoiceInfo.cTw);
            this.cTH.setContent(invoiceInfo.cTx);
            this.cTI.setContent(invoiceInfo.cTy);
            this.cTJ.setContent(invoiceInfo.cTz);
            this.cTK.setContent(invoiceInfo.cTA);
        }
    }
}
