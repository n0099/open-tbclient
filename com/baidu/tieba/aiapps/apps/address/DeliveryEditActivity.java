package com.baidu.tieba.aiapps.apps.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
    private g dbA;
    private boolean dbB;
    private String dbC;
    private com.baidu.tieba.aiapps.apps.address.c.b dby;
    private EditAddressView dbz;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.dbz = new EditAddressView(this, this.dby);
        setContentView(this.dbz);
        aED();
        this.dbz.setDeliveryEditChangedListener(this);
        if (!c.aEU().aEV()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aEU().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void go(boolean z) {
        if (z == this.dbB) {
            gq(!z);
        }
    }

    private void aED() {
        SwanAppBdActionBar aEv = aEv();
        if (aEv != null) {
            aEv.setLeftFirstViewVisibility(false);
            aEv.setRightExitViewVisibility(false);
            aEv.setLeftSecondViewVisibility(0);
            aEv.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aEv.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aEF();
                }
            });
            aEv.setRightTxtZone2Visibility(0);
            aEv.setRightImgZone2Enable(false);
            aEv.setRightTxtZone2Text(R.string.delivery_save);
            gq(false);
            if (TextUtils.equals(this.mType, "update")) {
                aEv.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                aEv.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aEE() {
        return this.dbz.getEditAdapter().aEE();
    }

    public void aEF() {
        if (aEE()) {
            this.dbA = new g.a(this).gC("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.gp(false);
                }
            }).d("取消", null).Lx();
        } else {
            gp(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void gq(boolean z) {
        SwanAppBdActionBar aEv = aEv();
        if (aEv != null) {
            if (z) {
                aEv.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aEG();
                    }
                });
            } else {
                aEv.setRightTxtZone2OnClickListener(null);
            }
            this.dbB = z;
            gr(com.baidu.swan.apps.u.a.EF().Fe());
        }
    }

    private void gr(boolean z) {
        int parseColor;
        SwanAppBdActionBar aEv = aEv();
        if (aEv != null) {
            if (z) {
                if (this.dbB) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.dbB) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aEv.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aEG() {
        Map<String, Object> deliveryEditData = this.dbz.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b r = com.baidu.tieba.aiapps.apps.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.dby.id)) {
                r.id = this.dby.id;
            }
            if (r != null) {
                a.C0283a c0283a = new a.C0283a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void aj(String str, int i) {
                        DeliveryEditActivity.this.a(r, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), "保存失败").LQ();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0283a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void sS(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), str).LQ();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aEP().c(r, c0283a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aEP().a(r, c0283a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aFc();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aES = com.baidu.tieba.aiapps.apps.address.b.a.aEP().aES();
        if (TextUtils.equals(str, "add")) {
            if (aES.size() == 0) {
                bVar.dcB = true;
            }
            aES.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= aES.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aES.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aES.add(0, aES.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        gp(z);
        return z;
    }

    private boolean o(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.tieba.aiapps.apps.address.c.b.sV(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").LQ();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.sW(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").LQ();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.dbC = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.dby = com.baidu.tieba.aiapps.apps.address.c.b.bf(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
