package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CreateBarGuideActivity extends NavigationBarActivity {
    private x Mn;
    private z aYN = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.aox.setTitleText(t.frs_create_forum);
        this.aYN = z.a(new y(getResources().getString(t.create_bar), new f(this, stringExtra)));
        this.Mn = NoDataViewFactory.a(getPageContext().getPageActivity(), getRootView(), aa.a(NoDataViewFactory.ImgType.CREATE), ab.k(getResources().getString(t.frs_remind_noforum), getResources().getString(t.frs_remind_create), stringExtra), this.aYN);
        this.Mn.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.Mn.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }
}
