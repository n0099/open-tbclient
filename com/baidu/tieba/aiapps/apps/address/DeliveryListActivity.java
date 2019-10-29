package com.baidu.tieba.aiapps.apps.address;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.upload.action.IMTrack;
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
    private String dmK;
    private ChooseAddressView dmN;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dmO = new ArrayList();
    private Handler dmP;
    private Bundle dmQ;
    private boolean dmR;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        aFx();
    }

    private void aFx() {
        if (!c.isLogin(TbadkCoreApplication.getInst())) {
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
        this.dmN = new ChooseAddressView(this);
        setContentView(this.dmN);
        aFt();
        this.dmN.setDeliveryChooseListener(this);
        this.dmP = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.dmN.bc(DeliveryListActivity.this.dmO);
                        DeliveryListActivity.this.aFz();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aFF().H(this.dmQ);
        aFy();
    }

    private void aFt() {
        SwanAppBdActionBar aFk = aFk();
        if (TextUtils.equals(this.dmK, "aiapp")) {
            aFk.setTitle(R.string.delivery_title_choose);
            aFk.setLeftFirstViewVisibility(true);
            return;
        }
        aFk.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dmR) {
            this.dmO = com.baidu.tieba.aiapps.apps.address.b.a.aFF().aFI();
            this.dmN.bc(this.dmO);
        }
    }

    private void aFy() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFI = com.baidu.tieba.aiapps.apps.address.b.a.aFF().aFI();
        if (aFI.size() > 0) {
            this.dmO = aFI;
            this.dmN.bc(this.dmO);
            aFz();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aFG = com.baidu.tieba.aiapps.apps.address.b.a.aFF().aFG();
                if (aFG != null && aFG.size() > 0) {
                    DeliveryListActivity.this.dmO = aFG;
                }
                DeliveryListActivity.this.dmP.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFz() {
        showLoading();
        if (TextUtils.equals(this.dmK, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void B(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.dmQ.putString("stoken", string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aFF().H(DeliveryListActivity.this.dmQ);
                            DeliveryListActivity.this.aFA();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).QN();
                }
            }, "dev");
        } else {
            aFA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFA() {
        com.baidu.tieba.aiapps.apps.address.b.a.aFF().a(new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aFB() {
                DeliveryListActivity.this.aFl();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void d(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aX(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).QN();
                if (DeliveryListActivity.this.dmO == null || DeliveryListActivity.this.dmO.size() == 0) {
                    DeliveryListActivity.this.dmN.j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aFz();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dmN.bc(list);
            this.dmO = list;
        } else if (this.dmO == null || this.dmO.size() <= 0) {
            this.dmN.aFU();
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
            intent.putExtra("openSource", this.dmK);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, sb(str));
        }
    }

    private int sb(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -838846263:
                if (str.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case 96417:
                if (str.equals(IMTrack.DbBuilder.ACTION_ADD)) {
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
            this.dmR = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lL(int i) {
        if (this.dmO != null && i < this.dmO.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dmO.get(i);
            if (TextUtils.equals(this.dmK, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.dmK, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aFF().d(bVar2, new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void ac(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.dmO.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dmO.get(i3);
                    bVar3.dnI = false;
                    if (i3 == i) {
                        bVar3.dnI = true;
                    }
                }
                DeliveryListActivity.this.dmN.bc(DeliveryListActivity.this.dmO);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).QN();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lM(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.lN(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).akP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.dmO != null && i < this.dmO.size() && (bVar = this.dmO.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.dnI;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aFF().b(bVar2, new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aFB() {
                    DeliveryListActivity.this.aFl();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ad(String str, int i2) {
                    DeliveryListActivity.this.dmO.remove(i);
                    if (z && DeliveryListActivity.this.dmO.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dmO.get(0)).dnI = true;
                    }
                    DeliveryListActivity.this.dmR = true;
                    DeliveryListActivity.this.dmN.bc(DeliveryListActivity.this.dmO);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").QN();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.dmQ = intent.getExtras();
        if (this.dmQ != null) {
            String string = this.dmQ.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dmK = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dmR) {
            com.baidu.tieba.aiapps.apps.address.b.a.aFF().aFH();
        }
    }
}
