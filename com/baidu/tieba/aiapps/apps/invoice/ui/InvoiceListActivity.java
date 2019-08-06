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
    private CommonEmptyView dcG;
    private SwanAppBdActionBar ddQ;
    private RecyclerView dep;
    private com.baidu.tieba.aiapps.apps.invoice.ui.a deq;
    private LinearLayout der;
    private View det;
    private Button deu;
    private RelativeLayout dev;
    private String dew;
    private String dex;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0285c dey = new c.InterfaceC0285c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0285c
        public void aL(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.deq != null) {
                InvoiceListActivity.this.vM();
                InvoiceListActivity.this.deq.aF(list);
                InvoiceListActivity.this.aFU();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void ta(String str) {
            InvoiceListActivity.this.u(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void co(String str, String str2) {
            InvoiceListActivity.this.cp(str, str2);
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_list);
        ab(getIntent());
        aFT();
        initView();
    }

    private void ab(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.dew = intent.getStringExtra("appId");
            this.dex = intent.getStringExtra("appKey");
        }
    }

    private void aFT() {
        this.ddQ = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        this.ddQ.setTitle(getString(R.string.invoice_info_activity_title));
        this.ddQ.setLeftFirstViewVisibility(true);
        this.ddQ.setRightMenuVisibility(false);
        this.ddQ.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.dev = (RelativeLayout) findViewById(R.id.root_container);
        this.dep = (RecyclerView) findViewById(R.id.invoice_list_view);
        this.deu = (Button) findViewById(R.id.new_invoice_info_btn);
        this.dcG = (CommonEmptyView) findViewById(R.id.empty_view);
        this.der = (LinearLayout) findViewById(R.id.new_invoice_info_area);
        this.det = findViewById(R.id.new_invoice_info_divider_line);
        this.dep.setBackground(getResources().getDrawable(R.color.invoice_list_bg));
        this.der.setBackground(getResources().getDrawable(R.color.invoice_create_new_btn_area));
        this.det.setBackground(getResources().getDrawable(R.color.invoice_create_new_divider_line));
        this.deu.setTextColor(getResources().getColor(R.color.invoice_create_new_btn_text));
        this.deu.setBackground(getResources().getDrawable(R.drawable.invoice_create_new_btn_bg));
        this.deq = new com.baidu.tieba.aiapps.apps.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.dep.setLayoutManager(this.mLayoutManager);
        this.dep.setAdapter(this.deq);
        aFU();
        this.deq.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
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
        this.deu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aFX();
            }
        });
        aFV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFU() {
        if (this.dcG != null) {
            this.dcG.setTitle(getString(R.string.invoice_empty_title));
            this.dcG.setIcon(R.drawable.empty_icon_document);
            if (this.deq != null && this.deq.getItemCount() > 0) {
                this.dcG.setVisibility(8);
            } else {
                this.dcG.setVisibility(0);
            }
        }
    }

    private void aFV() {
        if (com.baidu.tieba.aiapps.apps.a.c.aD(this)) {
            aFW();
        } else {
            u(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFW() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aFL().a(this, this.dew, this.dex, this.dey);
        } else {
            d.aFL().a(this.dey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        vM();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(String str, String str2) {
        vM();
        com.baidu.tieba.aiapps.apps.invoice.a.p(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.dev);
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
            jSONObject.put("taxNumber", invoiceInfo.ddy);
            jSONObject.put("companyAddress", invoiceInfo.ddz);
            jSONObject.put("telephone", invoiceInfo.ddA);
            jSONObject.put("bankName", invoiceInfo.ddB);
            jSONObject.put("bankAccount", invoiceInfo.ddC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aFL().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bW(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.deq != null) {
                        InvoiceListActivity.this.vM();
                        InvoiceListActivity.this.deq.bY(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ta(String str) {
                    InvoiceListActivity.this.u(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void co(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.cp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tieba.aiapps.apps.widget.a aVar = new com.baidu.tieba.aiapps.apps.widget.a(this.dep);
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
            d.aFL().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bV(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.deq != null) {
                        InvoiceListActivity.this.vM();
                        InvoiceListActivity.this.deq.bX(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.deq.bY(j);
                        }
                        InvoiceListActivity.this.aFU();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ta(String str) {
                    InvoiceListActivity.this.u(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void co(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.cp(str, str2);
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
    public void aFX() {
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
                    com.baidu.swan.apps.res.widget.b.d.k(this, R.string.invoice_toast_create_success).LQ();
                    if (this.deq != null && invoiceInfo != null) {
                        this.deq.m(invoiceInfo);
                        aFU();
                        break;
                    }
                    break;
                case 10002:
                    if (this.deq != null && invoiceInfo != null) {
                        this.deq.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> deB;
        private boolean deC;
        private boolean deD;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.deB = new WeakReference<>(invoiceListActivity);
            this.deC = z;
            this.deD = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.deB.get();
            if (invoiceListActivity != null) {
                if (com.baidu.tieba.aiapps.apps.a.c.aD(invoiceListActivity)) {
                    if (this.deC) {
                        invoiceListActivity.aFW();
                    }
                } else if (this.deD) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}
