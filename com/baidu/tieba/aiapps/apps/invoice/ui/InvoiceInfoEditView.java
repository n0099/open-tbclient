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
    private RadioGroup bDm;
    private ViewSwitcher bDn;
    private InvoiceCompanyInfoView bDo;
    private InvoicePersonalInfoView bDp;
    private TextWatcher bDq;
    private RadioGroup.OnCheckedChangeListener bDr;
    private c bDs;
    private LinearLayout bDt;
    private TextView bDu;
    private RadioButton bDv;
    private RadioButton bDw;
    private View buH;
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
        this.bDm = (RadioGroup) findViewById(e.g.invoice_type_group);
        this.bDn = (ViewSwitcher) findViewById(e.g.invoice_type_switcher);
        this.bDu = (TextView) findViewById(e.g.invoice_type_desc);
        this.bDv = (RadioButton) findViewById(e.g.invoice_type_company);
        this.bDw = (RadioButton) findViewById(e.g.invoice_type_personal);
        this.buH = findViewById(e.g.divider_line);
        this.bDt = (LinearLayout) findViewById(e.g.invoice_type_area);
        this.bDu.setTextColor(getResources().getColor(e.d.invoice_type));
        this.bDv.setTextColor(getResources().getColor(e.d.invoice_type_company));
        this.bDv.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.bDw.setTextColor(getResources().getColor(e.d.invoice_type_personal));
        this.bDw.setButtonDrawable(getResources().getDrawable(e.f.radio_button_selector));
        this.buH.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_info_item_divider_line));
        this.bDt.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_edit_view_bg));
        this.bDr = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == e.g.invoice_type_company) {
                    InvoiceInfoEditView.this.bDn.setDisplayedChild(0);
                } else if (i == e.g.invoice_type_personal) {
                    InvoiceInfoEditView.this.bDn.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bDs != null) {
                    InvoiceInfoEditView.this.bDs.Xj();
                }
            }
        };
        this.bDm.setOnCheckedChangeListener(this.bDr);
        this.bDo = new InvoiceCompanyInfoView(context);
        this.bDp = new InvoicePersonalInfoView(context);
        this.bDn.addView(this.bDo, 0);
        this.bDn.addView(this.bDp, 1);
        this.bDq = new TextWatcher() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.Xo();
            }
        };
        this.bDp.setTextChangedListener(this.bDq);
        this.bDo.setTextChangedListener(this.bDq);
        this.bDm.check(e.g.invoice_type_company);
    }

    public void setInputStatusListener(c cVar) {
        this.bDs = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xo() {
        if (this.bDs != null) {
            if (Xl()) {
                this.bDs.Xh();
            } else {
                this.bDs.Xi();
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xl() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Xl();
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
                this.bDm.check(e.g.invoice_type_company);
                this.bDo.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bDm.check(e.g.invoice_type_personal);
                this.bDp.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.f
    public boolean Xm() {
        f currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.Xm();
    }

    private f getCurrentInvoiceView() {
        if (this.bDn == null) {
            return null;
        }
        if (this.bDn.getDisplayedChild() == 0) {
            return this.bDo;
        }
        if (this.bDn.getDisplayedChild() == 1) {
            return this.bDp;
        }
        return null;
    }
}
