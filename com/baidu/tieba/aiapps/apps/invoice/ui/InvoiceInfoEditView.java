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
    private RadioGroup bHE;
    private ViewSwitcher bHF;
    private InvoiceCompanyInfoView bHG;
    private InvoicePersonalInfoView bHH;
    private TextWatcher bHI;
    private RadioGroup.OnCheckedChangeListener bHJ;
    private c bHK;
    private LinearLayout bHL;
    private TextView bHM;
    private RadioButton bHN;
    private RadioButton bHO;
    private View byS;
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
        this.bHE = (RadioGroup) findViewById(e.g.invoice_type_group);
        this.bHF = (ViewSwitcher) findViewById(e.g.invoice_type_switcher);
        this.bHM = (TextView) findViewById(e.g.invoice_type_desc);
        this.bHN = (RadioButton) findViewById(e.g.invoice_type_company);
        this.bHO = (RadioButton) findViewById(e.g.invoice_type_personal);
        this.byS = findViewById(e.g.divider_line);
        this.bHL = (LinearLayout) findViewById(e.g.invoice_type_area);
        this.bHM.setTextColor(getResources().getColor(e.d.invoice_type));
        this.bHN.setTextColor(getResources().getColor(e.d.invoice_type_company));
        this.bHN.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bHO.setTextColor(getResources().getColor(e.d.invoice_type_personal));
        this.bHO.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.byS.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
        this.bHL.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bHJ = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == e.g.invoice_type_company) {
                    InvoiceInfoEditView.this.bHF.setDisplayedChild(0);
                } else if (i == e.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.bHF.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bHK != null) {
                    InvoiceInfoEditView.this.bHK.Yy();
                }
            }
        };
        this.bHE.setOnCheckedChangeListener(this.bHJ);
        this.bHG = new InvoiceCompanyInfoView(context);
        this.bHH = new InvoicePersonalInfoView(context);
        this.bHF.addView(this.bHG, 0);
        this.bHF.addView(this.bHH, 1);
        this.bHI = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.YD();
            }
        };
        this.bHH.setTextChangedListener(this.bHI);
        this.bHG.setTextChangedListener(this.bHI);
        this.bHE.check(e.g.invoice_type_company);
    }

    public void setInputStatusListener(c cVar) {
        this.bHK = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YD() {
        if (this.bHK != null) {
            if (YA()) {
                this.bHK.Yw();
            } else {
                this.bHK.Yx();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean YA() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.YA();
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
                this.bHE.check(e.g.invoice_type_company);
                this.bHG.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bHE.check(e.g.invoice_type_personal);
                this.bHH.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean YB() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.YB();
    }

    private f getCurrentInvoiceView() {
        if (this.bHF == null) {
            return null;
        }
        if (this.bHF.getDisplayedChild() == 0) {
            return this.bHG;
        }
        if (this.bHF.getDisplayedChild() == 1) {
            return this.bHH;
        }
        return null;
    }
}
