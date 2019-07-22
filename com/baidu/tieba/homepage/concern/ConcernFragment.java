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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernFragment extends BaseFragment implements ae {
    private boolean fjz;
    private ConcernPageView gbP;
    private ConcernPageView.a gbQ;
    private boolean gbR = false;
    private CustomMessageListener dyI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().chF != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().chF, ConcernFragment.this.fvc) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUe));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a fvc = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUe));
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.gbP != null) {
                ConcernFragment.this.gbP.bno();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.gbP = new ConcernPageView(context);
        this.gbP.bpT();
        registerListener(this.dyI);
        registerListener(this.fvs);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gbP.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gbP.getParent()).removeView(this.gbP);
            if (this.gbQ != null) {
                this.gbP.setCallback(this.gbQ);
            }
        }
        this.gbP.setPageUniqueId(getUniqueId());
        if (this.gbR) {
            this.gbP.bpT();
            this.gbR = false;
        }
        return this.gbP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gbP != null) {
            this.gbP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbP != null) {
            this.gbP.setRecommendFrsNavigationAnimDispatcher(xVar);
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
        if (this.gbP != null) {
            this.gbP.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gbP.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.dyI);
        MessageManager.getInstance().unRegisterListener(this.fvs);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gbP.onDestroy();
        this.gbR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.fjz) {
                if (this.gbP != null) {
                    this.gbP.buP();
                }
                this.fjz = true;
            }
            this.gbP.setViewForeground();
            return;
        }
        this.gbP.buT();
        completePullRefresh();
    }

    public void aKh() {
        this.gbP.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.gbP.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.gbQ = aVar;
        this.gbP.setCallback(aVar);
    }

    public void az(String str, int i) {
        this.gbP.az(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gbP != null) {
            this.gbP.a(dataRes, z);
        }
    }

    public void buO() {
        if (this.gbP != null) {
            this.gbP.buQ();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
        if (this.fjz) {
            this.gbP.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJj() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gbP.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
