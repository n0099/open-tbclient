package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private TextView bEk;
    private EditText bEl;
    private View bEm;
    private String bEn;
    private boolean bEo;
    private Context mContext;
    private String mErrorMessage;
    private RelativeLayout mRootView;

    public InvoiceInfoItemView(Context context) {
        this(context, null);
    }

    public InvoiceInfoItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceInfoItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        inflate(context, e.h.invoice_info_item_view, this);
        this.mRootView = (RelativeLayout) findViewById(e.g.item_root_view);
        this.mRootView.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bEk = (TextView) findViewById(e.g.invoice_info_desc);
        this.bEl = (EditText) findViewById(e.g.invoice_info_content);
        this.bEm = findViewById(e.g.divider_line);
        this.bEk.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bEl.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bEl.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bEm.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bEo = aVar.bEo;
            this.bEk.setText(aVar.mDesc);
            this.bEl.setHint(aVar.bEq);
            if (!aVar.bEr) {
                this.bEl.setSingleLine();
            } else {
                aVar.bEp |= 131072;
            }
            this.bEl.setInputType(aVar.bEp);
            if (!TextUtils.isEmpty(aVar.bEs)) {
                this.bEl.setKeyListener(DigitsKeyListener.getInstance(aVar.bEs));
            }
            this.bEn = aVar.bEn;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bEl != null) {
            return this.bEl.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bEl != null) {
            this.bEl.setText(charSequence);
        }
    }

    public boolean Xz() {
        return this.bEo;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bEl != null && textWatcher != null) {
            this.bEl.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bEn;
        private boolean bEo = false;
        private int bEp = 1;
        private String bEq;
        private boolean bEr;
        private String bEs;
        private String mDesc;
        private String mErrorMessage;

        public a dx(boolean z) {
            this.bEo = z;
            return this;
        }

        public a kh(String str) {
            this.mDesc = str;
            return this;
        }

        public a hI(int i) {
            this.bEp = i;
            return this;
        }

        public a ki(String str) {
            this.bEq = str;
            return this;
        }

        public a kj(String str) {
            this.bEn = str;
            return this;
        }

        public a kk(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dy(boolean z) {
            this.bEr = z;
            return this;
        }

        public a kl(String str) {
            this.bEs = str;
            return this;
        }
    }
}
