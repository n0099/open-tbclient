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
    private View bDA;
    private String bDB;
    private boolean bDC;
    private TextView bDy;
    private EditText bDz;
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
        this.bDy = (TextView) findViewById(e.g.invoice_info_desc);
        this.bDz = (EditText) findViewById(e.g.invoice_info_content);
        this.bDA = findViewById(e.g.divider_line);
        this.bDy.setTextColor(getResources().getColor(e.d.invoice_info_desc));
        this.bDz.setTextColor(getResources().getColor(e.d.invoice_info_content));
        this.bDz.setHintTextColor(getResources().getColor(e.d.invoice_info_content_hint));
        this.bDA.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bDC = aVar.bDC;
            this.bDy.setText(aVar.mDesc);
            this.bDz.setHint(aVar.bDE);
            if (!aVar.bDF) {
                this.bDz.setSingleLine();
            } else {
                aVar.bDD |= 131072;
            }
            this.bDz.setInputType(aVar.bDD);
            if (!TextUtils.isEmpty(aVar.bDG)) {
                this.bDz.setKeyListener(DigitsKeyListener.getInstance(aVar.bDG));
            }
            this.bDB = aVar.bDB;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bDz != null) {
            return this.bDz.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bDz != null) {
            this.bDz.setText(charSequence);
        }
    }

    public boolean Xp() {
        return this.bDC;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bDz != null && textWatcher != null) {
            this.bDz.addTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bDB;
        private boolean bDC = false;
        private int bDD = 1;
        private String bDE;
        private boolean bDF;
        private String bDG;
        private String mDesc;
        private String mErrorMessage;

        public a dg(boolean z) {
            this.bDC = z;
            return this;
        }

        public a kf(String str) {
            this.mDesc = str;
            return this;
        }

        public a hv(int i) {
            this.bDD = i;
            return this;
        }

        public a kg(String str) {
            this.bDE = str;
            return this;
        }

        public a kh(String str) {
            this.bDB = str;
            return this;
        }

        public a ki(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a dh(boolean z) {
            this.bDF = z;
            return this;
        }

        public a kj(String str) {
            this.bDG = str;
            return this;
        }
    }
}
