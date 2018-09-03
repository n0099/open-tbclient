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
    private g dij;
    private e dik;
    private e.a dil;
    private NoNetworkView.a dim = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
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
        this.dik = new e();
        this.dil = new e.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.1
            @Override // com.baidu.tieba.forumMember.bawu.e.a
            public void a(ArrayList<i> arrayList, p pVar, boolean z, int i, String str) {
                if (z) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.dij.getRootView());
                    if (i == 0) {
                        BawuTeamInfoActivity.this.dij.a(arrayList, pVar, true);
                        return;
                    }
                    BawuTeamInfoActivity.this.showToast(str);
                    if (BawuTeamInfoActivity.this.dij.asU()) {
                        BawuTeamInfoActivity.this.dij.asV();
                        return;
                    }
                    return;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.dij.getRootView());
                    BawuTeamInfoActivity.this.dij.a(arrayList, pVar, false);
                }
                BawuTeamInfoActivity.this.dik.bF(BawuTeamInfoActivity.this.forumId);
            }
        };
        this.dik.a(this.dil);
        this.dik.bE(this.forumId);
        showLoadingView(this.dij.getRootView(), true);
    }

    public void initUI() {
        this.dij = new g(this);
        this.dij.f(this.dim);
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
        showLoadingView(this.dij.getRootView(), true);
        this.dik.bF(this.forumId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dij.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dik != null) {
            this.dik.destroy();
        }
        if (this.dij != null) {
            this.dij.onDestroy();
        }
    }
}
