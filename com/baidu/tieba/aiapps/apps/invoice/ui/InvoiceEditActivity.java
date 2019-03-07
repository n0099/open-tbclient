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
    private ScrollView aYC;
    private InvoiceInfoEditView cTL;
    private InvoiceInfo cTM;
    private int mType = 1;
    private View.OnClickListener cTN = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.cTL != null && InvoiceEditActivity.this.cTL.azh()) {
                new e.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(d.j.invoice_dialog_exit_title)).gd(InvoiceEditActivity.this.getString(d.j.invoice_dialog_exit_message)).b(d.j.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(d.j.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).Iu();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cTO = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.cTL != null) {
                invoiceInfo = InvoiceEditActivity.this.cTL.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cTM));
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
        SwanAppBdActionBar axX = axX();
        if (axX != null) {
            axX.setLeftFirstViewVisibility(false);
            axX.setLeftSecondViewVisibility(0);
            axX.setLeftSecondViewText(getString(d.j.invoice_action_bar_cancel));
            axX.setLeftSecondViewTextSize(14);
            axX.setLeftSecondViewClickListener(this.cTN);
            axX.setRightTxtZone1Visibility(0);
            axX.setRightTxtZone1Text(getString(d.j.invoice_action_bar_save));
            axX.setRightTxtZone1Clickable(false);
            axX.setRightTxtZone1OnClickListener(this.cTO);
            axX.setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0236d.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                axX.setTitle(getString(d.j.invoice_action_bar_title_edit));
            } else {
                axX.setTitle(getString(d.j.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.aYC = (ScrollView) findViewById(d.g.scroll_view);
        this.cTL = (InvoiceInfoEditView) findViewById(d.g.invoice_info_view);
        this.aYC.setBackgroundDrawable(getResources().getDrawable(d.C0236d.edit_activity_bg));
        azj();
        this.cTL.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void azc() {
                InvoiceEditActivity.this.fS(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void azd() {
                InvoiceEditActivity.this.fS(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aze() {
                InvoiceEditActivity.this.azj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azj() {
        if (this.cTL.azg()) {
            fS(true);
        } else {
            fS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(boolean z) {
        if (axX() != null) {
            if (z) {
                axX().setRightTxtZone1Clickable(true);
                axX().setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0236d.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            axX().setRightTxtZone1Clickable(false);
            axX().setRightTxtZone1TextSelector(getResources().getColorStateList(d.C0236d.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void V(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.cTM = invoiceInfo;
            if (invoiceInfo != null) {
                this.cTL.d(this.cTM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.uC();
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
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.uC();
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
        uC();
        com.baidu.tieba.aiapps.apps.invoice.a.dH(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str, String str2) {
        uC();
        com.baidu.tieba.aiapps.apps.invoice.a.m(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.cTL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.cTL);
    }
}
