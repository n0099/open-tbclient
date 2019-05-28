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
    private View cSZ;
    private RadioGroup dcm;
    private ViewSwitcher dcn;
    private InvoiceCompanyInfoView dco;
    private InvoicePersonalInfoView dcp;
    private TextWatcher dcq;
    private RadioGroup.OnCheckedChangeListener dcr;
    private b dcs;
    private LinearLayout dct;
    private TextView dcv;
    private RadioButton dcw;
    private RadioButton dcx;
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
        this.dcm = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dcn = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dcv = (TextView) findViewById(R.id.invoice_type_desc);
        this.dcw = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dcx = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cSZ = findViewById(R.id.divider_line);
        this.dct = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dcv.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dcw.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dcw.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dcx.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dcx.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cSZ.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dct.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dcr = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dcn.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dcn.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dcs != null) {
                    InvoiceInfoEditView.this.dcs.aEs();
                }
            }
        };
        this.dcm.setOnCheckedChangeListener(this.dcr);
        this.dco = new InvoiceCompanyInfoView(context);
        this.dcp = new InvoicePersonalInfoView(context);
        this.dcn.addView(this.dco, 0);
        this.dcn.addView(this.dcp, 1);
        this.dcq = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aEy();
            }
        };
        this.dcp.setTextChangedListener(this.dcq);
        this.dco.setTextChangedListener(this.dcq);
        this.dcm.check(R.id.invoice_type_company);
    }

    public void onActivityDestroy() {
        if (this.dcp != null) {
            this.dcp.removeTextChangedListener(this.dcq);
        }
        if (this.dco != null) {
            this.dco.removeTextChangedListener(this.dcq);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dcs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEy() {
        if (this.dcs != null) {
            if (aEu()) {
                this.dcs.aEq();
            } else {
                this.dcs.aEr();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEu() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aEu();
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
                this.dcm.check(R.id.invoice_type_company);
                this.dco.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dcm.check(R.id.invoice_type_personal);
                this.dcp.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEv() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aEv();
    }

    private e getCurrentInvoiceView() {
        if (this.dcn == null) {
            return null;
        }
        if (this.dcn.getDisplayedChild() == 0) {
            return this.dco;
        }
        if (this.dcn.getDisplayedChild() == 1) {
            return this.dcp;
        }
        return null;
    }
}
