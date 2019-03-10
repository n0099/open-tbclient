package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.aiapps.apps.invoice.e;
/* loaded from: classes4.dex */
public abstract class InvoiceBaseInfoView extends LinearLayout implements e {
    protected InvoiceInfoItemView[] cTE;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cTE != null && textWatcher != null) {
            for (int i = 0; i < this.cTE.length; i++) {
                this.cTE[i].setTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azh() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cTE == null || this.cTE.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTE) {
            if (invoiceInfoItemView.azm() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azi() {
        if (this.cTE == null || this.cTE.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTE) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
