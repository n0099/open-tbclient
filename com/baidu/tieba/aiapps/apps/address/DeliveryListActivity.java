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
    private String bBm;
    private ChooseAddressView bBp;
    private List<b> bBq = new ArrayList();
    private Handler bBr;
    private Bundle bBs;
    private boolean bBt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        Ws();
    }

    private void Ws() {
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
        this.bBp = new ChooseAddressView(this);
        setContentView(this.bBp);
        Wo();
        this.bBp.setDeliveryChooseListener(this);
        this.bBr = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bBp.ap(DeliveryListActivity.this.bBq);
                        DeliveryListActivity.this.Wu();
                        return true;
                    default:
                        return false;
                }
            }
        });
        com.baidu.tieba.aiapps.apps.address.b.a.Wz().i(this.bBs);
        Wt();
    }

    private void Wo() {
        AiAppsBdActionBar Wf = Wf();
        if (TextUtils.equals(this.bBm, "aiapp")) {
            Wf.setTitle(e.j.delivery_title_choose);
            Wf.setLeftFirstViewVisibility(true);
            return;
        }
        Wf.setTitle(e.j.delivery_title_list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bBt) {
            this.bBq = com.baidu.tieba.aiapps.apps.address.b.a.Wz().WC();
            this.bBp.ap(this.bBq);
        }
    }

    private void Wt() {
        List<b> WC = com.baidu.tieba.aiapps.apps.address.b.a.Wz().WC();
        if (WC.size() > 0) {
            this.bBq = WC;
            this.bBp.ap(this.bBq);
            Wu();
            return;
        }
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<b> WA = com.baidu.tieba.aiapps.apps.address.b.a.Wz().WA();
                if (WA != null && WA.size() > 0) {
                    DeliveryListActivity.this.bBq = WA;
                }
                DeliveryListActivity.this.bBr.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wu() {
        showLoading();
        if (TextUtils.equals(this.bBm, "aiapp")) {
            AiAppsRuntime.getAiAppAccountRuntime().getTplStoken(this, new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString(OAuthDef.TPL, "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bBs.putString(ISapiAccount.SAPI_ACCOUNT_STOKEN, string);
                            com.baidu.tieba.aiapps.apps.address.b.a.Wz().i(DeliveryListActivity.this.bBs);
                            DeliveryListActivity.this.Wv();
                            return;
                        }
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_token_error)).showToast();
                }
            }, OAuthDef.TPL);
        } else {
            Wv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wv() {
        com.baidu.tieba.aiapps.apps.address.b.a.Wz().a(new a.C0160a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
            public void Ww() {
                DeliveryListActivity.this.dismissLoading();
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
            public void h(List<b> list, int i) {
                DeliveryListActivity.this.ak(list);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bBq == null || DeliveryListActivity.this.bBq.size() == 0) {
                    DeliveryListActivity.this.bBp.g(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.Wu();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(List<b> list) {
        if (list != null && list.size() > 0) {
            this.bBp.ap(list);
            this.bBq = list;
        } else if (this.bBq == null || this.bBq.size() <= 0) {
            this.bBp.showEmptyView();
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
            intent.putExtra("openSource", this.bBm);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, jW(str));
        }
    }

    private int jW(String str) {
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
            this.bBt = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hp(int i) {
        if (this.bBq != null && i < this.bBq.size()) {
            b bVar = this.bBq.get(i);
            if (TextUtils.equals(this.bBm, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bBm, "aiapp")) {
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
        com.baidu.tieba.aiapps.apps.address.b.a.Wz().d(bVar2, new a.C0160a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.6
            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
            public void P(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bBq.size(); i3++) {
                    b bVar3 = (b) DeliveryListActivity.this.bBq.get(i3);
                    bVar3.bCg = false;
                    if (i3 == i) {
                        bVar3.bCg = true;
                    }
                }
                DeliveryListActivity.this.bBp.ap(DeliveryListActivity.this.bBq);
            }

            @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
            public void onFailure() {
                UniversalToast.makeText(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(e.j.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.a.b
    public void hq(final int i) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(e.j.invoice_menu_delete));
        bVar.a(arrayList, new b.InterfaceC0124b() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                if (i2 == 0) {
                    DeliveryListActivity.this.hr(i);
                    bVar2.dismiss();
                }
            }
        });
        bVar.d(getPageContext()).Ax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final int i) {
        com.baidu.tieba.aiapps.apps.address.c.b bVar;
        if (this.bBq != null && i < this.bBq.size() && (bVar = this.bBq.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bCg;
            com.baidu.tieba.aiapps.apps.address.c.b bVar2 = new com.baidu.tieba.aiapps.apps.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.tieba.aiapps.apps.address.b.a.Wz().b(bVar2, new a.C0160a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryListActivity.8
                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                public void Ww() {
                    DeliveryListActivity.this.dismissLoading();
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                public void Q(String str, int i2) {
                    DeliveryListActivity.this.bBq.remove(i);
                    if (z && DeliveryListActivity.this.bBq.size() > 0) {
                        ((com.baidu.tieba.aiapps.apps.address.c.b) DeliveryListActivity.this.bBq.get(0)).bCg = true;
                    }
                    DeliveryListActivity.this.bBt = true;
                    DeliveryListActivity.this.bBp.ap(DeliveryListActivity.this.bBq);
                }

                @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                public void onFailure() {
                    UniversalToast.makeText(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void parseIntent(Intent intent) {
        this.bBs = intent.getBundleExtra("addrParams");
        if (this.bBs != null) {
            String string = this.bBs.getString("openSource");
            if (!TextUtils.isEmpty(string)) {
                this.bBm = string;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bBt) {
            com.baidu.tieba.aiapps.apps.address.b.a.Wz().WB();
        }
    }
}
