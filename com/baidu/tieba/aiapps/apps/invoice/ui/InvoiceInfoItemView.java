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
    private View cTa;
    private TextView dcA;
    private EditText dcB;
    private String dcC;
    private boolean dcD;
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
        this.dcA = (TextView) findViewById(R.id.invoice_info_desc);
        this.dcB = (EditText) findViewById(R.id.invoice_info_content);
        this.cTa = findViewById(R.id.divider_line);
        this.dcA.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dcB.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dcB.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cTa.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dcD = aVar.dcD;
            this.dcA.setText(aVar.aYJ);
            this.dcB.setHint(aVar.dcF);
            if (!aVar.dcG) {
                this.dcB.setSingleLine();
            } else {
                aVar.dcE |= 131072;
            }
            this.dcB.setInputType(aVar.dcE);
            if (!TextUtils.isEmpty(aVar.dcH)) {
                this.dcB.setKeyListener(DigitsKeyListener.getInstance(aVar.dcH));
            }
            this.dcC = aVar.dcC;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.dcB != null) {
            return this.dcB.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dcB != null) {
            this.dcB.setText(charSequence);
        }
    }

    public boolean aEz() {
        return this.dcD;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dcB != null && textWatcher != null) {
            this.dcB.addTextChangedListener(textWatcher);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.dcB != null) {
            this.dcB.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aYJ;
        private String dcC;
        private boolean dcD = false;
        private int dcE = 1;
        private String dcF;
        private boolean dcG;
        private String dcH;
        private String mErrorMessage;

        public a gq(boolean z) {
            this.dcD = z;
            return this;
        }

        public a sJ(String str) {
            this.aYJ = str;
            return this;
        }

        public a mA(int i) {
            this.dcE = i;
            return this;
        }

        public a sK(String str) {
            this.dcF = str;
            return this;
        }

        public a sL(String str) {
            this.dcC = str;
            return this;
        }

        public a sM(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a gr(boolean z) {
            this.dcG = z;
            return this;
        }

        public a sN(String str) {
            this.dcH = str;
            return this;
        }
    }
}
