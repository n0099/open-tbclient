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
    private String bGh;
    private ChooseAddressView bGk;
    private List<b> bGl = new ArrayList();
    private Handler bGm;
    private Bundle bGn;
    private boolean bGo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        Ye();
    }

    private void Ye() {
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
        this.bGk = new ChooseAddressView(this);
        setContentView(this.bGk);
        Ya();
        this.bGk.setDeliveryChooseListener(this);
        this.bGm = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bGk.ap(DeliveryListActivity.this.bGl);
                        DeliveryListActivity.this.Yg();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.Yl().n(this.bGn);
        Yf();
    }

    private void Ya() {
        AiAppsBdActionBar XT = XT();
        if (TextUtils.equals(this.bGh, "aiapp")) {
            XT.setTitle(e.j.delivery_title_choose);
            XT.setLeftFirstViewVisibility(true);
            return;
        }
        XT.setTitle(e.j.delivery_title_list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bGo) {
            this.bGl = com.baidu.tieba.aiapps.apps.address.b.a.Yl().Yo();
            this.bGk.ap(this.bGl);
        }
    }

    private void Yf() {
        List<b> Yo = com.baidu.tieba.aiapps.apps.address.b.a.Yl().Yo();
        if (Yo.size() > 0) {
            this.bGl = Yo;
            this.bGk.ap(this.bGl);
            Yg();
            return;
        }
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<b> Ym = com.baidu.tieba.aiapps.apps.address.b.a.Yl().Ym();
                if (Ym != null && Ym.size() > 0) {
                    DeliveryListActivity.this.bGl = Ym;
                }
                DeliveryListActivity.this.bGm.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yg() {
        showLoading();
        if (TextUtils.equals(this.bGh, "aiapp")) {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(this, new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString(OAuthDef.TPL, "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bGn.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.Yl().n(DeliveryListActivity.this.bGn);
                            DeliveryListActivity.this.Yh();
                            return;
                        }
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_token_error)).showToast();
                }
            }, OAuthDef.TPL);
        } else {
            Yh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh() {
        com.baidu.tieba.aiapps.apps.address.b.a.Yl().a(new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void Yi() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void h(List<b> list, int i) {
                DeliveryListActivity.this.ak(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bGl == null || DeliveryListActivity.this.bGl.size() == 0) {
                    DeliveryListActivity.this.bGk.h(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.Yg();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bGk.ap(list);
            this.bGl = list;
        } else if (this.bGl == null || this.bGl.size() <= 0) {
            this.bGk.showEmptyView();
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
            intent.putExtra("openSource", this.bGh);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, kH(str));
        }
    }

    private int kH(String str) {
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
            this.bGo = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hR(int i) {
        if (this.bGl != null && i < this.bGl.size()) {
            b bVar = this.bGl.get(i);
            if (TextUtils.equals(this.bGh, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bGh, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.Yl().d(bVar2, new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void Q(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bGl.size(); i3++) {
                    b bVar3 = (b) DeliveryListActivity.this.bGl.get(i3);
                    bVar3.bHb = false;
                    if (i3 == i) {
                        bVar3.bHb = true;
                    }
                }
                DeliveryListActivity.this.bGk.ap(DeliveryListActivity.this.bGl);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hS(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.hT(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).BV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.bGl != null && i < this.bGl.size() && (bVar = this.bGl.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bHb;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.Yl().b(bVar2, new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void Yi() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void R(String str, int i2) {
                    DeliveryListActivity.this.bGl.remove(i);
                    if (z && DeliveryListActivity.this.bGl.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.bGl.get(0)).bHb = true;
                    }
                    DeliveryListActivity.this.bGo = true;
                    DeliveryListActivity.this.bGk.ap(DeliveryListActivity.this.bGl);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.bGn = intent.getBundleExtra("addrParams");
        if (this.bGn != null) {
            String string = this.bGn.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bGh = string;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bGo) {
            com.baidu.tieba.aiapps.apps.address.b.a.Yl().Yn();
        }
    }
}
