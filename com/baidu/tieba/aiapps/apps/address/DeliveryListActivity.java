package com.baidu.tieba.aiapps.apps.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class DeliveryListActivity extends TbSwanAppBaseActivity implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cRA;
    private ChooseAddressView cRD;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRE = new ArrayList();
    private Handler cRF;
    private Bundle cRG;
    private boolean cRH;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aye();
    }

    private void aye() {
        if (!com.baidu.tieba.aiapps.apps.a.a.bk(TbadkCoreApplication.getInst())) {
            com.baidu.tieba.aiapps.apps.a.a.b(this, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                }
            });
        } else {
            init();
        }
    }

    private void init() {
        this.cRD = new ChooseAddressView(this);
        setContentView(this.cRD);
        aya();
        this.cRD.setDeliveryChooseListener(this);
        this.cRF = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cRD.aC(DeliveryListActivity.this.cRE);
                        DeliveryListActivity.this.ayg();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aym().G(this.cRG);
        ayf();
    }

    private void aya() {
        SwanAppBdActionBar axU = axU();
        if (TextUtils.equals(this.cRA, "aiapp")) {
            axU.setTitle(d.j.delivery_title_choose);
            axU.setLeftFirstViewVisibility(true);
            return;
        }
        axU.setTitle(d.j.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cRH) {
            this.cRE = com.baidu.tieba.aiapps.apps.address.b.a.aym().ayp();
            this.cRD.aC(this.cRE);
        }
    }

    private void ayf() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> ayp = com.baidu.tieba.aiapps.apps.address.b.a.aym().ayp();
        if (ayp.size() > 0) {
            this.cRE = ayp;
            this.cRD.aC(this.cRE);
            ayg();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> ayn = com.baidu.tieba.aiapps.apps.address.b.a.aym().ayn();
                if (ayn != null && ayn.size() > 0) {
                    DeliveryListActivity.this.cRE = ayn;
                }
                DeliveryListActivity.this.cRF.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayg() {
        showLoading();
        if (TextUtils.equals(this.cRA, "aiapp")) {
            com.baidu.tieba.aiapps.apps.a.a.a((Context) this, new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cRG.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aym().G(DeliveryListActivity.this.cRG);
                            DeliveryListActivity.this.ayh();
                            return;
                        }
                    }
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_token_error)).II();
                }
            }, "dev");
        } else {
            ayh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        com.baidu.tieba.aiapps.apps.address.b.a.aym().a(new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void ayi() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.ax(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_net_error)).II();
                if (DeliveryListActivity.this.cRE == null || DeliveryListActivity.this.cRE.size() == 0) {
                    DeliveryListActivity.this.cRD.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.ayg();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cRD.aC(list);
            this.cRE = list;
        } else if (this.cRE == null || this.cRE.size() <= 0) {
            this.cRD.showEmptyView();
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
            intent.putExtra("openSource", this.cRA);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, rr(str));
        }
    }

    private int rr(String str) {
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
            this.cRH = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lH(int i) {
        if (this.cRE != null && i < this.cRE.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRE.get(i);
            if (TextUtils.equals(this.cRA, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cRA, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aym().d(bVar2, new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void an(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cRE.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cRE.get(i3);
                    bVar3.cSx = false;
                    if (i3 == i) {
                        bVar3.cSx = true;
                    }
                }
                DeliveryListActivity.this.cRD.aC(DeliveryListActivity.this.cRE);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_net_error)).II();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lI(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(d.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0225b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.lJ(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.cRE != null && i < this.cRE.size() && (bVar = this.cRE.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.cSx;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aym().b(bVar2, new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ayi() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ao(String str, int i2) {
                    DeliveryListActivity.this.cRE.remove(i);
                    if (z && DeliveryListActivity.this.cRE.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cRE.get(0)).cSx = true;
                    }
                    DeliveryListActivity.this.cRH = true;
                    DeliveryListActivity.this.cRD.aC(DeliveryListActivity.this.cRE);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "网络异常").II();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.cRG = intent.getBundleExtra("addrParams");
        if (this.cRG != null) {
            String string = this.cRG.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cRA = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.cRH) {
            com.baidu.tieba.aiapps.apps.address.b.a.aym().ayo();
        }
    }
}
