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
    private String cZU;
    private ChooseAddressView cZX;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cZY = new ArrayList();
    private Handler cZZ;
    private Bundle daa;
    private boolean dab;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aDm();
    }

    private void aDm() {
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
        this.cZX = new ChooseAddressView(this);
        setContentView(this.cZX);
        aDi();
        this.cZX.setDeliveryChooseListener(this);
        this.cZZ = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cZX.aJ(DeliveryListActivity.this.cZY);
                        DeliveryListActivity.this.aDo();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aDu().H(this.daa);
        aDn();
    }

    private void aDi() {
        SwanAppBdActionBar aDa = aDa();
        if (TextUtils.equals(this.cZU, "aiapp")) {
            aDa.setTitle(R.string.delivery_title_choose);
            aDa.setLeftFirstViewVisibility(true);
            return;
        }
        aDa.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dab) {
            this.cZY = com.baidu.tieba.aiapps.apps.address.b.a.aDu().aDx();
            this.cZX.aJ(this.cZY);
        }
    }

    private void aDn() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aDx = com.baidu.tieba.aiapps.apps.address.b.a.aDu().aDx();
        if (aDx.size() > 0) {
            this.cZY = aDx;
            this.cZX.aJ(this.cZY);
            aDo();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aDv = com.baidu.tieba.aiapps.apps.address.b.a.aDu().aDv();
                if (aDv != null && aDv.size() > 0) {
                    DeliveryListActivity.this.cZY = aDv;
                }
                DeliveryListActivity.this.cZZ.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDo() {
        showLoading();
        if (TextUtils.equals(this.cZU, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.daa.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aDu().H(DeliveryListActivity.this.daa);
                            DeliveryListActivity.this.aDp();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).Ld();
                }
            }, "dev");
        } else {
            aDp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDp() {
        com.baidu.tieba.aiapps.apps.address.b.a.aDu().a(new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aDq() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aE(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).Ld();
                if (DeliveryListActivity.this.cZY == null || DeliveryListActivity.this.cZY.size() == 0) {
                    DeliveryListActivity.this.cZX.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aDo();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cZX.aJ(list);
            this.cZY = list;
        } else if (this.cZY == null || this.cZY.size() <= 0) {
            this.cZX.showEmptyView();
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
            intent.putExtra("openSource", this.cZU);
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
            this.dab = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mu(int i) {
        if (this.cZY != null && i < this.cZY.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cZY.get(i);
            if (TextUtils.equals(this.cZU, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cZU, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aDu().d(bVar2, new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aj(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cZY.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cZY.get(i3);
                    bVar3.daT = false;
                    if (i3 == i) {
                        bVar3.daT = true;
                    }
                }
                DeliveryListActivity.this.cZX.aJ(DeliveryListActivity.this.cZY);
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
        if (this.cZY != null && i < this.cZY.size() && (bVar = this.cZY.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.daT;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aDu().b(bVar2, new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aDq() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ak(String str, int i2) {
                    DeliveryListActivity.this.cZY.remove(i);
                    if (z && DeliveryListActivity.this.cZY.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cZY.get(0)).daT = true;
                    }
                    DeliveryListActivity.this.dab = true;
                    DeliveryListActivity.this.cZX.aJ(DeliveryListActivity.this.cZY);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").Ld();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.daa = intent.getBundleExtra("addrParams");
        if (this.daa != null) {
            String string = this.daa.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cZU = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dab) {
            com.baidu.tieba.aiapps.apps.address.b.a.aDu().aDw();
        }
    }
}
