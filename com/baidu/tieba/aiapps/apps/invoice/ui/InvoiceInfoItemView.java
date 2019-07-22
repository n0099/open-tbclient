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
    private View cUw;
    private TextView dea;
    private EditText deb;
    private String dec;
    private boolean ded;
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
        this.dea = (TextView) findViewById(R.id.invoice_info_desc);
        this.deb = (EditText) findViewById(R.id.invoice_info_content);
        this.cUw = findViewById(R.id.divider_line);
        this.dea.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.deb.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.deb.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cUw.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.ded = aVar.ded;
            this.dea.setText(aVar.aZt);
            this.deb.setHint(aVar.def);
            if (!aVar.deg) {
                this.deb.setSingleLine();
            } else {
                aVar.dee |= 131072;
            }
            this.deb.setInputType(aVar.dee);
            if (!TextUtils.isEmpty(aVar.deh)) {
                this.deb.setKeyListener(DigitsKeyListener.getInstance(aVar.deh));
            }
            this.dec = aVar.dec;
            this.bsY = aVar.bsY;
        }
        return this;
    }

    public String getContent() {
        if (this.deb != null) {
            return this.deb.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.deb != null) {
            this.deb.setText(charSequence);
        }
    }

    public boolean aFQ() {
        return this.ded;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.deb != null && textWatcher != null) {
            this.deb.addTextChangedListener(textWatcher);
        }
    }

    public void e(TextWatcher textWatcher) {
        if (this.deb != null) {
            this.deb.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aZt;
        private String bsY;
        private String dec;
        private boolean ded = false;
        private int dee = 1;
        private String def;
        private boolean deg;
        private String deh;

        public a gu(boolean z) {
            this.ded = z;
            return this;
        }

        public a tc(String str) {
            this.aZt = str;
            return this;
        }

        public a mH(int i) {
            this.dee = i;
            return this;
        }

        public a td(String str) {
            this.def = str;
            return this;
        }

        public a te(String str) {
            this.dec = str;
            return this;
        }

        public a tf(String str) {
            this.bsY = str;
            return this;
        }

        public a gv(boolean z) {
            this.deg = z;
            return this;
        }

        public a tg(String str) {
            this.deh = str;
            return this;
        }
    }
}
