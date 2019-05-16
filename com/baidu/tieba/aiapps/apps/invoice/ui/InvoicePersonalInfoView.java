package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dbX;
    private InvoiceInfoItemView dca;

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
        this.dbX = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).sK(context.getString(R.string.invoice_desc_name)).gr(true).sL(context.getString(R.string.invoice_hint_personal_name)).sM("\\S+$").sN(context.getString(R.string.invoice_err_msg_personal_name)));
        this.dca = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sK(context.getString(R.string.invoice_desc_mobile)).gr(true).mA(2).sL(context.getString(R.string.invoice_hint_mobile)));
        this.dbW = new InvoiceInfoItemView[]{this.dbX, this.dca};
        for (int i = 0; i < this.dbW.length; i++) {
            addView(this.dbW[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.dbX.getContent(), this.dca.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dbX.setContent(invoiceInfo.mTitle);
            this.dca.setContent(invoiceInfo.dbP);
        }
    }
}
