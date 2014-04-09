package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.model.s;
import com.baidu.tieba.model.u;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.d implements w {
    private VoiceManager b;
    private s c;
    private j d;
    private View e;
    private com.baidu.tbadk.core.e g;
    private View h;
    private boolean i;
    private boolean f = false;
    private com.baidu.adp.lib.d.b<TbImageView> j = UserIconBox.a(getActivity(), 8);
    private boolean k = false;
    private Boolean l = null;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.h = layoutInflater.inflate(com.baidu.tieba.a.i.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.h);
        return frameLayout;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = g();
        e();
        this.l = null;
        if (this.g instanceof z) {
            this.b = ((z) this.g).d();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
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

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (c_()) {
            this.k = false;
            if (this.l == null) {
                this.l = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
            } else {
                this.k = this.l.booleanValue() ^ com.baidu.tbadk.core.h.a().f();
                this.l = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
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
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.d != null) {
            this.d.i();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == com.baidu.tieba.a.h.login_btn) {
            LoginActivity.a(this.g, 0, getString(com.baidu.tieba.a.k.forum_feed_login_tip), 11003);
        } else if (view.getId() == com.baidu.tieba.a.h.reg_btn) {
            SapiFastRegActivity.a(this.g, 22002);
        } else if (view.getId() == com.baidu.tieba.a.h.btn_go) {
            com.baidu.tbadk.core.d.b.a(this.g, 2);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.e != null) {
            h.a(this.g, this.e, i);
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
            this.d = new j(this.g, this);
            this.d.a(new c(this));
            this.d.a(new d(this));
            this.d.a(new e(this));
            this.d.a(new f(this));
            f();
            this.c.e();
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) getView();
        if (this.e != null) {
            frameLayout2.removeView(this.e);
        }
        int l = TbadkApplication.j().l();
        String string = getResources().getString(com.baidu.tieba.a.k.forum_feed_login_tip);
        com.baidu.tbadk.core.e eVar = this.g;
        i iVar = new i((byte) 0);
        View inflate = LinearLayout.inflate(eVar, com.baidu.tieba.a.i.forum_feed_guide, null);
        iVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.forum_feed_login_container);
        iVar.c = (NoNetworkView) inflate.findViewById(com.baidu.tieba.a.h.view_no_network);
        iVar.b = new com.baidu.tbadk.core.view.b(eVar, string, string, 0);
        iVar.a.addView(iVar.b.a());
        inflate.setTag(iVar);
        h.a(eVar, inflate, l);
        this.e = inflate;
        this.h.setVisibility(8);
        frameLayout2.addView(this.e);
    }

    private void f() {
        this.c = new s();
        this.c.setLoadDataCallBack(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        u uVar = (u) obj;
        if (uVar != null && uVar.a != null && uVar.a.b() != null && uVar.a.b().size() > 0) {
            aVar.d.a(uVar.a);
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
                TiebaStatic.a(aVar.g, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (aVar.c.g() == 2) {
                TiebaStatic.a(aVar.g, "forum_feed_loadmore", "load_more", 1, new Object[0]);
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
        return (TbadkApplication.E() == null || TbadkApplication.O() == null) ? false : true;
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
        return UtilHelper.d(this.g.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final ListView a() {
        return this.d.l();
    }

    @Override // com.baidu.tbadk.core.view.w
    public final int b() {
        if (this.d == null) {
            return 0;
        }
        j jVar = this.d;
        return com.baidu.tieba.a.h.user_icon_box;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.j;
    }
}
