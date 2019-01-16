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
    private TextView bID;
    private EditText bIE;
    private View bIF;
    private String bIG;
    private boolean bIH;
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
        this.bID = (TextView) findViewById(e.g.invoice_info_desc);
        this.bIE = (EditText) findViewById(e.g.invoice_info_content);
        this.bIF = findViewById(e.g.divider_line);
        this.bID.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bIE.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bIE.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bIF.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bIH = aVar.bIH;
            this.bID.setText(aVar.mDesc);
            this.bIE.setHint(aVar.bIJ);
            if (!aVar.bIK) {
                this.bIE.setSingleLine();
            } else {
                aVar.bII |= 131072;
            }
            this.bIE.setInputType(aVar.bII);
            if (!TextUtils.isEmpty(aVar.bIL)) {
                this.bIE.setKeyListener(DigitsKeyListener.getInstance(aVar.bIL));
            }
            this.bIG = aVar.bIG;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bIE != null) {
            return this.bIE.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bIE != null) {
            this.bIE.setText(charSequence);
        }
    }

    public boolean Zb() {
        return this.bIH;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bIE != null && textWatcher != null) {
            this.bIE.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bIG;
        private boolean bIH = false;
        private int bII = 1;
        private String bIJ;
        private boolean bIK;
        private String bIL;
        private String mDesc;
        private String mErrorMessage;

        public a dB(boolean z) {
            this.bIH = z;
            return this;
        }

        public a kS(String str) {
            this.mDesc = str;
            return this;
        }

        public a hX(int i) {
            this.bII = i;
            return this;
        }

        public a kT(String str) {
            this.bIJ = str;
            return this;
        }

        public a kU(String str) {
            this.bIG = str;
            return this;
        }

        public a kV(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dC(boolean z) {
            this.bIK = z;
            return this;
        }

        public a kW(String str) {
            this.bIL = str;
            return this;
        }
    }
}
