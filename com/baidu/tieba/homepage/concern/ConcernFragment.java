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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes16.dex */
public class ConcernFragment extends BaseFragment implements aq {
    private boolean hLD;
    private ConcernPageView iGo;
    private ConcernPageView.a iGp;
    private boolean iGq = false;
    private CustomMessageListener hUl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().eCa != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().eCa, ConcernFragment.this.hUk) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.iGo != null) {
                ConcernFragment.this.iGo.EF();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.iGo = new ConcernPageView(context);
        this.iGo.bMg();
        registerListener(this.hUl);
        registerListener(this.hUE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.iGo.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iGo.getParent()).removeView(this.iGo);
            if (this.iGp != null) {
                this.iGo.setCallback(this.iGp);
            }
        }
        this.iGo.setPageUniqueId(getUniqueId());
        if (this.iGq) {
            this.iGo.bMg();
            this.iGq = false;
        }
        return this.iGo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iGo != null) {
            this.iGo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.iGo != null) {
            this.iGo.setRecommendFrsNavigationAnimDispatcher(aaVar);
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
        if (this.iGo != null) {
            this.iGo.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iGo.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.hUl);
        MessageManager.getInstance().unRegisterListener(this.hUE);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.iGo.onDestroy();
        this.iGq = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.hLD) {
                if (this.iGo != null) {
                    this.iGo.cwa();
                }
                this.hLD = true;
            }
            this.iGo.setViewForeground();
            return;
        }
        this.iGo.cwg();
        completePullRefresh();
    }

    public void completePullRefresh() {
        this.iGo.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.iGp = aVar;
        this.iGo.setCallback(aVar);
    }

    public void aQ(String str, int i) {
        this.iGo.aQ(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.iGo != null) {
            this.iGo.a(dataRes, z);
        }
    }

    public void cvZ() {
        if (this.iGo != null) {
            this.iGo.cwb();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        if (this.hLD) {
            this.iGo.reload();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
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
        this.iGo.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iGo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
