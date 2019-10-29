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
    private View deR;
    private RadioGroup dpc;
    private ViewSwitcher dpd;
    private InvoiceCompanyInfoView dpe;
    private InvoicePersonalInfoView dpf;
    private TextWatcher dpg;
    private RadioGroup.OnCheckedChangeListener dph;
    private b dpi;
    private LinearLayout dpj;
    private TextView dpk;
    private RadioButton dpl;
    private RadioButton dpm;
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
        this.dpc = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dpd = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dpk = (TextView) findViewById(R.id.invoice_type_desc);
        this.dpl = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dpm = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.deR = findViewById(R.id.divider_line);
        this.dpj = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dpk.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dpl.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dpl.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dpm.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dpm.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.deR.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dpj.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.dph = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dpd.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dpd.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dpi != null) {
                    InvoiceInfoEditView.this.dpi.aGB();
                }
            }
        };
        this.dpc.setOnCheckedChangeListener(this.dph);
        this.dpe = new InvoiceCompanyInfoView(context);
        this.dpf = new InvoicePersonalInfoView(context);
        this.dpd.addView(this.dpe, 0);
        this.dpd.addView(this.dpf, 1);
        this.dpg = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aGI();
            }
        };
        this.dpf.setTextChangedListener(this.dpg);
        this.dpe.setTextChangedListener(this.dpg);
        this.dpc.check(R.id.invoice_type_company);
    }

    public void aGH() {
        if (this.dpf != null) {
            this.dpf.e(this.dpg);
        }
        if (this.dpe != null) {
            this.dpe.e(this.dpg);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dpi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGI() {
        if (this.dpi != null) {
            if (aGD()) {
                this.dpi.aGz();
            } else {
                this.dpi.aGA();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGD() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGD();
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
                this.dpc.check(R.id.invoice_type_company);
                this.dpe.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dpc.check(R.id.invoice_type_personal);
                this.dpf.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGE() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGE();
    }

    private e getCurrentInvoiceView() {
        if (this.dpd == null) {
            return null;
        }
        if (this.dpd.getDisplayedChild() == 0) {
            return this.dpe;
        }
        if (this.dpd.getDisplayedChild() == 1) {
            return this.dpf;
        }
        return null;
    }
}
