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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class ConcernFragment extends BaseFragment implements aj {
    private ConcernPageView hXw;
    private ConcernPageView.a hXx;
    private boolean hgs;
    private boolean hXy = false;
    private CustomMessageListener hoC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().ecK != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().ecK, ConcernFragment.this.hoB) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a hoB = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.hXw != null) {
                ConcernFragment.this.hXw.ya();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.hXw = new ConcernPageView(context);
        this.hXw.bwC();
        registerListener(this.hoC);
        registerListener(this.hoT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.hXw.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hXw.getParent()).removeView(this.hXw);
            if (this.hXx != null) {
                this.hXw.setCallback(this.hXx);
            }
        }
        this.hXw.setPageUniqueId(getUniqueId());
        if (this.hXy) {
            this.hXw.bwC();
            this.hXy = false;
        }
        return this.hXw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hXw != null) {
            this.hXw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.hXw != null) {
            this.hXw.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hXw != null) {
            this.hXw.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hXw.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.hoC);
        MessageManager.getInstance().unRegisterListener(this.hoT);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hXw.onDestroy();
        this.hXy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.hgs) {
                if (this.hXw != null) {
                    this.hXw.ceu();
                }
                this.hgs = true;
            }
            this.hXw.setViewForeground();
            return;
        }
        this.hXw.ceA();
        completePullRefresh();
    }

    public void brL() {
        this.hXw.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.hXw.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.hXx = aVar;
        this.hXw.setCallback(aVar);
    }

    public void aP(String str, int i) {
        this.hXw.aP(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.hXw != null) {
            this.hXw.a(dataRes, z);
        }
    }

    public void cet() {
        if (this.hXw != null) {
            this.hXw.cev();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        if (this.hgs) {
            this.hXw.reload();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(v.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hXw.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hXw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
