package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.d;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
/* loaded from: classes4.dex */
public class InvoiceEditActivity extends BaseActivity {
    private ScrollView bcg;
    private InvoiceInfoEditView ddH;
    private InvoiceInfo ddI;
    private SwanAppBdActionBar ddJ;
    private int mType = 1;
    private View.OnClickListener ddK = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.ddH != null && InvoiceEditActivity.this.ddH.aFL()) {
                new g.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_title)).gC(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_message)).b(R.string.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(R.string.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).Lx();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener ddL = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.ddH != null) {
                invoiceInfo = InvoiceEditActivity.this.ddH.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.ddI));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_edit);
        X(getIntent());
        initView();
        Y(getIntent());
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.ddJ = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        if (this.ddJ != null) {
            this.ddJ.setLeftFirstViewVisibility(false);
            this.ddJ.setRightMenuVisibility(false);
            this.ddJ.setLeftSecondViewVisibility(0);
            this.ddJ.setLeftSecondViewText(getString(R.string.invoice_action_bar_cancel));
            this.ddJ.setLeftSecondViewTextSize(14);
            this.ddJ.setLeftSecondViewClickListener(this.ddK);
            this.ddJ.setRightTxtZone1Visibility(0);
            this.ddJ.setRightTxtZone1Text(getString(R.string.invoice_action_bar_save));
            this.ddJ.setRightTxtZone1Clickable(false);
            this.ddJ.setRightTxtZone1OnClickListener(this.ddL);
            this.ddJ.setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.ddJ.setTitle(getString(R.string.invoice_action_bar_title_edit));
            } else {
                this.ddJ.setTitle(getString(R.string.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bcg = (ScrollView) findViewById(R.id.scroll_view);
        this.ddH = (InvoiceInfoEditView) findViewById(R.id.invoice_info_view);
        this.bcg.setBackground(getResources().getDrawable(R.color.edit_activity_bg));
        aFN();
        this.ddH.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aFG() {
                InvoiceEditActivity.this.gt(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aFH() {
                InvoiceEditActivity.this.gt(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aFI() {
                InvoiceEditActivity.this.aFN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFN() {
        if (this.ddH.aFK()) {
            gt(true);
        } else {
            gt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(boolean z) {
        if (aEt() != null) {
            if (z) {
                aEt().setRightTxtZone1Clickable(true);
                aEt().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            aEt().setRightTxtZone1Clickable(false);
            aEt().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void Y(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.ddI = invoiceInfo;
            if (invoiceInfo != null) {
                this.ddH.d(this.ddI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aFJ().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.vM();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ta(String str) {
                    InvoiceEditActivity.this.tb(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void co(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.cp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aFJ().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.vM();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ta(String str) {
                    InvoiceEditActivity.this.tb(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void co(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.cp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(String str) {
        vM();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(String str, String str2) {
        vM();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.ddH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ddH);
    }

    public SwanAppBdActionBar aEt() {
        return this.ddJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ddH != null) {
            this.ddH.aFO();
        }
    }
}
