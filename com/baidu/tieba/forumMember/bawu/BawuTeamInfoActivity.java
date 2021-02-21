package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.bawu.e;
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    private long forumId;
    private g jbO;
    private e jbP;
    private e.a jbQ;
    private NoNetworkView.a jbR = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                BawuTeamInfoActivity.this.refreshData();
            }
        }
    };

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
        this.jbP = new e();
        this.jbQ = new e.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.1
            @Override // com.baidu.tieba.forumMember.bawu.e.a
            public void a(ArrayList<i> arrayList, l lVar, boolean z, int i, String str) {
                if (z) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.jbO.getRootView());
                    if (i == 0) {
                        BawuTeamInfoActivity.this.jbO.a(arrayList, lVar, true);
                        return;
                    }
                    BawuTeamInfoActivity.this.showToast(str);
                    if (BawuTeamInfoActivity.this.jbO.cAN()) {
                        BawuTeamInfoActivity.this.jbO.cAO();
                        return;
                    }
                    return;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.jbO.getRootView());
                    BawuTeamInfoActivity.this.jbO.a(arrayList, lVar, false);
                }
                BawuTeamInfoActivity.this.jbP.gp(BawuTeamInfoActivity.this.forumId);
            }
        };
        this.jbP.a(this.jbQ);
        this.jbP.go(this.forumId);
        showLoadingView(this.jbO.getRootView(), true);
    }

    public void initUI() {
        this.jbO = new g(this);
        this.jbO.e(this.jbR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refreshData();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BAWU_TEAM_INFO, BawuTeamSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BAWU_TEAM_INFO, 1001705, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_BAWU_TEAM_INFO_CACHE, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        showLoadingView(this.jbO.getRootView(), true);
        this.jbP.gp(this.forumId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jbO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jbP != null) {
            this.jbP.destroy();
        }
        if (this.jbO != null) {
            this.jbO.onDestroy();
        }
    }
}
