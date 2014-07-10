package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class FacePurchaseRecordsActivity extends BaseActivity {
    private bc a;
    private ba b;
    private String c;
    private com.baidu.adp.base.h d = new av(this);
    private com.baidu.tbadk.core.view.m e = new aw(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, FacePurchaseRecordsActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        a();
        a(true);
    }

    private void a() {
        this.a = new bc(this);
        this.a.a(new ax(this));
        this.a.a(this);
        b();
    }

    private void a(Bundle bundle) {
        this.b = new ba();
        if (bundle != null) {
            this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        } else {
            this.c = getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        }
        this.b.a(this.c);
        this.b.setLoadDataCallBack(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.isNetOk()) {
            if (z) {
                showProgressBar();
            }
            this.b.a();
            return;
        }
        this.a.b();
    }

    private void b() {
        this.a.a(this.e);
    }

    private void c() {
        this.a.b(this.e);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.c);
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
        if (this.a != null) {
            this.a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.e();
        }
        c();
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.a != null && this.a.a() != null && (facePurchasePackageData = (FacePurchasePackageData) this.a.a().getItem(i)) != null) {
            sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.n(this, String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
