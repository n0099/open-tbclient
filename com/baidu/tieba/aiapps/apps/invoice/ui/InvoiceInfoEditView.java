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
    private View cSY;
    private RadioGroup dcl;
    private ViewSwitcher dcm;
    private InvoiceCompanyInfoView dcn;
    private InvoicePersonalInfoView dco;
    private TextWatcher dcp;
    private RadioGroup.OnCheckedChangeListener dcq;
    private b dcr;
    private LinearLayout dcs;
    private TextView dct;
    private RadioButton dcv;
    private RadioButton dcw;
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
        this.dcl = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dcm = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dct = (TextView) findViewById(R.id.invoice_type_desc);
        this.dcv = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dcw = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cSY = findViewById(R.id.divider_line);
        this.dcs = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dct.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dcv.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dcv.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dcw.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dcw.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cSY.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dcs.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dcq = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dcm.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dcm.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dcr != null) {
                    InvoiceInfoEditView.this.dcr.aEp();
                }
            }
        };
        this.dcl.setOnCheckedChangeListener(this.dcq);
        this.dcn = new InvoiceCompanyInfoView(context);
        this.dco = new InvoicePersonalInfoView(context);
        this.dcm.addView(this.dcn, 0);
        this.dcm.addView(this.dco, 1);
        this.dcp = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aEv();
            }
        };
        this.dco.setTextChangedListener(this.dcp);
        this.dcn.setTextChangedListener(this.dcp);
        this.dcl.check(R.id.invoice_type_company);
    }

    public void onActivityDestroy() {
        if (this.dco != null) {
            this.dco.removeTextChangedListener(this.dcp);
        }
        if (this.dcn != null) {
            this.dcn.removeTextChangedListener(this.dcp);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dcr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEv() {
        if (this.dcr != null) {
            if (aEr()) {
                this.dcr.aEn();
            } else {
                this.dcr.aEo();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEr() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aEr();
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
                this.dcl.check(R.id.invoice_type_company);
                this.dcn.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dcl.check(R.id.invoice_type_personal);
                this.dco.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEs() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aEs();
    }

    private e getCurrentInvoiceView() {
        if (this.dcm == null) {
            return null;
        }
        if (this.dcm.getDisplayedChild() == 0) {
            return this.dcn;
        }
        if (this.dcm.getDisplayedChild() == 1) {
            return this.dco;
        }
        return null;
    }
}
