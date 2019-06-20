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
    private View cTa;
    private RadioGroup dcn;
    private ViewSwitcher dco;
    private InvoiceCompanyInfoView dcp;
    private InvoicePersonalInfoView dcq;
    private TextWatcher dcr;
    private RadioGroup.OnCheckedChangeListener dcs;
    private b dct;
    private LinearLayout dcv;
    private TextView dcw;
    private RadioButton dcx;
    private RadioButton dcy;
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
        this.dcn = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dco = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dcw = (TextView) findViewById(R.id.invoice_type_desc);
        this.dcx = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dcy = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cTa = findViewById(R.id.divider_line);
        this.dcv = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dcw.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dcx.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dcx.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dcy.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dcy.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cTa.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dcv.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dcs = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dco.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dco.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dct != null) {
                    InvoiceInfoEditView.this.dct.aEs();
                }
            }
        };
        this.dcn.setOnCheckedChangeListener(this.dcs);
        this.dcp = new InvoiceCompanyInfoView(context);
        this.dcq = new InvoicePersonalInfoView(context);
        this.dco.addView(this.dcp, 0);
        this.dco.addView(this.dcq, 1);
        this.dcr = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
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
        this.dcq.setTextChangedListener(this.dcr);
        this.dcp.setTextChangedListener(this.dcr);
        this.dcn.check(R.id.invoice_type_company);
    }

    public void onActivityDestroy() {
        if (this.dcq != null) {
            this.dcq.removeTextChangedListener(this.dcr);
        }
        if (this.dcp != null) {
            this.dcp.removeTextChangedListener(this.dcr);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dct = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEy() {
        if (this.dct != null) {
            if (aEu()) {
                this.dct.aEq();
            } else {
                this.dct.aEr();
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
                this.dcn.check(R.id.invoice_type_company);
                this.dcp.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dcn.check(R.id.invoice_type_personal);
                this.dcq.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aEv() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aEv();
    }

    private e getCurrentInvoiceView() {
        if (this.dco == null) {
            return null;
        }
        if (this.dco.getDisplayedChild() == 0) {
            return this.dcp;
        }
        if (this.dco.getDisplayedChild() == 1) {
            return this.dcq;
        }
        return null;
    }
}
