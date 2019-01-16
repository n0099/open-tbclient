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
    private RadioButton bIA;
    private RadioButton bIB;
    private RadioGroup bIr;
    private ViewSwitcher bIs;
    private InvoiceCompanyInfoView bIt;
    private InvoicePersonalInfoView bIu;
    private TextWatcher bIv;
    private RadioGroup.OnCheckedChangeListener bIw;
    private c bIx;
    private LinearLayout bIy;
    private TextView bIz;
    private View bzG;
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
        this.bIr = (RadioGroup) findViewById(e.g.invoice_type_group);
        this.bIs = (ViewSwitcher) findViewById(e.g.invoice_type_switcher);
        this.bIz = (TextView) findViewById(e.g.invoice_type_desc);
        this.bIA = (RadioButton) findViewById(e.g.invoice_type_company);
        this.bIB = (RadioButton) findViewById(e.g.invoice_type_personal);
        this.bzG = findViewById(e.g.divider_line);
        this.bIy = (LinearLayout) findViewById(e.g.invoice_type_area);
        this.bIz.setTextColor(getResources().getColor(e.d.invoice_type));
        this.bIA.setTextColor(getResources().getColor(e.d.invoice_type_company));
        this.bIA.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bIB.setTextColor(getResources().getColor(e.d.invoice_type_personal));
        this.bIB.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bzG.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
        this.bIy.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bIw = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == e.g.invoice_type_company) {
                    InvoiceInfoEditView.this.bIs.setDisplayedChild(0);
                } else if (i == e.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.bIs.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bIx != null) {
                    InvoiceInfoEditView.this.bIx.YV();
                }
            }
        };
        this.bIr.setOnCheckedChangeListener(this.bIw);
        this.bIt = new InvoiceCompanyInfoView(context);
        this.bIu = new InvoicePersonalInfoView(context);
        this.bIs.addView(this.bIt, 0);
        this.bIs.addView(this.bIu, 1);
        this.bIv = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.Za();
            }
        };
        this.bIu.setTextChangedListener(this.bIv);
        this.bIt.setTextChangedListener(this.bIv);
        this.bIr.check(e.g.invoice_type_company);
    }

    public void setInputStatusListener(c cVar) {
        this.bIx = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za() {
        if (this.bIx != null) {
            if (YX()) {
                this.bIx.YT();
            } else {
                this.bIx.YU();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean YX() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.YX();
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
                this.bIr.check(e.g.invoice_type_company);
                this.bIt.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bIr.check(e.g.invoice_type_personal);
                this.bIu.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean YY() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.YY();
    }

    private f getCurrentInvoiceView() {
        if (this.bIs == null) {
            return null;
        }
        if (this.bIs.getDisplayedChild() == 0) {
            return this.bIt;
        }
        if (this.bIs.getDisplayedChild() == 1) {
            return this.bIu;
        }
        return null;
    }
}
