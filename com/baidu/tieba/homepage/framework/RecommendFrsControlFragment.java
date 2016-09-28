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
    private com.baidu.tbadk.e.a bPH;
    private ScrollFragmentTabHost cCi;
    private q cCj;
    private com.baidu.tbadk.f.f cCk;
    private CustomMessageTask cCl;
    private com.baidu.tieba.homepage.personalize.a.a cCm;
    private boolean cCn = false;
    private CustomMessageListener cCo = new e(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener cCp = new i(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private CustomMessageListener cCq = new j(this, CmdConfigCustom.CMD_HOME_EXTRA_INIT_OK);
    private CustomMessageListener cCr = new k(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private Boolean cCs = null;
    private b cCt = new l(this);
    private c cCu = new m(this);
    private CustomMessageListener cCv = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
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
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPH == null) {
                this.bPH = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bPH.ap(updateAttentionMessage.getData().toUid, null);
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
        com.baidu.tieba.homepage.framework.a.a.aml().cEe = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.cCi != null) {
                if (this.cCi.amc()) {
                    this.cCi.alT();
                    i(false, getResources().getDimensionPixelSize(r.e.ds520));
                } else {
                    this.cCi.setItemForeGround(this.cCi.getCurrentItem());
                }
            }
            com.baidu.tieba.homepage.framework.a.d.kd(0);
        } else {
            VoiceManager bh = com.baidu.tieba.tbadkCore.voice.b.bh(getActivity());
            if (bh != null) {
                bh.stopPlay();
            }
            eS(true);
        }
        this.cCi.amf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.cCi != null) {
            this.cCi.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aa();
        this.cCi = (ScrollFragmentTabHost) getView().findViewById(r.g.recommend_frs_tab_host);
        this.cCi.setPageUniqueId(getUniqueId());
        this.cCi.a(this.cCt, this.cCu);
        this.cCi.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        a.alK().setCreateTime(System.currentTimeMillis() - a.alK().jQ(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cCn = true;
        a.alK().d(System.currentTimeMillis(), 1);
        registerListener(this.cCo);
        registerListener(this.cCp);
        registerListener(this.cCq);
        registerListener(this.cCr);
        registerListener(this.cCv);
        alN();
        alM();
        this.cCm = new com.baidu.tieba.homepage.personalize.a.a();
    }

    private void alM() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new o(this));
        aVar.EQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.cCi.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.homepage.framework.a.a.aml().onDestory();
        if (this.bPH != null) {
            this.bPH.destory();
        }
        if (this.cCm != null) {
            this.cCm.onDestroy();
        }
    }

    private void alN() {
        this.cCl = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new p(this));
        this.cCl.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cCl);
    }

    private void aa() {
        com.baidu.tieba.homepage.framework.a.a.aml().m(getUniqueId());
        this.cCj = new q(getPageContext(), getUniqueId());
        this.cCj.a(new f(this));
        MessageManager.getInstance().sendMessage(new ControlModelMessage(this.cCj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.s(list) > 0 && this.cCi != null && !this.cCi.br(list)) {
            this.cCi.bq(list);
            if (com.baidu.tieba.homepage.framework.a.a.aml().cEc != 0) {
                com.baidu.tieba.homepage.framework.a.d.kc(com.baidu.tieba.homepage.framework.a.a.aml().cEc);
            }
            this.cCi.setCurrentTab(0);
            this.cCi.amg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.cCk == null) {
            if (i < 0) {
                this.cCk = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cCk = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cCk.tx();
        }
        if (this.cCi != null && this.cCi.getContentContainer() != null) {
            this.cCk.b(this.cCi.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alO() {
        if (this.cCk != null && this.cCi != null && this.cCi.getContentContainer() != null) {
            this.cCk.L(this.cCi.getContentContainer());
            this.cCk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new g(this));
        }
        this.refreshView.eS(getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gc(str);
        if (this.cCi != null && this.cCi.getContentContainer() != null) {
            this.refreshView.b(this.cCi.getContentContainer(), z);
        }
        this.refreshView.EB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ() {
        if (this.refreshView != null && this.cCi != null && this.cCi.getContentContainer() != null) {
            this.refreshView.L(this.cCi.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cCi != null) {
            this.cCi.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.tx();
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
        eS(isPrimary() && !this.cCn);
        this.cCn = false;
        if (this.cCi != null) {
            this.cCi.onPause();
        }
    }

    private void eS(boolean z) {
        this.cCi.eS(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.cCs == null) {
            this.cCs = Boolean.valueOf(com.baidu.tbadk.core.l.oH().oN());
        } else {
            z = this.cCs.booleanValue() ^ com.baidu.tbadk.core.l.oH().oN();
            this.cCs = Boolean.valueOf(com.baidu.tbadk.core.l.oH().oN());
        }
        if (z) {
            this.cCi.alY();
        }
        if (this.cCi != null) {
            this.cCi.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new h(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.cCi == null || this.cCn) {
            return null;
        }
        return this.cCi.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.cCi != null) {
            return this.cCi.getNextPageSourceKeyList();
        }
        return null;
    }
}
