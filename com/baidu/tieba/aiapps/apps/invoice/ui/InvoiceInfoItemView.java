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
    private TextView cUc;
    private EditText cUd;
    private View cUe;
    private String cUf;
    private boolean cUg;
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
        this.cUc = (TextView) findViewById(d.g.invoice_info_desc);
        this.cUd = (EditText) findViewById(d.g.invoice_info_content);
        this.cUe = findViewById(d.g.divider_line);
        this.cUc.setTextColor(getResources().getColor(d.C0277d.invoice_info_desc));
        this.cUd.setTextColor(getResources().getColor(d.C0277d.invoice_info_content));
        this.cUd.setHintTextColor(getResources().getColor(d.C0277d.invoice_info_content_hint));
        this.cUe.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cUg = aVar.cUg;
            this.cUc.setText(aVar.aVJ);
            this.cUd.setHint(aVar.cUi);
            if (!aVar.cUj) {
                this.cUd.setSingleLine();
            } else {
                aVar.cUh |= 131072;
            }
            this.cUd.setInputType(aVar.cUh);
            if (!TextUtils.isEmpty(aVar.cUk)) {
                this.cUd.setKeyListener(DigitsKeyListener.getInstance(aVar.cUk));
            }
            this.cUf = aVar.cUf;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cUd != null) {
            return this.cUd.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cUd != null) {
            this.cUd.setText(charSequence);
        }
    }

    public boolean azi() {
        return this.cUg;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cUd != null && textWatcher != null) {
            this.cUd.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aVJ;
        private String cUf;
        private boolean cUg = false;
        private int cUh = 1;
        private String cUi;
        private boolean cUj;
        private String cUk;
        private String mErrorMessage;

        public a fT(boolean z) {
            this.cUg = z;
            return this;
        }

        public a rA(String str) {
            this.aVJ = str;
            return this;
        }

        public a lN(int i) {
            this.cUh = i;
            return this;
        }

        public a rB(String str) {
            this.cUi = str;
            return this;
        }

        public a rC(String str) {
            this.cUf = str;
            return this;
        }

        public a rD(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fU(boolean z) {
            this.cUj = z;
            return this;
        }

        public a rE(String str) {
            this.cUk = str;
            return this;
        }
    }
}
