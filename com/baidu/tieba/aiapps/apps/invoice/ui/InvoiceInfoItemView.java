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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private TextView cUd;
    private EditText cUe;
    private View cUf;
    private String cUg;
    private boolean cUh;
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
        inflate(context, d.h.invoice_info_item_view, this);
        this.mRootView = (RelativeLayout) findViewById(d.g.item_root_view);
        this.mRootView.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_edit_view_bg));
        this.cUd = (TextView) findViewById(d.g.invoice_info_desc);
        this.cUe = (EditText) findViewById(d.g.invoice_info_content);
        this.cUf = findViewById(d.g.divider_line);
        this.cUd.setTextColor(getResources().getColor(d.C0236d.invoice_info_desc));
        this.cUe.setTextColor(getResources().getColor(d.C0236d.invoice_info_content));
        this.cUe.setHintTextColor(getResources().getColor(d.C0236d.invoice_info_content_hint));
        this.cUf.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cUh = aVar.cUh;
            this.cUd.setText(aVar.aVE);
            this.cUe.setHint(aVar.cUj);
            if (!aVar.cUk) {
                this.cUe.setSingleLine();
            } else {
                aVar.cUi |= 131072;
            }
            this.cUe.setInputType(aVar.cUi);
            if (!TextUtils.isEmpty(aVar.cUl)) {
                this.cUe.setKeyListener(DigitsKeyListener.getInstance(aVar.cUl));
            }
            this.cUg = aVar.cUg;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cUe != null) {
            return this.cUe.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cUe != null) {
            this.cUe.setText(charSequence);
        }
    }

    public boolean azl() {
        return this.cUh;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cUe != null && textWatcher != null) {
            this.cUe.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aVE;
        private String cUg;
        private boolean cUh = false;
        private int cUi = 1;
        private String cUj;
        private boolean cUk;
        private String cUl;
        private String mErrorMessage;

        public a fT(boolean z) {
            this.cUh = z;
            return this;
        }

        public a rA(String str) {
            this.aVE = str;
            return this;
        }

        public a lO(int i) {
            this.cUi = i;
            return this;
        }

        public a rB(String str) {
            this.cUj = str;
            return this;
        }

        public a rC(String str) {
            this.cUg = str;
            return this;
        }

        public a rD(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fU(boolean z) {
            this.cUk = z;
            return this;
        }

        public a rE(String str) {
            this.cUl = str;
            return this;
        }
    }
}
