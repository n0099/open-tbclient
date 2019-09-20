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
    private ScrollView bcE;
    private InvoiceInfoEditView dfA;
    private InvoiceInfo dfB;
    private SwanAppBdActionBar dfC;
    private int mType = 1;
    private View.OnClickListener dfD = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.dfA != null && InvoiceEditActivity.this.dfA.aGr()) {
                new g.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_title)).gE(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_message)).b(R.string.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(R.string.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).LB();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener dfE = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.dfA != null) {
                invoiceInfo = InvoiceEditActivity.this.dfA.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.dfB));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_edit);
        Z(getIntent());
        initView();
        aa(getIntent());
    }

    private void Z(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.dfC = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        if (this.dfC != null) {
            this.dfC.setLeftFirstViewVisibility(false);
            this.dfC.setRightMenuVisibility(false);
            this.dfC.setLeftSecondViewVisibility(0);
            this.dfC.setLeftSecondViewText(getString(R.string.invoice_action_bar_cancel));
            this.dfC.setLeftSecondViewTextSize(14);
            this.dfC.setLeftSecondViewClickListener(this.dfD);
            this.dfC.setRightTxtZone1Visibility(0);
            this.dfC.setRightTxtZone1Text(getString(R.string.invoice_action_bar_save));
            this.dfC.setRightTxtZone1Clickable(false);
            this.dfC.setRightTxtZone1OnClickListener(this.dfE);
            this.dfC.setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.dfC.setTitle(getString(R.string.invoice_action_bar_title_edit));
            } else {
                this.dfC.setTitle(getString(R.string.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bcE = (ScrollView) findViewById(R.id.scroll_view);
        this.dfA = (InvoiceInfoEditView) findViewById(R.id.invoice_info_view);
        this.bcE.setBackground(getResources().getDrawable(R.color.edit_activity_bg));
        aGt();
        this.dfA.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGm() {
                InvoiceEditActivity.this.gw(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGn() {
                InvoiceEditActivity.this.gw(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGo() {
                InvoiceEditActivity.this.aGt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        if (this.dfA.aGq()) {
            gw(true);
        } else {
            gw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        if (aEZ() != null) {
            if (z) {
                aEZ().setRightTxtZone1Clickable(true);
                aEZ().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            aEZ().setRightTxtZone1Clickable(false);
            aEZ().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void aa(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.dfB = invoiceInfo;
            if (invoiceInfo != null) {
                this.dfA.d(this.dfB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGp().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.vQ();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void tz(String str) {
                    InvoiceEditActivity.this.tA(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cp(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.cq(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGp().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.vQ();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void tz(String str) {
                    InvoiceEditActivity.this.tA(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cp(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.cq(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tA(String str) {
        vQ();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(String str, String str2) {
        vQ();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dfA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dfA);
    }

    public SwanAppBdActionBar aEZ() {
        return this.dfC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dfA != null) {
            this.dfA.aGu();
        }
    }
}
