package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dnX;
    private InvoiceInfoItemView doa;

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
        this.dnX = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gm(true).sk(context.getString(R.string.invoice_desc_name)).gn(true).sl(context.getString(R.string.invoice_hint_personal_name)).sm("\\S+$").sn(context.getString(R.string.invoice_err_msg_personal_name)));
        this.doa = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().sk(context.getString(R.string.invoice_desc_mobile)).gn(true).lQ(2).sl(context.getString(R.string.invoice_hint_mobile)));
        this.dnW = new InvoiceInfoItemView[]{this.dnX, this.doa};
        for (int i = 0; i < this.dnW.length; i++) {
            addView(this.dnW[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.dnX.getContent(), this.doa.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dnX.setContent(invoiceInfo.mTitle);
            this.doa.setContent(invoiceInfo.dnP);
        }
    }
}
