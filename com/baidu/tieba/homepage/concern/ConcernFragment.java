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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernFragment extends BaseFragment implements ah {
    private boolean dro;
    private ConcernPageView ejj;
    private ConcernPageView.a ejk;
    private boolean ejl = false;
    private CustomMessageListener bRt = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aLS != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aLS, ConcernFragment.this.dCH) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azn));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dCH = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azn));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.ejj = new ConcernPageView(context);
        this.ejj.aDk();
        registerListener(this.bRt);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ejj.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ejj.getParent()).removeView(this.ejj);
            if (this.ejk != null) {
                this.ejj.setCallback(this.ejk);
            }
        }
        this.ejj.setPageUniqueId(getUniqueId());
        if (this.ejl) {
            this.ejj.aDk();
            this.ejl = false;
        }
        return this.ejj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        if (this.ejj != null) {
            this.ejj.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ejj != null) {
            this.ejj.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ejj != null) {
            this.ejj.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ejj.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bRt);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ejj.onDestroy();
        this.ejl = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dro) {
                if (this.ejj != null) {
                    this.ejj.aIh();
                }
                this.dro = true;
            }
            this.ejj.setViewForeground();
            return;
        }
        this.ejj.aIl();
        completePullRefresh();
    }

    public void ZQ() {
        this.ejj.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.ejj.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.ejk = aVar;
        this.ejj.setCallback(aVar);
    }

    public void af(String str, int i) {
        this.ejj.af(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.ejj != null) {
            this.ejj.a(dataRes, z);
        }
    }

    public void aIg() {
        if (this.ejj != null) {
            this.ejj.aIi();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zu() {
        if (this.dro) {
            this.ejj.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zv() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zw() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.d(arrayList, arrayList.size() - 1))) {
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
        this.ejj.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ef() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
