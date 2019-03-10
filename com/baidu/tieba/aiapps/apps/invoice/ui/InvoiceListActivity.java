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
    private CommonEmptyView cSE;
    private RecyclerView cUm;
    private a cUn;
    private LinearLayout cUo;
    private View cUp;
    private Button cUq;
    private RelativeLayout cUr;
    private String cUt;
    private String cUu;
    private RecyclerView.LayoutManager mLayoutManager;
    private int cUs = 0;
    private String mSource = "source_setting";
    private c.InterfaceC0228c cUv = new c.InterfaceC0228c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0228c
        public void aE(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cUn != null) {
                InvoiceListActivity.this.uC();
                InvoiceListActivity.this.cUn.ay(list);
                InvoiceListActivity.this.azn();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void rz(String str) {
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
            this.cUt = intent.getStringExtra("appId");
            this.cUu = intent.getStringExtra(WBConstants.SSO_APP_KEY);
        }
    }

    private void U(Intent intent) {
        SwanAppBdActionBar axY = axY();
        axY.setTitle(getString(d.j.invoice_info_activity_title));
        if (intent != null) {
            this.cUs = intent.getIntExtra("bar_position", 0);
        }
        if (axY != null) {
            axY.setLeftFirstViewVisibility(this.cUs == 0);
        }
    }

    private void initView() {
        this.cUr = (RelativeLayout) findViewById(d.g.root_container);
        this.cUm = (RecyclerView) findViewById(d.g.invoice_list_view);
        this.cUq = (Button) findViewById(d.g.new_invoice_info_btn);
        this.cSE = (CommonEmptyView) findViewById(d.g.empty_view);
        this.cUo = (LinearLayout) findViewById(d.g.new_invoice_info_area);
        this.cUp = findViewById(d.g.new_invoice_info_divider_line);
        this.cUm.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_list_bg));
        this.cUo.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_create_new_btn_area));
        this.cUp.setBackgroundDrawable(getResources().getDrawable(d.C0236d.invoice_create_new_divider_line));
        this.cUq.setTextColor(getResources().getColor(d.C0236d.invoice_create_new_btn_text));
        this.cUq.setBackgroundDrawable(getResources().getDrawable(d.f.invoice_create_new_btn_bg));
        this.cUn = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cUm.setLayoutManager(this.mLayoutManager);
        this.cUm.setAdapter(this.cUn);
        azn();
        this.cUn.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
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
        this.cUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.azq();
            }
        });
        azo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azn() {
        if (this.cSE != null) {
            this.cSE.setTitle(getString(d.j.invoice_empty_title));
            this.cSE.setIcon(d.f.empty_icon_document);
            if (this.cUn != null && this.cUn.getItemCount() > 0) {
                this.cSE.setVisibility(8);
            } else {
                this.cSE.setVisibility(0);
            }
        }
    }

    private void azo() {
        if (bc.cZ(this)) {
            azp();
            return;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this, "请先登录").IK();
        finish();
    }

    private void azp() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.d.azg().a(this, this.cUt, this.cUu, this.cUv);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.d.azg().a(this.cUv);
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
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.cUr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.cUr);
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
            jSONObject.put("taxNumber", invoiceInfo.cTw);
            jSONObject.put("companyAddress", invoiceInfo.cTx);
            jSONObject.put("telephone", invoiceInfo.cTy);
            jSONObject.put("bankName", invoiceInfo.cTz);
            jSONObject.put("bankAccount", invoiceInfo.cTA);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.d.azg().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bG(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cUn != null) {
                        InvoiceListActivity.this.uC();
                        InvoiceListActivity.this.cUn.bI(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void rz(String str) {
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
        bVar.a(arrayList, new b.InterfaceC0191b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
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
            com.baidu.tieba.aiapps.apps.invoice.d.azg().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bF(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cUn != null) {
                        InvoiceListActivity.this.uC();
                        InvoiceListActivity.this.cUn.bH(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cUn.bI(j);
                        }
                        InvoiceListActivity.this.azn();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void rz(String str) {
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
        intent.putExtra("bar_position", this.cUs);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azq() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.cUs);
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
                    if (this.cUn != null && invoiceInfo != null) {
                        this.cUn.m(invoiceInfo);
                        azn();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cUn != null && invoiceInfo != null) {
                        this.cUn.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
