package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.model.aa;
import com.baidu.tieba.model.ac;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.ae;
import com.baidu.tieba.voice.ag;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumFeedActivity extends com.baidu.tieba.j implements ag {

    /* renamed from: a  reason: collision with root package name */
    VoiceManager f1229a;
    private aa b;
    private i c;
    private View d;
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        this.f1229a = new VoiceManager();
        this.f1229a.a((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.c != null) {
            this.c.j();
        }
        if (this.f1229a != null) {
            this.f1229a.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.e) {
            c();
            return;
        }
        if (this.c != null) {
            this.c.k();
        }
        if (this.f1229a != null) {
            this.f1229a.c(this);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f1229a != null) {
            this.f1229a.b((Activity) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.c != null) {
            this.c.j();
        }
        if (this.f1229a != null) {
            this.f1229a.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f1229a != null) {
            this.f1229a.g();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.a()) {
            LoginActivity.a(this, 0, getString(R.string.forum_feed_login_tip), 11003);
        } else if (view.getId() == f.b()) {
            Register2Activity.a(this, 12007);
        } else if (view.getId() == f.c()) {
            MainTabActivity.a(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.d != null) {
            f.a(this, this.d, i);
        }
    }

    private void c() {
        if (p()) {
            this.d = null;
            q();
            e();
            d();
            return;
        }
        u();
    }

    private void d() {
        f();
    }

    private void e() {
        this.b = new aa();
        this.b.setLoadDataCallBack(n());
    }

    private void f() {
        this.b.g();
    }

    private com.baidu.adp.a.g n() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        ac acVar = (ac) obj;
        if (acVar != null && acVar.f1887a != null && acVar.f1887a.a() != null && acVar.f1887a.a().size() > 0) {
            this.c.a(acVar.f1887a);
            this.b.a(true);
        }
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        if (this.b != null && this.b.e()) {
            this.c.a(this.b.j());
            if (this.b.a() && this.c != null) {
                this.c.f();
            }
            this.b.a(false);
            if (!this.b.f() && this.c != null) {
                this.c.i();
            }
            if (this.b.i() == 1) {
                StatService.onEvent(this, "forum_feed_refresh", Headers.REFRESH, 1);
            } else if (this.b.i() == 2) {
                StatService.onEvent(this, "forum_feed_loadmore", "load_more", 1);
            }
        } else if (this.c != null) {
            this.c.g();
            this.c.e();
        }
        if (this.b != null) {
            this.b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.b != null) {
            int errorCode = this.b.getErrorCode();
            String errorString = this.b.getErrorString();
            if (this.c != null) {
                this.c.g();
                if (!this.b.e()) {
                    this.c.e();
                }
            }
            if (errorCode != 0 && errorString != "" && t()) {
                a(errorString);
            }
        }
    }

    private boolean p() {
        this.e = (TiebaApplication.C() == null || TiebaApplication.H() == null) ? false : true;
        return this.e;
    }

    private void q() {
        this.c = new i(this);
        this.c.a(new b(this));
        this.c.a(new c(this));
        this.c.a(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (t()) {
            if (this.f1229a != null) {
                this.f1229a.g();
            }
            this.b.a(1);
            return;
        }
        this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.b.b() && this.b.f() && t()) {
            this.c.h();
            this.b.a(2);
        }
    }

    private boolean t() {
        return UtilHelper.i(getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    private void u() {
        this.d = f.a(this, getResources().getString(R.string.forum_feed_login_tip), TiebaApplication.g().as(), this);
        setContentView(this.d);
    }

    @Override // com.baidu.tieba.voice.ag
    public VoiceManager g_() {
        return this.f1229a;
    }

    @Override // com.baidu.tieba.voice.ag
    public ae a(VoiceManager.VoiceModel voiceModel) {
        return null;
    }
}
