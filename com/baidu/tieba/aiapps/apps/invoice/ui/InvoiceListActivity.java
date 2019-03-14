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
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.a;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InvoiceListActivity extends TbSwanAppBaseActivity {
    private CommonEmptyView cSA;
    private RecyclerView cUi;
    private a cUj;
    private LinearLayout cUk;
    private View cUl;
    private Button cUm;
    private RelativeLayout cUn;
    private String cUp;
    private String cUq;
    private RecyclerView.LayoutManager mLayoutManager;
    private int cUo = 0;
    private String mSource = "source_setting";
    private c.InterfaceC0267c cUr = new c.InterfaceC0267c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0267c
        public void aE(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cUj != null) {
                InvoiceListActivity.this.uC();
                InvoiceListActivity.this.cUj.ay(list);
                InvoiceListActivity.this.azm();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void rx(String str) {
            InvoiceListActivity.this.r(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void cd(String str, String str2) {
            InvoiceListActivity.this.ce(str, str2);
        }
    };

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_invoice_list);
        W(getIntent());
        U(getIntent());
        initView();
    }

    private void W(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.cUp = intent.getStringExtra("appId");
            this.cUq = intent.getStringExtra(WBConstants.SSO_APP_KEY);
        }
    }

    private void U(Intent intent) {
        SwanAppBdActionBar axX = axX();
        axX.setTitle(getString(d.j.invoice_info_activity_title));
        if (intent != null) {
            this.cUo = intent.getIntExtra("bar_position", 0);
        }
        if (axX != null) {
            axX.setLeftFirstViewVisibility(this.cUo == 0);
        }
    }

    private void initView() {
        this.cUn = (RelativeLayout) findViewById(d.g.root_container);
        this.cUi = (RecyclerView) findViewById(d.g.invoice_list_view);
        this.cUm = (Button) findViewById(d.g.new_invoice_info_btn);
        this.cSA = (CommonEmptyView) findViewById(d.g.empty_view);
        this.cUk = (LinearLayout) findViewById(d.g.new_invoice_info_area);
        this.cUl = findViewById(d.g.new_invoice_info_divider_line);
        this.cUi.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_list_bg));
        this.cUk.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_create_new_btn_area));
        this.cUl.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_create_new_divider_line));
        this.cUm.setTextColor(getResources().getColor(d.C0277d.invoice_create_new_btn_text));
        this.cUm.setBackgroundDrawable(getResources().getDrawable(d.f.invoice_create_new_btn_bg));
        this.cUj = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cUi.setLayoutManager(this.mLayoutManager);
        this.cUi.setAdapter(this.cUj);
        azm();
        this.cUj.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
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
        this.cUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.azp();
            }
        });
        azn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azm() {
        if (this.cSA != null) {
            this.cSA.setTitle(getString(d.j.invoice_empty_title));
            this.cSA.setIcon(d.f.empty_icon_document);
            if (this.cUj != null && this.cUj.getItemCount() > 0) {
                this.cSA.setVisibility(8);
            } else {
                this.cSA.setVisibility(0);
            }
        }
    }

    private void azn() {
        if (bc.cZ(this)) {
            azo();
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this, "请先登录").IK();
        finish();
    }

    private void azo() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(this, this.cUp, this.cUq, this.cUr);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(this.cUr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        uC();
        com.baidu.swan.apps.res.widget.b.d.a(this, "登录信息校验失败").IK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str, String str2) {
        uC();
        com.baidu.tieba.aiapps.apps.invoice.a.m(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.cUn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.cUn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(InvoiceInfo invoiceInfo) {
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "选择发票");
            Intent intent = new Intent();
            intent.putExtra("invoiceInfo", h(invoiceInfo).toString());
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
            jSONObject.put("taxNumber", invoiceInfo.cTs);
            jSONObject.put("companyAddress", invoiceInfo.cTt);
            jSONObject.put("telephone", invoiceInfo.cTu);
            jSONObject.put("bankName", invoiceInfo.cTv);
            jSONObject.put("bankAccount", invoiceInfo.cTw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bG(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cUj != null) {
                        InvoiceListActivity.this.uC();
                        InvoiceListActivity.this.cUj.bI(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void rx(String str) {
                    InvoiceListActivity.this.r(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cd(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.ce(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        b bVar = new b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(d.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0225b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(b bVar2, int i, View view) {
                if (i == 0) {
                    InvoiceListActivity.this.k(invoiceInfo);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).abc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azf().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bF(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cUj != null) {
                        InvoiceListActivity.this.uC();
                        InvoiceListActivity.this.cUj.bH(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cUj.bI(j);
                        }
                        InvoiceListActivity.this.azm();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void rx(String str) {
                    InvoiceListActivity.this.r(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cd(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.ce(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.cUo);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azp() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.cUo);
        intent.putExtra("type", 1);
        startActivityForResult(intent, 10001);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            InvoiceInfo invoiceInfo = null;
            if (intent != null) {
                invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            }
            switch (i) {
                case 10001:
                    com.baidu.swan.apps.res.widget.b.d.l(this, d.j.invoice_toast_create_success).IK();
                    if (this.cUj != null && invoiceInfo != null) {
                        this.cUj.m(invoiceInfo);
                        azm();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cUj != null && invoiceInfo != null) {
                        this.cUj.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
