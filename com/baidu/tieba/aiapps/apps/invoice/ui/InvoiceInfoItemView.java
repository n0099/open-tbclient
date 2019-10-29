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
    private String bMh;
    private View deR;
    private TextView dpo;
    private EditText dpp;
    private String dpq;
    private boolean dpr;
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
        this.dpo = (TextView) findViewById(R.id.invoice_info_desc);
        this.dpp = (EditText) findViewById(R.id.invoice_info_content);
        this.deR = findViewById(R.id.divider_line);
        this.dpo.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dpp.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dpp.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.deR.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dpr = aVar.dpr;
            this.dpo.setText(aVar.mDesc);
            this.dpp.setHint(aVar.dpt);
            if (!aVar.dpu) {
                this.dpp.setSingleLine();
            } else {
                aVar.dps |= 131072;
            }
            this.dpp.setInputType(aVar.dps);
            if (!TextUtils.isEmpty(aVar.dpv)) {
                this.dpp.setKeyListener(DigitsKeyListener.getInstance(aVar.dpv));
            }
            this.dpq = aVar.dpq;
            this.bMh = aVar.bMh;
        }
        return this;
    }

    public String getContent() {
        if (this.dpp != null) {
            return this.dpp.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dpp != null) {
            this.dpp.setText(charSequence);
        }
    }

    public boolean aGJ() {
        return this.dpr;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dpp != null && textWatcher != null) {
            this.dpp.addTextChangedListener(textWatcher);
        }
    }

    public void e(TextWatcher textWatcher) {
        if (this.dpp != null) {
            this.dpp.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String bMh;
        private String dpq;
        private boolean dpr = false;
        private int dps = 1;
        private String dpt;
        private boolean dpu;
        private String dpv;
        private String mDesc;

        public a gm(boolean z) {
            this.dpr = z;
            return this;
        }

        public a sk(String str) {
            this.mDesc = str;
            return this;
        }

        public a lR(int i) {
            this.dps = i;
            return this;
        }

        public a sl(String str) {
            this.dpt = str;
            return this;
        }

        public a sm(String str) {
            this.dpq = str;
            return this;
        }

        public a sn(String str) {
            this.bMh = str;
            return this;
        }

        public a gn(boolean z) {
            this.dpu = z;
            return this;
        }

        public a so(String str) {
            this.dpv = str;
            return this;
        }
    }
}
