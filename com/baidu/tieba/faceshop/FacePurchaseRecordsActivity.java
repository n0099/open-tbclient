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
    private String aot;
    private bb auk;
    private az aul;
    private com.baidu.adp.base.h mLoadDataCallBack = new at(this);
    private com.baidu.tbadk.core.view.u atr = new au(this);

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
        this.auk = new bb(this);
        this.auk.b(new av(this));
        this.auk.a(this);
        CU();
    }

    private void d(Bundle bundle) {
        this.aul = new az(this);
        if (bundle != null) {
            this.aot = bundle.getString("st_type");
        } else {
            this.aot = getIntent().getStringExtra("st_type");
        }
        this.aul.setStType(this.aot);
        this.aul.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        if (com.baidu.adp.lib.util.j.fh()) {
            if (z) {
                showProgressBar();
            }
            this.aul.yj();
            return;
        }
        this.auk.Dx();
    }

    private void CU() {
        this.auk.c(this.atr);
    }

    private void CV() {
        this.auk.d(this.atr);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.aot);
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
        if (this.auk != null) {
            this.auk.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aul != null) {
            this.aul.cancelLoadData();
        }
        CV();
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.auk != null && this.auk.Dw() != null && (facePurchasePackageData = (FacePurchasePackageData) this.auk.Dw().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this, String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
