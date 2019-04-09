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
    private View cKN;
    private RadioGroup cTQ;
    private ViewSwitcher cTR;
    private InvoiceCompanyInfoView cTS;
    private InvoicePersonalInfoView cTT;
    private TextWatcher cTU;
    private RadioGroup.OnCheckedChangeListener cTV;
    private b cTW;
    private LinearLayout cTX;
    private TextView cTY;
    private RadioButton cTZ;
    private RadioButton cUa;
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
        this.cTQ = (RadioGroup) findViewById(d.g.invoice_type_group);
        this.cTR = (ViewSwitcher) findViewById(d.g.invoice_type_switcher);
        this.cTY = (TextView) findViewById(d.g.invoice_type_desc);
        this.cTZ = (RadioButton) findViewById(d.g.invoice_type_company);
        this.cUa = (RadioButton) findViewById(d.g.invoice_type_personal);
        this.cKN = findViewById(d.g.divider_line);
        this.cTX = (LinearLayout) findViewById(d.g.invoice_type_area);
        this.cTY.setTextColor(getResources().getColor(d.C0277d.invoice_type));
        this.cTZ.setTextColor(getResources().getColor(d.C0277d.invoice_type_company));
        this.cTZ.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cUa.setTextColor(getResources().getColor(d.C0277d.invoice_type_personal));
        this.cUa.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cKN.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
        this.cTX.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_edit_view_bg));
        this.cTV = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == d.g.invoice_type_company) {
                    InvoiceInfoEditView.this.cTR.setDisplayedChild(0);
                } else if (i == d.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.cTR.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cTW != null) {
                    InvoiceInfoEditView.this.cTW.azb();
                }
            }
        };
        this.cTQ.setOnCheckedChangeListener(this.cTV);
        this.cTS = new InvoiceCompanyInfoView(context);
        this.cTT = new InvoicePersonalInfoView(context);
        this.cTR.addView(this.cTS, 0);
        this.cTR.addView(this.cTT, 1);
        this.cTU = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.azh();
            }
        };
        this.cTT.setTextChangedListener(this.cTU);
        this.cTS.setTextChangedListener(this.cTU);
        this.cTQ.check(d.g.invoice_type_company);
    }

    public void setInputStatusListener(b bVar) {
        this.cTW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azh() {
        if (this.cTW != null) {
            if (azd()) {
                this.cTW.ayZ();
            } else {
                this.cTW.aza();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azd() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.azd();
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
                this.cTQ.check(d.g.invoice_type_company);
                this.cTS.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cTQ.check(d.g.invoice_type_personal);
                this.cTT.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aze() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aze();
    }

    private e getCurrentInvoiceView() {
        if (this.cTR == null) {
            return null;
        }
        if (this.cTR.getDisplayedChild() == 0) {
            return this.cTS;
        }
        if (this.cTR.getDisplayedChild() == 1) {
            return this.cTT;
        }
        return null;
    }
}
