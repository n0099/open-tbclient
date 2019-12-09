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
import com.baidu.sapi2.activity.SlideActiviy;
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
    private CommonEmptyView dmV;
    private RecyclerView doF;
    private com.baidu.tieba.aiapps.apps.invoice.ui.a doG;
    private LinearLayout doH;
    private View doI;
    private Button doJ;
    private RelativeLayout doK;
    private String doL;
    private String doM;
    private SwanAppBdActionBar dog;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0321c doN = new c.InterfaceC0321c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.tieba.aiapps.apps.invoice.c.InterfaceC0321c
        public void be(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.doG != null) {
                InvoiceListActivity.this.AL();
                InvoiceListActivity.this.doG.aY(list);
                InvoiceListActivity.this.aGJ();
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
        aGI();
        initView();
    }

    private void ah(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.doL = intent.getStringExtra("appId");
            this.doM = intent.getStringExtra("appKey");
        }
    }

    private void aGI() {
        this.dog = (SwanAppBdActionBar) findViewById(R.id.bd_action_bar);
        this.dog.setTitle(getString(R.string.invoice_info_activity_title));
        this.dog.setLeftFirstViewVisibility(true);
        this.dog.setRightMenuVisibility(false);
        this.dog.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.doK = (RelativeLayout) findViewById(R.id.root_container);
        this.doF = (RecyclerView) findViewById(R.id.invoice_list_view);
        this.doJ = (Button) findViewById(R.id.new_invoice_info_btn);
        this.dmV = (CommonEmptyView) findViewById(R.id.empty_view);
        this.doH = (LinearLayout) findViewById(R.id.new_invoice_info_area);
        this.doI = findViewById(R.id.new_invoice_info_divider_line);
        this.doF.setBackground(getResources().getDrawable(R.color.invoice_list_bg));
        this.doH.setBackground(getResources().getDrawable(R.color.invoice_create_new_btn_area));
        this.doI.setBackground(getResources().getDrawable(R.color.invoice_create_new_divider_line));
        this.doJ.setTextColor(getResources().getColor(R.color.invoice_create_new_btn_text));
        this.doJ.setBackground(getResources().getDrawable(R.drawable.invoice_create_new_btn_bg));
        this.doG = new com.baidu.tieba.aiapps.apps.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.doF.setLayoutManager(this.mLayoutManager);
        this.doF.setAdapter(this.doG);
        aGJ();
        this.doG.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
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
        this.doJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aGM();
            }
        });
        aGK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGJ() {
        if (this.dmV != null) {
            this.dmV.setTitle(getString(R.string.invoice_empty_title));
            this.dmV.setIcon(R.drawable.empty_icon_document);
            if (this.doG != null && this.doG.getItemCount() > 0) {
                this.dmV.setVisibility(8);
            } else {
                this.dmV.setVisibility(0);
            }
        }
    }

    private void aGK() {
        if (com.baidu.tieba.aiapps.apps.a.c.isLogin(this)) {
            aGL();
        } else {
            x(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGL() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aGA().a(this, this.doL, this.doM, this.doN);
        } else {
            d.aGA().a(this.doN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        AL();
        com.baidu.tieba.aiapps.apps.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(String str, String str2) {
        AL();
        com.baidu.tieba.aiapps.apps.invoice.a.q(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.d(this, this.doK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.doK);
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
            jSONObject.put("taxNumber", invoiceInfo.dnN);
            jSONObject.put("companyAddress", invoiceInfo.dnO);
            jSONObject.put("telephone", invoiceInfo.dnP);
            jSONObject.put("bankName", invoiceInfo.dnQ);
            jSONObject.put("bankAccount", invoiceInfo.dnR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aGA().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.d
                public void bN(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.doG != null) {
                        InvoiceListActivity.this.AL();
                        InvoiceListActivity.this.doG.bP(invoiceInfo.mId);
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
        com.baidu.tieba.aiapps.apps.widget.a aVar = new com.baidu.tieba.aiapps.apps.widget.a(this.doF);
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
            d.aGA().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.tieba.aiapps.apps.invoice.c.b
                public void bM(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.doG != null) {
                        InvoiceListActivity.this.AL();
                        InvoiceListActivity.this.doG.bO(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.doG.bP(j);
                        }
                        InvoiceListActivity.this.aGJ();
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
        intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGM() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 1);
        startActivityForResult(intent, 10001);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            InvoiceInfo invoiceInfo = null;
            if (intent != null) {
                invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            }
            switch (i) {
                case 10001:
                    com.baidu.swan.apps.res.widget.b.d.i(this, R.string.invoice_toast_create_success).QO();
                    if (this.doG != null && invoiceInfo != null) {
                        this.doG.m(invoiceInfo);
                        aGJ();
                        break;
                    }
                    break;
                case 10002:
                    if (this.doG != null && invoiceInfo != null) {
                        this.doG.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> doQ;
        private boolean doR;
        private boolean doS;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.doQ = new WeakReference<>(invoiceListActivity);
            this.doR = z;
            this.doS = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.doQ.get();
            if (invoiceListActivity != null) {
                if (com.baidu.tieba.aiapps.apps.a.c.isLogin(invoiceListActivity)) {
                    if (this.doR) {
                        invoiceListActivity.aGL();
                    }
                } else if (this.doS) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}
