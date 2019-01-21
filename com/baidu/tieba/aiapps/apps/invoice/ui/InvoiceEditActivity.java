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
    private ScrollView bIl;
    private InvoiceInfoEditView bIm;
    private InvoiceInfo bIn;
    private int mType = 1;
    private View.OnClickListener bIo = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.bIm != null && InvoiceEditActivity.this.bIm.YY()) {
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
    private View.OnClickListener bIp = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.bIm != null) {
                invoiceInfo = InvoiceEditActivity.this.bIm.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.bIn));
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
        AiAppsBdActionBar XT = XT();
        if (XT != null) {
            XT.setLeftFirstViewVisibility(false);
            XT.setLeftSecondViewVisibility(0);
            XT.setLeftSecondViewText(getString(e.j.invoice_action_bar_cancel));
            XT.setLeftSecondViewTextSize(14);
            XT.setLeftSecondViewClickListener(this.bIo);
            XT.setRightTxtZone1Visibility(0);
            XT.setRightTxtZone1Text(getString(e.j.invoice_action_bar_save));
            XT.setRightTxtZone1Clickable(false);
            XT.setRightTxtZone1OnClickListener(this.bIp);
            XT.setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                XT.setTitle(getString(e.j.invoice_action_bar_title_edit));
            } else {
                XT.setTitle(getString(e.j.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bIl = (ScrollView) findViewById(e.g.scroll_view);
        this.bIm = (InvoiceInfoEditView) findViewById(e.g.invoice_info_view);
        this.bIl.setBackgroundDrawable(getResources().getDrawable(e.d.edit_activity_bg));
        YZ();
        this.bIm.setInputStatusListener(new c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void YT() {
                InvoiceEditActivity.this.dA(true);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void YU() {
                InvoiceEditActivity.this.dA(false);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.c
            public void YV() {
                InvoiceEditActivity.this.YZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YZ() {
        if (this.bIm.YX()) {
            dA(true);
        } else {
            dA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(boolean z) {
        if (XT() != null) {
            if (z) {
                XT().setRightTxtZone1Clickable(true);
                XT().setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            XT().setRightTxtZone1Clickable(false);
            XT().setRightTxtZone1TextSelector(getResources().getColorStateList(e.d.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void F(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.bIn = invoiceInfo;
            if (invoiceInfo != null) {
                this.bIm.d(this.bIn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(invoiceInfo, new d.e() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.4
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
                public void kQ(String str) {
                    InvoiceEditActivity.this.kR(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aY(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改发票失败");
                    InvoiceEditActivity.this.aZ(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(invoiceInfo, new d.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceEditActivity.5
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
                public void kQ(String str) {
                    InvoiceEditActivity.this.kR(str);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aY(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "创建发票失败");
                    InvoiceEditActivity.this.aZ(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR(String str) {
        removeLoadingView();
        b.cj(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(String str, String str2) {
        removeLoadingView();
        b.l(this, str, str2);
    }

    private void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.bIm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.bIm);
    }
}
