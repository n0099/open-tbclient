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
    private boolean dqk;
    private ConcernPageView ehP;
    private ConcernPageView.a ehQ;
    private boolean ehR = false;
    private CustomMessageListener bQJ = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aLc != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aLc, ConcernFragment.this.dBq) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayA));
                        }
                    } else if (updateAttentionMessage.getData().Jo && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dBq = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayA));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.ehP = new ConcernPageView(context);
        this.ehP.aDQ();
        registerListener(this.bQJ);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.ehP.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ehP.getParent()).removeView(this.ehP);
            if (this.ehQ != null) {
                this.ehP.setCallback(this.ehQ);
            }
        }
        this.ehP.setPageUniqueId(getUniqueId());
        if (this.ehR) {
            this.ehP.aDQ();
            this.ehR = false;
        }
        return this.ehP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        if (this.ehP != null) {
            this.ehP.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ehP != null) {
            this.ehP.setRecommendFrsNavigationAnimDispatcher(uVar);
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
        if (this.ehP != null) {
            this.ehP.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ehP.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bQJ);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ehP.onDestroy();
        this.ehR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dqk) {
                if (this.ehP != null) {
                    this.ehP.aIJ();
                }
                this.dqk = true;
            }
            this.ehP.setViewForeground();
            return;
        }
        this.ehP.aIN();
        completePullRefresh();
    }

    public void ZG() {
        this.ehP.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.ehP.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.ehQ = aVar;
        this.ehP.setCallback(aVar);
    }

    public void af(String str, int i) {
        this.ehP.af(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.ehP != null) {
            this.ehP.a(dataRes, z);
        }
    }

    public void aII() {
        if (this.ehP != null) {
            this.ehP.aIK();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
        if (this.dqk) {
            this.ehP.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zl() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zm() {
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
        this.ehP.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void DV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
