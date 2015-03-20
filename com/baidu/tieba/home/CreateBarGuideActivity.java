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
    private s Mq;
    private u aVS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.anm.setTitleText(y.frs_create_forum);
        this.aVS = u.a(new t(getResources().getString(y.create_bar), new e(this, stringExtra)));
        this.Mq = NoDataViewFactory.a(getPageContext().getPageActivity(), getRootView(), v.a(NoDataViewFactory.ImgType.CREATE), w.k(getResources().getString(y.frs_remind_noforum), getResources().getString(y.frs_remind_create), stringExtra), this.aVS);
        this.Mq.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.Mq.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }
}
