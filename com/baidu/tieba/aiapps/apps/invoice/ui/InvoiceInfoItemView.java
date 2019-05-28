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
    private View cSZ;
    private EditText dcA;
    private String dcB;
    private boolean dcC;
    private TextView dcz;
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
        inflate(context, R.layout.invoice_info_item_view, this);
        this.mRootView = (RelativeLayout) findViewById(R.id.item_root_view);
        this.mRootView.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dcz = (TextView) findViewById(R.id.invoice_info_desc);
        this.dcA = (EditText) findViewById(R.id.invoice_info_content);
        this.cSZ = findViewById(R.id.divider_line);
        this.dcz.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dcA.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dcA.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cSZ.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dcC = aVar.dcC;
            this.dcz.setText(aVar.aYJ);
            this.dcA.setHint(aVar.dcE);
            if (!aVar.dcF) {
                this.dcA.setSingleLine();
            } else {
                aVar.dcD |= 131072;
            }
            this.dcA.setInputType(aVar.dcD);
            if (!TextUtils.isEmpty(aVar.dcG)) {
                this.dcA.setKeyListener(DigitsKeyListener.getInstance(aVar.dcG));
            }
            this.dcB = aVar.dcB;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.dcA != null) {
            return this.dcA.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dcA != null) {
            this.dcA.setText(charSequence);
        }
    }

    public boolean aEz() {
        return this.dcC;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dcA != null && textWatcher != null) {
            this.dcA.addTextChangedListener(textWatcher);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.dcA != null) {
            this.dcA.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aYJ;
        private String dcB;
        private boolean dcC = false;
        private int dcD = 1;
        private String dcE;
        private boolean dcF;
        private String dcG;
        private String mErrorMessage;

        public a gq(boolean z) {
            this.dcC = z;
            return this;
        }

        public a sK(String str) {
            this.aYJ = str;
            return this;
        }

        public a mA(int i) {
            this.dcD = i;
            return this;
        }

        public a sL(String str) {
            this.dcE = str;
            return this;
        }

        public a sM(String str) {
            this.dcB = str;
            return this;
        }

        public a sN(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a gr(boolean z) {
            this.dcF = z;
            return this;
        }

        public a sO(String str) {
            this.dcG = str;
            return this;
        }
    }
}
