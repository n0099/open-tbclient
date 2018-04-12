package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernFragment extends BaseFragment implements af {
    private boolean cRk;
    private ConcernPageView dAs;
    private ConcernPageView.a dAt;
    private boolean dAu = false;
    private CustomMessageListener bro = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().auo != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().auo, ConcernFragment.this.cYh) != null) {
                            TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Aj && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a cYh = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.aje));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.dAs = new ConcernPageView(context);
        this.dAs.asV();
        registerListener(this.bro);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dAs.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dAs.getParent()).removeView(this.dAs);
            if (this.dAt != null) {
                this.dAs.setCallback(this.dAt);
            }
        }
        this.dAs.setPageUniqueId(getUniqueId());
        if (this.dAu) {
            this.dAs.asV();
            this.dAu = false;
        }
        return this.dAs;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        if (this.dAs != null) {
            this.dAs.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dAs != null) {
            this.dAs.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dAs != null) {
            this.dAs.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dAs.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bro);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dAs.onDestroy();
        this.dAu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.cRk) {
                if (this.dAs != null) {
                    this.dAs.axc();
                }
                this.cRk = true;
            }
            this.dAs.setViewForeground();
            return;
        }
        this.dAs.axg();
        completePullRefresh();
    }

    public void Ql() {
        this.dAs.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dAs.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.dAt = aVar;
        this.dAs.setCallback(aVar);
    }

    public void Y(String str, int i) {
        this.dAs.Y(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dAs != null) {
            this.dAs.a(dataRes, z);
        }
    }

    public void axa() {
        if (this.dAs != null) {
            this.dAs.axc();
            this.cRk = true;
        }
    }

    public void axb() {
        if (this.dAs != null) {
            this.dAs.axd();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void PP() {
        if (this.cRk) {
            this.dAs.reload();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void PQ() {
    }

    @Override // com.baidu.tieba.frs.af
    public void PR() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dAs.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void wY() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}
