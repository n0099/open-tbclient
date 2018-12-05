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
    private CommonEmptyView bGq;
    private RecyclerView bHW;
    private a bHX;
    private LinearLayout bHY;
    private View bHZ;
    private Button bIa;
    private RelativeLayout bIb;
    private String bId;
    private String bIe;
    private RecyclerView.LayoutManager mLayoutManager;
    private int bIc = 0;
    private String mSource = "source_setting";
    private d.c bIf = new d.c() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.3
        @Override // com.baidu.tieba.aiapps.apps.invoice.d.c
        public void ar(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.bHX != null) {
                InvoiceListActivity.this.removeLoadingView();
                InvoiceListActivity.this.bHX.ak(list);
                InvoiceListActivity.this.YD();
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void kz(String str) {
            InvoiceListActivity.this.n(true, false);
        }

        @Override // com.baidu.tieba.aiapps.apps.invoice.d
        public void aX(String str, String str2) {
            InvoiceListActivity.this.aY(str, str2);
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
            this.bId = intent.getStringExtra("ai_app_id");
            this.bIe = intent.getStringExtra("ai_app_key");
        }
    }

    private void E(Intent intent) {
        AiAppsBdActionBar Xu = Xu();
        Xu.setTitle(getString(e.j.invoice_info_activity_title));
        if (intent != null) {
            this.bIc = intent.getIntExtra("bar_position", 0);
        }
        if (Xu != null) {
            Xu.setLeftFirstViewVisibility(this.bIc == 0);
        }
    }

    private void initView() {
        this.bIb = (RelativeLayout) findViewById(e.g.root_container);
        this.bHW = (RecyclerView) findViewById(e.g.invoice_list_view);
        this.bIa = (Button) findViewById(e.g.new_invoice_info_btn);
        this.bGq = (CommonEmptyView) findViewById(e.g.empty_view);
        this.bHY = (LinearLayout) findViewById(e.g.new_invoice_info_area);
        this.bHZ = findViewById(e.g.new_invoice_info_divider_line);
        this.bHW.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_list_bg));
        this.bHY.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_btn_area));
        this.bHZ.setBackgroundDrawable(getResources().getDrawable(e.d.invoice_create_new_divider_line));
        this.bIa.setTextColor(getResources().getColor(e.d.invoice_create_new_btn_text));
        this.bIa.setBackgroundDrawable(getResources().getDrawable(e.f.invoice_create_new_btn_bg));
        this.bHX = new a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.bHW.setLayoutManager(this.mLayoutManager);
        this.bHW.setAdapter(this.bHX);
        YD();
        this.bHX.a(new a.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.1
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
        this.bIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.YG();
            }
        });
        YE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YD() {
        if (this.bGq != null) {
            this.bGq.setTitle(getString(e.j.invoice_empty_title));
            this.bGq.setIcon(e.f.empty_icon_document);
            if (this.bHX != null && this.bHX.getItemCount() > 0) {
                this.bGq.setVisibility(8);
            } else {
                this.bGq.setVisibility(0);
            }
        }
    }

    private void YE() {
        if (ba.bJ(this)) {
            YF();
            return;
        }
        UniversalToast.makeText(this, "请先登录").showToast();
        finish();
    }

    private void YF() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.tieba.aiapps.apps.invoice.e.Yx().a(this, this.bId, this.bIe, this.bIf);
        } else {
            com.baidu.tieba.aiapps.apps.invoice.e.Yx().a(this.bIf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        removeLoadingView();
        UniversalToast.makeText(this, "登录信息校验失败").showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
        removeLoadingView();
        b.j(this, str, str2);
    }

    private void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.bIb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.bIb);
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
            jSONObject.put("taxNumber", invoiceInfo.bHf);
            jSONObject.put("companyAddress", invoiceInfo.bHg);
            jSONObject.put("telephone", invoiceInfo.bHh);
            jSONObject.put("bankName", invoiceInfo.bHi);
            jSONObject.put("bankAccount", invoiceInfo.bHj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Yx().a(invoiceInfo.mId, new d.InterfaceC0198d() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.4
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.InterfaceC0198d
                public void bd(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票成功");
                    if (InvoiceListActivity.this.bHX != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bHX.bf(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kz(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aX(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "修改默认发票失败");
                    InvoiceListActivity.this.aY(str, str2);
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
        bVar.d(getPageContext()).BI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            com.baidu.tieba.aiapps.apps.invoice.e.Yx().a(invoiceInfo.mId, new d.b() { // from class: com.baidu.tieba.aiapps.apps.invoice.ui.InvoiceListActivity.6
                @Override // com.baidu.tieba.aiapps.apps.invoice.d.b
                public void bc(long j) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票成功");
                    if (InvoiceListActivity.this.bHX != null) {
                        InvoiceListActivity.this.removeLoadingView();
                        InvoiceListActivity.this.bHX.be(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.bHX.bf(j);
                        }
                        InvoiceListActivity.this.YD();
                    }
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void kz(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.tieba.aiapps.apps.invoice.d
                public void aX(String str, String str2) {
                    AiAppsLog.i(ChooseInvoiceAction.MODULE_TAG, "删除发票失败");
                    InvoiceListActivity.this.aY(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bIc);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YG() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("bar_position", this.bIc);
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
                    if (this.bHX != null && invoiceInfo != null) {
                        this.bHX.m(invoiceInfo);
                        YD();
                        break;
                    }
                    break;
                case 10002:
                    if (this.bHX != null && invoiceInfo != null) {
                        this.bHX.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
