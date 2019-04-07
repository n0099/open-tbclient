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
    private View cKM;
    private RadioGroup cTP;
    private ViewSwitcher cTQ;
    private InvoiceCompanyInfoView cTR;
    private InvoicePersonalInfoView cTS;
    private TextWatcher cTT;
    private RadioGroup.OnCheckedChangeListener cTU;
    private b cTV;
    private LinearLayout cTW;
    private TextView cTX;
    private RadioButton cTY;
    private RadioButton cTZ;
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
        this.cTP = (RadioGroup) findViewById(d.g.invoice_type_group);
        this.cTQ = (ViewSwitcher) findViewById(d.g.invoice_type_switcher);
        this.cTX = (TextView) findViewById(d.g.invoice_type_desc);
        this.cTY = (RadioButton) findViewById(d.g.invoice_type_company);
        this.cTZ = (RadioButton) findViewById(d.g.invoice_type_personal);
        this.cKM = findViewById(d.g.divider_line);
        this.cTW = (LinearLayout) findViewById(d.g.invoice_type_area);
        this.cTX.setTextColor(getResources().getColor(d.C0277d.invoice_type));
        this.cTY.setTextColor(getResources().getColor(d.C0277d.invoice_type_company));
        this.cTY.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cTZ.setTextColor(getResources().getColor(d.C0277d.invoice_type_personal));
        this.cTZ.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cKM.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_info_item_divider_line));
        this.cTW.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_edit_view_bg));
        this.cTU = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == d.g.invoice_type_company) {
                    InvoiceInfoEditView.this.cTQ.setDisplayedChild(0);
                } else if (i == d.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.cTQ.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cTV != null) {
                    InvoiceInfoEditView.this.cTV.azb();
                }
            }
        };
        this.cTP.setOnCheckedChangeListener(this.cTU);
        this.cTR = new InvoiceCompanyInfoView(context);
        this.cTS = new InvoicePersonalInfoView(context);
        this.cTQ.addView(this.cTR, 0);
        this.cTQ.addView(this.cTS, 1);
        this.cTT = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
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
        this.cTS.setTextChangedListener(this.cTT);
        this.cTR.setTextChangedListener(this.cTT);
        this.cTP.check(d.g.invoice_type_company);
    }

    public void setInputStatusListener(b bVar) {
        this.cTV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azh() {
        if (this.cTV != null) {
            if (azd()) {
                this.cTV.ayZ();
            } else {
                this.cTV.aza();
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
                this.cTP.check(d.g.invoice_type_company);
                this.cTR.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cTP.check(d.g.invoice_type_personal);
                this.cTS.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aze() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aze();
    }

    private e getCurrentInvoiceView() {
        if (this.cTQ == null) {
            return null;
        }
        if (this.cTQ.getDisplayedChild() == 0) {
            return this.cTR;
        }
        if (this.cTQ.getDisplayedChild() == 1) {
            return this.cTS;
        }
        return null;
    }
}
