package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction;
import com.baidu.searchbox.ng.ai.apps.res.ui.CommonEmptyView;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity;
import com.baidu.tieba.aiapps.apps.invoice.b;
import com.baidu.tieba.aiapps.apps.invoice.d;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.a;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InvoiceListActivity extends TbAiAppsBaseActivity {
    private CommonEmptyView bCX;
    private String bEA;
    private String bEB;
    private RecyclerView bEt;
    private a bEu;
    private LinearLayout bEv;
    private View bEw;
    private Button bEx;
    private RelativeLayout bEy;
    private RecyclerView.LayoutManager mLayoutManager;
    private int bEz = 0;
    private String mSource = "source_setting";
    private d.c bEC = new d.c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.d.c
        public void aq(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.bEu != null) {
                InvoiceListActivity.this.removeLoadingView();
                InvoiceListActivity.this.bEu.ak(list);
                InvoiceListActivity.this.XA();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void kf(String str) {
            InvoiceListActivity.this.n(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void aU(String str, String str2) {
            InvoiceListActivity.this.aV(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.activity_invoice_list);
        G(getIntent());
        E(getIntent());
        initView();
    }

    private void G(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.bEA = intent.getStringExtra("ai_app_id");
            this.bEB = intent.getStringExtra("ai_app_key");
        }
    }

    private void E(Intent intent) {
        AiAppsBdActionBar Wo = Wo();
        Wo.setTitle(getString(e.j.invoice_info_activity_title));
        if (intent != null) {
            this.bEz = intent.getIntExtra("bar_position", 0);
        }
        if (Wo != null) {
            Wo.setLeftFirstViewVisibility(this.bEz == 0);
        }
    }

    private void initView() {
        this.bEy = (RelativeLayout) findViewById(e.g.root_container);
        this.bEt = (RecyclerView) findViewById(e.g.invoice_list_view);
        this.bEx = (Button) findViewById(e.g.new_invoice_info_btn);
        this.bCX = (CommonEmptyView) findViewById(e.g.empty_view);
        this.bEv = (LinearLayout) findViewById(e.g.new_invoice_info_area);
        this.bEw = findViewById(e.g.new_invoice_info_divider_line);
        this.bEt.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_list_bg));
        this.bEv.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_btn_area));
        this.bEw.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_divider_line));
        this.bEx.setTextColor(getResources().getColor(e.d.invoice_create_new_btn_text));
        this.bEx.setBackgroundDrawable(getResources().getDrawable(e.f.invoice_create_new_btn_bg));
        this.bEu = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.bEt.setLayoutManager(this.mLayoutManager);
        this.bEt.setAdapter(this.bEu);
        XA();
        this.bEu.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // com.baidu.tieba.aiapps.apps.invoice.ui.a.b
            public void a(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.g(invoiceInfo);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.ui.a.b
            public void b(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.l(invoiceInfo);
            }

            @Override // com.baidu.tieba.aiapps.apps.invoice.ui.a.b
            public void c(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.j(invoiceInfo);
            }
        });
        this.bEx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.XD();
            }
        });
        XB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        if (this.bCX != null) {
            this.bCX.setTitle(getString(e.j.invoice_empty_title));
            this.bCX.setIcon(e.f.empty_icon_document);
            if (this.bEu != null && this.bEu.getItemCount() > 0) {
                this.bCX.setVisibility(8);
            } else {
                this.bCX.setVisibility(0);
            }
        }
    }

    private void XB() {
        if (ba.bG(this)) {
            XC();
            return;
        }
        UniversalToast.makeText(this, "请先登录").showToast();
        finish();
    }

    private void XC() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(this, this.bEA, this.bEB, this.bEC);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(this.bEC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        removeLoadingView();
        UniversalToast.makeText(this, "登录信息校验失败").showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, String str2) {
        removeLoadingView();
        b.j(this, str, str2);
    }

    private void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.bEy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.bEy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(InvoiceInfo invoiceInfo) {
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "选择发票");
            Intent intent = new Intent();
            intent.putExtra(ChooseInvoiceAction.KEY_INVOICE, h(invoiceInfo).toString());
            setResult(-1, intent);
            finish();
        } else if (invoiceInfo != null && invoiceInfo.mIsDefault != 1) {
            i(invoiceInfo);
        }
    }

    private JSONObject h(InvoiceInfo invoiceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", invoiceInfo.mType + "");
            jSONObject.put("title", invoiceInfo.mTitle);
            jSONObject.put("taxNumber", invoiceInfo.bDC);
            jSONObject.put("companyAddress", invoiceInfo.bDD);
            jSONObject.put("telephone", invoiceInfo.bDE);
            jSONObject.put("bankName", invoiceInfo.bDF);
            jSONObject.put("bankAccount", invoiceInfo.bDG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(invoiceInfo.mId, new d.InterfaceC0188d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.InterfaceC0188d
                public void aW(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票成功");
                    if (InvoiceListActivity.this.bEu != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bEu.aY(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kf(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aU(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票失败");
                    InvoiceListActivity.this.aV(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0148b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    InvoiceListActivity.this.k(invoiceInfo);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Xu().a(invoiceInfo.mId, new d.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.b
                public void aV(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票成功");
                    if (InvoiceListActivity.this.bEu != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bEu.aX(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.bEu.aY(j);
                        }
                        InvoiceListActivity.this.XA();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kf(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aU(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票失败");
                    InvoiceListActivity.this.aV(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bEz);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XD() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bEz);
        intent.putExtra("type", 1);
        startActivityForResult(intent, 10001);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            InvoiceInfo invoiceInfo = null;
            if (intent != null) {
                invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            }
            switch (i) {
                case 10001:
                    UniversalToast.makeText(this, e.j.invoice_toast_create_success).showToast();
                    if (this.bEu != null && invoiceInfo != null) {
                        this.bEu.m(invoiceInfo);
                        XA();
                        break;
                    }
                    break;
                case 10002:
                    if (this.bEu != null && invoiceInfo != null) {
                        this.bEu.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
