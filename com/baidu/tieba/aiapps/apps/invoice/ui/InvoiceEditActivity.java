package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity;
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.d;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceEditActivity extends TbAiAppsBaseActivity {
    private ScrollView bDR;
    private InvoiceInfoEditView bDS;
    private InvoiceInfo bDT;
    private int mType = 1;
    private View.OnClickListener bDU = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.bDS != null && InvoiceEditActivity.this.bDS.Xw()) {
                new AiAppAlertDialog.Builder(InvoiceEditActivity.this).setTitle(InvoiceEditActivity.this.getString(e.j.invoice_dialog_exit_title)).setMessage(InvoiceEditActivity.this.getString(e.j.invoice_dialog_exit_message)).setPositiveButton(e.j.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).setNegativeButton(e.j.invoice_dialog_exit_neg_btn, (DialogInterface.OnClickListener) null).show();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener bDV = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.bDS != null) {
                invoiceInfo = InvoiceEditActivity.this.bDS.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.bDT));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.activity_invoice_edit);
        E(getIntent());
        initView();
        F(getIntent());
    }

    private void E(Intent intent) {
        this.mType = intent.getIntExtra("type", 1);
        AiAppsBdActionBar Wo = Wo();
        if (Wo != null) {
            Wo.setLeftFirstViewVisibility(false);
            Wo.setLeftSecondViewVisibility(0);
            Wo.setLeftSecondViewText(getString(e.j.invoice_action_bar_cancel));
            Wo.setLeftSecondViewTextSize(14);
            Wo.setLeftSecondViewClickListener(this.bDU);
            Wo.setRightTxtZone1Visibility(0);
            Wo.setRightTxtZone1Text(getString(e.j.invoice_action_bar_save));
            Wo.setRightTxtZone1Clickable(false);
            Wo.setRightTxtZone1OnClickListener(this.bDV);
            Wo.setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                Wo.setTitle(getString(e.j.invoice_action_bar_title_edit));
            } else {
                Wo.setTitle(getString(e.j.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bDR = (ScrollView) findViewById(e.g.scroll_view);
        this.bDS = (InvoiceInfoEditView) findViewById(e.g.invoice_info_view);
        this.bDR.setBackgroundDrawable(getResources().getDrawable(e.d.edit_activity_bg));
        Xx();
        this.bDS.setInputStatusListener(new c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void Xr() {
                InvoiceEditActivity.this.dw(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void Xs() {
                InvoiceEditActivity.this.dw(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void Xt() {
                InvoiceEditActivity.this.Xx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xx() {
        if (this.bDS.Xv()) {
            dw(true);
        } else {
            dw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(boolean z) {
        if (Wo() != null) {
            if (z) {
                Wo().setRightTxtZone1Clickable(true);
                Wo().setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            Wo().setRightTxtZone1Clickable(false);
            Wo().setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void F(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.bDT = invoiceInfo;
            if (invoiceInfo != null) {
                this.bDS.d(this.bDT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(invoiceInfo, new d.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.e
                public void b(InvoiceInfo invoiceInfo2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改发票成功");
                    InvoiceEditActivity.this.removeLoadingView();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kf(String str) {
                    InvoiceEditActivity.this.kg(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aU(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改发票失败");
                    InvoiceEditActivity.this.aV(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(invoiceInfo, new d.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.a
                public void a(InvoiceInfo invoiceInfo2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "创建发票成功");
                    InvoiceEditActivity.this.removeLoadingView();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kf(String str) {
                    InvoiceEditActivity.this.kg(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aU(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "创建发票失败");
                    InvoiceEditActivity.this.aV(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(String str) {
        removeLoadingView();
        b.cg(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, String str2) {
        removeLoadingView();
        b.j(this, str, str2);
    }

    private void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.bDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.bDS);
    }
}
