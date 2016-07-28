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
import com.baidu.tieba.u;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private com.baidu.tbadk.e.a bEk;
    private boolean cqA = false;
    private CustomMessageListener cqB = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cqC = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cqD = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cqE = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cqF = null;
    private b cqG = new l(this);
    private c cqH = new m(this);
    private CustomMessageListener cqI = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private ScrollFragmentTabHost cqw;
    private q cqx;
    private com.baidu.tbadk.g.f cqy;
    private CustomMessageTask cqz;
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
            if (this.bEk == null) {
                this.bEk = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bEk.ap(updateAttentionMessage.getData().toUid, null);
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
        TbadkCoreApplication.m10getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.homepage.framework.a.a.ahm().css = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cqw != null) {
                if (this.cqw.ahd()) {
                    this.cqw.agU();
                    i(false, getResources().getDimensionPixelSize(u.e.ds520));
                } else {
                    this.cqw.setItemForeGround(this.cqw.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.jv(0);
        } else {
            VoiceManager aX = com.baidu.tieba.tbadkCore.voice.b.aX(getActivity());
            if (aX != null) {
                aX.stopPlay();
            }
            ev(true);
        }
        this.cqw.ahg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cqw != null) {
            this.cqw.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MF();
        this.cqw = (ScrollFragmentTabHost) getView().findViewById(u.g.recommend_frs_tab_host);
        this.cqw.setPageUniqueId(getUniqueId());
        this.cqw.a(this.cqG, this.cqH);
        this.cqw.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        a.agL().setCreateTime(System.currentTimeMillis() - a.agL().ji(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cqA = true;
        a.agL().c(System.currentTimeMillis(), 1);
        registerListener(this.cqB);
        registerListener(this.cqC);
        registerListener(this.cqD);
        registerListener(this.cqE);
        registerListener(this.cqI);
        agO();
        agN();
    }

    private void agN() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.Dw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cqw.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.ahm().onDestory();
        if (this.bEk != null) {
            this.bEk.destory();
        }
    }

    private void agO() {
        this.cqz = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cqz.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cqz);
    }

    private void MF() {
        com.baidu.tieba.homepage.framework.a.a.ahm().m(getUniqueId());
        this.cqx = new q(getPageContext(), getUniqueId());
        this.cqx.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cqx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.s(list) > 0 && this.cqw != null && !this.cqw.bp(list)) {
            this.cqw.bo(list);
            if (com.baidu.tieba.homepage.framework.a.a.ahm().csq != 0) {
                com.baidu.tieba.homepage.framework.a.d.ju(com.baidu.tieba.homepage.framework.a.a.ahm().csq);
            }
            this.cqw.setCurrentTab(0);
            this.cqw.ahh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cqy == null) {
            if (i < 0) {
                this.cqy = new com.baidu.tbadk.g.f(getActivity());
            } else {
                this.cqy = new com.baidu.tbadk.g.f(getActivity(), i);
            }
            this.cqy.sd();
        }
        if (this.cqw != null && this.cqw.getContentContainer() != null) {
            this.cqy.c(this.cqw.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agP() {
        if (this.cqy != null && this.cqw != null && this.cqw.getContentContainer() != null) {
            this.cqy.K(this.cqw.getContentContainer());
            this.cqy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.g.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eF(getResources().getDimensionPixelSize(u.e.ds280));
        this.refreshView.fV(str);
        if (this.cqw != null && this.cqw.getContentContainer() != null) {
            this.refreshView.c(this.cqw.getContentContainer(), z);
        }
        this.refreshView.Dh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IL() {
        if (this.refreshView != null && this.cqw != null && this.cqw.getContentContainer() != null) {
            this.refreshView.K(this.cqw.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cqw != null) {
            this.cqw.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.sd();
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
        ev(isPrimary() && !this.cqA);
        this.cqA = false;
        if (this.cqw != null) {
            this.cqw.onPause();
        }
    }

    private void ev(boolean z) {
        this.cqw.ev(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cqF == null) {
            this.cqF = Boolean.valueOf(com.baidu.tbadk.core.l.nL().nR());
        } else {
            z = this.cqF.booleanValue() ^ com.baidu.tbadk.core.l.nL().nR();
            this.cqF = Boolean.valueOf(com.baidu.tbadk.core.l.nL().nR());
        }
        if (z) {
            this.cqw.agY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cqw == null || this.cqA) {
            return null;
        }
        return this.cqw.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cqw != null) {
            return this.cqw.getNextPageSourceKeyList();
        }
        return null;
    }
}
