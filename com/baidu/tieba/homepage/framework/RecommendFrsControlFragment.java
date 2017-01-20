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
import com.baidu.tieba.r;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.e.a bGe;
    private ScrollFragmentTabHost ctP;
    private q ctQ;
    private com.baidu.tbadk.f.f ctR;
    private CustomMessageTask ctS;
    private com.baidu.tieba.homepage.personalize.a.a ctT;
    private boolean ctU = false;
    private CustomMessageListener ctV = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener ctW = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener ctX = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener ctY = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean ctZ = null;
    private b cua = new l(this);
    private c cub = new m(this);
    private CustomMessageListener cuc = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
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
            if (this.bGe == null) {
                this.bGe = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bGe.aq(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.j.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m9getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.ajO().cvP = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.ctP != null) {
                if (this.ctP.ajF()) {
                    this.ctP.ajv();
                    f(false, getResources().getDimensionPixelSize(r.f.ds520));
                } else {
                    this.ctP.setItemForeGround(this.ctP.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.ki(0);
        } else {
            VoiceManager bw = com.baidu.tieba.tbadkCore.voice.b.bw(getActivity());
            if (bw != null) {
                bw.stopPlay();
            }
            eW(true);
        }
        this.ctP.ajI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.ctP != null) {
            this.ctP.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aa();
        this.ctP = (ScrollFragmentTabHost) getView().findViewById(r.h.recommend_frs_tab_host);
        this.ctP.setPageUniqueId(getUniqueId());
        this.ctP.a(this.cua, this.cub);
        this.ctP.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.ajm().setCreateTime(System.currentTimeMillis() - a.ajm().jV(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ctU = true;
        a.ajm().c(System.currentTimeMillis(), 1);
        registerListener(this.ctV);
        registerListener(this.ctW);
        registerListener(this.ctX);
        registerListener(this.ctY);
        registerListener(this.cuc);
        ajp();
        ajo();
        this.ctT = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void ajo() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new o(this));
        pbHistoryCacheModel.Ex();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ctP.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.ajO().onDestory();
        if (this.bGe != null) {
            this.bGe.destory();
        }
        if (this.ctT != null) {
            this.ctT.onDestroy();
        }
    }

    private void ajp() {
        this.ctS = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.ctS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ctS);
    }

    private void aa() {
        com.baidu.tieba.homepage.framework.a.a.ajO().n(getUniqueId());
        this.ctQ = new q(getPageContext(), getUniqueId());
        this.ctQ.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ctQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.w.r(list) > 0 && this.ctP != null && !this.ctP.br(list)) {
            this.ctP.bq(list);
            if (com.baidu.tieba.homepage.framework.a.a.ajO().cvN != 0) {
                com.baidu.tieba.homepage.framework.a.d.kh(com.baidu.tieba.homepage.framework.a.a.ajO().cvN);
            }
            this.ctP.setCurrentTab(0);
            this.ctP.ajJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.ctR == null) {
            if (i < 0) {
                this.ctR = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.ctR = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.ctR.tg();
        }
        if (this.ctP != null && this.ctP.getContentContainer() != null) {
            this.ctR.b(this.ctP.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajq() {
        if (this.ctR != null && this.ctP != null && this.ctP.getContentContainer() != null) {
            this.ctR.K(this.ctP.getContentContainer());
            this.ctR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eX(getResources().getDimensionPixelSize(r.f.ds280));
        this.refreshView.fY(str);
        if (this.ctP != null && this.ctP.getContentContainer() != null) {
            this.refreshView.b(this.ctP.getContentContainer(), z);
        }
        this.refreshView.Ej();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        if (this.refreshView != null && this.ctP != null && this.ctP.getContentContainer() != null) {
            this.refreshView.K(this.ctP.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ctP != null) {
            this.ctP.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.tg();
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
        eW(isPrimary() && !this.ctU);
        this.ctU = false;
        if (this.ctP != null) {
            this.ctP.onPause();
        }
    }

    private void eW(boolean z) {
        this.ctP.eW(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.ctZ == null) {
            this.ctZ = Boolean.valueOf(com.baidu.tbadk.core.l.oC().oI());
        } else {
            z = this.ctZ.booleanValue() ^ com.baidu.tbadk.core.l.oC().oI();
            this.ctZ = Boolean.valueOf(com.baidu.tbadk.core.l.oC().oI());
        }
        if (z) {
            this.ctP.ajB();
        }
        if (this.ctP != null) {
            this.ctP.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.ctP == null || this.ctU) {
            return null;
        }
        return this.ctP.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.ctP != null) {
            return this.ctP.getNextPageSourceKeyList();
        }
        return null;
    }
}
