package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.e;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
/* loaded from: classes4.dex */
public class InvoiceInfoEditView extends FrameLayout implements e {
    private View cUw;
    private RadioGroup ddO;
    private ViewSwitcher ddP;
    private InvoiceCompanyInfoView ddQ;
    private InvoicePersonalInfoView ddR;
    private TextWatcher ddS;
    private RadioGroup.OnCheckedChangeListener ddT;
    private b ddU;
    private LinearLayout ddV;
    private TextView ddW;
    private RadioButton ddX;
    private RadioButton ddY;
    private Context mContext;

    public InvoiceInfoEditView(@NonNull Context context) {
        this(context, null);
    }

    public InvoiceInfoEditView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceInfoEditView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        inflate(context, R.layout.invoice_info_edit_view, this);
        this.ddO = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.ddP = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.ddW = (TextView) findViewById(R.id.invoice_type_desc);
        this.ddX = (RadioButton) findViewById(R.id.invoice_type_company);
        this.ddY = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cUw = findViewById(R.id.divider_line);
        this.ddV = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.ddW.setTextColor(getResources().getColor(R.color.invoice_type));
        this.ddX.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.ddX.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.ddY.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.ddY.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cUw.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.ddV.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.ddT = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.ddP.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.ddP.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.ddU != null) {
                    InvoiceInfoEditView.this.ddU.aFI();
                }
            }
        };
        this.ddO.setOnCheckedChangeListener(this.ddT);
        this.ddQ = new InvoiceCompanyInfoView(context);
        this.ddR = new InvoicePersonalInfoView(context);
        this.ddP.addView(this.ddQ, 0);
        this.ddP.addView(this.ddR, 1);
        this.ddS = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aFP();
            }
        };
        this.ddR.setTextChangedListener(this.ddS);
        this.ddQ.setTextChangedListener(this.ddS);
        this.ddO.check(R.id.invoice_type_company);
    }

    public void aFO() {
        if (this.ddR != null) {
            this.ddR.e(this.ddS);
        }
        if (this.ddQ != null) {
            this.ddQ.e(this.ddS);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.ddU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFP() {
        if (this.ddU != null) {
            if (aFK()) {
                this.ddU.aFG();
            } else {
                this.ddU.aFH();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFK() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aFK();
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        e currentInvoiceView = getCurrentInvoiceView();
        if (currentInvoiceView != null) {
            return currentInvoiceView.getInvoiceInfo();
        }
        return null;
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            if (invoiceInfo.mType == 0) {
                this.ddO.check(R.id.invoice_type_company);
                this.ddQ.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.ddO.check(R.id.invoice_type_personal);
                this.ddR.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFL() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aFL();
    }

    private e getCurrentInvoiceView() {
        if (this.ddP == null) {
            return null;
        }
        if (this.ddP.getDisplayedChild() == 0) {
            return this.ddQ;
        }
        if (this.ddP.getDisplayedChild() == 1) {
            return this.ddR;
        }
        return null;
    }
}
