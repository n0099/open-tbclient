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
    private com.baidu.tieba.aiapps.apps.address.c.b dlP;
    private EditAddressView dlQ;
    private g dlR;
    private boolean dlS;
    private String dlT;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.dlQ = new EditAddressView(this, this.dlP);
        setContentView(this.dlQ);
        aFr();
        this.dlQ.setDeliveryEditChangedListener(this);
        if (!c.aFI().aFJ()) {
            j.a(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aFI().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.address.a.b.a
    public void gg(boolean z) {
        if (z == this.dlS) {
            gi(!z);
        }
    }

    private void aFr() {
        SwanAppBdActionBar aFi = aFi();
        if (aFi != null) {
            aFi.setLeftFirstViewVisibility(false);
            aFi.setRightExitViewVisibility(false);
            aFi.setLeftSecondViewVisibility(0);
            aFi.setLeftSecondViewText(getString(R.string.delivery_cancel));
            aFi.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aFt();
                }
            });
            aFi.setRightTxtZone2Visibility(0);
            aFi.setRightImgZone2Enable(false);
            aFi.setRightTxtZone2Text(R.string.delivery_save);
            gi(false);
            if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
                aFi.setTitle(R.string.delivery_title_edit);
            } else if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_ADD)) {
                aFi.setTitle(R.string.delivery_title_add);
            }
        }
    }

    private boolean aFs() {
        return this.dlQ.getEditAdapter().aFs();
    }

    public void aFt() {
        if (aFs()) {
            this.dlR = new g.a(this).hi("退出后已编辑的信息不会保存").d("退出编辑").c("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.gh(false);
                }
            }).d(PayHelper.STATUS_CANCEL_DESC, null).Qv();
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
        SwanAppBdActionBar aFi = aFi();
        if (aFi != null) {
            if (z) {
                aFi.setRightTxtZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeliveryEditActivity.this.aFu();
                    }
                });
            } else {
                aFi.setRightTxtZone2OnClickListener(null);
            }
            this.dlS = z;
            gj(com.baidu.swan.apps.u.a.JE().Kd());
        }
    }

    private void gj(boolean z) {
        int parseColor;
        SwanAppBdActionBar aFi = aFi();
        if (aFi != null) {
            if (z) {
                if (this.dlS) {
                    parseColor = Color.parseColor("#1D3A7F");
                } else {
                    parseColor = Color.parseColor("#555555");
                }
            } else if (this.dlS) {
                parseColor = Color.parseColor("#3C76FF");
            } else {
                parseColor = Color.parseColor("#33666666");
            }
            aFi.setRightTxtZone1TextColor(parseColor);
        }
    }

    public void aFu() {
        Map<String, Object> deliveryEditData = this.dlQ.getDeliveryEditData();
        if (p(deliveryEditData)) {
            final com.baidu.tieba.aiapps.apps.address.c.b s = com.baidu.tieba.aiapps.apps.address.c.b.s(deliveryEditData);
            if (!TextUtils.isEmpty(this.dlP.id)) {
                s.id = this.dlP.id;
            }
            if (s != null) {
                a.C0319a c0319a = new a.C0319a() { // from class: com.baidu.tieba.aiapps.apps.address.DeliveryEditActivity.5
                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0319a, com.baidu.tieba.aiapps.apps.address.b.b
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

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0319a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void ac(String str, int i) {
                        DeliveryEditActivity.this.a(s, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0319a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.aFj();
                        d.a(AppRuntime.getAppContext(), "保存失败").QO();
                    }

                    @Override // com.baidu.tieba.aiapps.apps.address.b.a.C0319a, com.baidu.tieba.aiapps.apps.address.b.b
                    public void sa(String str) {
                        DeliveryEditActivity.this.aFj();
                        d.a(AppRuntime.getAppContext(), str).QO();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(s.id)) {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFD().c(s, c0319a);
                } else {
                    com.baidu.tieba.aiapps.apps.address.b.a.aFD().a(s, c0319a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.aiapps.apps.address.c.b bVar, String str) {
        boolean z;
        bVar.aFQ();
        List<com.baidu.tieba.aiapps.apps.address.c.b> aFG = com.baidu.tieba.aiapps.apps.address.b.a.aFD().aFG();
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_ADD)) {
            if (aFG.size() == 0) {
                bVar.dmQ = true;
            }
            aFG.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= aFG.size()) {
                    break;
                }
                com.baidu.tieba.aiapps.apps.address.c.b bVar2 = aFG.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aFG.add(0, aFG.remove(i));
                    z = true;
                    break;
                }
            }
        }
        aFj();
        gh(z);
        return z;
    }

    private boolean p(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.tieba.aiapps.apps.address.c.b.sd(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").QO();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.tieba.aiapps.apps.address.c.b.se(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").QO();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.dlT = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString(AddressManageResult.KEY_ADDR_INFO);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.dlP = com.baidu.tieba.aiapps.apps.address.c.b.bD(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}
