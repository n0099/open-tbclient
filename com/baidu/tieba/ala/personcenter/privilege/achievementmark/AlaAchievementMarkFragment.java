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
/* loaded from: classes3.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    private static final String TITLE = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_achievement_mark_fragment_title);
    private g fkQ;
    private com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a gqa;
    private AlaPersonCenterPrivilegeMarkModel gqb;
    private a gqc;
    private AlaPersonCenterPrivilegeMarkModel.a gqd = new AlaPersonCenterPrivilegeMarkModel.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.a
        public void a(int i, String str, Object obj) {
            AlaAchievementMarkFragment.this.hideLoadingView();
            if (i != 0 && !StringUtils.isNull(str)) {
                if (AlaAchievementMarkFragment.this.gqa != null) {
                    if (j.isNetWorkAvailable()) {
                        AlaAchievementMarkFragment.this.gqa.a(R.drawable.pic_live_empty04, R.string.ala_net_data_error_fail_tip, false, null);
                    } else {
                        AlaAchievementMarkFragment.this.gqa.a(R.drawable.pic_live_empty03, R.string.ala_net_fail_tip, true, AlaAchievementMarkFragment.this.fdF);
                    }
                    AlaAchievementMarkFragment.this.gqa.a(null, null);
                }
            } else if (obj == null) {
                AlaAchievementMarkFragment.this.gqa.a(null, null);
            } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                if (AlaAchievementMarkFragment.this.gqa != null) {
                    AlaAchievementMarkFragment.this.gqa.bqO();
                    AlaAchievementMarkFragment.this.gqa.a(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                }
            }
        }
    };
    private View.OnClickListener fdF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                AlaAchievementMarkFragment.this.refreshData();
            } else {
                AlaAchievementMarkFragment.this.showToast(AlaAchievementMarkFragment.this.getResources().getString(R.string.no_network_guide));
            }
        }
    };
    private a.InterfaceC0587a gqe = new a.InterfaceC0587a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.4
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.InterfaceC0587a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gqa = new com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a(getPageContext(), this.gqe);
        showLoadingView();
        refreshData();
        this.gqc = new a(getPageContext(), new a.InterfaceC0585a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment.1
            @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.InterfaceC0585a
            public void a(boolean z, com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
                if (z) {
                    AlaAchievementMarkFragment.this.refreshData();
                }
            }
        });
        return this.gqa.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.gqb == null) {
            this.gqb = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.gqd);
        }
        this.gqb.bIH();
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
        if (this.gqb != null) {
            this.gqb.destory();
        }
        if (this.gqc != null) {
            this.gqc.onDestroy();
        }
        hideLoadingView();
    }

    private void showLoadingView() {
        if (this.fkQ == null) {
            this.fkQ = new g(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.ds386));
        }
        if (this.gqa != null && this.gqa.getView() != null) {
            this.fkQ.attachView(this.gqa.getView(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fkQ != null && this.gqa != null && this.gqa.getView() != null) {
            this.fkQ.dettachView(this.gqa.getView());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fkQ != null) {
            this.fkQ.onChangeSkinType();
        }
    }
}
