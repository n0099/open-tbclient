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
    private com.baidu.tieba.aiapps.apps.address.c.b bFn;
    private EditAddressView bFo;
    private AiAppAlertDialog bFp;
    private boolean bFq;
    private String bFr;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.bFo = new EditAddressView(this, this.bFn);
        setContentView(this.bFo);
        XB();
        this.bFo.setDeliveryEditChangedListener(this);
        if (!c.XR().XS()) {
            AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.XR().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void dt(boolean z) {
        if (z == this.bFq) {
            dv(!z);
        }
    }

    private void XB() {
        AiAppsBdActionBar Xu = Xu();
        if (Xu != null) {
            Xu.setLeftFirstViewVisibility(false);
            Xu.setRightExitViewVisibility(false);
            Xu.setLeftSecondViewVisibility(0);
            Xu.setLeftSecondViewText(getString(e.j.delivery_cancel));
            Xu.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.XD();
                }
            });
            Xu.setRightTxtZone2Visibility(0);
            Xu.setRightImgZone2Enable(false);
            Xu.setRightTxtZone2Text(e.j.delivery_save);
            Xu.setRightTxtZone2TextSize(getResources().getDimensionPixelOffset(e.C0210e.tbds48));
            dv(false);
            if (TextUtils.equals(this.mType, "update")) {
                Xu.setTitle(e.j.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                Xu.setTitle(e.j.delivery_title_add);
            }
        }
    }

    private boolean XC() {
        return this.bFo.getEditAdapter().XC();
    }

    public void XD() {
        if (XC()) {
            this.bFp = new AiAppAlertDialog.Builder(this).setMessage("退出后已编辑的信息不会保存").setTitle("退出编辑").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.du(false);
                }
            }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
        } else {
            du(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void dv(boolean z) {
        AiAppsBdActionBar Xu = Xu();
        if (Xu != null) {
            if (z) {
                Xu.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.XE();
                    }
                });
            } else {
                Xu.setRightTxtZone2OnClickListener(null);
            }
            this.bFq = z;
            dw(AiAppNightModeHelper.getNightModeSwitcherState());
        }
    }

    private void dw(boolean z) {
        int parseColor;
        AiAppsBdActionBar Xu = Xu();
        if (Xu != null) {
            if (z) {
                if (this.bFq) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.bFq) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            Xu.setRightTxtZone2TextColor(parseColor);
        }
    }

    public void XE() {
        Map<String, Object> deliveryEditData = this.bFo.getDeliveryEditData();
        if (n(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b q = com.baidu.tieba.aiapps.apps.address.c.b.q(deliveryEditData);
            if (!TextUtils.isEmpty(this.bFn.id)) {
                q.id = this.bFn.id;
            }
            if (q != null) {
                a.C0195a c0195a = new a.C0195a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void O(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    q.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(q, "add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void P(String str, int i) {
                        DeliveryEditActivity.this.a(q, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0195a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void kp(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        UniversalToast.makeText(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(q.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.XM().c(q, c0195a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.XM().a(q, c0195a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.XZ();
        List<com.baidu.tieba.aiapps.apps.address.c.b> XP = com.baidu.tieba.aiapps.apps.address.b.a.XM().XP();
        if (TextUtils.equals(str, "add")) {
            if (XP.size() == 0) {
                bVar.bGl = true;
            }
            XP.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= XP.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = XP.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    XP.add(0, XP.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        du(z);
        return z;
    }

    private boolean n(Map<String, Object> map) {
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE) && !com.baidu.tieba.aiapps.apps.address.c.b.ks(String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE)))) {
            UniversalToast.makeText(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.kt(String.valueOf(map.get("zipcode")))) {
            UniversalToast.makeText(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.bFr = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bFn = com.baidu.tieba.aiapps.apps.address.c.b.K(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
