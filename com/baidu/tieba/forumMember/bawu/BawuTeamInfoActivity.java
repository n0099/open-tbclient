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
/* loaded from: classes23.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    private long forumId;
    private g iOp;
    private e iOq;
    private e.a iOr;
    private NoNetworkView.a iOs = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.2
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
        this.iOq = new e();
        this.iOr = new e.a() { // from class: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity.1
            @Override // com.baidu.tieba.forumMember.bawu.e.a
            public void a(ArrayList<i> arrayList, p pVar, boolean z, int i, String str) {
                if (z) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.iOp.getRootView());
                    if (i == 0) {
                        BawuTeamInfoActivity.this.iOp.a(arrayList, pVar, true);
                        return;
                    }
                    BawuTeamInfoActivity.this.showToast(str);
                    if (BawuTeamInfoActivity.this.iOp.cAt()) {
                        BawuTeamInfoActivity.this.iOp.cAu();
                        return;
                    }
                    return;
                }
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity.this.hideLoadingView(BawuTeamInfoActivity.this.iOp.getRootView());
                    BawuTeamInfoActivity.this.iOp.a(arrayList, pVar, false);
                }
                BawuTeamInfoActivity.this.iOq.gk(BawuTeamInfoActivity.this.forumId);
            }
        };
        this.iOq.a(this.iOr);
        this.iOq.gj(this.forumId);
        showLoadingView(this.iOp.getRootView(), true);
    }

    public void initUI() {
        this.iOp = new g(this);
        this.iOp.e(this.iOs);
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
        showLoadingView(this.iOp.getRootView(), true);
        this.iOq.gk(this.forumId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iOp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iOq != null) {
            this.iOq.destroy();
        }
        if (this.iOp != null) {
            this.iOp.onDestroy();
        }
    }
}
