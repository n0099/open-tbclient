package com.baidu.tieba.aiapps.apps.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity;
import com.baidu.tieba.aiapps.apps.address.a.b;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.b.c;
import com.baidu.tieba.aiapps.apps.address.view.EditAddressView;
import com.baidu.tieba.e;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DeliveryEditActivity extends TbAiAppsBaseActivity implements b.a {
    private com.baidu.tieba.aiapps.apps.address.c.b bBi;
    private EditAddressView bBj;
    private AiAppAlertDialog bBk;
    private boolean bBl;
    private String bBm;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.bBj = new EditAddressView(this, this.bBi);
        setContentView(this.bBj);
        Wo();
        this.bBj.setDeliveryEditChangedListener(this);
        if (!c.WE().WF()) {
            AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.WE().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void db(boolean z) {
        if (z == this.bBl) {
            dd(!z);
        }
    }

    private void Wo() {
        AiAppsBdActionBar Wf = Wf();
        if (Wf != null) {
            Wf.setLeftFirstViewVisibility(false);
            Wf.setRightExitViewVisibility(false);
            Wf.setLeftSecondViewVisibility(0);
            Wf.setLeftSecondViewText(getString(e.j.delivery_cancel));
            Wf.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.Wq();
                }
            });
            Wf.setRightTxtZone2Visibility(0);
            Wf.setRightImgZone2Enable(false);
            Wf.setRightTxtZone2Text(e.j.delivery_save);
            Wf.setRightTxtZone2TextSize(getResources().getDimensionPixelOffset(e.C0175e.tbds48));
            dd(false);
            if (TextUtils.equals(this.mType, "update")) {
                Wf.setTitle(e.j.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                Wf.setTitle(e.j.delivery_title_add);
            }
        }
    }

    private boolean Wp() {
        return this.bBj.getEditAdapter().Wp();
    }

    public void Wq() {
        if (Wp()) {
            this.bBk = new AiAppAlertDialog.Builder(this).setMessage("退出后已编辑的信息不会保存").setTitle("退出编辑").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.dc(false);
                }
            }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
        } else {
            dc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void dd(boolean z) {
        AiAppsBdActionBar Wf = Wf();
        if (Wf != null) {
            if (z) {
                Wf.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.Wr();
                    }
                });
            } else {
                Wf.setRightTxtZone2OnClickListener(null);
            }
            this.bBl = z;
            de(AiAppNightModeHelper.getNightModeSwitcherState());
        }
    }

    private void de(boolean z) {
        int parseColor;
        AiAppsBdActionBar Wf = Wf();
        if (Wf != null) {
            if (z) {
                if (this.bBl) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.bBl) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            Wf.setRightTxtZone2TextColor(parseColor);
        }
    }

    public void Wr() {
        Map<String, Object> deliveryEditData = this.bBj.getDeliveryEditData();
        if (k(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b n = com.baidu.tieba.aiapps.apps.address.c.b.n(deliveryEditData);
            if (!TextUtils.isEmpty(this.bBi.id)) {
                n.id = this.bBi.id;
            }
            if (n != null) {
                a.C0160a c0160a = new a.C0160a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void O(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    n.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(n, "add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void P(String str, int i) {
                        DeliveryEditActivity.this.a(n, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0160a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void jV(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(n.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.Wz().c(n, c0160a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.Wz().a(n, c0160a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.WM();
        List<com.baidu.tieba.aiapps.apps.address.c.b> WC = com.baidu.tieba.aiapps.apps.address.b.a.Wz().WC();
        if (TextUtils.equals(str, "add")) {
            if (WC.size() == 0) {
                bVar.bCg = true;
            }
            WC.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= WC.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = WC.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    WC.add(0, WC.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        dc(z);
        return z;
    }

    private boolean k(Map<String, Object> map) {
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE) && !com.baidu.tieba.aiapps.apps.address.c.b.jY(String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE)))) {
            UniversalToast.makeText(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.jZ(String.valueOf(map.get("zipcode")))) {
            UniversalToast.makeText(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.bBm = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bBi = com.baidu.tieba.aiapps.apps.address.c.b.J(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
