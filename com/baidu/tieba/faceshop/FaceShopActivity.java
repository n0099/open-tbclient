package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.util.HashMap;
/* loaded from: classes.dex */
public class FaceShopActivity extends com.baidu.tbadk.a {
    private bu a;
    private bs b;
    private x c;
    private final HashMap<String, com.baidu.tieba.download.a> d = new HashMap<>();
    private final com.baidu.tbadk.core.view.m e = new bg(this);
    private final com.baidu.adp.a.h f = new bh(this);
    private final com.baidu.adp.framework.c.a g = new bi(this, 0);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.j.class, FaceShopActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        String a;
        super.onCreate(bundle);
        this.a = new bu(this);
        this.a.a(new bj(this));
        this.a.a(new bk(this));
        this.a.a(this);
        this.a.a(this.e);
        registerListener(2001122, this.g);
        registerListener(2001120, this.g);
        f.a();
        this.b = new bs();
        if (bundle != null) {
            a = com.baidu.tbadk.core.b.j.a(bundle);
        } else {
            a = com.baidu.tbadk.core.b.j.a(getIntent());
            com.baidu.tbadk.core.g.a(this, a);
        }
        this.b.a(a);
        this.b.setLoadDataCallBack(this.f);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.a()) {
            if (z) {
                showProgressBar();
            }
            this.b.a(1);
            return;
        }
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(FaceShopActivity faceShopActivity) {
        if (faceShopActivity.b == null || faceShopActivity.a == null || !faceShopActivity.b.b()) {
            return;
        }
        faceShopActivity.a.c();
        faceShopActivity.b.a(2);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bm a;
        FacePackageData facePackageData;
        if (this.b != null && this.a != null && (a = this.a.a()) != null) {
            if (i < a.getCount() && i >= 0 && (facePackageData = (FacePackageData) a.getItem(i)) != null) {
                sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.i(this, String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            if (view == this.a.k()) {
                if (!TbadkApplication.F()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11037);
                    return;
                }
                EmotionManageActivity.a(this);
            }
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.g();
            this.a.a().c();
        }
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        this.a.b(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        if (this.a != null) {
            this.a.g();
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public final void a(int i) {
        FacePackageData facePackageData;
        if (this.a != null && this.a.a() != null && (facePackageData = (FacePackageData) this.a.a().getItem(i)) != null) {
            this.a.j();
            facePackageData.buyStatus = 1;
            facePackageData.canDownload = 1;
            this.a.a().notifyDataSetChanged();
            this.a.a().a(i);
        }
    }

    public final void a() {
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
                    String str = com.baidu.tbadk.core.util.bc.c(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.a.h();
                    this.c = new x();
                    this.c.setLoadDataCallBack(new bl(this, intExtra));
                    this.c.b(str);
                }
            } else if (i == 11003) {
                bm a = this.a.a();
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
