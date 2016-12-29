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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.e.a byF;
    private ScrollFragmentTabHost cmP;
    private q cmQ;
    private com.baidu.tbadk.f.f cmR;
    private CustomMessageTask cmS;
    private com.baidu.tieba.homepage.personalize.a.a cmT;
    private boolean cmU = false;
    private CustomMessageListener cmV = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cmW = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cmX = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cmY = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cmZ = null;
    private b cna = new l(this);
    private c cnb = new m(this);
    private CustomMessageListener cnc = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.f.h refreshView;

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
            if (this.byF == null) {
                this.byF = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.byF.aq(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m9getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.aiG().coN = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cmP != null) {
                if (this.cmP.aix()) {
                    this.cmP.aio();
                    f(false, getResources().getDimensionPixelSize(r.e.ds520));
                } else {
                    this.cmP.setItemForeGround(this.cmP.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jv(0);
        } else {
            VoiceManager bu = com.baidu.tieba.tbadkCore.voice.b.bu(getActivity());
            if (bu != null) {
                bu.stopPlay();
            }
            eS(true);
        }
        this.cmP.aiA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cmP != null) {
            this.cmP.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aa();
        this.cmP = (ScrollFragmentTabHost) getView().findViewById(r.g.recommend_frs_tab_host);
        this.cmP.setPageUniqueId(getUniqueId());
        this.cmP.a(this.cna, this.cnb);
        this.cmP.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.aif().setCreateTime(System.currentTimeMillis() - a.aif().ji(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cmU = true;
        a.aif().c(System.currentTimeMillis(), 1);
        registerListener(this.cmV);
        registerListener(this.cmW);
        registerListener(this.cmX);
        registerListener(this.cmY);
        registerListener(this.cnc);
        aii();
        aih();
        this.cmT = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void aih() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.ED();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cmP.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.aiG().onDestory();
        if (this.byF != null) {
            this.byF.destory();
        }
        if (this.cmT != null) {
            this.cmT.onDestroy();
        }
    }

    private void aii() {
        this.cmS = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cmS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cmS);
    }

    private void aa() {
        com.baidu.tieba.homepage.framework.a.a.aiG().m(getUniqueId());
        this.cmQ = new q(getPageContext(), getUniqueId());
        this.cmQ.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cmQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.s(list) > 0 && this.cmP != null && !this.cmP.bl(list)) {
            this.cmP.bk(list);
            if (com.baidu.tieba.homepage.framework.a.a.aiG().coL != 0) {
                com.baidu.tieba.homepage.framework.a.d.ju(com.baidu.tieba.homepage.framework.a.a.aiG().coL);
            }
            this.cmP.setCurrentTab(0);
            this.cmP.aiB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.cmR == null) {
            if (i < 0) {
                this.cmR = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cmR = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cmR.tm();
        }
        if (this.cmP != null && this.cmP.getContentContainer() != null) {
            this.cmR.b(this.cmP.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.cmR != null && this.cmP != null && this.cmP.getContentContainer() != null) {
            this.cmR.M(this.cmP.getContentContainer());
            this.cmR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eW(getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gb(str);
        if (this.cmP != null && this.cmP.getContentContainer() != null) {
            this.refreshView.b(this.cmP.getContentContainer(), z);
        }
        this.refreshView.Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        if (this.refreshView != null && this.cmP != null && this.cmP.getContentContainer() != null) {
            this.refreshView.M(this.cmP.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cmP != null) {
            this.cmP.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.tm();
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
        eS(isPrimary() && !this.cmU);
        this.cmU = false;
        if (this.cmP != null) {
            this.cmP.onPause();
        }
    }

    private void eS(boolean z) {
        this.cmP.eS(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cmZ == null) {
            this.cmZ = Boolean.valueOf(com.baidu.tbadk.core.l.oJ().oP());
        } else {
            z = this.cmZ.booleanValue() ^ com.baidu.tbadk.core.l.oJ().oP();
            this.cmZ = Boolean.valueOf(com.baidu.tbadk.core.l.oJ().oP());
        }
        if (z) {
            this.cmP.ait();
        }
        if (this.cmP != null) {
            this.cmP.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cmP == null || this.cmU) {
            return null;
        }
        return this.cmP.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cmP != null) {
            return this.cmP.getNextPageSourceKeyList();
        }
        return null;
    }
}
