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
import com.baidu.tbadk.m.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a;
/* loaded from: classes6.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);
    private g dEq;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a ezm;
    private AlaPersonCenterPrivilegeMarkModel ezn;
    private a ezo;
    private AlaPersonCenterPrivilegeMarkModel.a ezp = new AlaPersonCenterPrivilegeMarkModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.a
        public void a(int i, String str, Object obj) {
            AlaAchievementMarkFragment.this.hideLoadingView();
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaAchievementMarkFragment.this.ezm != null) {
                    if (j.isNetWorkAvailable()) {
                        AlaAchievementMarkFragment.this.ezm.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    } else {
                        AlaAchievementMarkFragment.this.ezm.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, AlaAchievementMarkFragment.this.dxG);
                    }
                    AlaAchievementMarkFragment.this.ezm.a(null, null);
                }
            } else if (obj == null) {
                AlaAchievementMarkFragment.this.ezm.a(null, null);
            } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                if (AlaAchievementMarkFragment.this.ezm != null) {
                    AlaAchievementMarkFragment.this.ezm.aJo();
                    AlaAchievementMarkFragment.this.ezm.a(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                }
            }
        }
    };
    private View.OnClickListener dxG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                AlaAchievementMarkFragment.this.refreshData();
            } else {
                AlaAchievementMarkFragment.this.showToast(AlaAchievementMarkFragment.this.getResources().getString(R.string.no_network_guide));
            }
        }
    };
    private a.InterfaceC0384a ezq = new a.InterfaceC0384a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.InterfaceC0384a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
        }
    };

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.ezm = new com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a(getPageContext(), this.ezq);
        showLoadingView();
        refreshData();
        this.ezo = new a(getPageContext(), new a.InterfaceC0382a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.InterfaceC0382a
            public void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
                if (z) {
                    AlaAchievementMarkFragment.this.refreshData();
                }
            }
        });
        return this.ezm.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.ezn == null) {
            this.ezn = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.ezp);
        }
        this.ezn.aXY();
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
        if (this.ezn != null) {
            this.ezn.destory();
        }
        if (this.ezo != null) {
            this.ezo.onDestroy();
        }
        hideLoadingView();
    }

    private void showLoadingView() {
        if (this.dEq == null) {
            this.dEq = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        if (this.ezm != null && this.ezm.getView() != null) {
            this.dEq.attachView(this.ezm.getView(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.dEq != null && this.ezm != null && this.ezm.getView() != null) {
            this.dEq.dettachView(this.ezm.getView());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEq != null) {
            this.dEq.onChangeSkinType();
        }
    }
}
