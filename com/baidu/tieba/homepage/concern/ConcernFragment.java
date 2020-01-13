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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes7.dex */
public class ConcernFragment extends BaseFragment implements af {
    private ConcernPageView gUG;
    private ConcernPageView.a gUH;
    private boolean gfl;
    private boolean gUI = false;
    private CustomMessageListener gnq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().djO != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().djO, ConcernFragment.this.gnp) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a gnp = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.gUG != null) {
                ConcernFragment.this.gUG.rl();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.gUG = new ConcernPageView(context);
        this.gUG.initListeners();
        registerListener(this.gnq);
        registerListener(this.gnG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gUG.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gUG.getParent()).removeView(this.gUG);
            if (this.gUH != null) {
                this.gUG.setCallback(this.gUH);
            }
        }
        this.gUG.setPageUniqueId(getUniqueId());
        if (this.gUI) {
            this.gUG.initListeners();
            this.gUI = false;
        }
        return this.gUG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gUG != null) {
            this.gUG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gUG != null) {
            this.gUG.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gUG != null) {
            this.gUG.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gUG.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.gnq);
        MessageManager.getInstance().unRegisterListener(this.gnG);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gUG.onDestroy();
        this.gUI = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.gfl) {
                if (this.gUG != null) {
                    this.gUG.bLu();
                }
                this.gfl = true;
            }
            this.gUG.setViewForeground();
            return;
        }
        this.gUG.bLA();
        completePullRefresh();
    }

    public void baZ() {
        this.gUG.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.gUG.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.gUH = aVar;
        this.gUG.setCallback(aVar);
    }

    public void aG(String str, int i) {
        this.gUG.aG(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gUG != null) {
            this.gUG.a(dataRes, z);
        }
    }

    public void bLt() {
        if (this.gUG != null) {
            this.gUG.bLv();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void yj() {
        if (this.gfl) {
            this.gUG.reload();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bah() {
    }

    @Override // com.baidu.tieba.frs.af
    public void bai() {
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
        this.gUG.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.af
    public void aFw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gUG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
