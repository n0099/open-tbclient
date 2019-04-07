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
    private TextView cUb;
    private EditText cUc;
    private View cUd;
    private String cUe;
    private boolean cUf;
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
        this.mRootView.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_edit_view_bg));
        this.cUb = (TextView) findViewById(d.g.invoice_info_desc);
        this.cUc = (EditText) findViewById(d.g.invoice_info_content);
        this.cUd = findViewById(d.g.divider_line);
        this.cUb.setTextColor(getResources().getColor(d.C0277d.invoice_info_desc));
        this.cUc.setTextColor(getResources().getColor(d.C0277d.invoice_info_content));
        this.cUc.setHintTextColor(getResources().getColor(d.C0277d.invoice_info_content_hint));
        this.cUd.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cUf = aVar.cUf;
            this.cUb.setText(aVar.aVI);
            this.cUc.setHint(aVar.cUh);
            if (!aVar.cUi) {
                this.cUc.setSingleLine();
            } else {
                aVar.cUg |= 131072;
            }
            this.cUc.setInputType(aVar.cUg);
            if (!TextUtils.isEmpty(aVar.cUj)) {
                this.cUc.setKeyListener(DigitsKeyListener.getInstance(aVar.cUj));
            }
            this.cUe = aVar.cUe;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cUc != null) {
            return this.cUc.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cUc != null) {
            this.cUc.setText(charSequence);
        }
    }

    public boolean azi() {
        return this.cUf;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cUc != null && textWatcher != null) {
            this.cUc.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aVI;
        private String cUe;
        private boolean cUf = false;
        private int cUg = 1;
        private String cUh;
        private boolean cUi;
        private String cUj;
        private String mErrorMessage;

        public a fT(boolean z) {
            this.cUf = z;
            return this;
        }

        public a rA(String str) {
            this.aVI = str;
            return this;
        }

        public a lN(int i) {
            this.cUg = i;
            return this;
        }

        public a rB(String str) {
            this.cUh = str;
            return this;
        }

        public a rC(String str) {
            this.cUe = str;
            return this;
        }

        public a rD(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fU(boolean z) {
            this.cUi = z;
            return this;
        }

        public a rE(String str) {
            this.cUj = str;
            return this;
        }
    }
}
