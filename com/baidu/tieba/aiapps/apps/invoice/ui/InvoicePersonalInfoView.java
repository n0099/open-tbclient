package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTD;
    private InvoiceInfoItemView cTG;

    public InvoicePersonalInfoView(Context context) {
        this(context, null);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.cTD = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rA(context.getString(d.j.invoice_desc_name)).fU(true).rB(context.getString(d.j.invoice_hint_personal_name)).rC("\\S+$").rD(context.getString(d.j.invoice_err_msg_personal_name)));
        this.cTG = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rA(context.getString(d.j.invoice_desc_mobile)).fU(true).lN(2).rB(context.getString(d.j.invoice_hint_mobile)));
        this.cTC = new InvoiceInfoItemView[]{this.cTD, this.cTG};
        for (int i = 0; i < this.cTC.length; i++) {
            addView(this.cTC[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cTD.getContent(), this.cTG.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTD.setContent(invoiceInfo.mTitle);
            this.cTG.setContent(invoiceInfo.cTw);
        }
    }
}
