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
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernFragment extends BaseFragment implements ah {
    private boolean dBk;
    private ConcernPageView etB;
    private ConcernPageView.a etC;
    private boolean etD = false;
    private CustomMessageListener bVY = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aPX != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aPX, ConcernFragment.this.dMD) != null) {
                            TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDq));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dMD = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDq));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.etB = new ConcernPageView(context);
        this.etB.aGi();
        registerListener(this.bVY);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.etB.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.etB.getParent()).removeView(this.etB);
            if (this.etC != null) {
                this.etB.setCallback(this.etC);
            }
        }
        this.etB.setPageUniqueId(getUniqueId());
        if (this.etD) {
            this.etB.aGi();
            this.etD = false;
        }
        return this.etB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        if (this.etB != null) {
            this.etB.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        if (this.etB != null) {
            this.etB.setRecommendFrsNavigationAnimDispatcher(vVar);
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
        if (this.etB != null) {
            this.etB.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.etB.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bVY);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.etB.onDestroy();
        this.etD = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dBk) {
                if (this.etB != null) {
                    this.etB.aLl();
                }
                this.dBk = true;
            }
            this.etB.setViewForeground();
            return;
        }
        this.etB.aLp();
        completePullRefresh();
    }

    public void abv() {
        this.etB.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.etB.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.etC = aVar;
        this.etB.setCallback(aVar);
    }

    public void ah(String str, int i) {
        this.etB.ah(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.etB != null) {
            this.etB.a(dataRes, z);
        }
    }

    public void aLk() {
        if (this.etB != null) {
            this.etB.aLm();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        if (this.dBk) {
            this.etB.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aba() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void abb() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1))) {
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
        this.etB.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
