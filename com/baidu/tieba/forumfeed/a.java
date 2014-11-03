package com.baidu.tieba.forumfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.account.SapiFastRegActivity;
import com.baidu.tieba.model.s;
import com.baidu.tieba.model.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends BaseFragment implements ae {
    private VoiceManager axZ;
    private s aya;
    private j ayb;
    private View ayc;
    private BaseFragmentActivity aye;
    private View ayf;
    private boolean ayg;
    private boolean ayd = false;
    private com.baidu.adp.lib.e.b<TbImageView> Iv = UserIconBox.f(getActivity(), 8);
    private boolean ayh = false;
    private Boolean ayi = null;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aye = (BaseFragmentActivity) activity;
    }

    public j Ee() {
        return this.ayb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ayd = isLogin();
        ny();
        this.ayi = null;
        if (this.aye instanceof com.baidu.tbadk.core.voice.o) {
            this.axZ = ((com.baidu.tbadk.core.voice.o) this.aye).getVoiceManager();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aya != null) {
            this.aya.cancelLoadData();
        }
        this.ayi = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            this.ayh = false;
            if (this.ayi == null) {
                this.ayi = Boolean.valueOf(com.baidu.tbadk.core.l.js().jw());
            } else {
                this.ayh = this.ayi.booleanValue() ^ com.baidu.tbadk.core.l.js().jw();
                this.ayi = Boolean.valueOf(com.baidu.tbadk.core.l.js().jw());
            }
            boolean isLogin = isLogin();
            if (this.ayd != isLogin) {
                this.ayd = isLogin;
                ny();
            } else if (this.ayh) {
                refresh();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ayc != null) {
            h.y(this.ayc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.Em()) {
            LoginActivity.a(this.aye, 0, getString(y.forum_feed_login_tip), 11003);
        } else if (view.getId() == h.En()) {
            SapiFastRegActivity.b(this.aye, 22002);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ayb != null) {
            this.ayb.eC(i);
        }
        if (this.ayc != null) {
            h.a(this.aye, this.ayc, i);
        }
    }

    private void ny() {
        if (isLogin()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.ayc != null) {
                h.y(this.ayc);
                frameLayout.removeView(this.ayc);
                this.ayc = null;
            }
            this.ayf.setVisibility(0);
            nu();
            Ef();
            yj();
            return;
        }
        Ek();
    }

    private View c(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(this.aye);
        this.ayf = layoutInflater.inflate(w.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.ayf);
        return frameLayout;
    }

    private void yj() {
        Eg();
    }

    private void Ef() {
        this.aya = new s(this.aye);
        this.aya.setLoadDataCallBack(Eh());
    }

    private void Eg() {
        this.aya.Tv();
    }

    private com.baidu.adp.base.h Eh() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        u uVar = (u) obj;
        if (uVar != null && uVar.boT != null && uVar.boT.yX() != null && uVar.boT.yX().size() > 0) {
            this.ayb.b(uVar.boT);
            this.aya.dF(true);
        } else if (!com.baidu.adp.lib.util.j.fh()) {
            this.ayb.Ep();
        }
        this.ayb.Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj) {
        if (this.aya != null && this.aya.Tu()) {
            this.ayb.b(this.aya.Ty());
            if (this.aya.Ts() && this.ayb != null) {
                this.ayb.Eq();
            }
            this.aya.dF(false);
            if (!this.aya.tZ() && this.ayb != null) {
                this.ayb.Er();
            }
            if (this.aya.Tx() == 1) {
                TiebaStatic.eventStat(this.aye, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (this.aya.Tx() == 2) {
                TiebaStatic.eventStat(this.aye, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (this.ayb != null) {
            this.ayb.DI();
            this.ayb.Ep();
        }
        if (this.aya != null) {
            this.aya.dF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ei() {
        if (this.aya != null) {
            int errorCode = this.aya.getErrorCode();
            String errorString = this.aya.getErrorString();
            if (this.ayb != null) {
                this.ayb.DI();
                if (!this.aya.Tu()) {
                    this.ayb.Ep();
                }
            }
            if (errorCode != 0 && errorString != "" && com.baidu.adp.lib.util.j.fh()) {
                this.aye.showToast(errorString);
            }
        }
    }

    private boolean isLogin() {
        return (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
    }

    private void nu() {
        this.ayb = new j(this.aye, this);
        this.ayb.b(new c(this));
        this.ayb.a(new d(this));
        this.ayb.h(new e(this));
        this.ayb.e(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.ayg = true;
        if (this.aya == null) {
            Ef();
        }
        if (com.baidu.adp.lib.util.j.fh()) {
            this.aya.gD(1);
        } else {
            this.ayb.DI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        if (this.aya.isIdle() && this.aya.tZ() && com.baidu.adp.lib.util.j.fh()) {
            this.ayb.DH();
            this.aya.gD(2);
        }
    }

    private void Ek() {
        FrameLayout frameLayout = (FrameLayout) getView();
        if (this.ayc != null) {
            frameLayout.removeView(this.ayc);
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.ayc = h.a(this.aye, getResources().getString(y.forum_feed_login_tip), skinType, this);
        this.ayf.setVisibility(8);
        frameLayout.addView(this.ayc);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public ListView getListView() {
        return this.ayb.uf();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.ayb == null) {
            return 0;
        }
        return this.ayb.Ew();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        return this.Iv;
    }
}
