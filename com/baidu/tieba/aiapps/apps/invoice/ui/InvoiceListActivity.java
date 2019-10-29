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
    private CommonEmptyView dnN;
    private SwanAppBdActionBar doX;
    private Button dpA;
    private RelativeLayout dpB;
    private String dpC;
    private String dpD;
    private RecyclerView dpw;
    private com.baidu.tieba.aiapps.apps.invoice.ui.a dpx;
    private LinearLayout dpy;
    private View dpz;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0326c dpE = new c.InterfaceC0326c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0326c
        public void be(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.dpx != null) {
                InvoiceListActivity.this.AK();
                InvoiceListActivity.this.dpx.aY(list);
                InvoiceListActivity.this.aGL();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void si(String str) {
            InvoiceListActivity.this.x(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.c
        public void ci(String str, String str2) {
            InvoiceListActivity.this.cj(str, str2);
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invoice_list);
        ah(getIntent());
        aGK();
        initView();
    }

    private void ah(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.dpC = intent.getStringExtra("appId");
            this.dpD = intent.getStringExtra("appKey");
        }
    }

    private void aGK() {
        this.doX = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        this.doX.setTitle(getString(R.string.invoice_info_activity_title));
        this.doX.setLeftFirstViewVisibility(true);
        this.doX.setRightMenuVisibility(false);
        this.doX.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.dpB = (RelativeLayout) findViewById(R.id.root_container);
        this.dpw = (RecyclerView) findViewById(R.id.invoice_list_view);
        this.dpA = (Button) findViewById(R.id.new_invoice_info_btn);
        this.dnN = (CommonEmptyView) findViewById(R.id.empty_view);
        this.dpy = (LinearLayout) findViewById(R.id.new_invoice_info_area);
        this.dpz = findViewById(R.id.new_invoice_info_divider_line);
        this.dpw.setBackground(getResources().getDrawable(R.color.invoice_list_bg));
        this.dpy.setBackground(getResources().getDrawable(R.color.invoice_create_new_btn_area));
        this.dpz.setBackground(getResources().getDrawable(R.color.invoice_create_new_divider_line));
        this.dpA.setTextColor(getResources().getColor(R.color.invoice_create_new_btn_text));
        this.dpA.setBackground(getResources().getDrawable(R.drawable.invoice_create_new_btn_bg));
        this.dpx = new com.baidu.tieba.aiapps.apps.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.dpw.setLayoutManager(this.mLayoutManager);
        this.dpw.setAdapter(this.dpx);
        aGL();
        this.dpx.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
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
        this.dpA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aGO();
            }
        });
        aGM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGL() {
        if (this.dnN != null) {
            this.dnN.setTitle(getString(R.string.invoice_empty_title));
            this.dnN.setIcon(R.drawable.empty_icon_document);
            if (this.dpx != null && this.dpx.getItemCount() > 0) {
                this.dnN.setVisibility(8);
            } else {
                this.dnN.setVisibility(0);
            }
        }
    }

    private void aGM() {
        if (com.baidu.tieba.aiapps.apps.a.c.isLogin(this)) {
            aGN();
        } else {
            x(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGN() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aGC().a(this, this.dpC, this.dpD, this.dpE);
        } else {
            d.aGC().a(this.dpE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        AK();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(String str, String str2) {
        AK();
        com.baidu.tieba.aiapps.apps.invoice.a.q(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.dpB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.dpB);
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
            jSONObject.put("taxNumber", invoiceInfo.doF);
            jSONObject.put("companyAddress", invoiceInfo.doG);
            jSONObject.put("telephone", invoiceInfo.doH);
            jSONObject.put("bankName", invoiceInfo.doI);
            jSONObject.put("bankAccount", invoiceInfo.doJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGC().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bO(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.dpx != null) {
                        InvoiceListActivity.this.AK();
                        InvoiceListActivity.this.dpx.bQ(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void si(String str) {
                    InvoiceListActivity.this.x(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ci(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.cj(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.tieba.aiapps.apps.widget.a aVar = new com.baidu.tieba.aiapps.apps.widget.a(this.dpw);
        aVar.s(0, R.string.invoice_menu_delete, R.drawable.menu_delete);
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
            d.aGC().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bN(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.dpx != null) {
                        InvoiceListActivity.this.AK();
                        InvoiceListActivity.this.dpx.bP(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.dpx.bQ(j);
                        }
                        InvoiceListActivity.this.aGL();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void si(String str) {
                    InvoiceListActivity.this.x(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.c
                public void ci(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.cj(str, str2);
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
    public void aGO() {
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
                    com.baidu.swan.apps.res.widget.b.d.i(this, R.string.invoice_toast_create_success).QN();
                    if (this.dpx != null && invoiceInfo != null) {
                        this.dpx.m(invoiceInfo);
                        aGL();
                        break;
                    }
                    break;
                case 10002:
                    if (this.dpx != null && invoiceInfo != null) {
                        this.dpx.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> dpH;
        private boolean dpI;
        private boolean dpJ;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.dpH = new WeakReference<>(invoiceListActivity);
            this.dpI = z;
            this.dpJ = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.dpH.get();
            if (invoiceListActivity != null) {
                if (com.baidu.tieba.aiapps.apps.a.c.isLogin(invoiceListActivity)) {
                    if (this.dpI) {
                        invoiceListActivity.aGN();
                    }
                } else if (this.dpJ) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}
