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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.download.DownloadData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class FaceShopActivity extends BaseActivity {
    private bp a;
    private bn b;
    private x c;
    private final HashMap<String, DownloadData> d = new HashMap<>();
    private final com.baidu.tbadk.core.view.q e = new bb(this);
    private final com.baidu.adp.base.h f = new bc(this);
    private final CustomMessageListener g = new bd(this, 0);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.p.class, FaceShopActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        a(bundle);
        this.a.c();
    }

    private void b() {
        this.a = new bp(this);
        this.a.a(new be(this));
        this.a.a(new bf(this));
        this.a.a(this);
        d();
        registerListener(2001122, this.g);
        registerListener(2001120, this.g);
        g.a();
    }

    private void a(Bundle bundle) {
        String a;
        this.b = new bn(this);
        if (bundle != null) {
            a = com.baidu.tbadk.core.atomData.p.a(bundle);
        } else {
            a = com.baidu.tbadk.core.atomData.p.a(getIntent());
            com.baidu.tbadk.core.f.a(this, a);
        }
        this.b.a(a);
        this.b.setLoadDataCallBack(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.isNetOk()) {
            if (z) {
                showProgressBar();
            }
            this.b.a(1);
            return;
        }
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b != null && this.a != null && this.b.b()) {
            this.a.d();
            this.b.a(2);
        }
    }

    private void d() {
        this.a.a(this.e);
    }

    private void e() {
        this.a.b(this.e);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bh a;
        FacePackageData facePackageData;
        if (this.b != null && this.a != null && (a = this.a.a()) != null) {
            if (i < a.getCount() && i >= 0 && (facePackageData = (FacePackageData) a.getItem(i)) != null) {
                sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.o(this, String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            if (view == this.a.k()) {
                if (!TbadkApplication.isLogin()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11037);
                    return;
                }
                EmotionManageActivity.a(this);
            }
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.a().b();
        }
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void a(int i) {
        FacePackageData facePackageData;
        if (this.a != null && this.a.a() != null && (facePackageData = (FacePackageData) this.a.a().getItem(i)) != null) {
            this.a.j();
            facePackageData.buyStatus = 1;
            facePackageData.canDownload = 1;
            this.a.a().notifyDataSetChanged();
            this.a.a().a(i);
        }
    }

    public void a() {
        this.a.i();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.a != null && this.a.a() != null) {
            if (i == 10000) {
                int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.a.a().getItem(intExtra);
                if (facePackageData != null) {
                    String str = com.baidu.tbadk.core.util.ba.c(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.a.h();
                    this.c = new x(this);
                    this.c.setLoadDataCallBack(new bg(this, intExtra));
                    this.c.b(str);
                }
            } else if (i == 11003) {
                bh a = this.a.a();
                int a2 = a.a();
                if (a2 >= 0) {
                    if (((FacePackageData) a.getItem(a2)).canDownload == 1) {
                        a.a(a2);
                    } else {
                        a.c(a2);
                    }
                }
            } else if (i == 11037) {
                EmotionManageActivity.a(this);
            }
        }
    }
}
