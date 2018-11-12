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
    private String bBY;
    private ChooseAddressView bCb;
    private List<b> bCc = new ArrayList();
    private Handler bCd;
    private Bundle bCe;
    private boolean bCf;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        WC();
    }

    private void WC() {
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
        this.bCb = new ChooseAddressView(this);
        setContentView(this.bCb);
        Wy();
        this.bCb.setDeliveryChooseListener(this);
        this.bCd = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bCb.ao(DeliveryListActivity.this.bCc);
                        DeliveryListActivity.this.WE();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.WJ().l(this.bCe);
        WD();
    }

    private void Wy() {
        AiAppsBdActionBar Wo = Wo();
        if (TextUtils.equals(this.bBY, "aiapp")) {
            Wo.setTitle(e.j.delivery_title_choose);
            Wo.setLeftFirstViewVisibility(true);
            return;
        }
        Wo.setTitle(e.j.delivery_title_list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bCf) {
            this.bCc = com.baidu.tieba.aiapps.apps.address.b.a.WJ().WM();
            this.bCb.ao(this.bCc);
        }
    }

    private void WD() {
        List<b> WM = com.baidu.tieba.aiapps.apps.address.b.a.WJ().WM();
        if (WM.size() > 0) {
            this.bCc = WM;
            this.bCb.ao(this.bCc);
            WE();
            return;
        }
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<b> WK = com.baidu.tieba.aiapps.apps.address.b.a.WJ().WK();
                if (WK != null && WK.size() > 0) {
                    DeliveryListActivity.this.bCc = WK;
                }
                DeliveryListActivity.this.bCd.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        showLoading();
        if (TextUtils.equals(this.bBY, "aiapp")) {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(this, new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString(OAuthDef.TPL, "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bCe.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.WJ().l(DeliveryListActivity.this.bCe);
                            DeliveryListActivity.this.WF();
                            return;
                        }
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_token_error)).showToast();
                }
            }, OAuthDef.TPL);
        } else {
            WF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WF() {
        com.baidu.tieba.aiapps.apps.address.b.a.WJ().a(new a.C0185a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
            public void WG() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
            public void h(List<b> list, int i) {
                DeliveryListActivity.this.aj(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bCc == null || DeliveryListActivity.this.bCc.size() == 0) {
                    DeliveryListActivity.this.bCb.h(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.WE();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bCb.ao(list);
            this.bCc = list;
        } else if (this.bCc == null || this.bCc.size() <= 0) {
            this.bCb.showEmptyView();
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
            intent.putExtra("openSource", this.bBY);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, jY(str));
        }
    }

    private int jY(String str) {
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
            this.bCf = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hC(int i) {
        if (this.bCc != null && i < this.bCc.size()) {
            b bVar = this.bCc.get(i);
            if (TextUtils.equals(this.bBY, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bBY, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.WJ().d(bVar2, new a.C0185a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
            public void P(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bCc.size(); i3++) {
                    b bVar3 = (b) DeliveryListActivity.this.bCc.get(i3);
                    bVar3.bCS = false;
                    if (i3 == i) {
                        bVar3.bCS = true;
                    }
                }
                DeliveryListActivity.this.bCb.ao(DeliveryListActivity.this.bCc);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hD(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0148b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.hE(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.bCc != null && i < this.bCc.size() && (bVar = this.bCc.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bCS;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.WJ().b(bVar2, new a.C0185a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                public void WG() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                public void Q(String str, int i2) {
                    DeliveryListActivity.this.bCc.remove(i);
                    if (z && DeliveryListActivity.this.bCc.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.bCc.get(0)).bCS = true;
                    }
                    DeliveryListActivity.this.bCf = true;
                    DeliveryListActivity.this.bCb.ao(DeliveryListActivity.this.bCc);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.bCe = intent.getBundleExtra("addrParams");
        if (this.bCe != null) {
            String string = this.bCe.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bBY = string;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bCf) {
            com.baidu.tieba.aiapps.apps.address.b.a.WJ().WL();
        }
    }
}
