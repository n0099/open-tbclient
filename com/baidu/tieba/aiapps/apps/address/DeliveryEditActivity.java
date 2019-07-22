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
    private com.baidu.tieba.aiapps.apps.address.c.b dbr;
    private EditAddressView dbs;
    private g dbt;
    private boolean dbu;
    private String dbv;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.dbs = new EditAddressView(this, this.dbr);
        setContentView(this.dbs);
        aEB();
        this.dbs.setDeliveryEditChangedListener(this);
        if (!c.aES().aET()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aES().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void go(boolean z) {
        if (z == this.dbu) {
            gq(!z);
        }
    }

    private void aEB() {
        SwanAppBdActionBar aEt = aEt();
        if (aEt != null) {
            aEt.setLeftFirstViewVisibility(false);
            aEt.setRightExitViewVisibility(false);
            aEt.setLeftSecondViewVisibility(0);
            aEt.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aEt.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aED();
                }
            });
            aEt.setRightTxtZone2Visibility(0);
            aEt.setRightImgZone2Enable(false);
            aEt.setRightTxtZone2Text(R.string.delivery_save);
            gq(false);
            if (TextUtils.equals(this.mType, "update")) {
                aEt.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                aEt.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aEC() {
        return this.dbs.getEditAdapter().aEC();
    }

    public void aED() {
        if (aEC()) {
            this.dbt = new g.a(this).gC("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
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
        SwanAppBdActionBar aEt = aEt();
        if (aEt != null) {
            if (z) {
                aEt.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aEE();
                    }
                });
            } else {
                aEt.setRightTxtZone2OnClickListener(null);
            }
            this.dbu = z;
            gr(com.baidu.swan.apps.u.a.EF().Fe());
        }
    }

    private void gr(boolean z) {
        int parseColor;
        SwanAppBdActionBar aEt = aEt();
        if (aEt != null) {
            if (z) {
                if (this.dbu) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.dbu) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aEt.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aEE() {
        Map<String, Object> deliveryEditData = this.dbs.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b r = com.baidu.tieba.aiapps.apps.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.dbr.id)) {
                r.id = this.dbr.id;
            }
            if (r != null) {
                a.C0277a c0277a = new a.C0277a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0277a, com.baidu.tieba.aiapps.apps.address.b.b
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0277a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void aj(String str, int i) {
                        DeliveryEditActivity.this.a(r, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0277a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), "保存失败").LQ();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0277a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void sS(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), str).LQ();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aEN().c(r, c0277a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aEN().a(r, c0277a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aFa();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aEQ = com.baidu.tieba.aiapps.apps.address.b.a.aEN().aEQ();
        if (TextUtils.equals(str, "add")) {
            if (aEQ.size() == 0) {
                bVar.dct = true;
            }
            aEQ.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= aEQ.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aEQ.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aEQ.add(0, aEQ.remove(i));
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
            this.dbv = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.dbr = com.baidu.tieba.aiapps.apps.address.c.b.bf(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
