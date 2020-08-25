package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a;
/* loaded from: classes4.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);
    private g fMN;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a gVa;
    private AlaPersonCenterPrivilegeMarkModel gVb;
    private a gVc;
    private AlaPersonCenterPrivilegeMarkModel.a gVd = new AlaPersonCenterPrivilegeMarkModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.a
        public void a(int i, String str, Object obj) {
            AlaAchievementMarkFragment.this.hideLoadingView();
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaAchievementMarkFragment.this.gVa != null) {
                    if (j.isNetWorkAvailable()) {
                        AlaAchievementMarkFragment.this.gVa.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    } else {
                        AlaAchievementMarkFragment.this.gVa.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, AlaAchievementMarkFragment.this.fFE);
                    }
                    AlaAchievementMarkFragment.this.gVa.a(null, null);
                }
            } else if (obj == null) {
                AlaAchievementMarkFragment.this.gVa.a(null, null);
            } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                if (AlaAchievementMarkFragment.this.gVa != null) {
                    AlaAchievementMarkFragment.this.gVa.bFW();
                    AlaAchievementMarkFragment.this.gVa.a(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                }
            }
        }
    };
    private View.OnClickListener fFE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                AlaAchievementMarkFragment.this.refreshData();
            } else {
                AlaAchievementMarkFragment.this.showToast(AlaAchievementMarkFragment.this.getResources().getString(R.string.no_network_guide));
            }
        }
    };
    private a.InterfaceC0655a gVe = new a.InterfaceC0655a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.InterfaceC0655a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gVa = new com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a(getPageContext(), this.gVe);
        showLoadingView();
        refreshData();
        this.gVc = new a(getPageContext(), new a.InterfaceC0653a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.InterfaceC0653a
            public void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
                if (z) {
                    AlaAchievementMarkFragment.this.refreshData();
                }
            }
        });
        return this.gVa.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gVb == null) {
            this.gVb = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.gVd);
        }
        this.gVb.bYX();
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        return 0;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        return TITLE;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            TiebaStatic.log("c13334");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gVb != null) {
            this.gVb.destory();
        }
        if (this.gVc != null) {
            this.gVc.onDestroy();
        }
        hideLoadingView();
    }

    private void showLoadingView() {
        if (this.fMN == null) {
            this.fMN = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        if (this.gVa != null && this.gVa.getView() != null) {
            this.fMN.attachView(this.gVa.getView(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fMN != null && this.gVa != null && this.gVa.getView() != null) {
            this.fMN.dettachView(this.gVa.getView());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
    }
}
