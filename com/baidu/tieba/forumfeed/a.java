package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.w;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.model.s;
import com.baidu.tieba.model.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.d implements w {
    private VoiceManager b;
    private s c;
    private j d;
    private View e;
    private BaseFragmentActivity g;
    private View h;
    private boolean i;
    private boolean f = false;
    private com.baidu.adp.lib.d.b<TbImageView> j = UserIconBox.a(getActivity(), 8);
    private boolean k = false;
    private Boolean l = null;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = l();
        f();
        this.l = null;
        if (this.g instanceof z) {
            this.b = ((z) this.g).d();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        if (this.d != null) {
            this.d.g();
        }
        this.l = null;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (d_()) {
            this.k = false;
            if (this.l == null) {
                this.l = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
            } else {
                this.k = this.l.booleanValue() ^ com.baidu.tbadk.core.h.a().f();
                this.l = Boolean.valueOf(com.baidu.tbadk.core.h.a().f());
            }
            boolean l = l();
            if (this.f != l) {
                this.f = l;
                f();
                return;
            }
            if (this.k) {
                n();
            }
            if (this.d != null) {
                this.d.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.d != null) {
            this.d.g();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.a()) {
            LoginActivity.a(this.g, 0, getString(y.forum_feed_login_tip), 11003);
        } else if (view.getId() == h.b()) {
            SapiFastRegActivity.a(this.g, 22002);
        } else if (view.getId() == h.c()) {
            com.baidu.tbadk.core.b.b.a(this.g, 2);
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.e != null) {
            h.a(this.g, this.e, i);
        }
    }

    private void f() {
        if (l()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.e != null) {
                frameLayout.removeView(this.e);
                this.e = null;
            }
            this.h.setVisibility(0);
            m();
            h();
            g();
            return;
        }
        q();
    }

    private View a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(this.g);
        this.h = layoutInflater.inflate(com.baidu.tieba.w.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.h);
        return frameLayout;
    }

    private void g() {
        i();
    }

    private void h() {
        this.c = new s();
        this.c.setLoadDataCallBack(j());
    }

    private void i() {
        this.c.g();
    }

    private com.baidu.adp.base.e j() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        u uVar = (u) obj;
        if (uVar != null && uVar.a != null && uVar.a.b() != null && uVar.a.b().size() > 0) {
            this.d.a(uVar.a);
            this.c.a(true);
        }
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        if (this.c != null && this.c.e()) {
            this.d.a(this.c.j());
            if (this.c.a() && this.d != null) {
                this.d.c();
            }
            this.c.a(false);
            if (!this.c.f() && this.d != null) {
                this.d.f();
            }
            if (this.c.i() == 1) {
                TiebaStatic.eventStat(this.g, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (this.c.i() == 2) {
                TiebaStatic.eventStat(this.g, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (this.d != null) {
            this.d.d();
            this.d.b();
        }
        if (this.c != null) {
            this.c.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.c != null) {
            int errorCode = this.c.getErrorCode();
            String errorString = this.c.getErrorString();
            if (this.d != null) {
                this.d.d();
                if (!this.c.e()) {
                    this.d.b();
                }
            }
            if (errorCode != 0 && errorString != "" && p()) {
                this.g.a(errorString);
            }
        }
    }

    private boolean l() {
        return (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
    }

    private void m() {
        this.d = new j(this.g, this);
        this.d.a(new c(this));
        this.d.a(new d(this));
        this.d.a(new e(this));
        this.d.a(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.i = true;
        if (this.c == null) {
            h();
        }
        if (p()) {
            this.c.a(1);
        } else {
            this.d.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.c.b() && this.c.f() && p()) {
            this.d.e();
            this.c.a(2);
        }
    }

    private boolean p() {
        return UtilHelper.getNetStatusInfo(this.g.getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL;
    }

    private void q() {
        FrameLayout frameLayout = (FrameLayout) getView();
        if (this.e != null) {
            frameLayout.removeView(this.e);
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.e = h.a(this.g, getResources().getString(y.forum_feed_login_tip), skinType, this);
        this.h.setVisibility(8);
        frameLayout.addView(this.e);
    }

    @Override // com.baidu.tbadk.core.view.w
    public ListView a() {
        return this.d.j();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.d == null) {
            return 0;
        }
        return this.d.k();
    }

    @Override // com.baidu.tbadk.core.view.w
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.j;
    }
}
