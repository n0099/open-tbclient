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
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.h.a bNb;
    private ScrollFragmentTabHost ctO;
    private q ctP;
    private com.baidu.tbadk.i.f ctQ;
    private CustomMessageTask ctR;
    private com.baidu.tieba.homepage.personalize.a.a ctS;
    private boolean ctT = false;
    private CustomMessageListener ctU = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener ctV = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener ctW = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener ctX = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean ctY = null;
    private b ctZ = new l(this);
    private c cua = new m(this);
    private CustomMessageListener cub = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private com.baidu.tbadk.i.h refreshView;

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
            if (this.bNb == null) {
                this.bNb = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bNb.ao(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.j.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m9getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.aiU().cvO = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.ctO != null) {
                if (this.ctO.aiL()) {
                    this.ctO.aiC();
                    f(false, getResources().getDimensionPixelSize(w.f.ds520));
                } else {
                    this.ctO.setItemForeGround(this.ctO.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jO(0);
        } else {
            VoiceManager bO = com.baidu.tieba.tbadkCore.voice.b.bO(getActivity());
            if (bO != null) {
                bO.stopPlay();
            }
            eN(true);
        }
        this.ctO.aiO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.ctO != null) {
            this.ctO.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.ctO = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.ctO.setPageContext(getPageContext());
        this.ctO.setPageUniqueId(getUniqueId());
        this.ctO.a(this.ctZ, this.cua);
        this.ctO.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.ait().setCreateTime(System.currentTimeMillis() - a.ait().jB(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctT = true;
        a.ait().c(System.currentTimeMillis(), 1);
        registerListener(this.ctU);
        registerListener(this.ctV);
        registerListener(this.ctW);
        registerListener(this.ctX);
        registerListener(this.cub);
        aiw();
        aiv();
        this.ctS = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void aiv() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new o(this));
        pbHistoryCacheModel.Fp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ctO.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.aiU().onDestory();
        if (this.bNb != null) {
            this.bNb.destory();
        }
        if (this.ctS != null) {
            this.ctS.onDestroy();
        }
    }

    private void aiw() {
        this.ctR = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.ctR.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ctR);
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.aiU().m(getUniqueId());
        this.ctP = new q(getPageContext(), getUniqueId());
        this.ctP.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ctP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.p(list) > 0 && this.ctO != null && !this.ctO.aX(list)) {
            this.ctO.aW(list);
            if (com.baidu.tieba.homepage.framework.a.a.aiU().cvM != 0) {
                com.baidu.tieba.homepage.framework.a.d.jN(com.baidu.tieba.homepage.framework.a.a.aiU().cvM);
            }
            this.ctO.setCurrentTab(0);
            this.ctO.aiP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.ctQ == null) {
            if (i < 0) {
                this.ctQ = new com.baidu.tbadk.i.f(getActivity());
            } else {
                this.ctQ = new com.baidu.tbadk.i.f(getActivity(), i);
            }
            this.ctQ.onChangeSkinType();
        }
        if (this.ctO != null && this.ctO.getContentContainer() != null) {
            this.ctQ.b(this.ctO.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        if (this.ctQ != null && this.ctO != null && this.ctO.getContentContainer() != null) {
            this.ctQ.I(this.ctO.getContentContainer());
            this.ctQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eV(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fT(str);
        if (this.ctO != null && this.ctO.getContentContainer() != null) {
            this.refreshView.b(this.ctO.getContentContainer(), z);
        }
        this.refreshView.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        if (this.refreshView != null && this.ctO != null && this.ctO.getContentContainer() != null) {
            this.refreshView.I(this.ctO.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ctO != null) {
            this.ctO.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
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
        eN(isPrimary() && !this.ctT);
        this.ctT = false;
        if (this.ctO != null) {
            this.ctO.onPause();
        }
    }

    private void eN(boolean z) {
        this.ctO.eN(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.ctY == null) {
            this.ctY = Boolean.valueOf(com.baidu.tbadk.core.q.po().pu());
        } else {
            z = this.ctY.booleanValue() ^ com.baidu.tbadk.core.q.po().pu();
            this.ctY = Boolean.valueOf(com.baidu.tbadk.core.q.po().pu());
        }
        if (z) {
            this.ctO.aiI();
        }
        if (this.ctO != null) {
            this.ctO.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.ctO == null || this.ctT) {
            return null;
        }
        return this.ctO.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.ctO != null) {
            return this.ctO.getNextPageSourceKeyList();
        }
        return null;
    }
}
