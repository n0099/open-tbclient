package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bHo;
    private InvoiceInfoItemView bHr;

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
        this.bHo = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dy(true).kB(context.getString(e.j.invoice_desc_name)).dz(true).kC(context.getString(e.j.invoice_hint_personal_name)).kD("\\S+$").kE(context.getString(e.j.invoice_err_msg_personal_name)));
        this.bHr = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kB(context.getString(e.j.invoice_desc_mobile)).dz(true).hW(2).kC(context.getString(e.j.invoice_hint_mobile)));
        this.bHn = new InvoiceInfoItemView[]{this.bHo, this.bHr};
        for (int i = 0; i < this.bHn.length; i++) {
            addView(this.bHn[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bHo.getContent(), this.bHr.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bHo.setContent(invoiceInfo.mTitle);
            this.bHr.setContent(invoiceInfo.bHh);
        }
    }
}
