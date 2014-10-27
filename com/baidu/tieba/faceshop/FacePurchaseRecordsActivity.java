package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
/* loaded from: classes.dex */
public class FacePurchaseRecordsActivity extends BaseActivity {
    private String aok;
    private bb aub;
    private az auc;
    private com.baidu.adp.base.h mLoadDataCallBack = new at(this);
    private com.baidu.tbadk.core.view.u ati = new au(this);

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, FacePurchaseRecordsActivity.class);
        intent.putExtra("st_type", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d(bundle);
        initUI();
        bE(true);
    }

    private void initUI() {
        this.aub = new bb(this);
        this.aub.b(new av(this));
        this.aub.a(this);
        CS();
    }

    private void d(Bundle bundle) {
        this.auc = new az(this);
        if (bundle != null) {
            this.aok = bundle.getString("st_type");
        } else {
            this.aok = getIntent().getStringExtra("st_type");
        }
        this.auc.setStType(this.aok);
        this.auc.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (com.baidu.adp.lib.util.j.fh()) {
            if (z) {
                showProgressBar();
            }
            this.auc.yh();
            return;
        }
        this.aub.Dv();
    }

    private void CS() {
        this.aub.c(this.ati);
    }

    private void CT() {
        this.aub.d(this.ati);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.aok);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.aub != null) {
            this.aub.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.auc != null) {
            this.auc.cancelLoadData();
        }
        CT();
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.aub != null && this.aub.Du() != null && (facePurchasePackageData = (FacePurchasePackageData) this.aub.Du().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this, String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
