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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private String bLq;
    private View ddZ;
    private boolean doA;
    private TextView dox;
    private EditText doy;
    private String doz;
    private Context mContext;
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
        inflate(context, R.layout.invoice_info_item_view, this);
        this.mRootView = (RelativeLayout) findViewById(R.id.item_root_view);
        this.mRootView.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dox = (TextView) findViewById(R.id.invoice_info_desc);
        this.doy = (EditText) findViewById(R.id.invoice_info_content);
        this.ddZ = findViewById(R.id.divider_line);
        this.dox.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.doy.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.doy.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.ddZ.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.doA = aVar.doA;
            this.dox.setText(aVar.mDesc);
            this.doy.setHint(aVar.doC);
            if (!aVar.doD) {
                this.doy.setSingleLine();
            } else {
                aVar.doB |= 131072;
            }
            this.doy.setInputType(aVar.doB);
            if (!TextUtils.isEmpty(aVar.doE)) {
                this.doy.setKeyListener(DigitsKeyListener.getInstance(aVar.doE));
            }
            this.doz = aVar.doz;
            this.bLq = aVar.bLq;
        }
        return this;
    }

    public String getContent() {
        if (this.doy != null) {
            return this.doy.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.doy != null) {
            this.doy.setText(charSequence);
        }
    }

    public boolean aGH() {
        return this.doA;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.doy != null && textWatcher != null) {
            this.doy.addTextChangedListener(textWatcher);
        }
    }

    public void e(TextWatcher textWatcher) {
        if (this.doy != null) {
            this.doy.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bLq;
        private boolean doA = false;
        private int doB = 1;
        private String doC;
        private boolean doD;
        private String doE;
        private String doz;
        private String mDesc;

        public a gm(boolean z) {
            this.doA = z;
            return this;
        }

        public a sk(String str) {
            this.mDesc = str;
            return this;
        }

        public a lQ(int i) {
            this.doB = i;
            return this;
        }

        public a sl(String str) {
            this.doC = str;
            return this;
        }

        public a sm(String str) {
            this.doz = str;
            return this;
        }

        public a sn(String str) {
            this.bLq = str;
            return this;
        }

        public a gn(boolean z) {
            this.doD = z;
            return this;
        }

        public a so(String str) {
            this.doE = str;
            return this;
        }
    }
}
