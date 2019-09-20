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
    private View cVw;
    private RadioGroup dfH;
    private ViewSwitcher dfI;
    private InvoiceCompanyInfoView dfJ;
    private InvoicePersonalInfoView dfK;
    private TextWatcher dfL;
    private RadioGroup.OnCheckedChangeListener dfM;
    private b dfN;
    private LinearLayout dfO;
    private TextView dfP;
    private RadioButton dfQ;
    private RadioButton dfR;
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
        this.dfH = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dfI = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dfP = (TextView) findViewById(R.id.invoice_type_desc);
        this.dfQ = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dfR = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cVw = findViewById(R.id.divider_line);
        this.dfO = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dfP.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dfQ.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dfQ.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dfR.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dfR.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cVw.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dfO.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dfM = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dfI.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dfI.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dfN != null) {
                    InvoiceInfoEditView.this.dfN.aGo();
                }
            }
        };
        this.dfH.setOnCheckedChangeListener(this.dfM);
        this.dfJ = new InvoiceCompanyInfoView(context);
        this.dfK = new InvoicePersonalInfoView(context);
        this.dfI.addView(this.dfJ, 0);
        this.dfI.addView(this.dfK, 1);
        this.dfL = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aGv();
            }
        };
        this.dfK.setTextChangedListener(this.dfL);
        this.dfJ.setTextChangedListener(this.dfL);
        this.dfH.check(R.id.invoice_type_company);
    }

    public void aGu() {
        if (this.dfK != null) {
            this.dfK.e(this.dfL);
        }
        if (this.dfJ != null) {
            this.dfJ.e(this.dfL);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dfN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGv() {
        if (this.dfN != null) {
            if (aGq()) {
                this.dfN.aGm();
            } else {
                this.dfN.aGn();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGq() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGq();
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
                this.dfH.check(R.id.invoice_type_company);
                this.dfJ.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dfH.check(R.id.invoice_type_personal);
                this.dfK.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGr() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGr();
    }

    private e getCurrentInvoiceView() {
        if (this.dfI == null) {
            return null;
        }
        if (this.dfI.getDisplayedChild() == 0) {
            return this.dfJ;
        }
        if (this.dfI.getDisplayedChild() == 1) {
            return this.dfK;
        }
        return null;
    }
}
