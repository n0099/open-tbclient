package com.baidu.tieba.aiapps.apps.address;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.a.c;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class DeliveryListActivity extends TbSwanAppBaseActivity implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dbC;
    private ChooseAddressView dbF;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dbG = new ArrayList();
    private Handler dbH;
    private Bundle dbI;
    private boolean dbJ;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aEH();
    }

    private void aEH() {
        if (!c.aD(TbadkCoreApplication.getInst())) {
            c.a(this, (Bundle) null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                }
            });
        } else {
            init();
        }
    }

    private void init() {
        this.dbF = new ChooseAddressView(this);
        setContentView(this.dbF);
        aED();
        this.dbF.setDeliveryChooseListener(this);
        this.dbH = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.dbF.aJ(DeliveryListActivity.this.dbG);
                        DeliveryListActivity.this.aEJ();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aEP().H(this.dbI);
        aEI();
    }

    private void aED() {
        SwanAppBdActionBar aEv = aEv();
        if (TextUtils.equals(this.dbC, "aiapp")) {
            aEv.setTitle(R.string.delivery_title_choose);
            aEv.setLeftFirstViewVisibility(true);
            return;
        }
        aEv.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dbJ) {
            this.dbG = com.baidu.tieba.aiapps.apps.address.b.a.aEP().aES();
            this.dbF.aJ(this.dbG);
        }
    }

    private void aEI() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aES = com.baidu.tieba.aiapps.apps.address.b.a.aEP().aES();
        if (aES.size() > 0) {
            this.dbG = aES;
            this.dbF.aJ(this.dbG);
            aEJ();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aEQ = com.baidu.tieba.aiapps.apps.address.b.a.aEP().aEQ();
                if (aEQ != null && aEQ.size() > 0) {
                    DeliveryListActivity.this.dbG = aEQ;
                }
                DeliveryListActivity.this.dbH.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEJ() {
        showLoading();
        if (TextUtils.equals(this.dbC, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.dbI.putString("stoken", string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aEP().H(DeliveryListActivity.this.dbI);
                            DeliveryListActivity.this.aEK();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).LQ();
                }
            }, "dev");
        } else {
            aEK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEK() {
        com.baidu.tieba.aiapps.apps.address.b.a.aEP().a(new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aEL() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aE(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LQ();
                if (DeliveryListActivity.this.dbG == null || DeliveryListActivity.this.dbG.size() == 0) {
                    DeliveryListActivity.this.dbF.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aEJ();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dbF.aJ(list);
            this.dbG = list;
        } else if (this.dbG == null || this.dbG.size() <= 0) {
            this.dbF.showEmptyView();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        if (bVar != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("addrInfo", com.baidu.tieba.aiapps.apps.address.c.b.c(bVar).toString());
            bundle.putString("type", str);
            intent.putExtra("data", bundle);
            intent.putExtra("openSource", this.dbC);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, sT(str));
        }
    }

    private int sT(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -838846263:
                if (str.equals("update")) {
                    c = 1;
                    break;
                }
                break;
            case 96417:
                if (str.equals("add")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 256;
            case 1:
                return 257;
            default:
                return 0;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.dbJ = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mC(int i) {
        if (this.dbG != null && i < this.dbG.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dbG.get(i);
            if (TextUtils.equals(this.dbC, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.dbC, "aiapp")) {
                Intent intent = new Intent();
                intent.putExtra("data", com.baidu.tieba.aiapps.apps.address.c.b.d(bVar).toString());
                setResult(-1, intent);
                finish();
            }
        }
    }

    private void a(com.baidu.tieba.aiapps.apps.address.c.b bVar, final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
        bVar2.id = bVar.id;
        com.baidu.tieba.aiapps.apps.address.b.a.aEP().d(bVar2, new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aj(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.dbG.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dbG.get(i3);
                    bVar3.dcB = false;
                    if (i3 == i) {
                        bVar3.dcB = true;
                    }
                }
                DeliveryListActivity.this.dbF.aJ(DeliveryListActivity.this.dbG);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LQ();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mD(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.mE(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).agN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.dbG != null && i < this.dbG.size() && (bVar = this.dbG.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.dcB;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aEP().b(bVar2, new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aEL() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ak(String str, int i2) {
                    DeliveryListActivity.this.dbG.remove(i);
                    if (z && DeliveryListActivity.this.dbG.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dbG.get(0)).dcB = true;
                    }
                    DeliveryListActivity.this.dbJ = true;
                    DeliveryListActivity.this.dbF.aJ(DeliveryListActivity.this.dbG);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").LQ();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.dbI = intent.getBundleExtra("addrParams");
        if (this.dbI != null) {
            String string = this.dbI.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dbC = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dbJ) {
            com.baidu.tieba.aiapps.apps.address.b.a.aEP().aER();
        }
    }
}
