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
    protected InvoiceInfoItemView[] dnW;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dnW != null && textWatcher != null) {
            for (int i = 0; i < this.dnW.length; i++) {
                this.dnW[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(TextWatcher textWatcher) {
        if (this.dnW != null && textWatcher != null) {
            for (int i = 0; i < this.dnW.length; i++) {
                this.dnW[i].e(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGB() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.dnW == null || this.dnW.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dnW) {
            if (invoiceInfoItemView.aGH() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGC() {
        if (this.dnW == null || this.dnW.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.dnW) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
