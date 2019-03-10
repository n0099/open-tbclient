package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cTF;
    private InvoiceInfoItemView cTI;

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
        this.cTF = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fT(true).rB(context.getString(d.j.invoice_desc_name)).fU(true).rC(context.getString(d.j.invoice_hint_personal_name)).rD("\\S+$").rE(context.getString(d.j.invoice_err_msg_personal_name)));
        this.cTI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().rB(context.getString(d.j.invoice_desc_mobile)).fU(true).lO(2).rC(context.getString(d.j.invoice_hint_mobile)));
        this.cTE = new InvoiceInfoItemView[]{this.cTF, this.cTI};
        for (int i = 0; i < this.cTE.length; i++) {
            addView(this.cTE[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cTF.getContent(), this.cTI.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cTF.setContent(invoiceInfo.mTitle);
            this.cTI.setContent(invoiceInfo.cTy);
        }
    }
}
