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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecommendFrsControlFragment extends BaseFragment {
    private ScrollFragmentTabHost cHg;
    private q cHh;
    private com.baidu.tbadk.i.f cHi;
    private com.baidu.tieba.homepage.personalize.a.a cHj;
    private boolean cHl;
    private com.baidu.tbadk.h.a ccC;
    private com.baidu.tbadk.i.h refreshView;
    private Boolean cHk = null;
    private NoNetworkView.a bFt = new c(this);
    private CustomMessageTask cHm = new CustomMessageTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, new i(this));
    private CustomMessageListener cHn = new j(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cHo = new k(this, CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB);
    private CustomMessageListener cHp = new l(this, CmdConfigCustom.CMD_LIKE_FORUM_NAME);
    private CustomMessageListener cHq = new m(this, CmdConfigCustom.CMD_UNLIKE_FORUM_NAME);
    private final CustomMessageListener ccW = new n(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener cHr = new o(this, CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL);
    private b cHs = new p(this);
    private CustomMessageListener cHt = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

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
            if (this.ccC == null) {
                this.ccC = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.ccC.an(updateAttentionMessage.getData().toUid, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(w.j.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cHg != null && this.cHg.amn()) {
                this.cHg.amj();
                g(false, getResources().getDimensionPixelSize(w.f.ds520));
            }
        } else {
            VoiceManager bP = com.baidu.tieba.tbadkCore.voice.b.bP(getActivity());
            if (bP != null) {
                bP.stopPlay();
            }
        }
        if (this.cHg != null) {
            this.cHg.setPrimary(isPrimary());
            this.cHg.amp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.cHg.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.cHg = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.cHg.a(getPageContext(), this.bFt);
        this.cHg.a(getChildFragmentManager(), this.cHs);
        this.cHg.setPageUniqueId(getUniqueId());
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.amb().setCreateTime(System.currentTimeMillis() - a.amb().kk(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.amb().c(System.currentTimeMillis(), 1);
        registerListener(this.cHn);
        registerListener(this.cHo);
        registerListener(this.cHp);
        registerListener(this.cHq);
        registerListener(this.cHt);
        registerListener(this.ccW);
        registerListener(this.cHr);
        this.cHm.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cHm);
        amd();
        this.cHj = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void amd() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new e(this));
        pbHistoryCacheModel.EK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.homepage.framework.a.a.amr().onDestory();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO);
        if (this.ccC != null) {
            this.ccC.destory();
        }
        if (this.cHj != null) {
            this.cHj.onDestroy();
        }
        this.cHg.onDestroy();
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.amr().l(getUniqueId());
        this.cHh = new q(getPageContext(), getUniqueId());
        this.cHh.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cHh));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (z.s(list) > 1) {
            ArrayList arrayList = new ArrayList();
            if (!TbadkCoreApplication.isLogin() || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsActivityConfig.class)) {
                arrayList.add(list.get(0));
                arrayList.add(list.get(1));
            } else {
                arrayList.addAll(list);
            }
            if (this.cHg != null && !this.cHg.bc(arrayList)) {
                this.cHg.bb(arrayList);
                this.cHg.g(0, false);
                this.cHg.amq();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ReadCacheRespMsg(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.cHi == null) {
            if (i < 0) {
                this.cHi = new com.baidu.tbadk.i.f(getActivity());
            } else {
                this.cHi = new com.baidu.tbadk.i.f(getActivity(), i);
            }
            this.cHi.onChangeSkinType();
        }
        if (this.cHg != null && this.cHg.getFrameLayout() != null) {
            this.cHi.c(this.cHg.getFrameLayout(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ame() {
        if (this.cHi != null && this.cHg != null && this.cHg.getFrameLayout() != null) {
            this.cHi.I(this.cHg.getFrameLayout());
            this.cHi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eU(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.gk(str);
        if (this.cHg != null && this.cHg.getFrameLayout() != null) {
            this.refreshView.c(this.cHg.getFrameLayout(), z);
        }
        this.refreshView.Ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Np() {
        if (this.refreshView != null && this.cHg != null && this.cHg.getFrameLayout() != null) {
            this.refreshView.I(this.cHg.getFrameLayout());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cHg != null) {
            this.cHg.onChangeSkinType(i);
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
                        if (intent.getIntExtra("type", -1) == 4 && isPrimary()) {
                            this.cHg.amk();
                            return;
                        }
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
        if (this.cHg != null) {
            this.cHg.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cHk == null) {
            this.cHk = Boolean.valueOf(com.baidu.tbadk.core.r.oK().oQ());
        } else {
            z = this.cHk.booleanValue() ^ com.baidu.tbadk.core.r.oK().oQ();
            this.cHk = Boolean.valueOf(com.baidu.tbadk.core.r.oK().oQ());
        }
        if (z) {
            this.cHg.aml();
        }
        if (this.cHg != null) {
            this.cHg.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cHg != null) {
            return this.cHg.getCurrentPageKey();
        }
        return null;
    }
}
