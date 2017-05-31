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
import com.baidu.tbadk.core.util.x;
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
    private com.baidu.tbadk.h.a bUu;
    private ScrollFragmentTabHost czu;
    private q czv;
    private com.baidu.tbadk.i.f czw;
    private com.baidu.tieba.homepage.personalize.a.a czx;
    private boolean czz;
    private com.baidu.tbadk.i.h refreshView;
    private Boolean czy = null;
    private NoNetworkView.a bEB = new c(this);
    private CustomMessageTask czA = new CustomMessageTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, new i(this));
    private CustomMessageListener czB = new j(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener czC = new k(this, CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB);
    private CustomMessageListener czD = new l(this, CmdConfigCustom.CMD_LIKE_FORUM_NAME);
    private CustomMessageListener czE = new m(this, CmdConfigCustom.CMD_UNLIKE_FORUM_NAME);
    private final CustomMessageListener bUN = new n(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener czF = new o(this, CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL);
    private b czG = new p(this);
    private CustomMessageListener czH = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

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
            if (this.bUu == null) {
                this.bUu = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bUu.an(updateAttentionMessage.getData().toUid, null);
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
            if (this.czu != null && this.czu.aiC()) {
                this.czu.aiy();
                g(false, getResources().getDimensionPixelSize(w.f.ds520));
            }
        } else {
            VoiceManager bV = com.baidu.tieba.tbadkCore.voice.b.bV(getActivity());
            if (bV != null) {
                bV.stopPlay();
            }
        }
        if (this.czu != null) {
            this.czu.setPrimary(isPrimary());
        }
        this.czu.aiE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.czu.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.czu = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.czu.a(getPageContext(), this.bEB);
        this.czu.a(getChildFragmentManager(), this.czG);
        this.czu.setPageUniqueId(getUniqueId());
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.aiq().setCreateTime(System.currentTimeMillis() - a.aiq().jZ(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.aiq().c(System.currentTimeMillis(), 1);
        registerListener(this.czB);
        registerListener(this.czC);
        registerListener(this.czD);
        registerListener(this.czE);
        registerListener(this.czH);
        registerListener(this.bUN);
        registerListener(this.czF);
        this.czA.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.czA);
        ais();
        this.czx = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void ais() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new e(this));
        pbHistoryCacheModel.En();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.homepage.framework.a.a.aiG().onDestory();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO);
        if (this.bUu != null) {
            this.bUu.destory();
        }
        if (this.czx != null) {
            this.czx.onDestroy();
        }
        this.czu.onDestroy();
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.aiG().l(getUniqueId());
        this.czv = new q(getPageContext(), getUniqueId());
        this.czv.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.czv));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (x.q(list) > 1) {
            ArrayList arrayList = new ArrayList();
            if (!TbadkCoreApplication.isLogin() || !TbadkCoreApplication.m9getInst().appResponseToIntentClass(FrsActivityConfig.class)) {
                arrayList.add(list.get(0));
                arrayList.add(list.get(1));
            } else {
                arrayList.addAll(list);
            }
            if (this.czu != null && !this.czu.aT(arrayList)) {
                this.czu.aS(arrayList);
                this.czu.g(0, false);
                this.czu.aiF();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ReadCacheRespMsg(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.czw == null) {
            if (i < 0) {
                this.czw = new com.baidu.tbadk.i.f(getActivity());
            } else {
                this.czw = new com.baidu.tbadk.i.f(getActivity(), i);
            }
            this.czw.onChangeSkinType();
        }
        if (this.czu != null && this.czu.getFrameLayout() != null) {
            this.czw.c(this.czu.getFrameLayout(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (this.czw != null && this.czu != null && this.czu.getFrameLayout() != null) {
            this.czw.H(this.czu.getFrameLayout());
            this.czw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eS(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fP(str);
        if (this.czu != null && this.czu.getFrameLayout() != null) {
            this.refreshView.c(this.czu.getFrameLayout(), z);
        }
        this.refreshView.DY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx() {
        if (this.refreshView != null && this.czu != null && this.czu.getFrameLayout() != null) {
            this.refreshView.H(this.czu.getFrameLayout());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.czu != null) {
            this.czu.onChangeSkinType(i);
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
                            this.czu.aiz();
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
        if (this.czu != null) {
            this.czu.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.czy == null) {
            this.czy = Boolean.valueOf(com.baidu.tbadk.core.r.oN().oT());
        } else {
            z = this.czy.booleanValue() ^ com.baidu.tbadk.core.r.oN().oT();
            this.czy = Boolean.valueOf(com.baidu.tbadk.core.r.oN().oT());
        }
        if (z) {
            this.czu.aiA();
        }
        if (this.czu != null) {
            this.czu.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.czu != null) {
            return this.czu.getCurrentPageKey();
        }
        return null;
    }
}
