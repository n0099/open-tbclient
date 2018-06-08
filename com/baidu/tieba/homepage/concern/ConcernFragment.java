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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernFragment extends BaseFragment implements af {
    private ConcernPageView dMG;
    private ConcernPageView.a dMH;
    private boolean dbv;
    private boolean dMI = false;
    private CustomMessageListener bzI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aCA != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aCA, ConcernFragment.this.diC) != null) {
                            TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arm));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a diC = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arm));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.dMG = new ConcernPageView(context);
        this.dMG.axa();
        registerListener(this.bzI);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dMG.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dMG.getParent()).removeView(this.dMG);
            if (this.dMH != null) {
                this.dMG.setCallback(this.dMH);
            }
        }
        this.dMG.setPageUniqueId(getUniqueId());
        if (this.dMI) {
            this.dMG.axa();
            this.dMI = false;
        }
        return this.dMG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        if (this.dMG != null) {
            this.dMG.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dMG != null) {
            this.dMG.setRecommendFrsNavigationAnimDispatcher(tVar);
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
        if (this.dMG != null) {
            this.dMG.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dMG.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bzI);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dMG.onDestroy();
        this.dMI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dbv) {
                if (this.dMG != null) {
                    this.dMG.aBT();
                }
                this.dbv = true;
            }
            this.dMG.setViewForeground();
            return;
        }
        this.dMG.aBX();
        completePullRefresh();
    }

    public void TG() {
        this.dMG.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dMG.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.dMH = aVar;
        this.dMG.setCallback(aVar);
    }

    public void ab(String str, int i) {
        this.dMG.ab(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dMG != null) {
            this.dMG.a(dataRes, z);
        }
    }

    public void aBR() {
        if (this.dMG != null) {
            this.dMG.aBT();
            this.dbv = true;
        }
    }

    public void aBS() {
        if (this.dMG != null) {
            this.dMG.aBU();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void Tk() {
        if (this.dbv) {
            this.dMG.reload();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void Tl() {
    }

    @Override // com.baidu.tieba.frs.af
    public void Tm() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(w.c(arrayList, arrayList.size() - 1))) {
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
        this.dMG.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void Ay() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }
}
