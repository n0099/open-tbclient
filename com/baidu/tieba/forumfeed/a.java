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
import com.baidu.tieba.model.u;
/* loaded from: classes.dex */
public final class a extends com.baidu.tbadk.core.d implements w {
    private VoiceManager a;
    private com.baidu.tieba.model.s b;
    private i c;
    private View d;
    private com.baidu.tbadk.core.e f;
    private View g;
    private boolean h;
    private boolean e = false;
    private com.baidu.adp.lib.d.b<TbImageView> i = UserIconBox.a(getActivity(), 8);
    private boolean j = false;
    private Boolean k = null;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this.f);
        this.g = layoutInflater.inflate(com.baidu.tieba.a.i.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.g);
        return frameLayout;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.e = f();
        d();
        this.k = null;
        if (this.f instanceof z) {
            this.a = ((z) this.f).d();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.c != null) {
            this.c.i();
        }
        this.k = null;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (isShow()) {
            this.j = false;
            if (this.k == null) {
                this.k = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
            } else {
                this.j = this.k.booleanValue() ^ com.baidu.tbadk.core.h.a().f();
                this.k = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
            }
            boolean f = f();
            if (this.e != f) {
                this.e = f;
                d();
                return;
            }
            if (this.j) {
                g();
            }
            if (this.c != null) {
                this.c.j();
            }
            if (this.a != null) {
                this.a.b(this.f);
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
        if (this.c != null) {
            this.c.i();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.a != null) {
            this.a.h();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == com.baidu.tieba.a.h.login_btn) {
            LoginActivity.a(this.f, 0, getString(com.baidu.tieba.a.k.forum_feed_login_tip), 11003);
        } else if (view.getId() == com.baidu.tieba.a.h.reg_btn) {
            SapiFastRegActivity.a(this.f, 22002);
        } else if (view.getId() == com.baidu.tieba.a.h.btn_go) {
            com.baidu.tbadk.core.d.b.a(this.f, 2);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.c != null) {
            this.c.a(i);
        }
        if (this.d != null) {
            g.a(this.f, this.d, i);
        }
    }

    private void d() {
        if (f()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.d != null) {
                frameLayout.removeView(this.d);
                this.d = null;
            }
            this.g.setVisibility(0);
            this.c = new i(this.f, this);
            this.c.a(new c(this));
            this.c.a(new d(this));
            this.c.a(new e(this));
            e();
            this.b.e();
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) getView();
        if (this.d != null) {
            frameLayout2.removeView(this.d);
        }
        int l = TbadkApplication.j().l();
        String string = getResources().getString(com.baidu.tieba.a.k.forum_feed_login_tip);
        com.baidu.tbadk.core.e eVar = this.f;
        h hVar = new h((byte) 0);
        View inflate = LinearLayout.inflate(eVar, com.baidu.tieba.a.i.forum_feed_guide, null);
        hVar.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.forum_feed_login_container);
        hVar.c = (NoNetworkView) inflate.findViewById(com.baidu.tieba.a.h.view_no_network);
        hVar.b = new com.baidu.tbadk.core.view.b(eVar, string, string, 0);
        hVar.a.addView(hVar.b.a());
        inflate.setTag(hVar);
        g.a(eVar, inflate, l);
        this.d = inflate;
        this.g.setVisibility(8);
        frameLayout2.addView(this.d);
    }

    private void e() {
        this.b = new com.baidu.tieba.model.s();
        this.b.setLoadDataCallBack(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        u uVar = (u) obj;
        if (uVar != null && uVar.a != null && uVar.a.b() != null && uVar.a.b().size() > 0) {
            aVar.c.a(uVar.a);
            aVar.b.a(true);
        }
        aVar.c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, Object obj) {
        if (aVar.b != null && aVar.b.c()) {
            aVar.c.a(aVar.b.h());
            if (aVar.b.a() && aVar.c != null) {
                aVar.c.e();
            }
            aVar.b.a(false);
            if (!aVar.b.d() && aVar.c != null) {
                aVar.c.h();
            }
            if (aVar.b.g() == 1) {
                TiebaStatic.a(aVar.f, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (aVar.b.g() == 2) {
                TiebaStatic.a(aVar.f, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (aVar.c != null) {
            aVar.c.f();
            aVar.c.d();
        }
        if (aVar.b != null) {
            aVar.b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(a aVar) {
        if (aVar.b != null) {
            int errorCode = aVar.b.getErrorCode();
            String errorString = aVar.b.getErrorString();
            if (aVar.c != null) {
                aVar.c.f();
                if (!aVar.b.c()) {
                    aVar.c.d();
                }
            }
            if (errorCode == 0 || errorString == "" || !aVar.h()) {
                return;
            }
            aVar.f.a(errorString);
        }
    }

    private static boolean f() {
        return (TbadkApplication.E() == null || TbadkApplication.O() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.h = true;
        if (this.b == null) {
            e();
        }
        if (h()) {
            this.b.a(1);
        } else {
            this.c.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(a aVar) {
        if (aVar.b.b() && aVar.b.d() && aVar.h()) {
            aVar.c.g();
            aVar.b.a(2);
        }
    }

    private boolean h() {
        return UtilHelper.d(this.f.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final ListView a() {
        return this.c.l();
    }

    @Override // com.baidu.tbadk.core.view.w
    public final int b() {
        if (this.c == null) {
            return 0;
        }
        i iVar = this.c;
        return com.baidu.tieba.a.h.user_icon_box;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.i;
    }
}
