package com.baidu.tieba.aiapps.apps.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.sapi2.result.AddressManageResult;
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
    private com.baidu.tieba.aiapps.apps.address.c.b ddl;
    private EditAddressView ddm;
    private g ddn;
    private boolean ddo;
    private String ddp;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent(getIntent());
        init();
    }

    private void init() {
        this.ddm = new EditAddressView(this, this.ddl);
        setContentView(this.ddm);
        aFh();
        this.ddm.setDeliveryEditChangedListener(this);
        if (!c.aFy().aFz()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aFy().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void gr(boolean z) {
        if (z == this.ddo) {
            gt(!z);
        }
    }

    private void aFh() {
        SwanAppBdActionBar aEZ = aEZ();
        if (aEZ != null) {
            aEZ.setLeftFirstViewVisibility(false);
            aEZ.setRightExitViewVisibility(false);
            aEZ.setLeftSecondViewVisibility(0);
            aEZ.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aEZ.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aFj();
                }
            });
            aEZ.setRightTxtZone2Visibility(0);
            aEZ.setRightImgZone2Enable(false);
            aEZ.setRightTxtZone2Text(R.string.delivery_save);
            gt(false);
            if (TextUtils.equals(this.mType, "update")) {
                aEZ.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, "add")) {
                aEZ.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aFi() {
        return this.ddm.getEditAdapter().aFi();
    }

    public void aFj() {
        if (aFi()) {
            this.ddn = new g.a(this).gE("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.gs(false);
                }
            }).d("取消", null).LB();
        } else {
            gs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gs(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void gt(boolean z) {
        SwanAppBdActionBar aEZ = aEZ();
        if (aEZ != null) {
            if (z) {
                aEZ.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aFk();
                    }
                });
            } else {
                aEZ.setRightTxtZone2OnClickListener(null);
            }
            this.ddo = z;
            gu(com.baidu.swan.apps.u.a.EJ().Fi());
        }
    }

    private void gu(boolean z) {
        int parseColor;
        SwanAppBdActionBar aEZ = aEZ();
        if (aEZ != null) {
            if (z) {
                if (this.ddo) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.ddo) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aEZ.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aFk() {
        Map<String, Object> deliveryEditData = this.ddm.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b r = com.baidu.tieba.aiapps.apps.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.ddl.id)) {
                r.id = this.ddl.id;
            }
            if (r != null) {
                a.C0292a c0292a = new a.C0292a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void ak(String str, int i) {
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void al(String str, int i) {
                        DeliveryEditActivity.this.a(r, "update");
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), "保存失败").LU();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0292a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void tr(String str) {
                        DeliveryEditActivity.this.dismissLoading();
                        d.a(AppRuntime.getAppContext(), str).LU();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFt().c(r, c0292a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFt().a(r, c0292a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aFG();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFw = com.baidu.tieba.aiapps.apps.address.b.a.aFt().aFw();
        if (TextUtils.equals(str, "add")) {
            if (aFw.size() == 0) {
                bVar.den = true;
            }
            aFw.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, "update")) {
            int i = 0;
            while (true) {
                if (i >= aFw.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aFw.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aFw.add(0, aFw.remove(i));
                    z = true;
                    break;
                }
            }
        }
        dismissLoading();
        gs(z);
        return z;
    }

    private boolean o(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.tieba.aiapps.apps.address.c.b.tu(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").LU();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.tv(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").LU();
            return false;
        } else {
            return true;
        }
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ddp = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString(AddressManageResult.KEY_ADDR_INFO);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.ddl = com.baidu.tieba.aiapps.apps.address.c.b.bf(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
