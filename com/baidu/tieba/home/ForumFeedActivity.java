package com.baidu.tieba.home;

import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumFeedActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.q f1141a;
    private s b;
    private View c;
    private boolean d = false;
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1141a != null) {
            this.f1141a.cancelLoadData();
        }
        if (this.b != null) {
            this.b.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.d) {
            b();
        } else if (this.b != null) {
            this.b.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.b != null) {
            this.b.h();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == q.a()) {
            LoginActivity.a(this, 0, getString(R.string.forum_feed_login_tip), 11003);
        } else if (view.getId() == q.b()) {
            Register2Activity.a(this, 12007);
        } else if (view.getId() == q.c()) {
            MainTabActivity.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (this.b != null) {
            this.b.a(i);
        }
        if (this.c != null) {
            q.a(this.c, i);
        }
    }

    private void b() {
        if (n()) {
            this.c = null;
            o();
            d();
            c();
            return;
        }
        s();
    }

    private void c() {
        k();
    }

    private void d() {
        this.f1141a = new com.baidu.tieba.model.q();
        this.f1141a.setLoadDataCallBack(l());
    }

    private void k() {
        this.f1141a.g();
    }

    private com.baidu.adp.a.e l() {
        return new l(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.tieba.model.s sVar = (com.baidu.tieba.model.s) obj;
        if (sVar != null && sVar.f1416a != null && sVar.f1416a.a() != null && sVar.f1416a.a().size() > 0) {
            this.b.a(sVar.f1416a);
            this.f1141a.a(true);
        }
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        if (this.f1141a != null && this.f1141a.e()) {
            this.b.a(this.f1141a.j());
            if (this.f1141a.a() && this.b != null) {
                this.b.d();
            }
            this.f1141a.a(false);
            if (!this.f1141a.f() && this.b != null) {
                this.b.g();
            }
            if (this.f1141a.i() == 1) {
                StatService.onEvent(this, "forum_feed_refresh", Headers.REFRESH, 1);
            } else if (this.f1141a.i() == 2) {
                StatService.onEvent(this, "forum_feed_loadmore", "load_more", 1);
            }
        } else if (this.b != null) {
            this.b.e();
            this.b.c();
        }
        if (this.f1141a != null) {
            this.f1141a.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f1141a != null) {
            int errorCode = this.f1141a.getErrorCode();
            String errorString = this.f1141a.getErrorString();
            if (this.b != null) {
                this.b.e();
                if (!this.f1141a.e()) {
                    this.b.c();
                }
            }
            if (errorCode != 0 && errorString != "" && r()) {
                a(errorString);
            }
        }
    }

    private boolean n() {
        this.d = (TiebaApplication.E() == null || TiebaApplication.I() == null) ? false : true;
        return this.d;
    }

    private void o() {
        this.b = new s(this);
        this.b.a(new m(this));
        this.b.a(new n(this));
        this.b.a(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (r()) {
            this.f1141a.a(1);
        } else {
            this.b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f1141a.b() && this.f1141a.f() && r()) {
            this.b.f();
            this.f1141a.a(2);
        }
    }

    private boolean r() {
        return NetWorkCore.b(this) != NetWorkCore.NetworkState.UNAVAIL;
    }

    private void s() {
        this.c = q.a(this, getResources().getString(R.string.forum_feed_login_tip), TiebaApplication.g().an(), this);
        setContentView(this.c);
    }
}
