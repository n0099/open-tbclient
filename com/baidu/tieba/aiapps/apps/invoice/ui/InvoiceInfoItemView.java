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
    private TextView cTZ;
    private EditText cUa;
    private View cUb;
    private String cUc;
    private boolean cUd;
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
        this.cTZ = (TextView) findViewById(d.g.invoice_info_desc);
        this.cUa = (EditText) findViewById(d.g.invoice_info_content);
        this.cUb = findViewById(d.g.divider_line);
        this.cTZ.setTextColor(getResources().getColor(d.C0277d.invoice_info_desc));
        this.cUa.setTextColor(getResources().getColor(d.C0277d.invoice_info_content));
        this.cUa.setHintTextColor(getResources().getColor(d.C0277d.invoice_info_content_hint));
        this.cUb.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cUd = aVar.cUd;
            this.cTZ.setText(aVar.aVF);
            this.cUa.setHint(aVar.cUf);
            if (!aVar.cUg) {
                this.cUa.setSingleLine();
            } else {
                aVar.cUe |= 131072;
            }
            this.cUa.setInputType(aVar.cUe);
            if (!TextUtils.isEmpty(aVar.cUh)) {
                this.cUa.setKeyListener(DigitsKeyListener.getInstance(aVar.cUh));
            }
            this.cUc = aVar.cUc;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cUa != null) {
            return this.cUa.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cUa != null) {
            this.cUa.setText(charSequence);
        }
    }

    public boolean azl() {
        return this.cUd;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cUa != null && textWatcher != null) {
            this.cUa.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aVF;
        private String cUc;
        private boolean cUd = false;
        private int cUe = 1;
        private String cUf;
        private boolean cUg;
        private String cUh;
        private String mErrorMessage;

        public a fT(boolean z) {
            this.cUd = z;
            return this;
        }

        public a rz(String str) {
            this.aVF = str;
            return this;
        }

        public a lO(int i) {
            this.cUe = i;
            return this;
        }

        public a rA(String str) {
            this.cUf = str;
            return this;
        }

        public a rB(String str) {
            this.cUc = str;
            return this;
        }

        public a rC(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fU(boolean z) {
            this.cUg = z;
            return this;
        }

        public a rD(String str) {
            this.cUh = str;
            return this;
        }
    }
}
