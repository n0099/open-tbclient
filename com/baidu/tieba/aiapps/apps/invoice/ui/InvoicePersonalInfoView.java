package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView ddI;
    private InvoiceInfoItemView ddL;

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
        this.ddI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gu(true).tc(context.getString(R.string.invoice_desc_name)).gv(true).td(context.getString(R.string.invoice_hint_personal_name)).te("\\S+$").tf(context.getString(R.string.invoice_err_msg_personal_name)));
        this.ddL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tc(context.getString(R.string.invoice_desc_mobile)).gv(true).mI(2).td(context.getString(R.string.invoice_hint_mobile)));
        this.ddH = new InvoiceInfoItemView[]{this.ddI, this.ddL};
        for (int i = 0; i < this.ddH.length; i++) {
            addView(this.ddH[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.ddI.getContent(), this.ddL.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.ddI.setContent(invoiceInfo.mTitle);
            this.ddL.setContent(invoiceInfo.ddA);
        }
    }
}
