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
    private View ddZ;
    private RadioGroup dol;
    private ViewSwitcher dom;
    private InvoiceCompanyInfoView don;
    private InvoicePersonalInfoView doo;
    private TextWatcher dop;
    private RadioGroup.OnCheckedChangeListener doq;
    private b dor;
    private LinearLayout dos;
    private TextView dot;
    private RadioButton dou;
    private RadioButton dov;
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
        this.dol = (RadioGroup) findViewById(R.id.invoice_type_group);
        this.dom = (ViewSwitcher) findViewById(R.id.invoice_type_switcher);
        this.dot = (TextView) findViewById(R.id.invoice_type_desc);
        this.dou = (RadioButton) findViewById(R.id.invoice_type_company);
        this.dov = (RadioButton) findViewById(R.id.invoice_type_personal);
        this.ddZ = findViewById(R.id.divider_line);
        this.dos = (LinearLayout) findViewById(R.id.invoice_type_area);
        this.dot.setTextColor(getResources().getColor(R.color.invoice_type));
        this.dou.setTextColor(getResources().getColor(R.color.invoice_type_company));
        this.dou.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.dov.setTextColor(getResources().getColor(R.color.invoice_type_personal));
        this.dov.setButtonDrawable(getResources().getDrawable(R.drawable.radio_button_selector));
        this.ddZ.setBackground(getResources().getDrawable(R.color.invoice_info_item_divider_line));
        this.dos.setBackground(getResources().getDrawable(R.color.invoice_edit_view_bg));
        this.doq = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.invoice_type_company) {
                    InvoiceInfoEditView.this.dom.setDisplayedChild(0);
                } else if (i == R.id.invoice_type_personal) {
                    InvoiceInfoEditView.this.dom.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.dor != null) {
                    InvoiceInfoEditView.this.dor.aGz();
                }
            }
        };
        this.dol.setOnCheckedChangeListener(this.doq);
        this.don = new InvoiceCompanyInfoView(context);
        this.doo = new InvoicePersonalInfoView(context);
        this.dom.addView(this.don, 0);
        this.dom.addView(this.doo, 1);
        this.dop = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aGG();
            }
        };
        this.doo.setTextChangedListener(this.dop);
        this.don.setTextChangedListener(this.dop);
        this.dol.check(R.id.invoice_type_company);
    }

    public void aGF() {
        if (this.doo != null) {
            this.doo.e(this.dop);
        }
        if (this.don != null) {
            this.don.e(this.dop);
        }
    }

    public void setInputStatusListener(b bVar) {
        this.dor = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGG() {
        if (this.dor != null) {
            if (aGB()) {
                this.dor.aGx();
            } else {
                this.dor.aGy();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGB() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGB();
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
                this.dol.check(R.id.invoice_type_company);
                this.don.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.dol.check(R.id.invoice_type_personal);
                this.doo.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.e
    public boolean aGC() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aGC();
    }

    private e getCurrentInvoiceView() {
        if (this.dom == null) {
            return null;
        }
        if (this.dom.getDisplayedChild() == 0) {
            return this.don;
        }
        if (this.dom.getDisplayedChild() == 1) {
            return this.doo;
        }
        return null;
    }
}
