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
    protected InvoiceInfoItemView[] dbX;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dbX != null && textWatcher != null) {
            for (int i = 0; i < this.dbX.length; i++) {
                this.dbX[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.dbX != null && textWatcher != null) {
            for (int i = 0; i < this.dbX.length; i++) {
                this.dbX[i].removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEu() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.dbX == null || this.dbX.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dbX) {
            if (invoiceInfoItemView.aEz() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEv() {
        if (this.dbX == null || this.dbX.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dbX) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
