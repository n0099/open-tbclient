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
    protected InvoiceInfoItemView[] doO;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.doO != null && textWatcher != null) {
            for (int i = 0; i < this.doO.length; i++) {
                this.doO[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(TextWatcher textWatcher) {
        if (this.doO != null && textWatcher != null) {
            for (int i = 0; i < this.doO.length; i++) {
                this.doO[i].e(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGD() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.doO == null || this.doO.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.doO) {
            if (invoiceInfoItemView.aGJ() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGE() {
        if (this.doO == null || this.doO.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.doO) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
