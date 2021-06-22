package com.baidu.tieba.forumMember.bawu;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import d.a.o0.p0.a.e;
import d.a.o0.p0.a.f;
import d.a.o0.p0.a.g;
import d.a.o0.p0.a.i;
import d.a.o0.p0.c.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class BawuTeamInfoActivity extends BaseActivity<BawuTeamInfoActivity> {
    public long forumId;
    public e.c mDataCallback;
    public e mModel;
    public NoNetworkView.b mNetworkChangedListener = new b();
    public g mView;

    /* loaded from: classes4.dex */
    public class a implements e.c {
        public a() {
        }

        @Override // d.a.o0.p0.a.e.c
        public void a(ArrayList<i> arrayList, l lVar, boolean z, int i2, String str) {
            if (!z) {
                if (arrayList != null && arrayList.size() > 0) {
                    BawuTeamInfoActivity bawuTeamInfoActivity = BawuTeamInfoActivity.this;
                    bawuTeamInfoActivity.hideLoadingView(bawuTeamInfoActivity.mView.d());
                    BawuTeamInfoActivity.this.mView.k(arrayList, lVar, false);
                }
                BawuTeamInfoActivity.this.mModel.i(BawuTeamInfoActivity.this.forumId);
                return;
            }
            BawuTeamInfoActivity bawuTeamInfoActivity2 = BawuTeamInfoActivity.this;
            bawuTeamInfoActivity2.hideLoadingView(bawuTeamInfoActivity2.mView.d());
            if (i2 == 0) {
                BawuTeamInfoActivity.this.mView.k(arrayList, lVar, true);
                return;
            }
            BawuTeamInfoActivity.this.showToast(str);
            if (BawuTeamInfoActivity.this.mView.e()) {
                BawuTeamInfoActivity.this.mView.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                BawuTeamInfoActivity.this.refreshData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        showLoadingView(this.mView.d(), true);
        this.mModel.i(this.forumId);
    }

    public void initData() {
        this.mModel = new e();
        a aVar = new a();
        this.mDataCallback = aVar;
        this.mModel.k(aVar);
        this.mModel.h(this.forumId);
        showLoadingView(this.mView.d(), true);
    }

    public void initUI() {
        g gVar = new g(this);
        this.mView = gVar;
        gVar.h(this.mNetworkChangedListener);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.f(i2);
    }

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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.mModel;
        if (eVar != null) {
            eVar.g();
        }
        g gVar = this.mView;
        if (gVar != null) {
            gVar.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refreshData();
    }

    public void registerTask() {
        d.a.o0.e3.d0.a.h(301007, BawuTeamSocketResponseMessage.class, false, false);
        d.a.o0.e3.d0.a.c(301007, CmdConfigHttp.BAWU_TEAM_INFO_CMD, TbConfig.GET_BAWU_INFO, BawuTeamHttpResponseMessage.class, false, false, false, false);
        d.a.o0.e3.d0.a.b(2003005, f.class);
    }
}
