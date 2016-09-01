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
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.f.a bPO;
    private ScrollFragmentTabHost cBE;
    private q cBF;
    private com.baidu.tbadk.g.f cBG;
    private CustomMessageTask cBH;
    private boolean cBI = false;
    private CustomMessageListener cBJ = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cBK = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cBL = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cBM = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cBN = null;
    private b cBO = new l(this);
    private c cBP = new m(this);
    private CustomMessageListener cBQ = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
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
            if (this.bPO == null) {
                this.bPO = new com.baidu.tbadk.f.a(getPageContext());
            }
            this.bPO.ap(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m9getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.alX().cDA = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cBE != null) {
                if (this.cBE.alO()) {
                    this.cBE.alF();
                    h(false, getResources().getDimensionPixelSize(t.e.ds520));
                } else {
                    this.cBE.setItemForeGround(this.cBE.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jX(0);
        } else {
            VoiceManager bk = com.baidu.tieba.tbadkCore.voice.b.bk(getActivity());
            if (bk != null) {
                bk.stopPlay();
            }
            eR(true);
        }
        this.cBE.alR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cBE != null) {
            this.cBE.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aa();
        this.cBE = (ScrollFragmentTabHost) getView().findViewById(t.g.recommend_frs_tab_host);
        this.cBE.setPageUniqueId(getUniqueId());
        this.cBE.a(this.cBO, this.cBP);
        this.cBE.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.alw().setCreateTime(System.currentTimeMillis() - a.alw().jK(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cBI = true;
        a.alw().d(System.currentTimeMillis(), 1);
        registerListener(this.cBJ);
        registerListener(this.cBK);
        registerListener(this.cBL);
        registerListener(this.cBM);
        registerListener(this.cBQ);
        alz();
        aly();
    }

    private void aly() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.EQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cBE.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.alX().onDestory();
        if (this.bPO != null) {
            this.bPO.destory();
        }
    }

    private void alz() {
        this.cBH = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cBH.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cBH);
    }

    private void aa() {
        com.baidu.tieba.homepage.framework.a.a.alX().m(getUniqueId());
        this.cBF = new q(getPageContext(), getUniqueId());
        this.cBF.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cBF));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.s(list) > 0 && this.cBE != null && !this.cBE.br(list)) {
            this.cBE.bq(list);
            if (com.baidu.tieba.homepage.framework.a.a.alX().cDy != 0) {
                com.baidu.tieba.homepage.framework.a.d.jW(com.baidu.tieba.homepage.framework.a.a.alX().cDy);
            }
            this.cBE.setCurrentTab(0);
            this.cBE.alS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.cBG == null) {
            if (i < 0) {
                this.cBG = new com.baidu.tbadk.g.f(getActivity());
            } else {
                this.cBG = new com.baidu.tbadk.g.f(getActivity(), i);
            }
            this.cBG.ti();
        }
        if (this.cBE != null && this.cBE.getContentContainer() != null) {
            this.cBG.b(this.cBE.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alA() {
        if (this.cBG != null && this.cBE != null && this.cBE.getContentContainer() != null) {
            this.cBG.L(this.cBE.getContentContainer());
            this.cBG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eT(getResources().getDimensionPixelSize(t.e.ds280));
        this.refreshView.fY(str);
        if (this.cBE != null && this.cBE.getContentContainer() != null) {
            this.refreshView.b(this.cBE.getContentContainer(), z);
        }
        this.refreshView.EB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        if (this.refreshView != null && this.cBE != null && this.cBE.getContentContainer() != null) {
            this.refreshView.L(this.cBE.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cBE != null) {
            this.cBE.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.ti();
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
        eR(isPrimary() && !this.cBI);
        this.cBI = false;
        if (this.cBE != null) {
            this.cBE.onPause();
        }
    }

    private void eR(boolean z) {
        this.cBE.eR(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cBN == null) {
            this.cBN = Boolean.valueOf(com.baidu.tbadk.core.l.oG().oM());
        } else {
            z = this.cBN.booleanValue() ^ com.baidu.tbadk.core.l.oG().oM();
            this.cBN = Boolean.valueOf(com.baidu.tbadk.core.l.oG().oM());
        }
        if (z) {
            this.cBE.alJ();
        }
        if (this.cBE != null) {
            this.cBE.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cBE == null || this.cBI) {
            return null;
        }
        return this.cBE.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cBE != null) {
            return this.cBE.getNextPageSourceKeyList();
        }
        return null;
    }
}
