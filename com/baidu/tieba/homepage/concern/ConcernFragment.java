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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class ConcernFragment extends BaseFragment implements ap {
    private boolean iLN;
    private ConcernPageView jJE;
    private ConcernPageView.a jJF;
    private boolean jJG = false;
    private CustomMessageListener iUt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().flk != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().flk, ConcernFragment.this.iUs) != null) {
                            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.jJE != null) {
                ConcernFragment.this.jJE.HO();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.jJE = new ConcernPageView(context);
        this.jJE.bZq();
        registerListener(this.iUt);
        registerListener(this.iUM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.jJE.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jJE.getParent()).removeView(this.jJE);
            if (this.jJF != null) {
                this.jJE.setCallback(this.jJF);
            }
        }
        this.jJE.setPageUniqueId(getUniqueId());
        if (this.jJG) {
            this.jJE.bZq();
            this.jJG = false;
        }
        return this.jJE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jJE != null) {
            this.jJE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.jJE != null) {
            this.jJE.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jJE != null) {
            this.jJE.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.jJE.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.iUt);
        MessageManager.getInstance().unRegisterListener(this.iUM);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jJE.onDestroy();
        this.jJG = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.iLN) {
                if (this.jJE != null) {
                    this.jJE.cNv();
                }
                this.iLN = true;
            }
            this.jJE.setViewForeground();
            return;
        }
        this.jJE.cNB();
        completePullRefresh();
    }

    public void completePullRefresh() {
        this.jJE.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.jJF = aVar;
        this.jJE.setCallback(aVar);
    }

    public void aU(String str, int i) {
        this.jJE.aU(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.jJE != null) {
            this.jJE.a(dataRes, z);
        }
    }

    public void cNu() {
        if (this.jJE != null) {
            this.jJE.cNw();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        if (this.iLN) {
            this.jJE.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
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
        this.jJE.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jJE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
