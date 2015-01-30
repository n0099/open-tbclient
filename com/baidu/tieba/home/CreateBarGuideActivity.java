package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
/* loaded from: classes.dex */
public class CreateBarGuideActivity extends NavigationBarActivity {
    private z aPy = null;
    x zO;

    static {
        TbadkApplication.getInst().RegisterIntent(CreateBarGuideActivityConfig.class, CreateBarGuideActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.aeV.setTitleText(com.baidu.tieba.z.frs_create_forum);
        this.aPy = z.a(new y(getResources().getString(com.baidu.tieba.z.create_bar), new e(this, stringExtra)));
        this.zO = NoDataViewFactory.a(getPageContext().getPageActivity(), getRootView(), aa.a(NoDataViewFactory.ImgType.CREATE), ab.m(getResources().getString(com.baidu.tieba.z.frs_remind_noforum), getResources().getString(com.baidu.tieba.z.frs_remind_create), stringExtra), this.aPy);
        this.zO.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.zO.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
    }
}
