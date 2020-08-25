package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.forumMember.bawu.e;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    private long forumId;
    private g hOg;
    private e hOh;
    private e.a hOi;
    private NoNetworkView.a hOj = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.2
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
        this.hOh = new e();
        this.hOi = new e.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.1
            @Override // com.baidu.tieba.forumMember.bawu.e.a
            public void a(ArrayList<i> arrayList, p pVar, boolean z, int i, String str) {
                if (z) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.hOg.getRootView());
                    if (i == 0) {
                        BawuTeamInfoActivity.this.hOg.a(arrayList, pVar, true);
                        return;
                    }
                    BawuTeamInfoActivity.this.showToast(str);
                    if (BawuTeamInfoActivity.this.hOg.ckg()) {
                        BawuTeamInfoActivity.this.hOg.ckh();
                        return;
                    }
                    return;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.hOg.getRootView());
                    BawuTeamInfoActivity.this.hOg.a(arrayList, pVar, false);
                }
                BawuTeamInfoActivity.this.hOh.eF(BawuTeamInfoActivity.this.forumId);
            }
        };
        this.hOh.a(this.hOi);
        this.hOh.eE(this.forumId);
        showLoadingView(this.hOg.getRootView(), true);
    }

    public void initUI() {
        this.hOg = new g(this);
        this.hOg.e(this.hOj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refreshData();
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BAWU_TEAM_INFO, BawuTeamSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_BAWU_TEAM_INFO, 1001705, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_BAWU_TEAM_INFO_CACHE, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        showLoadingView(this.hOg.getRootView(), true);
        this.hOh.eF(this.forumId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hOg.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hOh != null) {
            this.hOh.destroy();
        }
        if (this.hOg != null) {
            this.hOg.onDestroy();
        }
    }
}
