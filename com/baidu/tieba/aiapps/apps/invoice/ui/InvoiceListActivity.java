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
    private CommonEmptyView bHh;
    private RecyclerView bIN;
    private a bIO;
    private LinearLayout bIP;
    private View bIQ;
    private Button bIR;
    private RelativeLayout bIS;
    private String bIU;
    private String bIV;
    private RecyclerView.LayoutManager mLayoutManager;
    private int bIT = 0;
    private String mSource = "source_setting";
    private d.c bIW = new d.c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.d.c
        public void as(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.bIO != null) {
                InvoiceListActivity.this.removeLoadingView();
                InvoiceListActivity.this.bIO.al(list);
                InvoiceListActivity.this.Zc();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void kQ(String str) {
            InvoiceListActivity.this.n(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void aY(String str, String str2) {
            InvoiceListActivity.this.aZ(str, str2);
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
            this.bIU = intent.getStringExtra("ai_app_id");
            this.bIV = intent.getStringExtra("ai_app_key");
        }
    }

    private void E(Intent intent) {
        AiAppsBdActionBar XT = XT();
        XT.setTitle(getString(e.j.invoice_info_activity_title));
        if (intent != null) {
            this.bIT = intent.getIntExtra("bar_position", 0);
        }
        if (XT != null) {
            XT.setLeftFirstViewVisibility(this.bIT == 0);
        }
    }

    private void initView() {
        this.bIS = (RelativeLayout) findViewById(e.g.root_container);
        this.bIN = (RecyclerView) findViewById(e.g.invoice_list_view);
        this.bIR = (Button) findViewById(e.g.new_invoice_info_btn);
        this.bHh = (CommonEmptyView) findViewById(e.g.empty_view);
        this.bIP = (LinearLayout) findViewById(e.g.new_invoice_info_area);
        this.bIQ = findViewById(e.g.new_invoice_info_divider_line);
        this.bIN.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_list_bg));
        this.bIP.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_btn_area));
        this.bIQ.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_divider_line));
        this.bIR.setTextColor(getResources().getColor(e.d.invoice_create_new_btn_text));
        this.bIR.setBackgroundDrawable(getResources().getDrawable(e.f.invoice_create_new_btn_bg));
        this.bIO = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.bIN.setLayoutManager(this.mLayoutManager);
        this.bIN.setAdapter(this.bIO);
        Zc();
        this.bIO.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
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
        this.bIR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.Zf();
            }
        });
        Zd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zc() {
        if (this.bHh != null) {
            this.bHh.setTitle(getString(e.j.invoice_empty_title));
            this.bHh.setIcon(e.f.empty_icon_document);
            if (this.bIO != null && this.bIO.getItemCount() > 0) {
                this.bHh.setVisibility(8);
            } else {
                this.bHh.setVisibility(0);
            }
        }
    }

    private void Zd() {
        if (ba.bJ(this)) {
            Ze();
            return;
        }
        UniversalToast.makeText(this, "请先登录").showToast();
        finish();
    }

    private void Ze() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(this, this.bIU, this.bIV, this.bIW);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(this.bIW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        removeLoadingView();
        UniversalToast.makeText(this, "登录信息校验失败").showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(String str, String str2) {
        removeLoadingView();
        b.l(this, str, str2);
    }

    private void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.bIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.bIS);
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
            jSONObject.put("taxNumber", invoiceInfo.bHW);
            jSONObject.put("companyAddress", invoiceInfo.bHX);
            jSONObject.put("telephone", invoiceInfo.bHY);
            jSONObject.put("bankName", invoiceInfo.bHZ);
            jSONObject.put("bankAccount", invoiceInfo.bIa);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(invoiceInfo.mId, new d.InterfaceC0198d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.InterfaceC0198d
                public void be(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票成功");
                    if (InvoiceListActivity.this.bIO != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bIO.bg(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kQ(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aY(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票失败");
                    InvoiceListActivity.this.aZ(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    InvoiceListActivity.this.k(invoiceInfo);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).BV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.YW().a(invoiceInfo.mId, new d.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.b
                public void bd(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票成功");
                    if (InvoiceListActivity.this.bIO != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bIO.bf(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.bIO.bg(j);
                        }
                        InvoiceListActivity.this.Zc();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kQ(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aY(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票失败");
                    InvoiceListActivity.this.aZ(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bIT);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zf() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bIT);
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
                    if (this.bIO != null && invoiceInfo != null) {
                        this.bIO.m(invoiceInfo);
                        Zc();
                        break;
                    }
                    break;
                case 10002:
                    if (this.bIO != null && invoiceInfo != null) {
                        this.bIO.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
