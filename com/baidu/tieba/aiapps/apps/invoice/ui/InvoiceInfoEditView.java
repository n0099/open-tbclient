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
    private RadioGroup cTR;
    private ViewSwitcher cTS;
    private InvoiceCompanyInfoView cTT;
    private InvoicePersonalInfoView cTU;
    private TextWatcher cTV;
    private RadioGroup.OnCheckedChangeListener cTW;
    private b cTX;
    private LinearLayout cTY;
    private TextView cTZ;
    private RadioButton cUa;
    private RadioButton cUb;
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
        this.cTR = (RadioGroup) findViewById(d.g.invoice_type_group);
        this.cTS = (ViewSwitcher) findViewById(d.g.invoice_type_switcher);
        this.cTZ = (TextView) findViewById(d.g.invoice_type_desc);
        this.cUa = (RadioButton) findViewById(d.g.invoice_type_company);
        this.cUb = (RadioButton) findViewById(d.g.invoice_type_personal);
        this.cKN = findViewById(d.g.divider_line);
        this.cTY = (LinearLayout) findViewById(d.g.invoice_type_area);
        this.cTZ.setTextColor(getResources().getColor(d.C0236d.invoice_type));
        this.cUa.setTextColor(getResources().getColor(d.C0236d.invoice_type_company));
        this.cUa.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cUb.setTextColor(getResources().getColor(d.C0236d.invoice_type_personal));
        this.cUb.setButtonDrawable(getResources().getDrawable(d.f.radio_button_selector));
        this.cKN.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_info_item_divider_line));
        this.cTY.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_edit_view_bg));
        this.cTW = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == d.g.invoice_type_company) {
                    InvoiceInfoEditView.this.cTS.setDisplayedChild(0);
                } else if (i == d.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.cTS.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cTX != null) {
                    InvoiceInfoEditView.this.cTX.azf();
                }
            }
        };
        this.cTR.setOnCheckedChangeListener(this.cTW);
        this.cTT = new InvoiceCompanyInfoView(context);
        this.cTU = new InvoicePersonalInfoView(context);
        this.cTS.addView(this.cTT, 0);
        this.cTS.addView(this.cTU, 1);
        this.cTV = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.azl();
            }
        };
        this.cTU.setTextChangedListener(this.cTV);
        this.cTT.setTextChangedListener(this.cTV);
        this.cTR.check(d.g.invoice_type_company);
    }

    public void setInputStatusListener(b bVar) {
        this.cTX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azl() {
        if (this.cTX != null) {
            if (azh()) {
                this.cTX.azd();
            } else {
                this.cTX.aze();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azh() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.azh();
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
                this.cTR.check(d.g.invoice_type_company);
                this.cTT.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cTR.check(d.g.invoice_type_personal);
                this.cTU.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean azi() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.azi();
    }

    private e getCurrentInvoiceView() {
        if (this.cTS == null) {
            return null;
        }
        if (this.cTS.getDisplayedChild() == 0) {
            return this.cTT;
        }
        if (this.cTS.getDisplayedChild() == 1) {
            return this.cTU;
        }
        return null;
    }
}
