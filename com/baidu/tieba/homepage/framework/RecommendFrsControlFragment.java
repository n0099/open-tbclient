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
    private com.baidu.tbadk.e.a bSw;
    private boolean cHA = false;
    private CustomMessageListener cHB = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cHC = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cHD = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cHE = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cHF = null;
    private b cHG = new l(this);
    private c cHH = new m(this);
    private CustomMessageListener cHI = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ScrollFragmentTabHost cHv;
    private q cHw;
    private com.baidu.tbadk.f.f cHx;
    private CustomMessageTask cHy;
    private com.baidu.tieba.homepage.personalize.a.a cHz;
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
            if (this.bSw == null) {
                this.bSw = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bSw.aq(updateAttentionMessage.getData().toUid, null);
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
        com.baidu.tieba.homepage.framework.a.a.aog().cJs = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cHv != null) {
                if (this.cHv.anX()) {
                    this.cHv.anO();
                    i(false, getResources().getDimensionPixelSize(r.e.ds520));
                } else {
                    this.cHv.setItemForeGround(this.cHv.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.kk(0);
        } else {
            VoiceManager bv = com.baidu.tieba.tbadkCore.voice.b.bv(getActivity());
            if (bv != null) {
                bv.stopPlay();
            }
            fh(true);
        }
        this.cHv.aoa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cHv != null) {
            this.cHv.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aa();
        this.cHv = (ScrollFragmentTabHost) getView().findViewById(r.g.recommend_frs_tab_host);
        this.cHv.setPageUniqueId(getUniqueId());
        this.cHv.a(this.cHG, this.cHH);
        this.cHv.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.anF().setCreateTime(System.currentTimeMillis() - a.anF().jX(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cHA = true;
        a.anF().d(System.currentTimeMillis(), 1);
        registerListener(this.cHB);
        registerListener(this.cHC);
        registerListener(this.cHD);
        registerListener(this.cHE);
        registerListener(this.cHI);
        anI();
        anH();
        this.cHz = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void anH() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.EV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cHv.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.aog().onDestory();
        if (this.bSw != null) {
            this.bSw.destory();
        }
        if (this.cHz != null) {
            this.cHz.onDestroy();
        }
    }

    private void anI() {
        this.cHy = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cHy.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cHy);
    }

    private void aa() {
        com.baidu.tieba.homepage.framework.a.a.aog().m(getUniqueId());
        this.cHw = new q(getPageContext(), getUniqueId());
        this.cHw.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cHw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.x.s(list) > 0 && this.cHv != null && !this.cHv.bt(list)) {
            this.cHv.bs(list);
            if (com.baidu.tieba.homepage.framework.a.a.aog().cJq != 0) {
                com.baidu.tieba.homepage.framework.a.d.kj(com.baidu.tieba.homepage.framework.a.a.aog().cJq);
            }
            this.cHv.setCurrentTab(0);
            this.cHv.aob();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cHx == null) {
            if (i < 0) {
                this.cHx = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cHx = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cHx.tB();
        }
        if (this.cHv != null && this.cHv.getContentContainer() != null) {
            this.cHx.b(this.cHv.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anJ() {
        if (this.cHx != null && this.cHv != null && this.cHv.getContentContainer() != null) {
            this.cHx.M(this.cHv.getContentContainer());
            this.cHx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eV(getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gf(str);
        if (this.cHv != null && this.cHv.getContentContainer() != null) {
            this.refreshView.b(this.cHv.getContentContainer(), z);
        }
        this.refreshView.EG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        if (this.refreshView != null && this.cHv != null && this.cHv.getContentContainer() != null) {
            this.refreshView.M(this.cHv.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cHv != null) {
            this.cHv.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.tB();
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
        fh(isPrimary() && !this.cHA);
        this.cHA = false;
        if (this.cHv != null) {
            this.cHv.onPause();
        }
    }

    private void fh(boolean z) {
        this.cHv.fh(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cHF == null) {
            this.cHF = Boolean.valueOf(com.baidu.tbadk.core.l.oJ().oP());
        } else {
            z = this.cHF.booleanValue() ^ com.baidu.tbadk.core.l.oJ().oP();
            this.cHF = Boolean.valueOf(com.baidu.tbadk.core.l.oJ().oP());
        }
        if (z) {
            this.cHv.anT();
        }
        if (this.cHv != null) {
            this.cHv.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cHv == null || this.cHA) {
            return null;
        }
        return this.cHv.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cHv != null) {
            return this.cHv.getNextPageSourceKeyList();
        }
        return null;
    }
}
