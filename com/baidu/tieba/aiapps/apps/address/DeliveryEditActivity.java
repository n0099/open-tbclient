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
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity;
import com.baidu.tieba.aiapps.apps.address.a.b;
import com.baidu.tieba.aiapps.apps.address.b.a;
import com.baidu.tieba.aiapps.apps.address.b.c;
import com.baidu.tieba.aiapps.apps.address.view.EditAddressView;
import com.baidu.tieba.d;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DeliveryEditActivity extends TbSwanAppBaseActivity implements b.a {
    private String cRA;
    private com.baidu.tieba.aiapps.apps.address.c.b cRw;
    private EditAddressView cRx;
    private e cRy;
    private boolean cRz;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.cRx = new EditAddressView(this, this.cRw);
        setContentView(this.cRx);
        aya();
        this.cRx.setDeliveryEditChangedListener(this);
        if (!c.ayr().ays()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ayr().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void fN(boolean z) {
        if (z == this.cRz) {
            fP(!z);
        }
    }

    private void aya() {
        SwanAppBdActionBar axU = axU();
        if (axU != null) {
            axU.setLeftFirstViewVisibility(false);
            axU.setRightExitViewVisibility(false);
            axU.setLeftSecondViewVisibility(0);
            axU.setLeftSecondViewText(getString(d.j.delivery_cancel));
            axU.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.ayc();
                }
            });
            axU.setRightTxtZone2Visibility(0);
            axU.setRightImgZone2Enable(false);
            axU.setRightTxtZone2Text(d.j.delivery_save);
            fP(false);
            if (TextUtils.equals(this.mType, "update")) {
                axU.setTitle(d.j.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                axU.setTitle(d.j.delivery_title_add);
            }
        }
    }

    private boolean ayb() {
        return this.cRx.getEditAdapter().ayb();
    }

    public void ayc() {
        if (ayb()) {
            this.cRy = new e.a(this).ge("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.fO(false);
                }
            }).d("取消", null).Is();
        } else {
            fO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void fP(boolean z) {
        SwanAppBdActionBar axU = axU();
        if (axU != null) {
            if (z) {
                axU.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.ayd();
                    }
                });
            } else {
                axU.setRightTxtZone2OnClickListener(null);
            }
            this.cRz = z;
            fQ(com.baidu.swan.apps.u.a.CR().Dq());
        }
    }

    private void fQ(boolean z) {
        int parseColor;
        SwanAppBdActionBar axU = axU();
        if (axU != null) {
            if (z) {
                if (this.cRz) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.cRz) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            axU.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void ayd() {
        Map<String, Object> deliveryEditData = this.cRx.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b r = com.baidu.tieba.aiapps.apps.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.cRw.id)) {
                r.id = this.cRw.id;
            }
            if (r != null) {
                a.C0265a c0265a = new a.C0265a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void am(String str, int i) {
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void an(String str, int i) {
                        DeliveryEditActivity.this.a(r, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "保存失败").II();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0265a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void rq(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), str).II();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aym().c(r, c0265a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aym().a(r, c0265a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.ayz();
        List<com.baidu.tieba.aiapps.apps.address.c.b> ayp = com.baidu.tieba.aiapps.apps.address.b.a.aym().ayp();
        if (TextUtils.equals(str, "add")) {
            if (ayp.size() == 0) {
                bVar.cSx = true;
            }
            ayp.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= ayp.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = ayp.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    ayp.add(0, ayp.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        fO(z);
        return z;
    }

    private boolean o(Map<String, Object> map) {
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE) && !com.baidu.tieba.aiapps.apps.address.c.b.rt(String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE)))) {
            com.baidu.swan.apps.res.widget.b.d.a(this, "电话号码格式不正确").II();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.ru(String.valueOf(map.get("zipcode")))) {
            com.baidu.swan.apps.res.widget.b.d.a(this, "邮编格式不正确").II();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.cRA = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cRw = com.baidu.tieba.aiapps.apps.address.c.b.aT(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
