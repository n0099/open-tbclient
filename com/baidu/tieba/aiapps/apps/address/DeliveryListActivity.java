package com.baidu.tieba.aiapps.apps.address;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.result.AddressManageResult;
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
    private String ddp;
    private ChooseAddressView dds;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> ddt = new ArrayList();
    private Handler ddv;
    private Bundle ddw;
    private boolean ddx;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        aFl();
    }

    private void aFl() {
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
        this.dds = new ChooseAddressView(this);
        setContentView(this.dds);
        aFh();
        this.dds.setDeliveryChooseListener(this);
        this.ddv = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.dds.aJ(DeliveryListActivity.this.ddt);
                        DeliveryListActivity.this.aFn();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aFt().H(this.ddw);
        aFm();
    }

    private void aFh() {
        SwanAppBdActionBar aEZ = aEZ();
        if (TextUtils.equals(this.ddp, "aiapp")) {
            aEZ.setTitle(R.string.delivery_title_choose);
            aEZ.setLeftFirstViewVisibility(true);
            return;
        }
        aEZ.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.ddx) {
            this.ddt = com.baidu.tieba.aiapps.apps.address.b.a.aFt().aFw();
            this.dds.aJ(this.ddt);
        }
    }

    private void aFm() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFw = com.baidu.tieba.aiapps.apps.address.b.a.aFt().aFw();
        if (aFw.size() > 0) {
            this.ddt = aFw;
            this.dds.aJ(this.ddt);
            aFn();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aFu = com.baidu.tieba.aiapps.apps.address.b.a.aFt().aFu();
                if (aFu != null && aFu.size() > 0) {
                    DeliveryListActivity.this.ddt = aFu;
                }
                DeliveryListActivity.this.ddv.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFn() {
        showLoading();
        if (TextUtils.equals(this.ddp, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.ddw.putString("stoken", string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aFt().H(DeliveryListActivity.this.ddw);
                            DeliveryListActivity.this.aFo();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).LU();
                }
            }, "dev");
        } else {
            aFo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFo() {
        com.baidu.tieba.aiapps.apps.address.b.a.aFt().a(new a.C0292a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aFp() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
            public void g(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aE(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LU();
                if (DeliveryListActivity.this.ddt == null || DeliveryListActivity.this.ddt.size() == 0) {
                    DeliveryListActivity.this.dds.i(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aFn();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dds.aJ(list);
            this.ddt = list;
        } else if (this.ddt == null || this.ddt.size() <= 0) {
            this.dds.showEmptyView();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void b(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        if (bVar != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(AddressManageResult.KEY_ADDR_INFO, com.baidu.tieba.aiapps.apps.address.c.b.c(bVar).toString());
            bundle.putString("type", str);
            intent.putExtra("data", bundle);
            intent.putExtra("openSource", this.ddp);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, ts(str));
        }
    }

    private int ts(String str) {
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
            this.ddx = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mG(int i) {
        if (this.ddt != null && i < this.ddt.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.ddt.get(i);
            if (TextUtils.equals(this.ddp, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.ddp, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aFt().d(bVar2, new a.C0292a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
            public void al(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.ddt.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.ddt.get(i3);
                    bVar3.den = false;
                    if (i3 == i) {
                        bVar3.den = true;
                    }
                }
                DeliveryListActivity.this.dds.aJ(DeliveryListActivity.this.ddt);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).LU();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void mH(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.mI(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).agR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.ddt != null && i < this.ddt.size() && (bVar = this.ddt.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.den;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aFt().b(bVar2, new a.C0292a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aFp() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                public void am(String str, int i2) {
                    DeliveryListActivity.this.ddt.remove(i);
                    if (z && DeliveryListActivity.this.ddt.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.ddt.get(0)).den = true;
                    }
                    DeliveryListActivity.this.ddx = true;
                    DeliveryListActivity.this.dds.aJ(DeliveryListActivity.this.ddt);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").LU();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.ddw = intent.getBundleExtra("addrParams");
        if (this.ddw != null) {
            String string = this.ddw.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.ddp = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.ddx) {
            com.baidu.tieba.aiapps.apps.address.b.a.aFt().aFv();
        }
    }
}
