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
    private TextView bIE;
    private EditText bIF;
    private View bIG;
    private String bIH;
    private boolean bII;
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
        this.bIE = (TextView) findViewById(e.g.invoice_info_desc);
        this.bIF = (EditText) findViewById(e.g.invoice_info_content);
        this.bIG = findViewById(e.g.divider_line);
        this.bIE.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bIF.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bIF.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bIG.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bII = aVar.bII;
            this.bIE.setText(aVar.mDesc);
            this.bIF.setHint(aVar.bIK);
            if (!aVar.bIL) {
                this.bIF.setSingleLine();
            } else {
                aVar.bIJ |= 131072;
            }
            this.bIF.setInputType(aVar.bIJ);
            if (!TextUtils.isEmpty(aVar.bIM)) {
                this.bIF.setKeyListener(DigitsKeyListener.getInstance(aVar.bIM));
            }
            this.bIH = aVar.bIH;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bIF != null) {
            return this.bIF.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bIF != null) {
            this.bIF.setText(charSequence);
        }
    }

    public boolean Zb() {
        return this.bII;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bIF != null && textWatcher != null) {
            this.bIF.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bIH;
        private boolean bII = false;
        private int bIJ = 1;
        private String bIK;
        private boolean bIL;
        private String bIM;
        private String mDesc;
        private String mErrorMessage;

        public a dB(boolean z) {
            this.bII = z;
            return this;
        }

        public a kS(String str) {
            this.mDesc = str;
            return this;
        }

        public a hX(int i) {
            this.bIJ = i;
            return this;
        }

        public a kT(String str) {
            this.bIK = str;
            return this;
        }

        public a kU(String str) {
            this.bIH = str;
            return this;
        }

        public a kV(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dC(boolean z) {
            this.bIL = z;
            return this;
        }

        public a kW(String str) {
            this.bIM = str;
            return this;
        }
    }
}
