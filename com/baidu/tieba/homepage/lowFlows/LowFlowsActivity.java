package com.baidu.tieba.homepage.lowFlows;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import d.b.i0.a1.f.c;
import d.b.i0.a1.f.i.a;
/* loaded from: classes4.dex */
public class LowFlowsActivity extends BaseActivity<LowFlowsActivity> {
    public c mLowFlowsView;

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a086";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        c cVar = this.mLowFlowsView;
        if (cVar != null) {
            cVar.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(getPageContext());
        this.mLowFlowsView = aVar;
        aVar.loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar = this.mLowFlowsView;
        if (cVar != null) {
            cVar.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c cVar = this.mLowFlowsView;
        if (cVar != null) {
            cVar.loadData();
        }
        if (getIntent() != null) {
            d.b.i0.a1.f.h.a.a("c14083", StringUtils.isNull(getIntent().getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID)) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), getIntent().getStringExtra(LowFlowsActivityConfig.TAB_CODE));
        }
    }
}
