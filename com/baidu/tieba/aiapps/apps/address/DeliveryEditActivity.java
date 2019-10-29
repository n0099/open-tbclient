package com.baidu.tieba.aiapps.apps.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.tbadk.pay.PayHelper;
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
    private com.baidu.tieba.aiapps.apps.address.c.b dmG;
    private EditAddressView dmH;
    private g dmI;
    private boolean dmJ;
    private String dmK;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.dmH = new EditAddressView(this, this.dmG);
        setContentView(this.dmH);
        aFt();
        this.dmH.setDeliveryEditChangedListener(this);
        if (!c.aFK().aFL()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aFK().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void gg(boolean z) {
        if (z == this.dmJ) {
            gi(!z);
        }
    }

    private void aFt() {
        SwanAppBdActionBar aFk = aFk();
        if (aFk != null) {
            aFk.setLeftFirstViewVisibility(false);
            aFk.setRightExitViewVisibility(false);
            aFk.setLeftSecondViewVisibility(0);
            aFk.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aFk.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aFv();
                }
            });
            aFk.setRightTxtZone2Visibility(0);
            aFk.setRightImgZone2Enable(false);
            aFk.setRightTxtZone2Text(R.string.delivery_save);
            gi(false);
            if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
                aFk.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_ADD)) {
                aFk.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aFu() {
        return this.dmH.getEditAdapter().aFu();
    }

    public void aFv() {
        if (aFu()) {
            this.dmI = new g.a(this).hi("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.gh(false);
                }
            }).d(PayHelper.STATUS_CANCEL_DESC, null).Qu();
        } else {
            gh(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void gi(boolean z) {
        SwanAppBdActionBar aFk = aFk();
        if (aFk != null) {
            if (z) {
                aFk.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aFw();
                    }
                });
            } else {
                aFk.setRightTxtZone2OnClickListener(null);
            }
            this.dmJ = z;
            gj(com.baidu.swan.apps.u.a.JD().Kc());
        }
    }

    private void gj(boolean z) {
        int parseColor;
        SwanAppBdActionBar aFk = aFk();
        if (aFk != null) {
            if (z) {
                if (this.dmJ) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.dmJ) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aFk.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aFw() {
        Map<String, Object> deliveryEditData = this.dmH.getDeliveryEditData();
        if (p(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b s = com.baidu.tieba.aiapps.apps.address.c.b.s(deliveryEditData);
            if (!TextUtils.isEmpty(this.dmG.id)) {
                s.id = this.dmG.id;
            }
            if (s != null) {
                a.C0324a c0324a = new a.C0324a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void ab(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    s.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(s, IMTrack.DbBuilder.ACTION_ADD);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void ac(String str, int i) {
                        DeliveryEditActivity.this.a(s, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.aFl();
                        d.a(AppRuntime.getAppContext(), "保存失败").QN();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0324a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void sa(String str) {
                        DeliveryEditActivity.this.aFl();
                        d.a(AppRuntime.getAppContext(), str).QN();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(s.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFF().c(s, c0324a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFF().a(s, c0324a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aFS();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFI = com.baidu.tieba.aiapps.apps.address.b.a.aFF().aFI();
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_ADD)) {
            if (aFI.size() == 0) {
                bVar.dnI = true;
            }
            aFI.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= aFI.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aFI.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aFI.add(0, aFI.remove(i));
                    z = true;
                    break;
                }
            }
        }
        aFl();
        gh(z);
        return z;
    }

    private boolean p(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.tieba.aiapps.apps.address.c.b.sd(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").QN();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.se(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").QN();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.dmK = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString(AddressManageResult.KEY_ADDR_INFO);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.dmG = com.baidu.tieba.aiapps.apps.address.c.b.bC(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
