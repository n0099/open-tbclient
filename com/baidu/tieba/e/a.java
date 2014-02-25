package com.baidu.tieba.e;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.view.df;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.af;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.j implements df {
    private VoiceManager b;
    private com.baidu.tieba.model.p c;
    private i d;
    private View e;
    private com.baidu.tieba.k g;
    private View h;
    private boolean i;
    private boolean f = false;
    private com.baidu.adp.lib.d.b<TbImageView> j = UserIconBox.a(getActivity(), 8);
    private boolean k = false;
    private Boolean l = null;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = k();
        e();
        this.l = null;
        if (this.g instanceof af) {
            this.b = ((af) this.g).h();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        if (this.d != null) {
            this.d.j();
        }
        this.l = null;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            this.k = false;
            if (this.l == null) {
                this.l = Boolean.valueOf(com.baidu.tieba.h.a.a().f());
            } else {
                this.k = this.l.booleanValue() ^ com.baidu.tieba.h.a.a().f();
                this.l = Boolean.valueOf(com.baidu.tieba.h.a.a().f());
            }
            boolean k = k();
            if (this.f != k) {
                this.f = k;
                e();
                return;
            }
            if (this.k) {
                m();
            }
            if (this.d != null) {
                this.d.k();
            }
            if (this.b != null) {
                this.b.c(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.d != null) {
            this.d.j();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.h();
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == g.a()) {
            LoginActivity.a(this.g, 0, getString(R.string.forum_feed_login_tip), 11003);
        } else if (view.getId() == g.b()) {
            SapiFastRegActivity.a(this.g, 22002);
        } else if (view.getId() == g.c()) {
            com.baidu.tieba.mainentrance.f.a(this.g, 2);
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.e != null) {
            g.a(this.g, this.e, i);
        }
    }

    private void e() {
        if (k()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.e != null) {
                frameLayout.removeView(this.e);
                this.e = null;
            }
            this.h.setVisibility(0);
            l();
            g();
            f();
            return;
        }
        p();
    }

    private View a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.h = layoutInflater.inflate(R.layout.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.h);
        return frameLayout;
    }

    private void f() {
        h();
    }

    private void g() {
        this.c = new com.baidu.tieba.model.p();
        this.c.setLoadDataCallBack(i());
    }

    private void h() {
        this.c.g();
    }

    private com.baidu.adp.a.g i() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        com.baidu.tieba.model.r rVar = (com.baidu.tieba.model.r) obj;
        if (rVar != null && rVar.a != null && rVar.a.b() != null && rVar.a.b().size() > 0) {
            this.d.a(rVar.a);
            this.c.a(true);
        }
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        if (this.c != null && this.c.e()) {
            this.d.a(this.c.j());
            if (this.c.a() && this.d != null) {
                this.d.f();
            }
            this.c.a(false);
            if (!this.c.f() && this.d != null) {
                this.d.i();
            }
            if (this.c.i() == 1) {
                cb.a(this.g, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (this.c.i() == 2) {
                cb.a(this.g, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (this.d != null) {
            this.d.g();
            this.d.e();
        }
        if (this.c != null) {
            this.c.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.c != null) {
            int errorCode = this.c.getErrorCode();
            String errorString = this.c.getErrorString();
            if (this.d != null) {
                this.d.g();
                if (!this.c.e()) {
                    this.d.e();
                }
            }
            if (errorCode != 0 && errorString != "" && o()) {
                this.g.a(errorString);
            }
        }
    }

    private boolean k() {
        return (TiebaApplication.A() == null || TiebaApplication.F() == null) ? false : true;
    }

    private void l() {
        this.d = new i(this.g, this);
        this.d.a(new c(this));
        this.d.a(new d(this));
        this.d.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.i = true;
        if (this.c == null) {
            g();
        }
        if (o()) {
            this.c.a(1);
        } else {
            this.d.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.c.b() && this.c.f() && o()) {
            this.d.h();
            this.c.a(2);
        }
    }

    private boolean o() {
        return UtilHelper.h(this.g.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    private void p() {
        FrameLayout frameLayout = (FrameLayout) getView();
        if (this.e != null) {
            frameLayout.removeView(this.e);
        }
        int al = TiebaApplication.g().al();
        this.e = g.a(this.g, getResources().getString(R.string.forum_feed_login_tip), al, this);
        this.h.setVisibility(8);
        frameLayout.addView(this.e);
    }

    @Override // com.baidu.tieba.view.df
    public ListView c() {
        return this.d.m();
    }

    @Override // com.baidu.tieba.view.df
    public int a() {
        if (this.d == null) {
            return 0;
        }
        return this.d.n();
    }

    @Override // com.baidu.tieba.view.df
    public com.baidu.adp.lib.d.b<TbImageView> g_() {
        return this.j;
    }
}
