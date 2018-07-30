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
import com.baidu.tbadk.util.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernFragment extends BaseFragment implements ah {
    private ConcernPageView dSJ;
    private ConcernPageView.a dSK;
    private boolean dcn;
    private boolean dSL = false;
    private CustomMessageListener bCp = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().aDu, ConcernFragment.this.dnt) != null) {
                            TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arq));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a dnt = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arq));
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.dSJ = new ConcernPageView(context);
        this.dSJ.ayj();
        registerListener(this.bCp);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dSJ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.dSJ.getParent()).removeView(this.dSJ);
            if (this.dSK != null) {
                this.dSJ.setCallback(this.dSK);
            }
        }
        this.dSJ.setPageUniqueId(getUniqueId());
        if (this.dSL) {
            this.dSJ.ayj();
            this.dSL = false;
        }
        return this.dSJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        if (this.dSJ != null) {
            this.dSJ.setHeaderViewHeight(i);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dSJ != null) {
            this.dSJ.setRecommendFrsNavigationAnimDispatcher(sVar);
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
        if (this.dSJ != null) {
            this.dSJ.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dSJ.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.bCp);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dSJ.onDestroy();
        this.dSL = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.dcn) {
                if (this.dSJ != null) {
                    this.dSJ.aDh();
                }
                this.dcn = true;
            }
            this.dSJ.setViewForeground();
            return;
        }
        this.dSJ.aDl();
        completePullRefresh();
    }

    public void Ui() {
        this.dSJ.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.dSJ.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.dSK = aVar;
        this.dSJ.setCallback(aVar);
    }

    public void W(String str, int i) {
        this.dSJ.W(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dSJ != null) {
            this.dSJ.a(dataRes, z);
        }
    }

    public void aDg() {
        if (this.dSJ != null) {
            this.dSJ.aDi();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TM() {
        if (this.dcn) {
            this.dSJ.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TN() {
    }

    @Override // com.baidu.tieba.frs.ah
    public void TO() {
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
        this.dSJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ah
    public void AG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }
}
