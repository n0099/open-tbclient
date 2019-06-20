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
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.invoice.c;
import com.baidu.tieba.aiapps.apps.invoice.d;
import com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo;
import com.baidu.tieba.aiapps.apps.invoice.ui.a;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InvoiceListActivity extends BaseActivity {
    private CommonEmptyView dba;
    private RecyclerView dcI;
    private com.baidu.tieba.aiapps.apps.invoice.ui.a dcJ;
    private LinearLayout dcK;
    private View dcL;
    private Button dcM;
    private RelativeLayout dcN;
    private String dcO;
    private String dcP;
    private SwanAppBdActionBar dci;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0282c dcQ = new c.InterfaceC0282c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0282c
        public void aL(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.dcJ != null) {
                InvoiceListActivity.this.vl();
                InvoiceListActivity.this.dcJ.aF(list);
                InvoiceListActivity.this.aEB();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void sH(String str) {
            InvoiceListActivity.this.s(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void cn(String str, String str2) {
            InvoiceListActivity.this.co(str, str2);
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_list);
        Z(getIntent());
        aEA();
        initView();
    }

    private void Z(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.dcO = intent.getStringExtra("appId");
            this.dcP = intent.getStringExtra("appKey");
        }
    }

    private void aEA() {
        this.dci = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        this.dci.setTitle(getString(R.string.invoice_info_activity_title));
        this.dci.setLeftFirstViewVisibility(true);
        this.dci.setRightMenuVisibility(false);
        this.dci.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.dcN = (RelativeLayout) findViewById(R.id.root_container);
        this.dcI = (RecyclerView) findViewById(R.id.invoice_list_view);
        this.dcM = (Button) findViewById(R.id.new_invoice_info_btn);
        this.dba = (CommonEmptyView) findViewById(R.id.empty_view);
        this.dcK = (LinearLayout) findViewById(R.id.new_invoice_info_area);
        this.dcL = findViewById(R.id.new_invoice_info_divider_line);
        this.dcI.setBackground(getResources().getDrawable(R.color.invoice_list_bg));
        this.dcK.setBackground(getResources().getDrawable(R.color.invoice_create_new_btn_area));
        this.dcL.setBackground(getResources().getDrawable(R.color.invoice_create_new_divider_line));
        this.dcM.setTextColor(getResources().getColor(R.color.invoice_create_new_btn_text));
        this.dcM.setBackground(getResources().getDrawable(R.drawable.invoice_create_new_btn_bg));
        this.dcJ = new com.baidu.tieba.aiapps.apps.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.dcI.setLayoutManager(this.mLayoutManager);
        this.dcI.setAdapter(this.dcJ);
        aEB();
        this.dcJ.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
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
        this.dcM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aEE();
            }
        });
        aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        if (this.dba != null) {
            this.dba.setTitle(getString(R.string.invoice_empty_title));
            this.dba.setIcon(R.drawable.empty_icon_document);
            if (this.dcJ != null && this.dcJ.getItemCount() > 0) {
                this.dba.setVisibility(8);
            } else {
                this.dba.setVisibility(0);
            }
        }
    }

    private void aEC() {
        if (com.baidu.tieba.aiapps.apps.a.c.aD(this)) {
            aED();
        } else {
            s(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aED() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aEt().a(this, this.dcO, this.dcP, this.dcQ);
        } else {
            d.aEt().a(this.dcQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(String str, String str2) {
        vl();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dcN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dcN);
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
            jSONObject.put("taxNumber", invoiceInfo.dbP);
            jSONObject.put("companyAddress", invoiceInfo.dbQ);
            jSONObject.put("telephone", invoiceInfo.dbR);
            jSONObject.put("bankName", invoiceInfo.dbS);
            jSONObject.put("bankAccount", invoiceInfo.dbT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aEt().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bV(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.dcJ != null) {
                        InvoiceListActivity.this.vl();
                        InvoiceListActivity.this.dcJ.bX(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void sH(String str) {
                    InvoiceListActivity.this.s(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.co(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tieba.aiapps.apps.widget.a aVar = new com.baidu.tieba.aiapps.apps.widget.a(this.dcI);
        aVar.m(0, R.string.invoice_menu_delete, R.drawable.menu_delete);
        aVar.a(new b.a() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
            @Override // com.baidu.swan.apps.res.widget.a.b.a
            public void c(b bVar) {
                if (bVar != null && bVar.getItemId() == 0) {
                    InvoiceListActivity.this.k(invoiceInfo);
                }
            }
        });
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aEt().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bU(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.dcJ != null) {
                        InvoiceListActivity.this.vl();
                        InvoiceListActivity.this.dcJ.bW(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.dcJ.bX(j);
                        }
                        InvoiceListActivity.this.aEB();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void sH(String str) {
                    InvoiceListActivity.this.s(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.co(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEE() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
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
                    com.baidu.swan.apps.res.widget.b.d.k(this, R.string.invoice_toast_create_success).Ld();
                    if (this.dcJ != null && invoiceInfo != null) {
                        this.dcJ.m(invoiceInfo);
                        aEB();
                        break;
                    }
                    break;
                case 10002:
                    if (this.dcJ != null && invoiceInfo != null) {
                        this.dcJ.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements com.baidu.swan.apps.a.a {
        private WeakReference<InvoiceListActivity> dcT;
        private boolean dcU;
        private boolean dcV;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.dcT = new WeakReference<>(invoiceListActivity);
            this.dcU = z;
            this.dcV = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.dcT.get();
            if (invoiceListActivity != null) {
                if (com.baidu.tieba.aiapps.apps.a.c.aD(invoiceListActivity)) {
                    if (this.dcU) {
                        invoiceListActivity.aED();
                    }
                } else if (this.dcV) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}
