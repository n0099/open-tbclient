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
    private View cSY;
    private String dcA;
    private boolean dcB;
    private TextView dcy;
    private EditText dcz;
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
        this.dcy = (TextView) findViewById(R.id.invoice_info_desc);
        this.dcz = (EditText) findViewById(R.id.invoice_info_content);
        this.cSY = findViewById(R.id.divider_line);
        this.dcy.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dcz.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dcz.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cSY.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dcB = aVar.dcB;
            this.dcy.setText(aVar.aYJ);
            this.dcz.setHint(aVar.dcD);
            if (!aVar.dcE) {
                this.dcz.setSingleLine();
            } else {
                aVar.dcC |= 131072;
            }
            this.dcz.setInputType(aVar.dcC);
            if (!TextUtils.isEmpty(aVar.dcF)) {
                this.dcz.setKeyListener(DigitsKeyListener.getInstance(aVar.dcF));
            }
            this.dcA = aVar.dcA;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.dcz != null) {
            return this.dcz.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dcz != null) {
            this.dcz.setText(charSequence);
        }
    }

    public boolean aEw() {
        return this.dcB;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dcz != null && textWatcher != null) {
            this.dcz.addTextChangedListener(textWatcher);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.dcz != null) {
            this.dcz.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aYJ;
        private String dcA;
        private boolean dcB = false;
        private int dcC = 1;
        private String dcD;
        private boolean dcE;
        private String dcF;
        private String mErrorMessage;

        public a gq(boolean z) {
            this.dcB = z;
            return this;
        }

        public a sK(String str) {
            this.aYJ = str;
            return this;
        }

        public a mA(int i) {
            this.dcC = i;
            return this;
        }

        public a sL(String str) {
            this.dcD = str;
            return this;
        }

        public a sM(String str) {
            this.dcA = str;
            return this;
        }

        public a sN(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a gr(boolean z) {
            this.dcE = z;
            return this;
        }

        public a sO(String str) {
            this.dcF = str;
            return this;
        }
    }
}
