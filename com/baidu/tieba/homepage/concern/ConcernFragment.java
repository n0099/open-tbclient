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
import com.baidu.tbadk.util.w;
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
    private boolean fou;
    private ConcernPageView gdT;
    private ConcernPageView.a gdU;
    private boolean gdV = false;
    private CustomMessageListener fwC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    if (updateAttentionMessage.getData().cwD != null) {
                        if (AntiHelper.a(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().cwD, ConcernFragment.this.fwB) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(ConcernFragment.this.getActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private final AntiHelper.a fwB = new AntiHelper.a() { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.homepage.concern.ConcernFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.gdT != null) {
                ConcernFragment.this.gdT.pC();
            }
        }
    };

    public ConcernFragment() {
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        this.gdT = new ConcernPageView(context);
        this.gdT.aNd();
        registerListener(this.fwC);
        registerListener(this.fwS);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.gdT.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gdT.getParent()).removeView(this.gdT);
            if (this.gdU != null) {
                this.gdT.setCallback(this.gdU);
            }
        }
        this.gdT.setPageUniqueId(getUniqueId());
        if (this.gdV) {
            this.gdT.aNd();
            this.gdV = false;
        }
        return this.gdT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gdT != null) {
            this.gdT.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.gdT != null) {
            this.gdT.setRecommendFrsNavigationAnimDispatcher(wVar);
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
        if (this.gdT != null) {
            this.gdT.onResume();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gdT.setTabInForeBackgroundState(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.fwC);
        MessageManager.getInstance().unRegisterListener(this.fwS);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gdT.onDestroy();
        this.gdV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.fou) {
                if (this.gdT != null) {
                    this.gdT.bsV();
                }
                this.fou = true;
            }
            this.gdT.setViewForeground();
            return;
        }
        this.gdT.bsZ();
        completePullRefresh();
    }

    public void aKh() {
        this.gdT.setViewForeground(true);
    }

    public void completePullRefresh() {
        this.gdT.completePullRefresh();
    }

    public void setCallback(ConcernPageView.a aVar) {
        this.gdU = aVar;
        this.gdT.setCallback(aVar);
    }

    public void aw(String str, int i) {
        this.gdT.aw(str, i);
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.gdT != null) {
            this.gdT.a(dataRes, z);
        }
    }

    public void bsU() {
        if (this.gdT != null) {
            this.gdT.bsW();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
        if (this.fou) {
            this.gdT.reload();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.HOMEPAGE_CONCERN;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gdT.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gdT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }
}
