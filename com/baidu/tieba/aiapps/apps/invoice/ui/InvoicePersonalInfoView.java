package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bHr;
    private InvoiceInfoItemView bHu;

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
        this.bHr = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kC(context.getString(e.j.invoice_desc_name)).dz(true).kD(context.getString(e.j.invoice_hint_personal_name)).kE("\\S+$").kF(context.getString(e.j.invoice_err_msg_personal_name)));
        this.bHu = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kC(context.getString(e.j.invoice_desc_mobile)).dz(true).hX(2).kD(context.getString(e.j.invoice_hint_mobile)));
        this.bHq = new InvoiceInfoItemView[]{this.bHr, this.bHu};
        for (int i = 0; i < this.bHq.length; i++) {
            addView(this.bHq[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bHr.getContent(), this.bHu.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bHr.setContent(invoiceInfo.mTitle);
            this.bHu.setContent(invoiceInfo.bHk);
        }
    }
}
