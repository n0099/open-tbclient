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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
public class FacePackageDetailActivity extends BaseActivity {
    private am a;
    private ao b;
    private ar c;
    private z d;
    private boolean e = false;
    private final Rect f = new Rect();
    private final com.baidu.tbadk.core.view.m g = new ag(this);
    private final BaseActivity.LoadDataCallBack h = new ah(this, this);
    private final CustomMessageListener i = new ai(this, 2001122);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.n.class, FacePackageDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        e();
        a();
    }

    private void e() {
        this.b = new ao(this);
        f();
        registerListener(this.i);
        g.a();
    }

    private void a(Bundle bundle) {
        this.a = new am();
        if (bundle != null) {
            this.a.c(bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE));
            this.a.b(bundle.getString(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.a.a(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING));
        } else {
            this.a.c(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE));
            this.a.b(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.a.a(getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, false));
            com.baidu.tbadk.core.f.a(this, getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE));
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

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null && this.b != null) {
            if (view == this.b.i()) {
                if (!TbadkApplication.isLogin()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11003);
                    return;
                } else if (this.e) {
                    switch (this.a.d()) {
                        case 2:
                        case 3:
                            com.baidu.tbadk.core.f.a(this, "emotion_package_detail_free");
                            String b = this.a.b();
                            DownloadData downloadData = new DownloadData(this.a.e());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            g.a().a(downloadData);
                            if (!com.baidu.tbadk.core.util.bm.c(b)) {
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
                            com.baidu.tbadk.core.f.a(this, "emotion_package_detail_buy");
                            b();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.b.j()) {
                DownloadData downloadData2 = new DownloadData(this.a.e());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                g.a().a(downloadData2);
                this.a.a(false);
                g.a().a(this.a.e());
            }
            super.onClick(view);
        }
    }

    private void h() {
        this.c = new ar();
        this.c.a(this.a.e());
        DownloadData downloadData = new DownloadData(this.a.e());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(com.baidu.tieba.y.neterror));
        this.c.setLoadDataCallBack(new aj(this, downloadData));
    }

    public void a(String str, String str2, String str3) {
        g.a().a(str, str2, str3);
    }

    public void b() {
        showProgressBar();
        String e = this.a.e();
        this.d = new z();
        this.d.setLoadDataCallBack(new ak(this));
        this.d.a(e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.b != null) {
            this.b.h();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
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
                    if (com.baidu.tbadk.core.util.bm.c(stringExtra)) {
                        stringExtra = this.a.f();
                    }
                    this.b.e();
                    this.d = new z();
                    this.d.setLoadDataCallBack(new al(this));
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

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b.k()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.b.l();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.f.set(x, y, x + 1, y + 1);
                    GridView n = this.b.n();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(n, this.f);
                    int pointToPosition = n.pointToPosition(this.f.left, this.f.top);
                    if (pointToPosition != -1) {
                        a(n.getChildAt(pointToPosition - n.getFirstVisiblePosition()), pointToPosition);
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
        this.b.m();
    }
}
