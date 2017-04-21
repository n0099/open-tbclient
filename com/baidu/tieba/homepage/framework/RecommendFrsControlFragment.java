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
    private com.baidu.tbadk.h.a bPs;
    private ScrollFragmentTabHost cwf;
    private q cwg;
    private com.baidu.tbadk.i.f cwh;
    private CustomMessageTask cwi;
    private com.baidu.tieba.homepage.personalize.a.a cwj;
    private boolean cwk = false;
    private CustomMessageListener cwl = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cwm = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cwn = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cwo = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cwp = null;
    private b cwq = new l(this);
    private c cwr = new m(this);
    private CustomMessageListener cws = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
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
            if (this.bPs == null) {
                this.bPs = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bPs.ao(updateAttentionMessage.getData().toUid, null);
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
        com.baidu.tieba.homepage.framework.a.a.ajV().cyf = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cwf != null) {
                if (this.cwf.ajM()) {
                    this.cwf.ajD();
                    g(false, getResources().getDimensionPixelSize(w.f.ds520));
                } else {
                    this.cwf.setItemForeGround(this.cwf.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jU(0);
        } else {
            VoiceManager bO = com.baidu.tieba.tbadkCore.voice.b.bO(getActivity());
            if (bO != null) {
                bO.stopPlay();
            }
            eX(true);
        }
        this.cwf.ajP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cwf != null) {
            this.cwf.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.cwf = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.cwf.setPageContext(getPageContext());
        this.cwf.setPageUniqueId(getUniqueId());
        this.cwf.a(this.cwq, this.cwr);
        this.cwf.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.aju().setCreateTime(System.currentTimeMillis() - a.aju().jH(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cwk = true;
        a.aju().c(System.currentTimeMillis(), 1);
        registerListener(this.cwl);
        registerListener(this.cwm);
        registerListener(this.cwn);
        registerListener(this.cwo);
        registerListener(this.cws);
        ajx();
        ajw();
        this.cwj = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void ajw() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new o(this));
        pbHistoryCacheModel.Fp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cwf.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.ajV().onDestory();
        if (this.bPs != null) {
            this.bPs.destory();
        }
        if (this.cwj != null) {
            this.cwj.onDestroy();
        }
    }

    private void ajx() {
        this.cwi = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cwi.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cwi);
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.ajV().m(getUniqueId());
        this.cwg = new q(getPageContext(), getUniqueId());
        this.cwg.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cwg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.p(list) > 0 && this.cwf != null && !this.cwf.aY(list)) {
            this.cwf.aX(list);
            if (com.baidu.tieba.homepage.framework.a.a.ajV().cyd != 0) {
                com.baidu.tieba.homepage.framework.a.d.jT(com.baidu.tieba.homepage.framework.a.a.ajV().cyd);
            }
            this.cwf.setCurrentTab(0);
            this.cwf.ajQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.cwh == null) {
            if (i < 0) {
                this.cwh = new com.baidu.tbadk.i.f(getActivity());
            } else {
                this.cwh = new com.baidu.tbadk.i.f(getActivity(), i);
            }
            this.cwh.onChangeSkinType();
        }
        if (this.cwf != null && this.cwf.getContentContainer() != null) {
            this.cwh.b(this.cwf.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajy() {
        if (this.cwh != null && this.cwf != null && this.cwf.getContentContainer() != null) {
            this.cwh.I(this.cwf.getContentContainer());
            this.cwh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eV(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fT(str);
        if (this.cwf != null && this.cwf.getContentContainer() != null) {
            this.refreshView.b(this.cwf.getContentContainer(), z);
        }
        this.refreshView.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        if (this.refreshView != null && this.cwf != null && this.cwf.getContentContainer() != null) {
            this.refreshView.I(this.cwf.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cwf != null) {
            this.cwf.onChangeSkinType(i);
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
        eX(isPrimary() && !this.cwk);
        this.cwk = false;
        if (this.cwf != null) {
            this.cwf.onPause();
        }
    }

    private void eX(boolean z) {
        this.cwf.eX(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cwp == null) {
            this.cwp = Boolean.valueOf(com.baidu.tbadk.core.q.po().pu());
        } else {
            z = this.cwp.booleanValue() ^ com.baidu.tbadk.core.q.po().pu();
            this.cwp = Boolean.valueOf(com.baidu.tbadk.core.q.po().pu());
        }
        if (z) {
            this.cwf.ajJ();
        }
        if (this.cwf != null) {
            this.cwf.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cwf == null || this.cwk) {
            return null;
        }
        return this.cwf.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cwf != null) {
            return this.cwf.getNextPageSourceKeyList();
        }
        return null;
    }
}
