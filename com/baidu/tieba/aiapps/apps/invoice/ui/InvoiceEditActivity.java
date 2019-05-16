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
    private InvoiceInfoEditView dcd;
    private InvoiceInfo dcf;
    private SwanAppBdActionBar dcg;
    private int mType = 1;
    private View.OnClickListener dch = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.dcd != null && InvoiceEditActivity.this.dcd.aEs()) {
                new g.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_title)).gx(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_message)).b(R.string.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
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
    private View.OnClickListener dci = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.dcd != null) {
                invoiceInfo = InvoiceEditActivity.this.dcd.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.dcf));
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
        this.dcg = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        if (this.dcg != null) {
            this.dcg.setLeftFirstViewVisibility(false);
            this.dcg.setRightMenuVisibility(false);
            this.dcg.setLeftSecondViewVisibility(0);
            this.dcg.setLeftSecondViewText(getString(R.string.invoice_action_bar_cancel));
            this.dcg.setLeftSecondViewTextSize(14);
            this.dcg.setLeftSecondViewClickListener(this.dch);
            this.dcg.setRightTxtZone1Visibility(0);
            this.dcg.setRightTxtZone1Text(getString(R.string.invoice_action_bar_save));
            this.dcg.setRightTxtZone1Clickable(false);
            this.dcg.setRightTxtZone1OnClickListener(this.dci);
            this.dcg.setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.dcg.setTitle(getString(R.string.invoice_action_bar_title_edit));
            } else {
                this.dcg.setTitle(getString(R.string.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bbv = (ScrollView) findViewById(R.id.scroll_view);
        this.dcd = (InvoiceInfoEditView) findViewById(R.id.invoice_info_view);
        this.bbv.setBackground(getResources().getDrawable(R.color.edit_activity_bg));
        aEu();
        this.dcd.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEn() {
                InvoiceEditActivity.this.gp(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEo() {
                InvoiceEditActivity.this.gp(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aEp() {
                InvoiceEditActivity.this.aEu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEu() {
        if (this.dcd.aEr()) {
            gp(true);
        } else {
            gp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(boolean z) {
        if (aDa() != null) {
            if (z) {
                aDa().setRightTxtZone1Clickable(true);
                aDa().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            aDa().setRightTxtZone1Clickable(false);
            aDa().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void Y(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.dcf = invoiceInfo;
            if (invoiceInfo != null) {
                this.dcd.d(this.dcf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aEq().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
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
                public void sI(String str) {
                    InvoiceEditActivity.this.sJ(str);
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
            d.aEq().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
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
                public void sI(String str) {
                    InvoiceEditActivity.this.sJ(str);
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
    public void sJ(String str) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(String str, String str2) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dcd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dcd);
    }

    public SwanAppBdActionBar aDa() {
        return this.dcg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dcd != null) {
            this.dcd.onActivityDestroy();
        }
    }
}
