package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.download.DownloadData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class FaceShopActivity extends BaseActivity {
    private x atm;
    private bq auu;
    private bo auv;
    private final HashMap<String, DownloadData> auw = new HashMap<>();
    private final com.baidu.tbadk.core.view.u atr = new bc(this);
    private final com.baidu.adp.base.h mLoadDataCallBack = new bd(this);
    private final CustomMessageListener Sg = new be(this, 0);

    static {
        TbadkApplication.m251getInst().RegisterIntent(FaceShopActivityConfig.class, FaceShopActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        d(bundle);
        this.auu.DC();
    }

    private void initUI() {
        this.auu = new bq(this);
        this.auu.b(new bf(this));
        this.auu.a(new bg(this));
        this.auu.a(this);
        CU();
        registerListener(2001122, this.Sg);
        registerListener(2001120, this.Sg);
        g.CJ();
    }

    private void d(Bundle bundle) {
        String st_type;
        this.auv = new bo(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            com.baidu.tbadk.core.j.l(this, st_type);
        }
        this.auv.eV(st_type);
        this.auv.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (com.baidu.adp.lib.util.j.fh()) {
            if (z) {
                showProgressBar();
            }
            this.auv.ey(1);
            return;
        }
        this.auu.Dx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy() {
        if (this.auv != null && this.auu != null && this.auv.getHasMore()) {
            this.auu.DD();
            this.auv.ey(2);
        }
    }

    private void CU() {
        this.auu.c(this.atr);
    }

    private void CV() {
        this.auu.d(this.atr);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bi DB;
        FacePackageData facePackageData;
        if (this.auv != null && this.auu != null && (DB = this.auu.DB()) != null) {
            if (i < DB.getCount() && i >= 0 && (facePackageData = (FacePackageData) DB.getItem(i)) != null) {
                sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this, String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.auu != null) {
            if (view == this.auu.DG()) {
                if (!TbadkApplication.isLogin()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11037);
                    return;
                }
                EmotionManageActivity.S(this);
            }
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.auv != null) {
            this.auv.cancelLoadData();
        }
        if (this.auu != null) {
            this.auu.DB().onDestroy();
        }
        if (this.atm != null) {
            this.atm.cancelLoadData();
        }
        CV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.auu != null) {
            this.auu.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.auu != null) {
            this.auu.onChangeSkinType(i);
        }
    }

    public void eu(int i) {
        FacePackageData facePackageData;
        if (this.auu != null && this.auu.DB() != null && (facePackageData = (FacePackageData) this.auu.DB().getItem(i)) != null) {
            this.auu.Dn();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.auu.DB().notifyDataSetChanged();
            this.auu.DB().ev(i);
        }
    }

    public void CZ() {
        this.auu.Dm();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.auu != null && this.auu.DB() != null) {
            if (i == 10000) {
                int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.auu.DB().getItem(intExtra);
                if (facePackageData != null) {
                    String str = com.baidu.tbadk.core.util.az.aA(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.auu.Dl();
                    this.atm = new x(this);
                    this.atm.setLoadDataCallBack(new bh(this, intExtra));
                    this.atm.eP(str);
                }
            } else if (i == 11003) {
                bi DB = this.auu.DB();
                int Dz = DB.Dz();
                if (Dz >= 0) {
                    if (((FacePackageData) DB.getItem(Dz)).can_download == 1) {
                        DB.ev(Dz);
                    } else {
                        DB.ex(Dz);
                    }
                }
            } else if (i == 11037) {
                EmotionManageActivity.S(this);
            }
        }
    }
}
