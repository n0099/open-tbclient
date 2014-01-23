package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.view.br;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class FacePackageDetailActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private w a;
    private z b;
    private ac c;
    private j d;
    private boolean e = false;
    private br f = new r(this);
    private com.baidu.tieba.m g = new s(this);

    public static void a(Context context, String str, boolean z, String str2) {
        Intent intent = new Intent(context, FacePackageDetailActivity.class);
        intent.putExtra("st_type", str2);
        intent.putExtra("pkg_id", str);
        intent.putExtra("is_downloading", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        e();
        a();
    }

    private void e() {
        this.b = new z(this);
        f();
        com.baidu.tieba.im.messageCenter.e.a().a(-122, this);
        com.baidu.tieba.c.d.a();
    }

    private void a(Bundle bundle) {
        this.a = new w();
        if (bundle != null) {
            this.a.c(bundle.getString("st_type"));
            this.a.b(bundle.getString("pkg_id"));
            this.a.a(bundle.getBoolean("is_downloading"));
        } else {
            this.a.c(getIntent().getStringExtra("st_type"));
            this.a.b(getIntent().getStringExtra("pkg_id"));
            this.a.a(getIntent().getBooleanExtra("is_downloading", false));
            com.baidu.tieba.ao.a(this, getIntent().getStringExtra("st_type"));
        }
        this.a.a(this.g);
    }

    public void a() {
        showProgressBar();
        this.a.g();
    }

    private void f() {
        this.b.a(this.f);
    }

    private void g() {
        this.b.b(this.f);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null && this.b != null) {
            if (view == this.b.j()) {
                if (!TiebaApplication.B()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11003);
                    return;
                } else if (this.e) {
                    switch (this.a.d()) {
                        case 2:
                        case 3:
                            com.baidu.tieba.ao.a(this, "emotion_package_detail_free");
                            String b = this.a.b();
                            com.baidu.tieba.c.a aVar = new com.baidu.tieba.c.a(this.a.e());
                            aVar.a(1);
                            aVar.d((String) null);
                            aVar.b(11);
                            com.baidu.tieba.c.d.a().a(aVar);
                            if (!bu.c(b)) {
                                if (this.a.a() != null && this.a.a().facePackage != null) {
                                    a(this.a.e(), this.a.a().facePackage.pname, b);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                h();
                                break;
                            }
                            break;
                        case 4:
                            com.baidu.tieba.ao.a(this, "emotion_package_detail_buy");
                            b();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.b.k()) {
                com.baidu.tieba.c.a aVar2 = new com.baidu.tieba.c.a(this.a.e());
                aVar2.a(4);
                aVar2.d((String) null);
                aVar2.b(11);
                com.baidu.tieba.c.d.a().a(aVar2);
                this.a.a(false);
                com.baidu.tieba.c.d.a().a(this.a.e());
            }
            super.onClick(view);
        }
    }

    private void h() {
        this.c = new ac();
        this.c.a(this.a.e());
        com.baidu.tieba.c.a aVar = new com.baidu.tieba.c.a(this.a.e());
        aVar.b(11);
        aVar.a(2);
        aVar.d(getResources().getString(R.string.neterror));
        this.c.setLoadDataCallBack(new t(this, aVar));
    }

    public void a(String str, String str2, String str3) {
        com.baidu.tieba.c.d.a().a(str, str2, str3);
    }

    public void b() {
        showProgressBar();
        String e = this.a.e();
        this.d = new j();
        this.d.setLoadDataCallBack(new u(this));
        this.d.a(e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        if (this.b != null) {
            this.b.h();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.i();
        }
        if (this.a != null) {
            this.a.cancelLoadData();
        }
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        if (this.d != null) {
            this.d.cancelLoadData();
        }
        g();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
        super.onChangeSkinType(i);
    }

    public void c() {
        this.b.g();
        h();
    }

    public void d() {
        this.b.f();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.b != null && this.a != null && this.a.a() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.a.a().facePackage != null) {
                    if (bu.c(stringExtra)) {
                        stringExtra = this.a.f();
                    }
                    this.b.e();
                    this.d = new j();
                    this.d.setLoadDataCallBack(new v(this));
                    this.d.b(stringExtra);
                }
            } else if (i == 11003) {
                if (this.a.a().facePackage.canDownload == 1) {
                    h();
                } else {
                    b();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        List<com.baidu.tieba.c.a> a;
        com.baidu.tieba.c.a aVar;
        if (this.a != null && this.a.a() != null && this.b != null && qVar.w() == -122 && (qVar instanceof com.baidu.tieba.c.b) && (a = ((com.baidu.tieba.c.b) qVar).a()) != null) {
            FacePackageData facePackageData = this.a.a().facePackage;
            if (a.size() >= 1 && (aVar = a.get(0)) != null && aVar.a().equals(this.a.e())) {
                int f = aVar.f();
                if (f == 3 || f == 0) {
                    facePackageData.downloaded = 1;
                    facePackageData.downloading = 0;
                } else if (f == 2 || f == 4) {
                    if (!bu.c(aVar.n())) {
                        showToast(aVar.n());
                    }
                    if (this.c != null) {
                        this.c.cancelLoadData();
                    }
                    facePackageData.downloaded = 0;
                    facePackageData.downloading = 0;
                } else if (f == 1) {
                    facePackageData.downloading = 1;
                    facePackageData.downloaded = 0;
                    facePackageData.downloadTotal = aVar.i();
                    facePackageData.downloadNow = aVar.h();
                }
            }
            this.a.a(facePackageData);
            this.b.c(this.a);
        }
    }
}
