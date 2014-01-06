package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.model.aa;
import com.baidu.tieba.model.ac;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.view.cj;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.af;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ForumFeedActivity extends BaseFragment implements cj {
    private VoiceManager a;
    private aa b;
    private i c;
    private View d;
    private BaseFragmentActivity f;
    private View g;
    private boolean h;
    private boolean e = false;
    private com.baidu.adp.lib.d.b<TbImageView> i = UserIconBox.a(i(), 8);
    private boolean Y = false;
    private Boolean Z = null;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.f = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        this.e = N();
        H();
        this.Z = null;
        if (this.f instanceof af) {
            this.a = ((af) this.f).d_();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.c != null) {
            this.c.j();
        }
        this.Z = null;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (F()) {
            this.Y = false;
            if (this.Z == null) {
                this.Z = Boolean.valueOf(com.baidu.tieba.e.a.a().f());
            } else {
                this.Y = this.Z.booleanValue() != com.baidu.tieba.e.a.a().f();
                this.Z = Boolean.valueOf(com.baidu.tieba.e.a.a().f());
            }
            boolean N = N();
            if (this.e != N) {
                this.e = N;
                H();
                return;
            }
            if (this.Y) {
                P();
            }
            if (this.c != null) {
                this.c.k();
            }
            if (this.a != null) {
                this.a.c(this.f);
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        if (this.c != null) {
            this.c.j();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void s() {
        super.s();
        if (this.a != null) {
            this.a.h();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.a()) {
            LoginActivity.a(this.f, 0, a(R.string.forum_feed_login_tip), 11003);
        } else if (view.getId() == f.b()) {
            Register2Activity.a(this.f, 12007);
        } else if (view.getId() == f.c()) {
            MainTabActivity.a(this.f, 2);
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.d != null) {
            f.a(this.f, this.d, i);
        }
    }

    private void H() {
        if (N()) {
            FrameLayout frameLayout = (FrameLayout) q();
            if (this.d != null) {
                frameLayout.removeView(this.d);
                this.d = null;
            }
            this.g.setVisibility(0);
            O();
            J();
            I();
            return;
        }
        S();
    }

    private View a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(this.f);
        this.g = layoutInflater.inflate(R.layout.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.g);
        return frameLayout;
    }

    private void I() {
        K();
    }

    private void J() {
        this.b = new aa();
        this.b.setLoadDataCallBack(L());
    }

    private void K() {
        this.b.g();
    }

    private com.baidu.adp.a.g L() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        ac acVar = (ac) obj;
        if (acVar != null && acVar.a != null && acVar.a.b() != null && acVar.a.b().size() > 0) {
            this.c.a(acVar.a);
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
                StatService.onEvent(this.f, "forum_feed_refresh", Headers.REFRESH, 1);
            } else if (this.b.i() == 2) {
                StatService.onEvent(this.f, "forum_feed_loadmore", "load_more", 1);
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
    public void M() {
        if (this.b != null) {
            int errorCode = this.b.getErrorCode();
            String errorString = this.b.getErrorString();
            if (this.c != null) {
                this.c.g();
                if (!this.b.e()) {
                    this.c.e();
                }
            }
            if (errorCode != 0 && errorString != "" && R()) {
                this.f.a(errorString);
            }
        }
    }

    private boolean N() {
        return (TiebaApplication.A() == null || TiebaApplication.G() == null) ? false : true;
    }

    private void O() {
        this.c = new i(this.f, this);
        this.c.a(new b(this));
        this.c.a(new c(this));
        this.c.a(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.h = true;
        if (this.b == null) {
            J();
        }
        if (R()) {
            this.b.a(1);
        } else {
            this.c.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.b.b() && this.b.f() && R()) {
            this.c.h();
            this.b.a(2);
        }
    }

    private boolean R() {
        return UtilHelper.g(this.f.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    private void S() {
        FrameLayout frameLayout = (FrameLayout) q();
        if (this.d != null) {
            frameLayout.removeView(this.d);
        }
        int an = TiebaApplication.g().an();
        this.d = f.a(this.f, j().getString(R.string.forum_feed_login_tip), an, this);
        this.g.setVisibility(8);
        frameLayout.addView(this.d);
    }

    @Override // com.baidu.tieba.view.cj
    public ListView c() {
        return this.c.m();
    }

    @Override // com.baidu.tieba.view.cj
    public int a() {
        if (this.c == null) {
            return 0;
        }
        return this.c.n();
    }

    @Override // com.baidu.tieba.view.cj
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.i;
    }
}
