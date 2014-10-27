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
    private VoiceManager axQ;
    private s axR;
    private j axS;
    private View axT;
    private BaseFragmentActivity axV;
    private View axW;
    private boolean axX;
    private boolean axU = false;
    private com.baidu.adp.lib.e.b<TbImageView> Iu = UserIconBox.f(getActivity(), 8);
    private boolean axY = false;
    private Boolean axZ = null;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.axV = (BaseFragmentActivity) activity;
    }

    public j Ec() {
        return this.axS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return c(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.axU = isLogin();
        ny();
        this.axZ = null;
        if (this.axV instanceof com.baidu.tbadk.core.voice.o) {
            this.axQ = ((com.baidu.tbadk.core.voice.o) this.axV).getVoiceManager();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.axR != null) {
            this.axR.cancelLoadData();
        }
        this.axZ = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            this.axY = false;
            if (this.axZ == null) {
                this.axZ = Boolean.valueOf(com.baidu.tbadk.core.k.js().jw());
            } else {
                this.axY = this.axZ.booleanValue() ^ com.baidu.tbadk.core.k.js().jw();
                this.axZ = Boolean.valueOf(com.baidu.tbadk.core.k.js().jw());
            }
            boolean isLogin = isLogin();
            if (this.axU != isLogin) {
                this.axU = isLogin;
                ny();
            } else if (this.axY) {
                refresh();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.axT != null) {
            h.y(this.axT);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.Ek()) {
            LoginActivity.a(this.axV, 0, getString(y.forum_feed_login_tip), 11003);
        } else if (view.getId() == h.El()) {
            SapiFastRegActivity.b(this.axV, 22002);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.axS != null) {
            this.axS.eC(i);
        }
        if (this.axT != null) {
            h.a(this.axV, this.axT, i);
        }
    }

    private void ny() {
        if (isLogin()) {
            FrameLayout frameLayout = (FrameLayout) getView();
            if (this.axT != null) {
                h.y(this.axT);
                frameLayout.removeView(this.axT);
                this.axT = null;
            }
            this.axW.setVisibility(0);
            nu();
            Ed();
            yh();
            return;
        }
        Ei();
    }

    private View c(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(this.axV);
        this.axW = layoutInflater.inflate(w.forum_feed_view, (ViewGroup) null);
        frameLayout.addView(this.axW);
        return frameLayout;
    }

    private void yh() {
        Ee();
    }

    private void Ed() {
        this.axR = new s(this.axV);
        this.axR.setLoadDataCallBack(Ef());
    }

    private void Ee() {
        this.axR.Ts();
    }

    private com.baidu.adp.base.h Ef() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        u uVar = (u) obj;
        if (uVar != null && uVar.boF != null && uVar.boF.yV() != null && uVar.boF.yV().size() > 0) {
            this.axS.b(uVar.boF);
            this.axR.dF(true);
        } else if (!com.baidu.adp.lib.util.j.fh()) {
            this.axS.En();
        }
        this.axS.Em();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj) {
        if (this.axR != null && this.axR.Tr()) {
            this.axS.b(this.axR.Tv());
            if (this.axR.Tp() && this.axS != null) {
                this.axS.Eo();
            }
            this.axR.dF(false);
            if (!this.axR.tX() && this.axS != null) {
                this.axS.Ep();
            }
            if (this.axR.Tu() == 1) {
                TiebaStatic.eventStat(this.axV, "forum_feed_refresh", "refresh", 1, new Object[0]);
            } else if (this.axR.Tu() == 2) {
                TiebaStatic.eventStat(this.axV, "forum_feed_loadmore", "load_more", 1, new Object[0]);
            }
        } else if (this.axS != null) {
            this.axS.DG();
            this.axS.En();
        }
        if (this.axR != null) {
            this.axR.dF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eg() {
        if (this.axR != null) {
            int errorCode = this.axR.getErrorCode();
            String errorString = this.axR.getErrorString();
            if (this.axS != null) {
                this.axS.DG();
                if (!this.axR.Tr()) {
                    this.axS.En();
                }
            }
            if (errorCode != 0 && errorString != "" && com.baidu.adp.lib.util.j.fh()) {
                this.axV.showToast(errorString);
            }
        }
    }

    private boolean isLogin() {
        return (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
    }

    private void nu() {
        this.axS = new j(this.axV, this);
        this.axS.b(new c(this));
        this.axS.a(new d(this));
        this.axS.h(new e(this));
        this.axS.e(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.axX = true;
        if (this.axR == null) {
            Ed();
        }
        if (com.baidu.adp.lib.util.j.fh()) {
            this.axR.gD(1);
        } else {
            this.axS.DG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        if (this.axR.isIdle() && this.axR.tX() && com.baidu.adp.lib.util.j.fh()) {
            this.axS.DF();
            this.axR.gD(2);
        }
    }

    private void Ei() {
        FrameLayout frameLayout = (FrameLayout) getView();
        if (this.axT != null) {
            frameLayout.removeView(this.axT);
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.axT = h.a(this.axV, getResources().getString(y.forum_feed_login_tip), skinType, this);
        this.axW.setVisibility(8);
        frameLayout.addView(this.axT);
    }

    @Override // com.baidu.tbadk.core.view.ae
    public ListView getListView() {
        return this.axS.ud();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.axS == null) {
            return 0;
        }
        return this.axS.Eu();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        return this.Iu;
    }
}
