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
    private String bsY;
    private View cUD;
    private TextView deh;
    private EditText dei;
    private String dej;
    private boolean dek;
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
        this.deh = (TextView) findViewById(R.id.invoice_info_desc);
        this.dei = (EditText) findViewById(R.id.invoice_info_content);
        this.cUD = findViewById(R.id.divider_line);
        this.deh.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dei.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dei.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cUD.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dek = aVar.dek;
            this.deh.setText(aVar.aZt);
            this.dei.setHint(aVar.dem);
            if (!aVar.den) {
                this.dei.setSingleLine();
            } else {
                aVar.del |= 131072;
            }
            this.dei.setInputType(aVar.del);
            if (!TextUtils.isEmpty(aVar.deo)) {
                this.dei.setKeyListener(DigitsKeyListener.getInstance(aVar.deo));
            }
            this.dej = aVar.dej;
            this.bsY = aVar.bsY;
        }
        return this;
    }

    public String getContent() {
        if (this.dei != null) {
            return this.dei.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dei != null) {
            this.dei.setText(charSequence);
        }
    }

    public boolean aFS() {
        return this.dek;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dei != null && textWatcher != null) {
            this.dei.addTextChangedListener(textWatcher);
        }
    }

    public void e(TextWatcher textWatcher) {
        if (this.dei != null) {
            this.dei.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aZt;
        private String bsY;
        private String dej;
        private boolean dek = false;
        private int del = 1;
        private String dem;
        private boolean den;
        private String deo;

        public a gu(boolean z) {
            this.dek = z;
            return this;
        }

        public a tc(String str) {
            this.aZt = str;
            return this;
        }

        public a mI(int i) {
            this.del = i;
            return this;
        }

        public a td(String str) {
            this.dem = str;
            return this;
        }

        public a te(String str) {
            this.dej = str;
            return this;
        }

        public a tf(String str) {
            this.bsY = str;
            return this;
        }

        public a gv(boolean z) {
            this.den = z;
            return this;
        }

        public a tg(String str) {
            this.deo = str;
            return this;
        }
    }
}
