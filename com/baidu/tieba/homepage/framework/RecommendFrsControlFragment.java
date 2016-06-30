package com.baidu.tieba.homepage.framework;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.u;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.e.a bDd;
    private ScrollFragmentTabHost coi;
    private q coj;
    private com.baidu.tbadk.g.f cok;
    private CustomMessageTask col;
    private boolean con = false;
    private CustomMessageListener coo = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cop = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener coq = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cor = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cos = null;
    private b cot = new l(this);
    private c cou = new m(this);
    private CustomMessageListener cov = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.g.h refreshView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ControlModelMessage extends CustomMessage<q> {
        public ControlModelMessage(q qVar) {
            super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL);
            setData(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bDd == null) {
                this.bDd = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bDd.ap(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(u.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m9getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.agG().cpN = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.coi != null) {
                if (this.coi.agz()) {
                    this.coi.agr();
                    h(false, getResources().getDimensionPixelSize(u.e.ds520));
                } else {
                    this.coi.setItemForeGround(this.coi.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jq(0);
            return;
        }
        VoiceManager aX = com.baidu.tieba.tbadkCore.voice.b.aX(getActivity());
        if (aX != null) {
            aX.stopPlay();
        }
        eu(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.coi != null) {
            this.coi.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MG();
        this.coi = (ScrollFragmentTabHost) getView().findViewById(u.g.recommend_frs_tab_host);
        this.coi.setPageUniqueId(getUniqueId());
        this.coi.a(this.cot, this.cou);
        this.coi.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.agi().setCreateTime(System.currentTimeMillis() - a.agi().jh(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.con = true;
        a.agi().b(System.currentTimeMillis(), 1);
        registerListener(this.coo);
        registerListener(this.cop);
        registerListener(this.coq);
        registerListener(this.cor);
        registerListener(this.cov);
        agl();
        agk();
    }

    private void agk() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.Dx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.coi.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.agG().onDestory();
        if (this.bDd != null) {
            this.bDd.destory();
        }
    }

    private void agl() {
        this.col = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.col.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.col);
    }

    private void MG() {
        com.baidu.tieba.homepage.framework.a.a.agG().m(getUniqueId());
        this.coj = new q(getPageContext(), getUniqueId());
        this.coj.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.coj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(List<TagInfo> list) {
        if (y.s(list) > 0 && this.coi != null && !this.coi.bl(list)) {
            this.coi.bk(list);
            if (com.baidu.tieba.homepage.framework.a.a.agG().cpL != 0) {
                com.baidu.tieba.homepage.framework.a.d.jp(com.baidu.tieba.homepage.framework.a.a.agG().cpL);
            }
            this.coi.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.cok == null) {
            if (i < 0) {
                this.cok = new com.baidu.tbadk.g.f(getActivity());
            } else {
                this.cok = new com.baidu.tbadk.g.f(getActivity(), i);
            }
            this.cok.se();
        }
        if (this.coi != null && this.coi.getContentContainer() != null) {
            this.cok.c(this.coi.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agm() {
        if (this.cok != null && this.coi != null && this.coi.getContentContainer() != null) {
            this.cok.K(this.coi.getContentContainer());
            this.cok = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eF(getResources().getDimensionPixelSize(u.e.ds280));
        this.refreshView.fX(str);
        if (this.coi != null && this.coi.getContentContainer() != null) {
            this.refreshView.c(this.coi.getContentContainer(), z);
        }
        this.refreshView.Di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        if (this.refreshView != null && this.coi != null && this.coi.getContentContainer() != null) {
            this.refreshView.K(this.coi.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.coi != null) {
            this.coi.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.se();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        eu(isPrimary() && !this.con);
        this.con = false;
        if (this.coi != null) {
            this.coi.onPause();
        }
    }

    private void eu(boolean z) {
        this.coi.eu(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cos == null) {
            this.cos = Boolean.valueOf(com.baidu.tbadk.core.l.nW().oc());
        } else {
            z = this.cos.booleanValue() ^ com.baidu.tbadk.core.l.nW().oc();
            this.cos = Boolean.valueOf(com.baidu.tbadk.core.l.nW().oc());
        }
        if (z) {
            this.coi.agv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.coi == null || this.con) {
            return null;
        }
        return this.coi.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.coi != null) {
            return this.coi.getNextPageSourceKeyList();
        }
        return null;
    }
}
