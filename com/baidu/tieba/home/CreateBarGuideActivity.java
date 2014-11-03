package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarGuideActivity extends NavigationBarActivity {
    com.baidu.tbadk.core.view.o aHu;
    private com.baidu.tbadk.core.view.q aMp = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(CreateBarGuideActivityConfig.class, CreateBarGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.bhL.setTitleText(y.frs_create_forum);
        this.aMp = com.baidu.tbadk.core.view.q.a(new com.baidu.tbadk.core.view.p(getResources().getString(y.create_bar), new e(this, stringExtra)));
        this.aHu = NoDataViewFactory.a(this, getRootView(), com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.CREATE), com.baidu.tbadk.core.view.s.j(getResources().getString(y.frs_remind_noforum), getResources().getString(y.frs_remind_create), stringExtra), this.aMp);
        this.aHu.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.aHu.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }
}
