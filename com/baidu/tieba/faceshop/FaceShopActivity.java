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
    private x atd;
    private bq aul;
    private bo aum;
    private final HashMap<String, DownloadData> aun = new HashMap<>();
    private final com.baidu.tbadk.core.view.u ati = new bc(this);
    private final com.baidu.adp.base.h mLoadDataCallBack = new bd(this);
    private final CustomMessageListener Sc = new be(this, 0);

    static {
        TbadkApplication.m251getInst().RegisterIntent(FaceShopActivityConfig.class, FaceShopActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        d(bundle);
        this.aul.DA();
    }

    private void initUI() {
        this.aul = new bq(this);
        this.aul.b(new bf(this));
        this.aul.a(new bg(this));
        this.aul.a(this);
        CS();
        registerListener(2001122, this.Sc);
        registerListener(2001120, this.Sc);
        g.CH();
    }

    private void d(Bundle bundle) {
        String st_type;
        this.aum = new bo(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            com.baidu.tbadk.core.i.l(this, st_type);
        }
        this.aum.eV(st_type);
        this.aum.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (com.baidu.adp.lib.util.j.fh()) {
            if (z) {
                showProgressBar();
            }
            this.aum.ey(1);
            return;
        }
        this.aul.Dv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw() {
        if (this.aum != null && this.aul != null && this.aum.getHasMore()) {
            this.aul.DB();
            this.aum.ey(2);
        }
    }

    private void CS() {
        this.aul.c(this.ati);
    }

    private void CT() {
        this.aul.d(this.ati);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bi Dz;
        FacePackageData facePackageData;
        if (this.aum != null && this.aul != null && (Dz = this.aul.Dz()) != null) {
            if (i < Dz.getCount() && i >= 0 && (facePackageData = (FacePackageData) Dz.getItem(i)) != null) {
                sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this, String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aul != null) {
            if (view == this.aul.DE()) {
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
        if (this.aum != null) {
            this.aum.cancelLoadData();
        }
        if (this.aul != null) {
            this.aul.Dz().onDestroy();
        }
        if (this.atd != null) {
            this.atd.cancelLoadData();
        }
        CT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.aul != null) {
            this.aul.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aul != null) {
            this.aul.onChangeSkinType(i);
        }
    }

    public void eu(int i) {
        FacePackageData facePackageData;
        if (this.aul != null && this.aul.Dz() != null && (facePackageData = (FacePackageData) this.aul.Dz().getItem(i)) != null) {
            this.aul.Dl();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.aul.Dz().notifyDataSetChanged();
            this.aul.Dz().ev(i);
        }
    }

    public void CX() {
        this.aul.Dk();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.aul != null && this.aul.Dz() != null) {
            if (i == 10000) {
                int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.aul.Dz().getItem(intExtra);
                if (facePackageData != null) {
                    String str = com.baidu.tbadk.core.util.ay.aA(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.aul.Dj();
                    this.atd = new x(this);
                    this.atd.setLoadDataCallBack(new bh(this, intExtra));
                    this.atd.eP(str);
                }
            } else if (i == 11003) {
                bi Dz = this.aul.Dz();
                int Dx = Dz.Dx();
                if (Dx >= 0) {
                    if (((FacePackageData) Dz.getItem(Dx)).can_download == 1) {
                        Dz.ev(Dx);
                    } else {
                        Dz.ex(Dx);
                    }
                }
            } else if (i == 11037) {
                EmotionManageActivity.S(this);
            }
        }
    }
}
