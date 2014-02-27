package com.baidu.tieba.e;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.view.df;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.af;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class a extends com.baidu.tieba.j implements df {
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
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.h = layoutInflater.inflate(R.layout.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.h);
        return frameLayout;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = g();
        e();
        this.l = null;
        if (this.g instanceof af) {
            this.b = ((af) this.g).c_();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        if (this.d != null) {
            this.d.i();
        }
        this.l = null;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (d()) {
            this.k = false;
            if (this.l == null) {
                this.l = Boolean.valueOf(com.baidu.tieba.h.a.a().f());
            } else {
                this.k = this.l.booleanValue() ^ com.baidu.tieba.h.a.a().f();
                this.l = Boolean.valueOf(com.baidu.tieba.h.a.a().f());
            }
            boolean g = g();
            if (this.f != g) {
                this.f = g;
                e();
                return;
            }
            if (this.k) {
                h();
            }
            if (this.d != null) {
                this.d.j();
            }
            if (this.b != null) {
                this.b.b(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.d != null) {
            this.d.i();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.h();
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.login_btn) {
            LoginActivity.a(this.g, 0, getString(R.string.forum_feed_login_tip), 11003);
        } else if (view.getId() == R.id.reg_btn) {
            SapiFastRegActivity.a(this.g, 22002);
        } else if (view.getId() == R.id.btn_go) {
            com.baidu.tieba.mainentrance.d.a(this.g, 2);
        }
    }

    @Override // com.baidu.tieba.j
    public final void c(int i) {
        super.c(i);
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.e != null) {
            g.a(this.g, this.e, i);
        }
    }

    private void e() {
        if (g()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.e != null) {
                frameLayout.removeView(this.e);
                this.e = null;
            }
            this.h.setVisibility(0);
            this.d = new i(this.g, this);
            this.d.a(new c(this));
            this.d.a(new d(this));
            this.d.a(new e(this));
            f();
            this.c.e();
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) getView();
        if (this.e != null) {
            frameLayout2.removeView(this.e);
        }
        int ae = TiebaApplication.g().ae();
        String string = getResources().getString(R.string.forum_feed_login_tip);
        com.baidu.tieba.k kVar = this.g;
        h hVar = new h((byte) 0);
        View inflate = LinearLayout.inflate(kVar, R.layout.forum_feed_guide, null);
        hVar.a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        hVar.c = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        hVar.b = new com.baidu.tieba.home.r(kVar, string, string, 0);
        hVar.a.addView(hVar.b.a());
        inflate.setTag(hVar);
        g.a(kVar, inflate, ae);
        this.e = inflate;
        this.h.setVisibility(8);
        frameLayout2.addView(this.e);
    }

    private void f() {
        this.c = new com.baidu.tieba.model.p();
        this.c.setLoadDataCallBack(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        com.baidu.tieba.model.r rVar = (com.baidu.tieba.model.r) obj;
        if (rVar != null && rVar.a != null && rVar.a.b() != null && rVar.a.b().size() > 0) {
            aVar.d.a(rVar.a);
            aVar.c.a(true);
        }
        aVar.d.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, Object obj) {
        if (aVar.c != null && aVar.c.c()) {
            aVar.d.a(aVar.c.h());
            if (aVar.c.a() && aVar.d != null) {
                aVar.d.e();
            }
            aVar.c.a(false);
            if (!aVar.c.d() && aVar.d != null) {
                aVar.d.h();
            }
            if (aVar.c.g() == 1) {
                cb.a(aVar.g, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (aVar.c.g() == 2) {
                cb.a(aVar.g, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (aVar.d != null) {
            aVar.d.f();
            aVar.d.d();
        }
        if (aVar.c != null) {
            aVar.c.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(a aVar) {
        if (aVar.c != null) {
            int errorCode = aVar.c.getErrorCode();
            String errorString = aVar.c.getErrorString();
            if (aVar.d != null) {
                aVar.d.f();
                if (!aVar.c.c()) {
                    aVar.d.d();
                }
            }
            if (errorCode == 0 || errorString == "" || !aVar.i()) {
                return;
            }
            aVar.g.a(errorString);
        }
    }

    private static boolean g() {
        return (TiebaApplication.v() == null || TiebaApplication.z() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.i = true;
        if (this.c == null) {
            f();
        }
        if (i()) {
            this.c.a(1);
        } else {
            this.d.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(a aVar) {
        if (aVar.c.b() && aVar.c.d() && aVar.i()) {
            aVar.d.g();
            aVar.c.a(2);
        }
    }

    private boolean i() {
        return UtilHelper.h(this.g.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    @Override // com.baidu.tieba.view.df
    public final ListView c() {
        return this.d.l();
    }

    @Override // com.baidu.tieba.view.df
    public final int a() {
        if (this.d == null) {
            return 0;
        }
        i iVar = this.d;
        return R.id.user_icon_box;
    }

    @Override // com.baidu.tieba.view.df
    public final com.baidu.adp.lib.d.b<TbImageView> b() {
        return this.j;
    }
}
