package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dfu;
    private InvoiceInfoItemView dfx;

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
        this.dfu = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gx(true).tB(context.getString(R.string.invoice_desc_name)).gy(true).tC(context.getString(R.string.invoice_hint_personal_name)).tD("\\S+$").tE(context.getString(R.string.invoice_err_msg_personal_name)));
        this.dfx = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tB(context.getString(R.string.invoice_desc_mobile)).gy(true).mM(2).tC(context.getString(R.string.invoice_hint_mobile)));
        this.dft = new InvoiceInfoItemView[]{this.dfu, this.dfx};
        for (int i = 0; i < this.dft.length; i++) {
            addView(this.dft[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.dfu.getContent(), this.dfx.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dfu.setContent(invoiceInfo.mTitle);
            this.dfx.setContent(invoiceInfo.dfm);
        }
    }
}
