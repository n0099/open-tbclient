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
    protected InvoiceInfoItemView[] cTA;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cTA != null && textWatcher != null) {
            for (int i = 0; i < this.cTA.length; i++) {
                this.cTA[i].setTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azg() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cTA == null || this.cTA.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTA) {
            if (invoiceInfoItemView.azl() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azh() {
        if (this.cTA == null || this.cTA.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cTA) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
