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
    protected InvoiceInfoItemView[] dbW;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dbW != null && textWatcher != null) {
            for (int i = 0; i < this.dbW.length; i++) {
                this.dbW[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.dbW != null && textWatcher != null) {
            for (int i = 0; i < this.dbW.length; i++) {
                this.dbW[i].removeTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEr() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.dbW == null || this.dbW.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dbW) {
            if (invoiceInfoItemView.aEw() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEs() {
        if (this.dbW == null || this.dbW.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dbW) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
