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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InvoiceListActivity extends TbSwanAppBaseActivity {
    private CommonEmptyView cSC;
    private RecyclerView cUk;
    private a cUl;
    private LinearLayout cUm;
    private View cUn;
    private Button cUo;
    private RelativeLayout cUp;
    private String cUr;
    private String cUs;
    private RecyclerView.LayoutManager mLayoutManager;
    private int cUq = 0;
    private String mSource = "source_setting";
    private c.InterfaceC0267c cUt = new c.InterfaceC0267c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0267c
        public void aE(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cUl != null) {
                InvoiceListActivity.this.uB();
                InvoiceListActivity.this.cUl.ay(list);
                InvoiceListActivity.this.azj();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void ry(String str) {
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
            this.cUr = intent.getStringExtra("appId");
            this.cUs = intent.getStringExtra("appKey");
        }
    }

    private void U(Intent intent) {
        SwanAppBdActionBar axU = axU();
        axU.setTitle(getString(d.j.invoice_info_activity_title));
        if (intent != null) {
            this.cUq = intent.getIntExtra("bar_position", 0);
        }
        if (axU != null) {
            axU.setLeftFirstViewVisibility(this.cUq == 0);
        }
    }

    private void initView() {
        this.cUp = (RelativeLayout) findViewById(d.g.root_container);
        this.cUk = (RecyclerView) findViewById(d.g.invoice_list_view);
        this.cUo = (Button) findViewById(d.g.new_invoice_info_btn);
        this.cSC = (CommonEmptyView) findViewById(d.g.empty_view);
        this.cUm = (LinearLayout) findViewById(d.g.new_invoice_info_area);
        this.cUn = findViewById(d.g.new_invoice_info_divider_line);
        this.cUk.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_list_bg));
        this.cUm.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_create_new_btn_area));
        this.cUn.setBackgroundDrawable(getResources().getDrawable(d.C0277d.invoice_create_new_divider_line));
        this.cUo.setTextColor(getResources().getColor(d.C0277d.invoice_create_new_btn_text));
        this.cUo.setBackgroundDrawable(getResources().getDrawable(d.f.invoice_create_new_btn_bg));
        this.cUl = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cUk.setLayoutManager(this.mLayoutManager);
        this.cUk.setAdapter(this.cUl);
        azj();
        this.cUl.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
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
        this.cUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.azm();
            }
        });
        azk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azj() {
        if (this.cSC != null) {
            this.cSC.setTitle(getString(d.j.invoice_empty_title));
            this.cSC.setIcon(d.f.empty_icon_document);
            if (this.cUl != null && this.cUl.getItemCount() > 0) {
                this.cSC.setVisibility(8);
            } else {
                this.cSC.setVisibility(0);
            }
        }
    }

    private void azk() {
        if (bc.cZ(this)) {
            azl();
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this, "请先登录").II();
        finish();
    }

    private void azl() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(this, this.cUr, this.cUs, this.cUt);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(this.cUt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        uB();
        com.baidu.swan.apps.res.widget.b.d.a(this, "登录信息校验失败").II();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(String str, String str2) {
        uB();
        com.baidu.tieba.aiapps.apps.invoice.a.m(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.cUp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.cUp);
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
            jSONObject.put("taxNumber", invoiceInfo.cTu);
            jSONObject.put("companyAddress", invoiceInfo.cTv);
            jSONObject.put("telephone", invoiceInfo.cTw);
            jSONObject.put("bankName", invoiceInfo.cTx);
            jSONObject.put("bankAccount", invoiceInfo.cTy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bG(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cUl != null) {
                        InvoiceListActivity.this.uB();
                        InvoiceListActivity.this.cUl.bI(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ry(String str) {
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
        bVar.d(getPageContext()).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azc().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bF(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cUl != null) {
                        InvoiceListActivity.this.uB();
                        InvoiceListActivity.this.cUl.bH(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cUl.bI(j);
                        }
                        InvoiceListActivity.this.azj();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ry(String str) {
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
        intent.putExtra("bar_position", this.cUq);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azm() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.cUq);
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
                    com.baidu.swan.apps.res.widget.b.d.l(this, d.j.invoice_toast_create_success).II();
                    if (this.cUl != null && invoiceInfo != null) {
                        this.cUl.m(invoiceInfo);
                        azj();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cUl != null && invoiceInfo != null) {
                        this.cUl.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
