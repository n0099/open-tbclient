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
    private String dlT;
    private ChooseAddressView dlW;
    private List<com.baidu.tieba.aiapps.apps.address.c.b> dlX = new ArrayList();
    private Handler dlY;
    private Bundle dlZ;
    private boolean dma;

    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        aFv();
    }

    private void aFv() {
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
        this.dlW = new ChooseAddressView(this);
        setContentView(this.dlW);
        aFr();
        this.dlW.setDeliveryChooseListener(this);
        this.dlY = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.dlW.bc(DeliveryListActivity.this.dlX);
                        DeliveryListActivity.this.aFx();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.aFD().H(this.dlZ);
        aFw();
    }

    private void aFr() {
        SwanAppBdActionBar aFi = aFi();
        if (TextUtils.equals(this.dlT, "aiapp")) {
            aFi.setTitle(R.string.delivery_title_choose);
            aFi.setLeftFirstViewVisibility(true);
            return;
        }
        aFi.setTitle(R.string.delivery_title_list);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.dma) {
            this.dlX = com.baidu.tieba.aiapps.apps.address.b.a.aFD().aFG();
            this.dlW.bc(this.dlX);
        }
    }

    private void aFw() {
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFG = com.baidu.tieba.aiapps.apps.address.b.a.aFD().aFG();
        if (aFG.size() > 0) {
            this.dlX = aFG;
            this.dlW.bc(this.dlX);
            aFx();
            return;
        }
        j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.tieba.aiapps.apps.address.c.b> aFE = com.baidu.tieba.aiapps.apps.address.b.a.aFD().aFE();
                if (aFE != null && aFE.size() > 0) {
                    DeliveryListActivity.this.dlX = aFE;
                }
                DeliveryListActivity.this.dlY.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFx() {
        showLoading();
        if (TextUtils.equals(this.dlT, "aiapp")) {
            c.b(this, new com.baidu.swan.apps.an.d.a<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: o */
                public void B(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.dlZ.putString("stoken", string);
                            com.baidu.tieba.aiapps.apps.address.b.a.aFD().H(DeliveryListActivity.this.dlZ);
                            DeliveryListActivity.this.aFy();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_token_error)).QO();
                }
            }, "dev");
        } else {
            aFy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFy() {
        com.baidu.tieba.aiapps.apps.address.b.a.aFD().a(new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void aFz() {
                DeliveryListActivity.this.aFj();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void d(List<com.baidu.tieba.aiapps.apps.address.c.b> list, int i) {
                DeliveryListActivity.this.aX(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).QO();
                if (DeliveryListActivity.this.dlX == null || DeliveryListActivity.this.dlX.size() == 0) {
                    DeliveryListActivity.this.dlW.j(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aFx();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(List<com.baidu.tieba.aiapps.apps.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.dlW.bc(list);
            this.dlX = list;
        } else if (this.dlX == null || this.dlX.size() <= 0) {
            this.dlW.aFS();
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
            intent.putExtra("openSource", this.dlT);
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
            this.dma = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lK(int i) {
        if (this.dlX != null && i < this.dlX.size()) {
            com.baidu.tieba.aiapps.apps.address.c.b bVar = this.dlX.get(i);
            if (TextUtils.equals(this.dlT, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.dlT, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.aFD().d(bVar2, new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void ac(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.dlX.size(); i3++) {
                    com.baidu.tieba.aiapps.apps.address.c.b bVar3 = (com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dlX.get(i3);
                    bVar3.dmQ = false;
                    if (i3 == i) {
                        bVar3.dmQ = true;
                    }
                }
                DeliveryListActivity.this.dlW.bc(DeliveryListActivity.this.dlX);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(R.string.delivery_net_error)).QO();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void lL(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.invoice_menu_delete));
        bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.lM(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).akN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.dlX != null && i < this.dlX.size() && (bVar = this.dlX.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.dmQ;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.aFD().b(bVar2, new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void aFz() {
                    DeliveryListActivity.this.aFj();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void ad(String str, int i2) {
                    DeliveryListActivity.this.dlX.remove(i);
                    if (z && DeliveryListActivity.this.dlX.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.dlX.get(0)).dmQ = true;
                    }
                    DeliveryListActivity.this.dma = true;
                    DeliveryListActivity.this.dlW.bc(DeliveryListActivity.this.dlX);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").QO();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.dlZ = intent.getExtras();
        if (this.dlZ != null) {
            String string = this.dlZ.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.dlT = string;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.dma) {
            com.baidu.tieba.aiapps.apps.address.b.a.aFD().aFF();
        }
    }
}
