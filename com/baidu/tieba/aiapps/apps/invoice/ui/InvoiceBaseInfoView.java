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
    protected InvoiceInfoItemView[] bCY;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bCY != null && textWatcher != null) {
            for (int i = 0; i < this.bCY.length; i++) {
                this.bCY[i].setTextChangedListener(textWatcher);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xl() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.bCY == null || this.bCY.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bCY) {
            if (invoiceInfoItemView.Xp() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xm() {
        if (this.bCY == null || this.bCY.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bCY) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}
