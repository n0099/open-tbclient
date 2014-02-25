package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.by;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class FacePackageDetailActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
    private v a;
    private x b;
    private ac c;
    private j d;
    private boolean e = false;
    private Rect f = new Rect();
    private by g = new q(this);
    private com.baidu.tieba.i h = new r(this, this);

    public static void a(Context context, String str, boolean z, String str2) {
        Intent intent = new Intent(context, FacePackageDetailActivity.class);
        intent.putExtra("st_type", str2);
        intent.putExtra("pkg_id", str);
        intent.putExtra("is_downloading", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        e();
        a();
    }

    private void e() {
        this.b = new x(this);
        f();
        com.baidu.tieba.im.messageCenter.e.a().a(-122, this);
        com.baidu.tieba.d.d.a();
    }

    private void a(Bundle bundle) {
        this.a = new v();
        if (bundle != null) {
            this.a.c(bundle.getString("st_type"));
            this.a.b(bundle.getString("pkg_id"));
            this.a.a(bundle.getBoolean("is_downloading"));
        } else {
            this.a.c(getIntent().getStringExtra("st_type"));
            this.a.b(getIntent().getStringExtra("pkg_id"));
            this.a.a(getIntent().getBooleanExtra("is_downloading", false));
            com.baidu.tieba.ai.a(this, getIntent().getStringExtra("st_type"));
        }
        this.a.a(this.h);
    }

    public void a() {
        showProgressBar();
        this.a.g();
    }

    private void f() {
        this.b.a(this.g);
    }

    private void g() {
        this.b.b(this.g);
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
                            com.baidu.tieba.ai.a(this, "emotion_package_detail_free");
                            String b = this.a.b();
                            com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(this.a.e());
                            aVar.a(1);
                            aVar.e((String) null);
                            aVar.b(11);
                            com.baidu.tieba.d.d.a().a(aVar);
                            if (!bs.c(b)) {
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
                            com.baidu.tieba.ai.a(this, "emotion_package_detail_buy");
                            b();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.b.k()) {
                com.baidu.tieba.d.a aVar2 = new com.baidu.tieba.d.a(this.a.e());
                aVar2.a(4);
                aVar2.e((String) null);
                aVar2.b(11);
                com.baidu.tieba.d.d.a().a(aVar2);
                this.a.a(false);
                com.baidu.tieba.d.d.a().a(this.a.e());
            }
            super.onClick(view);
        }
    }

    private void h() {
        this.c = new ac();
        this.c.a(this.a.e());
        com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(this.a.e());
        aVar.b(11);
        aVar.a(2);
        aVar.e(getResources().getString(R.string.neterror));
        this.c.setLoadDataCallBack(new s(this, aVar));
    }

    public void a(String str, String str2, String str3) {
        com.baidu.tieba.d.d.a().a(str, str2, str3);
    }

    public void b() {
        showProgressBar();
        String e = this.a.e();
        this.d = new j();
        this.d.setLoadDataCallBack(new t(this));
        this.d.a(e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        if (this.b != null) {
            this.b.h();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tieba.f
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
                    if (bs.c(stringExtra)) {
                        stringExtra = this.a.f();
                    }
                    this.b.e();
                    this.d = new j();
                    this.d.setLoadDataCallBack(new u(this));
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
    public void a(com.baidu.tieba.im.message.s sVar) {
        List<com.baidu.tieba.d.a> a;
        com.baidu.tieba.d.a aVar;
        if (this.a != null && this.a.a() != null && this.b != null && sVar.w() == -122 && (sVar instanceof com.baidu.tieba.d.b) && (a = ((com.baidu.tieba.d.b) sVar).a()) != null) {
            FacePackageData facePackageData = this.a.a().facePackage;
            if (a.size() >= 1 && (aVar = a.get(0)) != null && aVar.a().equals(this.a.e())) {
                int f = aVar.f();
                if (f == 3 || f == 0) {
                    facePackageData.downloaded = 1;
                    facePackageData.downloading = 0;
                } else if (f == 2 || f == 4) {
                    if (!bs.c(aVar.n())) {
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

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a(view, i);
        return true;
    }

    private void a(View view, int i) {
        FacePackageData facePackageData;
        if (view != null) {
            view.getDrawingRect(this.f);
            ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.f);
            if (this.a.a() != null && (facePackageData = this.a.a().facePackage) != null) {
                this.b.a(i, this.f, facePackageData);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b.l()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.b.m();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.f.set(x, y, x + 1, y + 1);
                    GridView o = this.b.o();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(o, this.f);
                    int pointToPosition = o.pointToPosition(this.f.left, this.f.top);
                    if (pointToPosition != -1) {
                        a(o.getChildAt(pointToPosition - o.getFirstVisiblePosition()), pointToPosition);
                        break;
                    }
                    break;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.n();
    }
}
