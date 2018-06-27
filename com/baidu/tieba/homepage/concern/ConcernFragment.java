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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernFragment extends BaseFragment implements ah {
    private boolean cZw;
    private ConcernPageView dPW;
    private ConcernPageView.a dPX;
    private boolean dPY = false;
    private CustomMessageListener bBI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aDu, ConcernFragment.this.dkD) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arP));
                        }
                    } else if (updateAttentionMessage.getData().Gr && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dkD = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arP));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.dPW = new ConcernPageView(context);
        this.dPW.axE();
        registerListener(this.bBI);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dPW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dPW.getParent()).removeView(this.dPW);
            if (this.dPX != null) {
                this.dPW.setCallback(this.dPX);
            }
        }
        this.dPW.setPageUniqueId(getUniqueId());
        if (this.dPY) {
            this.dPW.axE();
            this.dPY = false;
        }
        return this.dPW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        if (this.dPW != null) {
            this.dPW.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dPW != null) {
            this.dPW.setRecommendFrsNavigationAnimDispatcher(tVar);
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
        if (this.dPW != null) {
            this.dPW.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dPW.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bBI);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dPW.onDestroy();
        this.dPY = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.cZw) {
                if (this.dPW != null) {
                    this.dPW.aCz();
                }
                this.cZw = true;
            }
            this.dPW.setViewForeground();
            return;
        }
        this.dPW.aCD();
        completePullRefresh();
    }

    public void Ua() {
        this.dPW.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dPW.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.dPX = aVar;
        this.dPW.setCallback(aVar);
    }

    public void aa(String str, int i) {
        this.dPW.aa(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dPW != null) {
            this.dPW.a(dataRes, z);
        }
    }

    public void aCx() {
        if (this.dPW != null) {
            this.dPW.aCz();
            this.cZw = true;
        }
    }

    public void aCy() {
        if (this.dPW != null) {
            this.dPW.aCA();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TE() {
        if (this.cZw) {
            this.dPW.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TF() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(w.d(arrayList, arrayList.size() - 1))) {
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
        this.dPW.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void AP() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
