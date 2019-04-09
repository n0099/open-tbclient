package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceEditActivity extends TbSwanAppBaseActivity {
    private ScrollView aYH;
    private InvoiceInfoEditView cTK;
    private InvoiceInfo cTL;
    private int mType = 1;
    private View.OnClickListener cTM = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.cTK != null && InvoiceEditActivity.this.cTK.aze()) {
                new e.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(d.j.invoice_dialog_exit_title)).ge(InvoiceEditActivity.this.getString(d.j.invoice_dialog_exit_message)).b(d.j.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(d.j.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).Is();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cTN = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.cTK != null) {
                invoiceInfo = InvoiceEditActivity.this.cTK.getInvoiceInfo();
            } else {
                invoiceInfo = null;
            }
            if (InvoiceEditActivity.this.mType != 0 || invoiceInfo == null) {
                if (InvoiceEditActivity.this.mType == 1 && invoiceInfo != null) {
                    InvoiceEditActivity.this.f(invoiceInfo);
                    return;
                }
                return;
            }
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cTL));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_invoice_edit);
        U(getIntent());
        initView();
        V(getIntent());
    }

    private void U(Intent intent) {
        this.mType = intent.getIntExtra("type", 1);
        SwanAppBdActionBar axU = axU();
        if (axU != null) {
            axU.setLeftFirstViewVisibility(false);
            axU.setLeftSecondViewVisibility(0);
            axU.setLeftSecondViewText(getString(d.j.invoice_action_bar_cancel));
            axU.setLeftSecondViewTextSize(14);
            axU.setLeftSecondViewClickListener(this.cTM);
            axU.setRightTxtZone1Visibility(0);
            axU.setRightTxtZone1Text(getString(d.j.invoice_action_bar_save));
            axU.setRightTxtZone1Clickable(false);
            axU.setRightTxtZone1OnClickListener(this.cTN);
            axU.setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0277d.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                axU.setTitle(getString(d.j.invoice_action_bar_title_edit));
            } else {
                axU.setTitle(getString(d.j.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.aYH = (ScrollView) findViewById(d.g.scroll_view);
        this.cTK = (InvoiceInfoEditView) findViewById(d.g.invoice_info_view);
        this.aYH.setBackgroundDrawable(getResources().getDrawable(d.C0277d.edit_activity_bg));
        azg();
        this.cTK.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void ayZ() {
                InvoiceEditActivity.this.fS(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aza() {
                InvoiceEditActivity.this.fS(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void azb() {
                InvoiceEditActivity.this.azg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azg() {
        if (this.cTK.azd()) {
            fS(true);
        } else {
            fS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(boolean z) {
        if (axU() != null) {
            if (z) {
                axU().setRightTxtZone1Clickable(true);
                axU().setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0277d.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            axU().setRightTxtZone1Clickable(false);
            axU().setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0277d.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void V(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.cTL = invoiceInfo;
            if (invoiceInfo != null) {
                this.cTK.d(this.cTL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.uB();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ry(String str) {
                    InvoiceEditActivity.this.rz(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cd(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.ce(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.uB();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ry(String str) {
                    InvoiceEditActivity.this.rz(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cd(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.ce(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(String str) {
        uB();
        com.baidu.tieba.aiapps.apps.invoice.a.dG(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str, String str2) {
        uB();
        com.baidu.tieba.aiapps.apps.invoice.a.m(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.cTK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.cTK);
    }
}
