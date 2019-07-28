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
    private Handler dbA;
    private Bundle dbB;
    private boolean dbC;
    private String dbv;
    private ChooseAddressView dby;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dbz = new ArrayList();

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aEF();
    }

    private void aEF() {
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
        this.dby = new ChooseAddressView(this);
        setContentView(this.dby);
        aEB();
        this.dby.setDeliveryChooseListener(this);
        this.dbA = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.dby.aJ(DeliveryListActivity.this.dbz);
                        DeliveryListActivity.this.aEH();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aEN().H(this.dbB);
        aEG();
    }

    private void aEB() {
        SwanAppBdActionBar aEt = aEt();
        if (TextUtils.equals(this.dbv, "aiapp")) {
            aEt.setTitle(R.string.delivery_title_choose);
            aEt.setLeftFirstViewVisibility(true);
            return;
        }
        aEt.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dbC) {
            this.dbz = com.baidu.tieba.aiapps.apps.address.b.a.aEN().aEQ();
            this.dby.aJ(this.dbz);
        }
    }

    private void aEG() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aEQ = com.baidu.tieba.aiapps.apps.address.b.a.aEN().aEQ();
        if (aEQ.size() > 0) {
            this.dbz = aEQ;
            this.dby.aJ(this.dbz);
            aEH();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aEO = com.baidu.tieba.aiapps.apps.address.b.a.aEN().aEO();
                if (aEO != null && aEO.size() > 0) {
                    DeliveryListActivity.this.dbz = aEO;
                }
                DeliveryListActivity.this.dbA.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEH() {
        showLoading();
        if (TextUtils.equals(this.dbv, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.dbB.putString("stoken", string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aEN().H(DeliveryListActivity.this.dbB);
                            DeliveryListActivity.this.aEI();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).LQ();
                }
            }, "dev");
        } else {
            aEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEI() {
        com.baidu.tieba.aiapps.apps.address.b.a.aEN().a(new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aEJ() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aE(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LQ();
                if (DeliveryListActivity.this.dbz == null || DeliveryListActivity.this.dbz.size() == 0) {
                    DeliveryListActivity.this.dby.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aEH();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dby.aJ(list);
            this.dbz = list;
        } else if (this.dbz == null || this.dbz.size() <= 0) {
            this.dby.showEmptyView();
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
            intent.putExtra("openSource", this.dbv);
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
            this.dbC = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mB(int i) {
        if (this.dbz != null && i < this.dbz.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dbz.get(i);
            if (TextUtils.equals(this.dbv, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.dbv, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aEN().d(bVar2, new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aj(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.dbz.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dbz.get(i3);
                    bVar3.dct = false;
                    if (i3 == i) {
                        bVar3.dct = true;
                    }
                }
                DeliveryListActivity.this.dby.aJ(DeliveryListActivity.this.dbz);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LQ();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mC(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.mD(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).agL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.dbz != null && i < this.dbz.size() && (bVar = this.dbz.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.dct;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aEN().b(bVar2, new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aEJ() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ak(String str, int i2) {
                    DeliveryListActivity.this.dbz.remove(i);
                    if (z && DeliveryListActivity.this.dbz.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dbz.get(0)).dct = true;
                    }
                    DeliveryListActivity.this.dbC = true;
                    DeliveryListActivity.this.dby.aJ(DeliveryListActivity.this.dbz);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").LQ();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.dbB = intent.getBundleExtra("addrParams");
        if (this.dbB != null) {
            String string = this.dbB.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dbv = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dbC) {
            com.baidu.tieba.aiapps.apps.address.b.a.aEN().aEP();
        }
    }
}
