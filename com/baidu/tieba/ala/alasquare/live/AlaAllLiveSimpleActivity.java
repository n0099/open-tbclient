package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaAllLiveSimpleActivity extends BaseFragmentActivity {
    private AlaSquareLiveFragment duv;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.square_simple_live_activity);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.nav_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.all_live_act_title);
        if (bundle == null) {
            this.duv = new AlaSquareLiveFragment(true);
            this.duv.setPrimary(true);
            getSupportFragmentManager().beginTransaction().add(R.id.container, this.duv).commitAllowingStateLoss();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.duv != null) {
            this.duv.changeSkinType(i);
        }
    }
}
