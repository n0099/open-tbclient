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
    private com.baidu.tbadk.h.a bOH;
    private ScrollFragmentTabHost ctc;
    private q ctd;
    private com.baidu.tbadk.i.f cte;
    private com.baidu.tieba.homepage.personalize.a.a ctf;
    private boolean cth;
    private com.baidu.tbadk.i.h refreshView;
    private Boolean ctg = null;
    private NoNetworkView.a byG = new c(this);
    private CustomMessageTask cti = new CustomMessageTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, new i(this));
    private CustomMessageListener ctj = new j(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener ctk = new k(this, CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB);
    private CustomMessageListener ctl = new l(this, CmdConfigCustom.CMD_LIKE_FORUM_NAME);
    private CustomMessageListener ctm = new m(this, CmdConfigCustom.CMD_UNLIKE_FORUM_NAME);
    private final CustomMessageListener bOZ = new n(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener ctn = new o(this, CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL);
    private b cto = new p(this);
    private CustomMessageListener ctp = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

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
            if (this.bOH == null) {
                this.bOH = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bOH.ao(updateAttentionMessage.getData().toUid, null);
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
            if (this.ctc != null && this.ctc.ahn()) {
                this.ctc.ahj();
                g(false, getResources().getDimensionPixelSize(w.f.ds520));
            }
        } else {
            VoiceManager bU = com.baidu.tieba.tbadkCore.voice.b.bU(getActivity());
            if (bU != null) {
                bU.stopPlay();
            }
        }
        if (this.ctc != null) {
            this.ctc.setPrimary(isPrimary());
        }
        this.ctc.ahp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        this.ctc.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bj();
        this.ctc = (ScrollFragmentTabHost) getView().findViewById(w.h.recommend_frs_tab_host);
        this.ctc.a(getPageContext(), this.byG);
        this.ctc.a(getChildFragmentManager(), this.cto);
        this.ctc.setPageUniqueId(getUniqueId());
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.ahb().setCreateTime(System.currentTimeMillis() - a.ahb().jA(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.ahb().b(System.currentTimeMillis(), 1);
        registerListener(this.ctj);
        registerListener(this.ctk);
        registerListener(this.ctl);
        registerListener(this.ctm);
        registerListener(this.ctp);
        registerListener(this.bOZ);
        registerListener(this.ctn);
        this.cti.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cti);
        ahd();
        this.ctf = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void ahd() {
        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(getPageContext());
        pbHistoryCacheModel.setUniqueId(getUniqueId());
        pbHistoryCacheModel.a(new e(this));
        pbHistoryCacheModel.Et();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.homepage.framework.a.a.ahr().onDestory();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO);
        if (this.bOH != null) {
            this.bOH.destory();
        }
        if (this.ctf != null) {
            this.ctf.onDestroy();
        }
        this.ctc.onDestroy();
    }

    private void bj() {
        com.baidu.tieba.homepage.framework.a.a.ahr().m(getUniqueId());
        this.ctd = new q(getPageContext(), getUniqueId());
        this.ctd.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.ctd));
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
            if (this.ctc != null && !this.ctc.aT(arrayList)) {
                this.ctc.aS(arrayList);
                this.ctc.g(0, false);
                this.ctc.ahq();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new ReadCacheRespMsg(CmdConfigCustom.CMD_UPDATE_LIKE_FORUMS_IN_HOME_RECOMMEND, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.cte == null) {
            if (i < 0) {
                this.cte = new com.baidu.tbadk.i.f(getActivity());
            } else {
                this.cte = new com.baidu.tbadk.i.f(getActivity(), i);
            }
            this.cte.onChangeSkinType();
        }
        if (this.ctc != null && this.ctc.getFrameLayout() != null) {
            this.cte.c(this.ctc.getFrameLayout(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        if (this.cte != null && this.ctc != null && this.ctc.getFrameLayout() != null) {
            this.cte.H(this.ctc.getFrameLayout());
            this.cte = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eR(getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fQ(str);
        if (this.ctc != null && this.ctc.getFrameLayout() != null) {
            this.refreshView.c(this.ctc.getFrameLayout(), z);
        }
        this.refreshView.Ee();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR() {
        if (this.refreshView != null && this.ctc != null && this.ctc.getFrameLayout() != null) {
            this.refreshView.H(this.ctc.getFrameLayout());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ctc != null) {
            this.ctc.onChangeSkinType(i);
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
                            this.ctc.ahk();
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
        if (this.ctc != null) {
            this.ctc.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.ctg == null) {
            this.ctg = Boolean.valueOf(com.baidu.tbadk.core.r.oV().pb());
        } else {
            z = this.ctg.booleanValue() ^ com.baidu.tbadk.core.r.oV().pb();
            this.ctg = Boolean.valueOf(com.baidu.tbadk.core.r.oV().pb());
        }
        if (z) {
            this.ctc.ahl();
        }
        if (this.ctc != null) {
            this.ctc.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.ctc != null) {
            return this.ctc.getCurrentPageKey();
        }
        return null;
    }
}
