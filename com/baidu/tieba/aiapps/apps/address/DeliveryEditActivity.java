package com.baidu.tieba.aiapps.apps.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.address.a.b;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.b.c;
import com.baidu.tieba.aiapps.apps.address.view.EditAddressView;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DeliveryEditActivity extends TbSwanAppBaseActivity implements b.a {
    private com.baidu.tieba.aiapps.apps.address.c.b cZR;
    private EditAddressView cZS;
    private g cZT;
    private boolean cZU;
    private String cZV;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.cZS = new EditAddressView(this, this.cZR);
        setContentView(this.cZS);
        aDl();
        this.cZS.setDeliveryEditChangedListener(this);
        if (!c.aDC().aDD()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aDC().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void gk(boolean z) {
        if (z == this.cZU) {
            gm(!z);
        }
    }

    private void aDl() {
        SwanAppBdActionBar aDd = aDd();
        if (aDd != null) {
            aDd.setLeftFirstViewVisibility(false);
            aDd.setRightExitViewVisibility(false);
            aDd.setLeftSecondViewVisibility(0);
            aDd.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aDd.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aDn();
                }
            });
            aDd.setRightTxtZone2Visibility(0);
            aDd.setRightImgZone2Enable(false);
            aDd.setRightTxtZone2Text(R.string.delivery_save);
            gm(false);
            if (TextUtils.equals(this.mType, "update")) {
                aDd.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                aDd.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aDm() {
        return this.cZS.getEditAdapter().aDm();
    }

    public void aDn() {
        if (aDm()) {
            this.cZT = new g.a(this).gx("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.gl(false);
                }
            }).d("取消", null).KK();
        } else {
            gl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void gm(boolean z) {
        SwanAppBdActionBar aDd = aDd();
        if (aDd != null) {
            if (z) {
                aDd.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aDo();
                    }
                });
            } else {
                aDd.setRightTxtZone2OnClickListener(null);
            }
            this.cZU = z;
            gn(com.baidu.swan.apps.u.a.DW().Ev());
        }
    }

    private void gn(boolean z) {
        int parseColor;
        SwanAppBdActionBar aDd = aDd();
        if (aDd != null) {
            if (z) {
                if (this.cZU) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.cZU) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aDd.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aDo() {
        Map<String, Object> deliveryEditData = this.cZS.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b r = com.baidu.tieba.aiapps.apps.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.cZR.id)) {
                r.id = this.cZR.id;
            }
            if (r != null) {
                a.C0280a c0280a = new a.C0280a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void ai(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    r.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(r, "add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void aj(String str, int i) {
                        DeliveryEditActivity.this.a(r, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), "保存失败").Ld();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0280a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void sA(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), str).Ld();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aDx().c(r, c0280a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aDx().a(r, c0280a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aDK();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aDA = com.baidu.tieba.aiapps.apps.address.b.a.aDx().aDA();
        if (TextUtils.equals(str, "add")) {
            if (aDA.size() == 0) {
                bVar.daU = true;
            }
            aDA.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= aDA.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aDA.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aDA.add(0, aDA.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        gl(z);
        return z;
    }

    private boolean o(Map<String, Object> map) {
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE) && !com.baidu.tieba.aiapps.apps.address.c.b.sD(String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE)))) {
            d.a(this, "电话号码格式不正确").Ld();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.sE(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").Ld();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.cZV = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cZR = com.baidu.tieba.aiapps.apps.address.c.b.bf(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
