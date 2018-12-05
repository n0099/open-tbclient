package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.aiapps.apps.invoice.f;
/* loaded from: classes4.dex */
public abstract class InvoiceBaseInfoView extends LinearLayout implements f {
    protected InvoiceInfoItemView[] bHn;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bHn != null && textWatcher != null) {
            for (int i = 0; i < this.bHn.length; i++) {
                this.bHn[i].setTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Yy() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.bHn == null || this.bHn.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bHn) {
            if (invoiceInfoItemView.YC() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Yz() {
        if (this.bHn == null || this.bHn.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bHn) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
