package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class FacePurchaseRecordsActivity extends com.baidu.tieba.j {
    private aq a;
    private an b;
    private String c;
    private com.baidu.adp.a.g d = new ai(this);
    private com.baidu.tieba.view.bf e = new aj(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, FacePurchaseRecordsActivity.class);
        intent.putExtra("st_type", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        a();
        a(true);
    }

    private void a() {
        this.a = new aq(this);
        this.a.a(new ah(this));
        this.a.a(this);
        b();
    }

    private void a(Bundle bundle) {
        this.b = new an();
        if (bundle != null) {
            this.c = bundle.getString("st_type");
        } else {
            this.c = getIntent().getStringExtra("st_type");
        }
        this.b.a(this.c);
        this.b.setLoadDataCallBack(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.b()) {
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
        bundle.putString("st_type", this.c);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
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

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.a != null && this.a.a() != null && (facePurchasePackageData = (FacePurchasePackageData) this.a.a().getItem(i)) != null) {
            FacePackageDetailActivity.a(this, String.valueOf(facePurchasePackageData.pid), false, "purchase_record");
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
