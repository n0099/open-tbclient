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
    private CommonEmptyView det;
    private SwanAppBdActionBar dfC;
    private RecyclerView dgb;
    private com.baidu.tieba.aiapps.apps.invoice.ui.a dgc;
    private LinearLayout dgd;
    private View dge;
    private Button dgf;
    private RelativeLayout dgg;
    private String dgh;
    private String dgi;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0294c dgj = new c.InterfaceC0294c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0294c
        public void aL(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.dgc != null) {
                InvoiceListActivity.this.vQ();
                InvoiceListActivity.this.dgc.aF(list);
                InvoiceListActivity.this.aGy();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void tz(String str) {
            InvoiceListActivity.this.u(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void cp(String str, String str2) {
            InvoiceListActivity.this.cq(str, str2);
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_list);
        ab(getIntent());
        aGx();
        initView();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.dgh = intent.getStringExtra("appId");
            this.dgi = intent.getStringExtra("appKey");
        }
    }

    private void aGx() {
        this.dfC = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        this.dfC.setTitle(getString(R.string.invoice_info_activity_title));
        this.dfC.setLeftFirstViewVisibility(true);
        this.dfC.setRightMenuVisibility(false);
        this.dfC.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.dgg = (RelativeLayout) findViewById(R.id.root_container);
        this.dgb = (RecyclerView) findViewById(R.id.invoice_list_view);
        this.dgf = (Button) findViewById(R.id.new_invoice_info_btn);
        this.det = (CommonEmptyView) findViewById(R.id.empty_view);
        this.dgd = (LinearLayout) findViewById(R.id.new_invoice_info_area);
        this.dge = findViewById(R.id.new_invoice_info_divider_line);
        this.dgb.setBackground(getResources().getDrawable(R.color.invoice_list_bg));
        this.dgd.setBackground(getResources().getDrawable(R.color.invoice_create_new_btn_area));
        this.dge.setBackground(getResources().getDrawable(R.color.invoice_create_new_divider_line));
        this.dgf.setTextColor(getResources().getColor(R.color.invoice_create_new_btn_text));
        this.dgf.setBackground(getResources().getDrawable(R.drawable.invoice_create_new_btn_bg));
        this.dgc = new com.baidu.tieba.aiapps.apps.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.dgb.setLayoutManager(this.mLayoutManager);
        this.dgb.setAdapter(this.dgc);
        aGy();
        this.dgc.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
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
        this.dgf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aGB();
            }
        });
        aGz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGy() {
        if (this.det != null) {
            this.det.setTitle(getString(R.string.invoice_empty_title));
            this.det.setIcon(R.drawable.empty_icon_document);
            if (this.dgc != null && this.dgc.getItemCount() > 0) {
                this.det.setVisibility(8);
            } else {
                this.det.setVisibility(0);
            }
        }
    }

    private void aGz() {
        if (com.baidu.tieba.aiapps.apps.a.c.aD(this)) {
            aGA();
        } else {
            u(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGA() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aGp().a(this, this.dgh, this.dgi, this.dgj);
        } else {
            d.aGp().a(this.dgj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        vQ();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(String str, String str2) {
        vQ();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dgg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dgg);
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
            jSONObject.put("taxNumber", invoiceInfo.dfk);
            jSONObject.put("companyAddress", invoiceInfo.dfl);
            jSONObject.put("telephone", invoiceInfo.dfm);
            jSONObject.put("bankName", invoiceInfo.dfn);
            jSONObject.put("bankAccount", invoiceInfo.dfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGp().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bZ(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.dgc != null) {
                        InvoiceListActivity.this.vQ();
                        InvoiceListActivity.this.dgc.cb(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void tz(String str) {
                    InvoiceListActivity.this.u(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cp(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.cq(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tieba.aiapps.apps.widget.a aVar = new com.baidu.tieba.aiapps.apps.widget.a(this.dgb);
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
            d.aGp().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bY(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.dgc != null) {
                        InvoiceListActivity.this.vQ();
                        InvoiceListActivity.this.dgc.ca(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.dgc.cb(j);
                        }
                        InvoiceListActivity.this.aGy();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void tz(String str) {
                    InvoiceListActivity.this.u(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void cp(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.cq(str, str2);
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
    public void aGB() {
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
                    com.baidu.swan.apps.res.widget.b.d.k(this, R.string.invoice_toast_create_success).LU();
                    if (this.dgc != null && invoiceInfo != null) {
                        this.dgc.m(invoiceInfo);
                        aGy();
                        break;
                    }
                    break;
                case 10002:
                    if (this.dgc != null && invoiceInfo != null) {
                        this.dgc.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> dgm;
        private boolean dgn;
        private boolean dgo;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.dgm = new WeakReference<>(invoiceListActivity);
            this.dgn = z;
            this.dgo = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.dgm.get();
            if (invoiceListActivity != null) {
                if (com.baidu.tieba.aiapps.apps.a.c.aD(invoiceListActivity)) {
                    if (this.dgn) {
                        invoiceListActivity.aGA();
                    }
                } else if (this.dgo) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}
