package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bDL;
    private InvoiceInfoItemView bDO;

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
        this.bDL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().dx(true).kh(context.getString(e.j.invoice_desc_name)).dy(true).ki(context.getString(e.j.invoice_hint_personal_name)).kj("\\S+$").kk(context.getString(e.j.invoice_err_msg_personal_name)));
        this.bDO = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().kh(context.getString(e.j.invoice_desc_mobile)).dy(true).hI(2).ki(context.getString(e.j.invoice_hint_mobile)));
        this.bDK = new InvoiceInfoItemView[]{this.bDL, this.bDO};
        for (int i = 0; i < this.bDK.length; i++) {
            addView(this.bDK[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bDL.getContent(), this.bDO.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bDL.setContent(invoiceInfo.mTitle);
            this.bDO.setContent(invoiceInfo.bDE);
        }
    }
}
