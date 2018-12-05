package com.baidu.tieba.aiapps.apps.address;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthDef;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity;
import com.baidu.tieba.aiapps.apps.address.a.a;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.c.b;
import com.baidu.tieba.aiapps.apps.address.view.ChooseAddressView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class DeliveryListActivity extends TbAiAppsBaseActivity implements a.b {
    private String bFr;
    private ChooseAddressView bFu;
    private List<b> bFv = new ArrayList();
    private Handler bFw;
    private Bundle bFx;
    private boolean bFy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        XF();
    }

    private void XF() {
        if (!com.baidu.tieba.aiapps.apps.a.b.isLogin(TbadkCoreApplication.getInst())) {
            com.baidu.tieba.aiapps.apps.a.b.login(this, null, new OnAiAppLoginResultListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.1
                @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
                public void onResult(int i) {
                }
            });
        } else {
            init();
        }
    }

    private void init() {
        this.bFu = new ChooseAddressView(this);
        setContentView(this.bFu);
        XB();
        this.bFu.setDeliveryChooseListener(this);
        this.bFw = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bFu.ao(DeliveryListActivity.this.bFv);
                        DeliveryListActivity.this.XH();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.XM().n(this.bFx);
        XG();
    }

    private void XB() {
        AiAppsBdActionBar Xu = Xu();
        if (TextUtils.equals(this.bFr, "aiapp")) {
            Xu.setTitle(e.j.delivery_title_choose);
            Xu.setLeftFirstViewVisibility(true);
            return;
        }
        Xu.setTitle(e.j.delivery_title_list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bFy) {
            this.bFv = com.baidu.tieba.aiapps.apps.address.b.a.XM().XP();
            this.bFu.ao(this.bFv);
        }
    }

    private void XG() {
        List<b> XP = com.baidu.tieba.aiapps.apps.address.b.a.XM().XP();
        if (XP.size() > 0) {
            this.bFv = XP;
            this.bFu.ao(this.bFv);
            XH();
            return;
        }
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<b> XN = com.baidu.tieba.aiapps.apps.address.b.a.XM().XN();
                if (XN != null && XN.size() > 0) {
                    DeliveryListActivity.this.bFv = XN;
                }
                DeliveryListActivity.this.bFw.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XH() {
        showLoading();
        if (TextUtils.equals(this.bFr, "aiapp")) {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(this, new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString(OAuthDef.TPL, "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bFx.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.XM().n(DeliveryListActivity.this.bFx);
                            DeliveryListActivity.this.XI();
                            return;
                        }
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_token_error)).showToast();
                }
            }, OAuthDef.TPL);
        } else {
            XI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        com.baidu.tieba.aiapps.apps.address.b.a.XM().a(new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void XJ() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void h(List<b> list, int i) {
                DeliveryListActivity.this.aj(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bFv == null || DeliveryListActivity.this.bFv.size() == 0) {
                    DeliveryListActivity.this.bFu.h(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.XH();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bFu.ao(list);
            this.bFv = list;
        } else if (this.bFv == null || this.bFv.size() <= 0) {
            this.bFu.showEmptyView();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void b(b bVar, String str) {
        if (bVar != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("addrInfo", b.c(bVar).toString());
            bundle.putString("type", str);
            intent.putExtra("data", bundle);
            intent.putExtra("openSource", this.bFr);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, kq(str));
        }
    }

    private int kq(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.bFy = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hQ(int i) {
        if (this.bFv != null && i < this.bFv.size()) {
            b bVar = this.bFv.get(i);
            if (TextUtils.equals(this.bFr, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bFr, "aiapp")) {
                Intent intent = new Intent();
                intent.putExtra("data", b.d(bVar).toString());
                setResult(-1, intent);
                finish();
            }
        }
    }

    private void a(b bVar, final int i) {
        b bVar2 = new b();
        bVar2.id = bVar.id;
        com.baidu.tieba.aiapps.apps.address.b.a.XM().d(bVar2, new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void P(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bFv.size(); i3++) {
                    b bVar3 = (b) DeliveryListActivity.this.bFv.get(i3);
                    bVar3.bGl = false;
                    if (i3 == i) {
                        bVar3.bGl = true;
                    }
                }
                DeliveryListActivity.this.bFu.ao(DeliveryListActivity.this.bFv);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hR(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.hS(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).BI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.bFv != null && i < this.bFv.size() && (bVar = this.bFv.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bGl;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.XM().b(bVar2, new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void XJ() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void Q(String str, int i2) {
                    DeliveryListActivity.this.bFv.remove(i);
                    if (z && DeliveryListActivity.this.bFv.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.bFv.get(0)).bGl = true;
                    }
                    DeliveryListActivity.this.bFy = true;
                    DeliveryListActivity.this.bFu.ao(DeliveryListActivity.this.bFv);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.bFx = intent.getBundleExtra("addrParams");
        if (this.bFx != null) {
            String string = this.bFx.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bFr = string;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bFy) {
            com.baidu.tieba.aiapps.apps.address.b.a.XM().XO();
        }
    }
}
