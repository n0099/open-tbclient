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
    private TextView bHN;
    private EditText bHO;
    private View bHP;
    private String bHQ;
    private boolean bHR;
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
        this.bHN = (TextView) findViewById(e.g.invoice_info_desc);
        this.bHO = (EditText) findViewById(e.g.invoice_info_content);
        this.bHP = findViewById(e.g.divider_line);
        this.bHN.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bHO.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bHO.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bHP.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bHR = aVar.bHR;
            this.bHN.setText(aVar.mDesc);
            this.bHO.setHint(aVar.bHT);
            if (!aVar.bHU) {
                this.bHO.setSingleLine();
            } else {
                aVar.bHS |= 131072;
            }
            this.bHO.setInputType(aVar.bHS);
            if (!TextUtils.isEmpty(aVar.bHV)) {
                this.bHO.setKeyListener(DigitsKeyListener.getInstance(aVar.bHV));
            }
            this.bHQ = aVar.bHQ;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bHO != null) {
            return this.bHO.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bHO != null) {
            this.bHO.setText(charSequence);
        }
    }

    public boolean YC() {
        return this.bHR;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bHO != null && textWatcher != null) {
            this.bHO.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bHQ;
        private boolean bHR = false;
        private int bHS = 1;
        private String bHT;
        private boolean bHU;
        private String bHV;
        private String mDesc;
        private String mErrorMessage;

        public a dy(boolean z) {
            this.bHR = z;
            return this;
        }

        public a kB(String str) {
            this.mDesc = str;
            return this;
        }

        public a hW(int i) {
            this.bHS = i;
            return this;
        }

        public a kC(String str) {
            this.bHT = str;
            return this;
        }

        public a kD(String str) {
            this.bHQ = str;
            return this;
        }

        public a kE(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dz(boolean z) {
            this.bHU = z;
            return this;
        }

        public a kF(String str) {
            this.bHV = str;
            return this;
        }
    }
}
