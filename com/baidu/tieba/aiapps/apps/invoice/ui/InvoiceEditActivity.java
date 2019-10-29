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
    private ScrollView bvD;
    private InvoiceInfoEditView doV;
    private InvoiceInfo doW;
    private SwanAppBdActionBar doX;
    private int mType = 1;
    private View.OnClickListener doY = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.doV != null && InvoiceEditActivity.this.doV.aGE()) {
                new g.a(InvoiceEditActivity.this).d(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_title)).hi(InvoiceEditActivity.this.getString(R.string.invoice_dialog_exit_message)).b(R.string.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).c(R.string.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).Qu();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener doZ = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.doV != null) {
                invoiceInfo = InvoiceEditActivity.this.doV.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.doW));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_edit);
        af(getIntent());
        initView();
        ag(getIntent());
    }

    private void af(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.doX = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        if (this.doX != null) {
            this.doX.setLeftFirstViewVisibility(false);
            this.doX.setRightMenuVisibility(false);
            this.doX.setLeftSecondViewVisibility(0);
            this.doX.setLeftSecondViewText(getString(R.string.invoice_action_bar_cancel));
            this.doX.setLeftSecondViewTextSize(14);
            this.doX.setLeftSecondViewClickListener(this.doY);
            this.doX.setRightTxtZone1Visibility(0);
            this.doX.setRightTxtZone1Text(getString(R.string.invoice_action_bar_save));
            this.doX.setRightTxtZone1Clickable(false);
            this.doX.setRightTxtZone1OnClickListener(this.doZ);
            this.doX.setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.doX.setTitle(getString(R.string.invoice_action_bar_title_edit));
            } else {
                this.doX.setTitle(getString(R.string.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bvD = (ScrollView) findViewById(R.id.scroll_view);
        this.doV = (InvoiceInfoEditView) findViewById(R.id.invoice_info_view);
        this.bvD.setBackground(getResources().getDrawable(R.color.edit_activity_bg));
        aGG();
        this.doV.setInputStatusListener(new b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGz() {
                InvoiceEditActivity.this.gl(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGA() {
                InvoiceEditActivity.this.gl(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.b
            public void aGB() {
                InvoiceEditActivity.this.aGG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGG() {
        if (this.doV.aGD()) {
            gl(true);
        } else {
            gl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(boolean z) {
        if (aFk() != null) {
            if (z) {
                aFk().setRightTxtZone1Clickable(true);
                aFk().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            aFk().setRightTxtZone1Clickable(false);
            aFk().setRightTxtZone1TextSelector(getResources().getColorStateList(R.color.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void ag(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.doW = invoiceInfo;
            if (invoiceInfo != null) {
                this.doV.d(this.doW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGC().a(invoiceInfo, new c.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.AK();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void si(String str) {
                    InvoiceEditActivity.this.sj(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ci(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.cj(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGC().a(invoiceInfo, new c.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.AK();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void si(String str) {
                    InvoiceEditActivity.this.sj(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ci(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.cj(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(String str) {
        AK();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(String str, String str2) {
        AK();
        com.baidu.tieba.aiapps.apps.invoice.a.q(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.doV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.doV);
    }

    public SwanAppBdActionBar aFk() {
        return this.doX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.doV != null) {
            this.doV.aGH();
        }
    }
}
