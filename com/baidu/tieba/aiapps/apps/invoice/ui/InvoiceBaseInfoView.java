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
    protected InvoiceInfoItemView[] ddA;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.ddA != null && textWatcher != null) {
            for (int i = 0; i < this.ddA.length; i++) {
                this.ddA[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(TextWatcher textWatcher) {
        if (this.ddA != null && textWatcher != null) {
            for (int i = 0; i < this.ddA.length; i++) {
                this.ddA[i].e(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFK() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.ddA == null || this.ddA.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.ddA) {
            if (invoiceInfoItemView.aFQ() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFL() {
        if (this.ddA == null || this.ddA.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.ddA) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
