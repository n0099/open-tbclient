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
    private RadioGroup bHB;
    private ViewSwitcher bHC;
    private InvoiceCompanyInfoView bHD;
    private InvoicePersonalInfoView bHE;
    private TextWatcher bHF;
    private RadioGroup.OnCheckedChangeListener bHG;
    private c bHH;
    private LinearLayout bHI;
    private TextView bHJ;
    private RadioButton bHK;
    private RadioButton bHL;
    private View byP;
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
        this.bHB = (RadioGroup) findViewById(e.g.invoice_type_group);
        this.bHC = (ViewSwitcher) findViewById(e.g.invoice_type_switcher);
        this.bHJ = (TextView) findViewById(e.g.invoice_type_desc);
        this.bHK = (RadioButton) findViewById(e.g.invoice_type_company);
        this.bHL = (RadioButton) findViewById(e.g.invoice_type_personal);
        this.byP = findViewById(e.g.divider_line);
        this.bHI = (LinearLayout) findViewById(e.g.invoice_type_area);
        this.bHJ.setTextColor(getResources().getColor(e.d.invoice_type));
        this.bHK.setTextColor(getResources().getColor(e.d.invoice_type_company));
        this.bHK.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bHL.setTextColor(getResources().getColor(e.d.invoice_type_personal));
        this.bHL.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.byP.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
        this.bHI.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bHG = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == e.g.invoice_type_company) {
                    InvoiceInfoEditView.this.bHC.setDisplayedChild(0);
                } else if (i == e.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.bHC.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bHH != null) {
                    InvoiceInfoEditView.this.bHH.Yw();
                }
            }
        };
        this.bHB.setOnCheckedChangeListener(this.bHG);
        this.bHD = new InvoiceCompanyInfoView(context);
        this.bHE = new InvoicePersonalInfoView(context);
        this.bHC.addView(this.bHD, 0);
        this.bHC.addView(this.bHE, 1);
        this.bHF = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.YB();
            }
        };
        this.bHE.setTextChangedListener(this.bHF);
        this.bHD.setTextChangedListener(this.bHF);
        this.bHB.check(e.g.invoice_type_company);
    }

    public void setInputStatusListener(c cVar) {
        this.bHH = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YB() {
        if (this.bHH != null) {
            if (Yy()) {
                this.bHH.Yu();
            } else {
                this.bHH.Yv();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Yy() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Yy();
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
                this.bHB.check(e.g.invoice_type_company);
                this.bHD.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bHB.check(e.g.invoice_type_personal);
                this.bHE.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Yz() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Yz();
    }

    private f getCurrentInvoiceView() {
        if (this.bHC == null) {
            return null;
        }
        if (this.bHC.getDisplayedChild() == 0) {
            return this.bHD;
        }
        if (this.bHC.getDisplayedChild() == 1) {
            return this.bHE;
        }
        return null;
    }
}
