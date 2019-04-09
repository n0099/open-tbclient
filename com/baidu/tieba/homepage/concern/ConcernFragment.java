package com.baidu.tieba.homepage.concern;

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernFragment extends BaseFragment implements ae {
    private boolean eOo;
    private ConcernPageView fFM;
    private ConcernPageView.a fFN;
    private boolean fFO = false;
    private CustomMessageListener dds = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().bYC != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().bYC, ConcernFragment.this.eZQ) != null) {
                            TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLq));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a eZQ = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLq));
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.fFM.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fFM.getParent()).removeView(this.fFM);
            if (this.fFN != null) {
                this.fFM.setCallback(this.fFN);
            }
        }
        this.fFM.setPageUniqueId(getUniqueId());
        if (this.fFO) {
            this.fFM.bgy();
            this.fFO = false;
        }
        return this.fFM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
        if (this.fFM != null) {
            this.fFM.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fFM != null) {
            this.fFM.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fFM != null) {
            this.fFM.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fFM.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.dds);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fFM.onDestroy();
        this.fFO = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.eOo) {
                if (this.fFM != null) {
                    this.fFM.blo();
                }
                this.eOo = true;
            }
            this.fFM.setViewForeground();
            return;
        }
        this.fFM.blq();
        completePullRefresh();
    }

    public void completePullRefresh() {
        this.fFM.completePullRefresh();
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBr() {
        if (this.eOo) {
            this.fFM.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBs() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBt() {
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
        this.fFM.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeH() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
