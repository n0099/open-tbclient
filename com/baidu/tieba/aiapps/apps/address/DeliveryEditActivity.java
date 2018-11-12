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
    private com.baidu.tieba.aiapps.apps.address.c.b bBU;
    private EditAddressView bBV;
    private AiAppAlertDialog bBW;
    private boolean bBX;
    private String bBY;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.bBV = new EditAddressView(this, this.bBU);
        setContentView(this.bBV);
        Wy();
        this.bBV.setDeliveryEditChangedListener(this);
        if (!c.WO().WP()) {
            AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.WO().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void ds(boolean z) {
        if (z == this.bBX) {
            du(!z);
        }
    }

    private void Wy() {
        AiAppsBdActionBar Wo = Wo();
        if (Wo != null) {
            Wo.setLeftFirstViewVisibility(false);
            Wo.setRightExitViewVisibility(false);
            Wo.setLeftSecondViewVisibility(0);
            Wo.setLeftSecondViewText(getString(e.j.delivery_cancel));
            Wo.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.WA();
                }
            });
            Wo.setRightTxtZone2Visibility(0);
            Wo.setRightImgZone2Enable(false);
            Wo.setRightTxtZone2Text(e.j.delivery_save);
            Wo.setRightTxtZone2TextSize(getResources().getDimensionPixelOffset(e.C0200e.tbds48));
            du(false);
            if (TextUtils.equals(this.mType, "update")) {
                Wo.setTitle(e.j.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                Wo.setTitle(e.j.delivery_title_add);
            }
        }
    }

    private boolean Wz() {
        return this.bBV.getEditAdapter().Wz();
    }

    public void WA() {
        if (Wz()) {
            this.bBW = new AiAppAlertDialog.Builder(this).setMessage("退出后已编辑的信息不会保存").setTitle("退出编辑").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.dt(false);
                }
            }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
        } else {
            dt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void du(boolean z) {
        AiAppsBdActionBar Wo = Wo();
        if (Wo != null) {
            if (z) {
                Wo.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.WB();
                    }
                });
            } else {
                Wo.setRightTxtZone2OnClickListener(null);
            }
            this.bBX = z;
            dv(AiAppNightModeHelper.getNightModeSwitcherState());
        }
    }

    private void dv(boolean z) {
        int parseColor;
        AiAppsBdActionBar Wo = Wo();
        if (Wo != null) {
            if (z) {
                if (this.bBX) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.bBX) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            Wo.setRightTxtZone2TextColor(parseColor);
        }
    }

    public void WB() {
        Map<String, Object> deliveryEditData = this.bBV.getDeliveryEditData();
        if (k(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b n = com.baidu.tieba.aiapps.apps.address.c.b.n(deliveryEditData);
            if (!TextUtils.isEmpty(this.bBU.id)) {
                n.id = this.bBU.id;
            }
            if (n != null) {
                a.C0185a c0185a = new a.C0185a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void P(String str, int i) {
                        DeliveryEditActivity.this.a(n, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0185a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void jX(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(n.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.WJ().c(n, c0185a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.WJ().a(n, c0185a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.WW();
        List<com.baidu.tieba.aiapps.apps.address.c.b> WM = com.baidu.tieba.aiapps.apps.address.b.a.WJ().WM();
        if (TextUtils.equals(str, "add")) {
            if (WM.size() == 0) {
                bVar.bCS = true;
            }
            WM.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= WM.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = WM.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    WM.add(0, WM.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        dt(z);
        return z;
    }

    private boolean k(Map<String, Object> map) {
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE) && !com.baidu.tieba.aiapps.apps.address.c.b.ka(String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE)))) {
            UniversalToast.makeText(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.kb(String.valueOf(map.get("zipcode")))) {
            UniversalToast.makeText(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.bBY = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bBU = com.baidu.tieba.aiapps.apps.address.c.b.J(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
