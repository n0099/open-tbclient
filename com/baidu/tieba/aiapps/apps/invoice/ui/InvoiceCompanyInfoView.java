package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes4.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView dfu;
    private InvoiceInfoItemView dfv;
    private InvoiceInfoItemView dfw;
    private InvoiceInfoItemView dfx;
    private InvoiceInfoItemView dfy;
    private InvoiceInfoItemView dfz;

    public InvoiceCompanyInfoView(Context context) {
        this(context, null);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.dfu = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gx(true).gy(true).tB(context.getString(R.string.invoice_desc_name)).tC(context.getString(R.string.invoice_hint_name)).tD("\\S+$").tE(context.getString(R.string.invoice_err_msg_name)));
        this.dfv = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gx(true).tB(context.getString(R.string.invoice_desc_tax_number)).gy(true).mM(2).tF(context.getString(R.string.alphabet_and_number)).tC(context.getString(R.string.invoice_hint_tax_number)).tD("\\S+$").tE(context.getString(R.string.invoice_err_msg_tax_number)));
        this.dfw = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gy(true).tB(context.getString(R.string.invoice_desc_company_address)).tC(context.getString(R.string.invoice_hint_company_address)));
        this.dfx = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tB(context.getString(R.string.invoice_desc_mobile)).gy(true).mM(2).tC(context.getString(R.string.invoice_hint_mobile)));
        this.dfy = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().gy(true).tB(context.getString(R.string.invoice_desc_bank)).tC(context.getString(R.string.invoice_hint_bank)));
        this.dfz = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().tB(context.getString(R.string.invoice_desc_bank_account)).gy(true).mM(2).tC(context.getString(R.string.invoice_hint_bank_account)));
        this.dft = new InvoiceInfoItemView[]{this.dfu, this.dfv, this.dfw, this.dfx, this.dfy, this.dfz};
        for (int i = 0; i < this.dft.length; i++) {
            addView(this.dft[i], i);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.dfu.getContent(), this.dfv.getContent(), this.dfw.getContent(), this.dfx.getContent(), this.dfy.getContent(), this.dfz.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.dfu.setContent(invoiceInfo.mTitle);
            this.dfv.setContent(invoiceInfo.dfk);
            this.dfw.setContent(invoiceInfo.dfl);
            this.dfx.setContent(invoiceInfo.dfm);
            this.dfy.setContent(invoiceInfo.dfn);
            this.dfz.setContent(invoiceInfo.dfo);
        }
    }
}
