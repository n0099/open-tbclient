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
    private com.baidu.tbadk.e.a bNm;
    private ScrollFragmentTabHost cvo;
    private q cvp;
    private com.baidu.tbadk.f.f cvq;
    private CustomMessageTask cvr;
    private com.baidu.tieba.homepage.personalize.a.a cvs;
    private com.baidu.tbadk.f.h refreshView;
    private boolean cvt = false;
    private CustomMessageListener cvu = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cvv = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cvw = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cvx = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cvy = null;
    private b cvz = new l(this);
    private c cvA = new m(this);
    private CustomMessageListener cvB = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

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
            if (this.bNm == null) {
                this.bNm = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bNm.an(updateAttentionMessage.getData().toUid, null);
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
        com.baidu.tieba.homepage.framework.a.a.aja().cxo = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cvo != null) {
                if (this.cvo.aiR()) {
                    this.cvo.aiI();
                    f(false, getResources().getDimensionPixelSize(w.f.ds520));
                } else {
                    this.cvo.setItemForeGround(this.cvo.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jN(0);
        } else {
            VoiceManager bU = com.baidu.tieba.tbadkCore.voice.b.bU(getActivity());
            if (bU != null) {
                bU.stopPlay();
            }
            eN(true);
        }
        this.cvo.aiU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cvo != null) {
            this.cvo.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bk();
        this.cvo = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.cvo.setPageContext(getPageContext());
        this.cvo.setPageUniqueId(getUniqueId());
        this.cvo.a(this.cvz, this.cvA);
        this.cvo.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.aiz().setCreateTime(System.currentTimeMillis() - a.aiz().jA(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cvt = true;
        a.aiz().c(System.currentTimeMillis(), 1);
        registerListener(this.cvu);
        registerListener(this.cvv);
        registerListener(this.cvw);
        registerListener(this.cvx);
        registerListener(this.cvB);
        aiC();
        aiB();
        this.cvs = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void aiB() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new o(this));
        pbHistoryCacheModel.ER();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cvo.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.aja().onDestory();
        if (this.bNm != null) {
            this.bNm.destory();
        }
        if (this.cvs != null) {
            this.cvs.onDestroy();
        }
    }

    private void aiC() {
        this.cvr = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cvr.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cvr);
    }

    private void bk() {
        com.baidu.tieba.homepage.framework.a.a.aja().m(getUniqueId());
        this.cvp = new q(getPageContext(), getUniqueId());
        this.cvp.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cvp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.p(list) > 0 && this.cvo != null && !this.cvo.aY(list)) {
            this.cvo.aX(list);
            if (com.baidu.tieba.homepage.framework.a.a.aja().cxm != 0) {
                com.baidu.tieba.homepage.framework.a.d.jM(com.baidu.tieba.homepage.framework.a.a.aja().cxm);
            }
            this.cvo.setCurrentTab(0);
            this.cvo.aiV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.cvq == null) {
            if (i < 0) {
                this.cvq = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cvq = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cvq.tD();
        }
        if (this.cvo != null && this.cvo.getContentContainer() != null) {
            this.cvq.b(this.cvo.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiD() {
        if (this.cvq != null && this.cvo != null && this.cvo.getContentContainer() != null) {
            this.cvq.I(this.cvo.getContentContainer());
            this.cvq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eS(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fN(str);
        if (this.cvo != null && this.cvo.getContentContainer() != null) {
            this.refreshView.b(this.cvo.getContentContainer(), z);
        }
        this.refreshView.EC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.refreshView != null && this.cvo != null && this.cvo.getContentContainer() != null) {
            this.refreshView.I(this.cvo.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cvo != null) {
            this.cvo.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.tD();
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
        eN(isPrimary() && !this.cvt);
        this.cvt = false;
        if (this.cvo != null) {
            this.cvo.onPause();
        }
    }

    private void eN(boolean z) {
        this.cvo.eN(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cvy == null) {
            this.cvy = Boolean.valueOf(com.baidu.tbadk.core.l.oQ().oW());
        } else {
            z = this.cvy.booleanValue() ^ com.baidu.tbadk.core.l.oQ().oW();
            this.cvy = Boolean.valueOf(com.baidu.tbadk.core.l.oQ().oW());
        }
        if (z) {
            this.cvo.aiO();
        }
        if (this.cvo != null) {
            this.cvo.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cvo == null || this.cvt) {
            return null;
        }
        return this.cvo.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cvo != null) {
            return this.cvo.getNextPageSourceKeyList();
        }
        return null;
    }
}
