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
    private String btw;
    private View cVw;
    private TextView dfT;
    private EditText dfU;
    private String dfV;
    private boolean dfW;
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
        this.dfT = (TextView) findViewById(R.id.invoice_info_desc);
        this.dfU = (EditText) findViewById(R.id.invoice_info_content);
        this.cVw = findViewById(R.id.divider_line);
        this.dfT.setTextColor(getResources().getColor(R.color.invoice_info_desc));
        this.dfU.setTextColor(getResources().getColor(R.color.invoice_info_content));
        this.dfU.setHintTextColor(getResources().getColor(R.color.invoice_info_content_hint));
        this.cVw.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.dfW = aVar.dfW;
            this.dfT.setText(aVar.aZR);
            this.dfU.setHint(aVar.dfY);
            if (!aVar.dfZ) {
                this.dfU.setSingleLine();
            } else {
                aVar.dfX |= 131072;
            }
            this.dfU.setInputType(aVar.dfX);
            if (!TextUtils.isEmpty(aVar.dga)) {
                this.dfU.setKeyListener(DigitsKeyListener.getInstance(aVar.dga));
            }
            this.dfV = aVar.dfV;
            this.btw = aVar.btw;
        }
        return this;
    }

    public String getContent() {
        if (this.dfU != null) {
            return this.dfU.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.dfU != null) {
            this.dfU.setText(charSequence);
        }
    }

    public boolean aGw() {
        return this.dfW;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.dfU != null && textWatcher != null) {
            this.dfU.addTextChangedListener(textWatcher);
        }
    }

    public void e(TextWatcher textWatcher) {
        if (this.dfU != null) {
            this.dfU.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private String aZR;
        private String btw;
        private String dfV;
        private boolean dfW = false;
        private int dfX = 1;
        private String dfY;
        private boolean dfZ;
        private String dga;

        public a gx(boolean z) {
            this.dfW = z;
            return this;
        }

        public a tB(String str) {
            this.aZR = str;
            return this;
        }

        public a mM(int i) {
            this.dfX = i;
            return this;
        }

        public a tC(String str) {
            this.dfY = str;
            return this;
        }

        public a tD(String str) {
            this.dfV = str;
            return this;
        }

        public a tE(String str) {
            this.btw = str;
            return this;
        }

        public a gy(boolean z) {
            this.dfZ = z;
            return this;
        }

        public a tF(String str) {
            this.dga = str;
            return this;
        }
    }
}
