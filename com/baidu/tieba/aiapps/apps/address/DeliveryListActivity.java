package com.baidu.tieba.aiapps.apps.address;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    private String cZV;
    private ChooseAddressView cZY;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cZZ = new ArrayList();
    private Handler daa;
    private Bundle dab;
    private boolean dac;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aDp();
    }

    private void aDp() {
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
        this.cZY = new ChooseAddressView(this);
        setContentView(this.cZY);
        aDl();
        this.cZY.setDeliveryChooseListener(this);
        this.daa = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cZY.aJ(DeliveryListActivity.this.cZZ);
                        DeliveryListActivity.this.aDr();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aDx().H(this.dab);
        aDq();
    }

    private void aDl() {
        SwanAppBdActionBar aDd = aDd();
        if (TextUtils.equals(this.cZV, "aiapp")) {
            aDd.setTitle(R.string.delivery_title_choose);
            aDd.setLeftFirstViewVisibility(true);
            return;
        }
        aDd.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dac) {
            this.cZZ = com.baidu.tieba.aiapps.apps.address.b.a.aDx().aDA();
            this.cZY.aJ(this.cZZ);
        }
    }

    private void aDq() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aDA = com.baidu.tieba.aiapps.apps.address.b.a.aDx().aDA();
        if (aDA.size() > 0) {
            this.cZZ = aDA;
            this.cZY.aJ(this.cZZ);
            aDr();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aDy = com.baidu.tieba.aiapps.apps.address.b.a.aDx().aDy();
                if (aDy != null && aDy.size() > 0) {
                    DeliveryListActivity.this.cZZ = aDy;
                }
                DeliveryListActivity.this.daa.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDr() {
        showLoading();
        if (TextUtils.equals(this.cZV, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.dab.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aDx().H(DeliveryListActivity.this.dab);
                            DeliveryListActivity.this.aDs();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).Ld();
                }
            }, "dev");
        } else {
            aDs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDs() {
        com.baidu.tieba.aiapps.apps.address.b.a.aDx().a(new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aDt() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aE(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).Ld();
                if (DeliveryListActivity.this.cZZ == null || DeliveryListActivity.this.cZZ.size() == 0) {
                    DeliveryListActivity.this.cZY.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aDr();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cZY.aJ(list);
            this.cZZ = list;
        } else if (this.cZZ == null || this.cZZ.size() <= 0) {
            this.cZY.showEmptyView();
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
            intent.putExtra("openSource", this.cZV);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, sB(str));
        }
    }

    private int sB(String str) {
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
            this.dac = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mu(int i) {
        if (this.cZZ != null && i < this.cZZ.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cZZ.get(i);
            if (TextUtils.equals(this.cZV, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cZV, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aDx().d(bVar2, new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aj(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cZZ.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cZZ.get(i3);
                    bVar3.daU = false;
                    if (i3 == i) {
                        bVar3.daU = true;
                    }
                }
                DeliveryListActivity.this.cZY.aJ(DeliveryListActivity.this.cZZ);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).Ld();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mv(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.mw(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).afJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.cZZ != null && i < this.cZZ.size() && (bVar = this.cZZ.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.daU;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aDx().b(bVar2, new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aDt() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ak(String str, int i2) {
                    DeliveryListActivity.this.cZZ.remove(i);
                    if (z && DeliveryListActivity.this.cZZ.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cZZ.get(0)).daU = true;
                    }
                    DeliveryListActivity.this.dac = true;
                    DeliveryListActivity.this.cZY.aJ(DeliveryListActivity.this.cZZ);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").Ld();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.dab = intent.getBundleExtra("addrParams");
        if (this.dab != null) {
            String string = this.dab.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cZV = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dac) {
            com.baidu.tieba.aiapps.apps.address.b.a.aDx().aDz();
        }
    }
}
