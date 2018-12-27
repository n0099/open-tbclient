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
    private TextView bHQ;
    private EditText bHR;
    private View bHS;
    private String bHT;
    private boolean bHU;
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
        this.bHQ = (TextView) findViewById(e.g.invoice_info_desc);
        this.bHR = (EditText) findViewById(e.g.invoice_info_content);
        this.bHS = findViewById(e.g.divider_line);
        this.bHQ.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bHR.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bHR.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bHS.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bHU = aVar.bHU;
            this.bHQ.setText(aVar.mDesc);
            this.bHR.setHint(aVar.bHW);
            if (!aVar.bHX) {
                this.bHR.setSingleLine();
            } else {
                aVar.bHV |= 131072;
            }
            this.bHR.setInputType(aVar.bHV);
            if (!TextUtils.isEmpty(aVar.bHY)) {
                this.bHR.setKeyListener(DigitsKeyListener.getInstance(aVar.bHY));
            }
            this.bHT = aVar.bHT;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bHR != null) {
            return this.bHR.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bHR != null) {
            this.bHR.setText(charSequence);
        }
    }

    public boolean YE() {
        return this.bHU;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bHR != null && textWatcher != null) {
            this.bHR.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bHT;
        private boolean bHU = false;
        private int bHV = 1;
        private String bHW;
        private boolean bHX;
        private String bHY;
        private String mDesc;
        private String mErrorMessage;

        public a dy(boolean z) {
            this.bHU = z;
            return this;
        }

        public a kC(String str) {
            this.mDesc = str;
            return this;
        }

        public a hX(int i) {
            this.bHV = i;
            return this;
        }

        public a kD(String str) {
            this.bHW = str;
            return this;
        }

        public a kE(String str) {
            this.bHT = str;
            return this;
        }

        public a kF(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dz(boolean z) {
            this.bHX = z;
            return this;
        }

        public a kG(String str) {
            this.bHY = str;
            return this;
        }
    }
}
