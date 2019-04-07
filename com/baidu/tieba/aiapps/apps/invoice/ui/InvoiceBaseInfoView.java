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
    protected InvoiceInfoItemView[] cTC;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cTC != null && textWatcher != null) {
            for (int i = 0; i < this.cTC.length; i++) {
                this.cTC[i].setTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azd() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cTC == null || this.cTC.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTC) {
            if (invoiceInfoItemView.azi() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aze() {
        if (this.cTC == null || this.cTC.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTC) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
