package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class FacePurchaseRecordsActivity extends com.baidu.tbadk.a {
    private bf a;
    private bd b;
    private String c;
    private com.baidu.adp.a.h d = new ay(this);
    private com.baidu.tbadk.core.view.m e = new az(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, FacePurchaseRecordsActivity.class);
        intent.putExtra("st_type", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new bd();
        if (bundle != null) {
            this.c = bundle.getString("st_type");
        } else {
            this.c = getIntent().getStringExtra("st_type");
        }
        this.b.a(this.c);
        this.b.setLoadDataCallBack(this.d);
        this.a = new bf(this);
        this.a.a(new ba(this));
        this.a.a(this);
        this.a.a(this.e);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.a()) {
            if (z) {
                showProgressBar();
            }
            this.b.a();
            return;
        }
        this.a.b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.c);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.d();
        }
        this.a.b(this.e);
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.a != null && this.a.a() != null && (facePurchasePackageData = (FacePurchasePackageData) this.a.a().getItem(i)) != null) {
            sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(this, String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
