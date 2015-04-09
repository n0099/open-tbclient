package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.u;
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class CreateBarGuideActivity extends NavigationBarActivity {
    private s Ms;
    private u aWi = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.anu.setTitleText(y.frs_create_forum);
        this.aWi = u.a(new t(getResources().getString(y.create_bar), new e(this, stringExtra)));
        this.Ms = NoDataViewFactory.a(getPageContext().getPageActivity(), getRootView(), v.a(NoDataViewFactory.ImgType.CREATE), w.k(getResources().getString(y.frs_remind_noforum), getResources().getString(y.frs_remind_create), stringExtra), this.aWi);
        this.Ms.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.Ms.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }
}
