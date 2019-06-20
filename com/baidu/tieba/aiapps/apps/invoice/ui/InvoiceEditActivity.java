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
    private ScrollView bbv;
    private InvoiceInfoEditView dcg;
    private InvoiceInfo dch;
    private SwanAppBdActionBar dci;
    private int mType = 1;
    private View.OnClickListener dcj = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.dcg != null && InvoiceEditActivity.this.dcg.aEv()) {
                new g.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_title)).gw(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_message)).b(R.string.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(R.string.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).KK();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener dck = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.dcg != null) {
                invoiceInfo = InvoiceEditActivity.this.dcg.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.dch));
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
        this.dci = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        if (this.dci != null) {
            this.dci.setLeftFirstViewVisibility(false);
            this.dci.setRightMenuVisibility(false);
            this.dci.setLeftSecondViewVisibility(0);
            this.dci.setLeftSecondViewText(getString(R.string.invoice_action_bar_cancel));
            this.dci.setLeftSecondViewTextSize(14);
            this.dci.setLeftSecondViewClickListener(this.dcj);
            this.dci.setRightTxtZone1Visibility(0);
            this.dci.setRightTxtZone1Text(getString(R.string.invoice_action_bar_save));
            this.dci.setRightTxtZone1Clickable(false);
            this.dci.setRightTxtZone1OnClickListener(this.dck);
            this.dci.setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.dci.setTitle(getString(R.string.invoice_action_bar_title_edit));
            } else {
                this.dci.setTitle(getString(R.string.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bbv = (ScrollView) findViewById(R.id.scroll_view);
        this.dcg = (InvoiceInfoEditView) findViewById(R.id.invoice_info_view);
        this.bbv.setBackground(getResources().getDrawable(R.color.edit_activity_bg));
        aEx();
        this.dcg.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEq() {
                InvoiceEditActivity.this.gp(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEr() {
                InvoiceEditActivity.this.gp(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEs() {
                InvoiceEditActivity.this.aEx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEx() {
        if (this.dcg.aEu()) {
            gp(true);
        } else {
            gp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(boolean z) {
        if (aDd() != null) {
            if (z) {
                aDd().setRightTxtZone1Clickable(true);
                aDd().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            aDd().setRightTxtZone1Clickable(false);
            aDd().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void Y(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.dch = invoiceInfo;
            if (invoiceInfo != null) {
                this.dcg.d(this.dch);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aEt().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.vl();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void sH(String str) {
                    InvoiceEditActivity.this.sI(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.co(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aEt().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.vl();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void sH(String str) {
                    InvoiceEditActivity.this.sI(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.co(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sI(String str) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(String str, String str2) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dcg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dcg);
    }

    public SwanAppBdActionBar aDd() {
        return this.dci;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dcg != null) {
            this.dcg.onActivityDestroy();
        }
    }
}
