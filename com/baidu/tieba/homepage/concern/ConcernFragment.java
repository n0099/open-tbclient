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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class ConcernFragment extends BaseFragment implements aq {
    private boolean iAe;
    private ConcernPageView jvp;
    private ConcernPageView.a jvq;
    private boolean jvr = false;
    private CustomMessageListener iIL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().feD != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().feD, ConcernFragment.this.iIK) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.jvp != null) {
                ConcernFragment.this.jvp.GI();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.jvp = new ConcernPageView(context);
        this.jvp.bWm();
        registerListener(this.iIL);
        registerListener(this.iJe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jvp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jvp.getParent()).removeView(this.jvp);
            if (this.jvq != null) {
                this.jvp.setCallback(this.jvq);
            }
        }
        this.jvp.setPageUniqueId(getUniqueId());
        if (this.jvr) {
            this.jvp.bWm();
            this.jvr = false;
        }
        return this.jvp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jvp != null) {
            this.jvp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
        if (this.jvp != null) {
            this.jvp.setRecommendFrsNavigationAnimDispatcher(abVar);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jvp != null) {
            this.jvp.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.jvp.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.iIL);
        MessageManager.getInstance().unRegisterListener(this.iJe);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jvp.onDestroy();
        this.jvr = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.iAe) {
                if (this.jvp != null) {
                    this.jvp.cIA();
                }
                this.iAe = true;
            }
            this.jvp.setViewForeground();
            return;
        }
        this.jvp.cIG();
        completePullRefresh();
    }

    public void completePullRefresh() {
        this.jvp.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.jvq = aVar;
        this.jvp.setCallback(aVar);
    }

    public void aU(String str, int i) {
        this.jvp.aU(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.jvp != null) {
            this.jvp.a(dataRes, z);
        }
    }

    public void cIz() {
        if (this.jvp != null) {
            this.jvp.cIB();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        if (this.iAe) {
            this.jvp.reload();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(y.getItem(arrayList, arrayList.size() - 1))) {
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
        this.jvp.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jvp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
