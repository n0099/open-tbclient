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
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.e;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceInfoEditView extends FrameLayout implements e {
    private View cKK;
    private RadioGroup cTN;
    private ViewSwitcher cTO;
    private InvoiceCompanyInfoView cTP;
    private InvoicePersonalInfoView cTQ;
    private TextWatcher cTR;
    private RadioGroup.OnCheckedChangeListener cTS;
    private b cTT;
    private LinearLayout cTU;
    private TextView cTV;
    private RadioButton cTW;
    private RadioButton cTX;
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
        inflate(context, d.h.invoice_info_edit_view, this);
        this.cTN = (RadioGroup) findViewById(d.g.invoice_type_group);
        this.cTO = (ViewSwitcher) findViewById(d.g.invoice_type_switcher);
        this.cTV = (TextView) findViewById(d.g.invoice_type_desc);
        this.cTW = (RadioButton) findViewById(d.g.invoice_type_company);
        this.cTX = (RadioButton) findViewById(d.g.invoice_type_personal);
        this.cKK = findViewById(d.g.divider_line);
        this.cTU = (LinearLayout) findViewById(d.g.invoice_type_area);
        this.cTV.setTextColor(getResources().getColor(d.C0277d.invoice_type));
        this.cTW.setTextColor(getResources().getColor(d.C0277d.invoice_type_company));
        this.cTW.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cTX.setTextColor(getResources().getColor(d.C0277d.invoice_type_personal));
        this.cTX.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cKK.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
        this.cTU.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_edit_view_bg));
        this.cTS = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == d.g.invoice_type_company) {
                    InvoiceInfoEditView.this.cTO.setDisplayedChild(0);
                } else if (i == d.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.cTO.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cTT != null) {
                    InvoiceInfoEditView.this.cTT.aze();
                }
            }
        };
        this.cTN.setOnCheckedChangeListener(this.cTS);
        this.cTP = new InvoiceCompanyInfoView(context);
        this.cTQ = new InvoicePersonalInfoView(context);
        this.cTO.addView(this.cTP, 0);
        this.cTO.addView(this.cTQ, 1);
        this.cTR = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.azk();
            }
        };
        this.cTQ.setTextChangedListener(this.cTR);
        this.cTP.setTextChangedListener(this.cTR);
        this.cTN.check(d.g.invoice_type_company);
    }

    public void setInputStatusListener(b bVar) {
        this.cTT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        if (this.cTT != null) {
            if (azg()) {
                this.cTT.azc();
            } else {
                this.cTT.azd();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azg() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.azg();
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
                this.cTN.check(d.g.invoice_type_company);
                this.cTP.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cTN.check(d.g.invoice_type_personal);
                this.cTQ.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azh() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.azh();
    }

    private e getCurrentInvoiceView() {
        if (this.cTO == null) {
            return null;
        }
        if (this.cTO.getDisplayedChild() == 0) {
            return this.cTP;
        }
        if (this.cTO.getDisplayedChild() == 1) {
            return this.cTQ;
        }
        return null;
    }
}
