package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dbZ;
    private InvoiceInfoItemView dcc;

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
        this.dbZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gq(true).sJ(context.getString(R.string.invoice_desc_name)).gr(true).sK(context.getString(R.string.invoice_hint_personal_name)).sL("\\S+$").sM(context.getString(R.string.invoice_err_msg_personal_name)));
        this.dcc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sJ(context.getString(R.string.invoice_desc_mobile)).gr(true).mA(2).sK(context.getString(R.string.invoice_hint_mobile)));
        this.dbY = new InvoiceInfoItemView[]{this.dbZ, this.dcc};
        for (int i = 0; i < this.dbY.length; i++) {
            addView(this.dbY[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.dbZ.getContent(), this.dcc.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dbZ.setContent(invoiceInfo.mTitle);
            this.dcc.setContent(invoiceInfo.dbR);
        }
    }
}
