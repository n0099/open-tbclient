package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.bawu.e;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    private g dDV;
    private e dDW;
    private e.a dDX;
    private NoNetworkView.a dDY = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                BawuTeamInfoActivity.this.refreshData();
            }
        }
    };
    private long forumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.forumId = getIntent().getLongExtra("forum_id", 0L);
        }
        registerTask();
        initUI();
        initData();
    }

    public void initData() {
        this.dDW = new e();
        this.dDX = new e.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.1
            @Override // com.baidu.tieba.forumMember.bawu.e.a
            public void a(ArrayList<i> arrayList, p pVar, boolean z, int i, String str) {
                if (z) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.dDV.getRootView());
                    if (i == 0) {
                        BawuTeamInfoActivity.this.dDV.a(arrayList, pVar, true);
                        return;
                    }
                    BawuTeamInfoActivity.this.showToast(str);
                    if (BawuTeamInfoActivity.this.dDV.azm()) {
                        BawuTeamInfoActivity.this.dDV.azn();
                        return;
                    }
                    return;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.dDV.getRootView());
                    BawuTeamInfoActivity.this.dDV.a(arrayList, pVar, false);
                }
                BawuTeamInfoActivity.this.dDW.bT(BawuTeamInfoActivity.this.forumId);
            }
        };
        this.dDW.a(this.dDX);
        this.dDW.bS(this.forumId);
        showLoadingView(this.dDV.getRootView(), true);
    }

    public void initUI() {
        this.dDV = new g(this);
        this.dDV.f(this.dDY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refreshData();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(301007, BawuTeamSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2003005, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        showLoadingView(this.dDV.getRootView(), true);
        this.dDW.bT(this.forumId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dDV.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dDW != null) {
            this.dDW.destroy();
        }
        if (this.dDV != null) {
            this.dDV.onDestroy();
        }
    }
}
