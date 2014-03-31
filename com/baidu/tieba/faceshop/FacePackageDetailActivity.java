package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
public class FacePackageDetailActivity extends com.baidu.tbadk.a {
    private ak a;
    private am b;
    private ar c;
    private x d;
    private boolean e = false;
    private final Rect f = new Rect();
    private final com.baidu.tbadk.core.view.m g = new ae(this);
    private final com.baidu.tbadk.d h = new af(this, this);
    private final com.baidu.adp.framework.c.a i = new ag(this, 2001122);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.i.class, FacePackageDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ak();
        if (bundle != null) {
            this.a.c(bundle.getString("st_type"));
            this.a.b(bundle.getString("pkg_id"));
            this.a.a(bundle.getBoolean("is_downloading"));
        } else {
            this.a.c(getIntent().getStringExtra("st_type"));
            this.a.b(getIntent().getStringExtra("pkg_id"));
            this.a.a(getIntent().getBooleanExtra("is_downloading", false));
            com.baidu.tbadk.core.g.a(this, getIntent().getStringExtra("st_type"));
        }
        this.a.a(this.h);
        this.b = new am(this);
        this.b.a(this.g);
        registerListener(this.i);
        f.a();
        a();
    }

    public final void a() {
        showProgressBar();
        this.a.g();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null && this.b != null) {
            if (view == this.b.h()) {
                if (!TbadkApplication.F()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11003);
                    return;
                } else if (this.e) {
                    switch (this.a.d()) {
                        case 2:
                        case 3:
                            com.baidu.tbadk.core.g.a(this, "emotion_package_detail_free");
                            String b = this.a.b();
                            com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(this.a.e());
                            aVar.a(1);
                            aVar.e((String) null);
                            aVar.b(11);
                            f.a();
                            f.a(aVar);
                            if (!com.baidu.tbadk.core.util.bc.c(b)) {
                                if (this.a.a() != null && this.a.a().facePackage != null) {
                                    a(this.a.e(), this.a.a().facePackage.pname, b);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                d();
                                break;
                            }
                            break;
                        case 4:
                            com.baidu.tbadk.core.g.a(this, "emotion_package_detail_buy");
                            e();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.b.i()) {
                com.baidu.tieba.download.a aVar2 = new com.baidu.tieba.download.a(this.a.e());
                aVar2.a(4);
                aVar2.e((String) null);
                aVar2.b(11);
                f.a();
                f.a(aVar2);
                this.a.a(false);
                f.a();
                f.a(this.a.e());
            }
            super.onClick(view);
        }
    }

    private void d() {
        this.c = new ar();
        this.c.a(this.a.e());
        com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(this.a.e());
        aVar.b(11);
        aVar.a(2);
        aVar.e(getResources().getString(com.baidu.tieba.a.k.neterror));
        this.c.setLoadDataCallBack(new ah(this, aVar));
    }

    public static void a(String str, String str2, String str3) {
        f.a().a(str, str2, str3);
    }

    private void e() {
        showProgressBar();
        String e = this.a.e();
        this.d = new x();
        this.d.setLoadDataCallBack(new ai(this));
        this.d.a(e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        if (this.b != null) {
            this.b.f();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.g();
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
        this.b.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        if (this.b != null) {
            this.b.a(i);
        }
        super.onChangeSkinType(i);
    }

    public final void b() {
        this.b.e();
        d();
    }

    public final void c() {
        this.b.d();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.b != null && this.a != null && this.a.a() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.a.a().facePackage != null) {
                    if (com.baidu.tbadk.core.util.bc.c(stringExtra)) {
                        stringExtra = this.a.f();
                    }
                    this.b.c();
                    this.d = new x();
                    this.d.setLoadDataCallBack(new aj(this));
                    this.d.b(stringExtra);
                }
            } else if (i == 11003) {
                if (this.a.a().facePackage.canDownload == 1) {
                    d();
                } else {
                    e();
                }
            }
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
        if (this.b.j()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.b.k();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.f.set(x, y, x + 1, y + 1);
                    GridView m = this.b.m();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(m, this.f);
                    int pointToPosition = m.pointToPosition(this.f.left, this.f.top);
                    if (pointToPosition != -1) {
                        a(m.getChildAt(pointToPosition - m.getFirstVisiblePosition()), pointToPosition);
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
        this.b.l();
    }
}
