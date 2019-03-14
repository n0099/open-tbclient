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
    private ChooseAddressView cRB;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> cRC = new ArrayList();
    private Handler cRD;
    private Bundle cRE;
    private boolean cRF;
    private String cRy;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        ayh();
    }

    private void ayh() {
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
        this.cRB = new ChooseAddressView(this);
        setContentView(this.cRB);
        ayd();
        this.cRB.setDeliveryChooseListener(this);
        this.cRD = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cRB.aC(DeliveryListActivity.this.cRC);
                        DeliveryListActivity.this.ayj();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.ayp().G(this.cRE);
        ayi();
    }

    private void ayd() {
        SwanAppBdActionBar axX = axX();
        if (TextUtils.equals(this.cRy, "aiapp")) {
            axX.setTitle(d.j.delivery_title_choose);
            axX.setLeftFirstViewVisibility(true);
            return;
        }
        axX.setTitle(d.j.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cRF) {
            this.cRC = com.baidu.tieba.aiapps.apps.address.b.a.ayp().ays();
            this.cRB.aC(this.cRC);
        }
    }

    private void ayi() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> ays = com.baidu.tieba.aiapps.apps.address.b.a.ayp().ays();
        if (ays.size() > 0) {
            this.cRC = ays;
            this.cRB.aC(this.cRC);
            ayj();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> ayq = com.baidu.tieba.aiapps.apps.address.b.a.ayp().ayq();
                if (ayq != null && ayq.size() > 0) {
                    DeliveryListActivity.this.cRC = ayq;
                }
                DeliveryListActivity.this.cRD.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayj() {
        showLoading();
        if (TextUtils.equals(this.cRy, "aiapp")) {
            com.baidu.tieba.aiapps.apps.a.a.a((Context) this, new com.baidu.swan.apps.an.c.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cRE.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.ayp().G(DeliveryListActivity.this.cRE);
                            DeliveryListActivity.this.ayk();
                            return;
                        }
                    }
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_token_error)).IK();
                }
            }, "dev");
        } else {
            ayk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayk() {
        com.baidu.tieba.aiapps.apps.address.b.a.ayp().a(new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void ayl() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.ax(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_net_error)).IK();
                if (DeliveryListActivity.this.cRC == null || DeliveryListActivity.this.cRC.size() == 0) {
                    DeliveryListActivity.this.cRB.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.ayj();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cRB.aC(list);
            this.cRC = list;
        } else if (this.cRC == null || this.cRC.size() <= 0) {
            this.cRB.showEmptyView();
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
            intent.putExtra("openSource", this.cRy);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, rq(str));
        }
    }

    private int rq(String str) {
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
            this.cRF = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lI(int i) {
        if (this.cRC != null && i < this.cRC.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.cRC.get(i);
            if (TextUtils.equals(this.cRy, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cRy, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.ayp().d(bVar2, new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void an(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cRC.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cRC.get(i3);
                    bVar3.cSv = false;
                    if (i3 == i) {
                        bVar3.cSv = true;
                    }
                }
                DeliveryListActivity.this.cRB.aC(DeliveryListActivity.this.cRC);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(d.j.delivery_net_error)).IK();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lJ(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(d.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0225b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.lK(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).abc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.cRC != null && i < this.cRC.size() && (bVar = this.cRC.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.cSv;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.ayp().b(bVar2, new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ayl() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ao(String str, int i2) {
                    DeliveryListActivity.this.cRC.remove(i);
                    if (z && DeliveryListActivity.this.cRC.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.cRC.get(0)).cSv = true;
                    }
                    DeliveryListActivity.this.cRF = true;
                    DeliveryListActivity.this.cRB.aC(DeliveryListActivity.this.cRC);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "网络异常").IK();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.cRE = intent.getBundleExtra("addrParams");
        if (this.cRE != null) {
            String string = this.cRE.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.cRy = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.cRF) {
            com.baidu.tieba.aiapps.apps.address.b.a.ayp().ayr();
        }
    }
}
