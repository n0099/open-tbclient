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
    private View cUD;
    private RadioGroup ddV;
    private ViewSwitcher ddW;
    private InvoiceCompanyInfoView ddX;
    private InvoicePersonalInfoView ddY;
    private TextWatcher ddZ;
    private RadioGroup.OnCheckedChangeListener dea;
    private b deb;
    private LinearLayout dec;
    private TextView ded;
    private RadioButton dee;
    private RadioButton def;
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
        this.ddV = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.ddW = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.ded = (TextView) findViewById(R.id.invoice_type_desc);
        this.dee = (RadioButton) findViewById(R.id.invoice_type_company);
        this.def = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.cUD = findViewById(R.id.divider_line);
        this.dec = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.ded.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dee.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dee.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.def.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.def.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.cUD.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dec.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dea = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.ddW.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.ddW.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.deb != null) {
                    InvoiceInfoEditView.this.deb.aFK();
                }
            }
        };
        this.ddV.setOnCheckedChangeListener(this.dea);
        this.ddX = new InvoiceCompanyInfoView(context);
        this.ddY = new InvoicePersonalInfoView(context);
        this.ddW.addView(this.ddX, 0);
        this.ddW.addView(this.ddY, 1);
        this.ddZ = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aFR();
            }
        };
        this.ddY.setTextChangedListener(this.ddZ);
        this.ddX.setTextChangedListener(this.ddZ);
        this.ddV.check(R.id.invoice_type_company);
    }

    public void aFQ() {
        if (this.ddY != null) {
            this.ddY.e(this.ddZ);
        }
        if (this.ddX != null) {
            this.ddX.e(this.ddZ);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.deb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFR() {
        if (this.deb != null) {
            if (aFM()) {
                this.deb.aFI();
            } else {
                this.deb.aFJ();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFM() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aFM();
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
                this.ddV.check(R.id.invoice_type_company);
                this.ddX.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.ddV.check(R.id.invoice_type_personal);
                this.ddY.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aFN() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aFN();
    }

    private e getCurrentInvoiceView() {
        if (this.ddW == null) {
            return null;
        }
        if (this.ddW.getDisplayedChild() == 0) {
            return this.ddX;
        }
        if (this.ddW.getDisplayedChild() == 1) {
            return this.ddY;
        }
        return null;
    }
}
