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
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.f;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceInfoEditView extends FrameLayout implements f {
    private RadioGroup bDY;
    private ViewSwitcher bDZ;
    private InvoiceCompanyInfoView bEa;
    private InvoicePersonalInfoView bEb;
    private TextWatcher bEc;
    private RadioGroup.OnCheckedChangeListener bEd;
    private c bEe;
    private LinearLayout bEf;
    private TextView bEg;
    private RadioButton bEh;
    private RadioButton bEi;
    private View bvs;
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
        inflate(context, e.h.invoice_info_edit_view, this);
        this.bDY = (RadioGroup) findViewById(e.g.invoice_type_group);
        this.bDZ = (ViewSwitcher) findViewById(e.g.invoice_type_switcher);
        this.bEg = (TextView) findViewById(e.g.invoice_type_desc);
        this.bEh = (RadioButton) findViewById(e.g.invoice_type_company);
        this.bEi = (RadioButton) findViewById(e.g.invoice_type_personal);
        this.bvs = findViewById(e.g.divider_line);
        this.bEf = (LinearLayout) findViewById(e.g.invoice_type_area);
        this.bEg.setTextColor(getResources().getColor(e.d.invoice_type));
        this.bEh.setTextColor(getResources().getColor(e.d.invoice_type_company));
        this.bEh.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bEi.setTextColor(getResources().getColor(e.d.invoice_type_personal));
        this.bEi.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bvs.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
        this.bEf.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bEd = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == e.g.invoice_type_company) {
                    InvoiceInfoEditView.this.bDZ.setDisplayedChild(0);
                } else if (i == e.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.bDZ.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bEe != null) {
                    InvoiceInfoEditView.this.bEe.Xt();
                }
            }
        };
        this.bDY.setOnCheckedChangeListener(this.bEd);
        this.bEa = new InvoiceCompanyInfoView(context);
        this.bEb = new InvoicePersonalInfoView(context);
        this.bDZ.addView(this.bEa, 0);
        this.bDZ.addView(this.bEb, 1);
        this.bEc = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.Xy();
            }
        };
        this.bEb.setTextChangedListener(this.bEc);
        this.bEa.setTextChangedListener(this.bEc);
        this.bDY.check(e.g.invoice_type_company);
    }

    public void setInputStatusListener(c cVar) {
        this.bEe = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xy() {
        if (this.bEe != null) {
            if (Xv()) {
                this.bEe.Xr();
            } else {
                this.bEe.Xs();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xv() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Xv();
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public InvoiceInfo getInvoiceInfo() {
        f currentInvoiceView = getCurrentInvoiceView();
        if (currentInvoiceView != null) {
            return currentInvoiceView.getInvoiceInfo();
        }
        return null;
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            if (invoiceInfo.mType == 0) {
                this.bDY.check(e.g.invoice_type_company);
                this.bEa.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bDY.check(e.g.invoice_type_personal);
                this.bEb.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xw() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Xw();
    }

    private f getCurrentInvoiceView() {
        if (this.bDZ == null) {
            return null;
        }
        if (this.bDZ.getDisplayedChild() == 0) {
            return this.bEa;
        }
        if (this.bDZ.getDisplayedChild() == 1) {
            return this.bEb;
        }
        return null;
    }
}
