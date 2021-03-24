package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaAllLiveSimpleActivity extends BaseFragmentActivity {
    public AlaSquareLiveFragment mFragment;
    public NavigationBar mNavigationBar;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        AlaSquareLiveFragment alaSquareLiveFragment = this.mFragment;
        if (alaSquareLiveFragment != null) {
            alaSquareLiveFragment.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.square_simple_live_activity);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.nav_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.all_live_act_title);
        if (bundle == null) {
            AlaSquareLiveFragment alaSquareLiveFragment = new AlaSquareLiveFragment(true);
            this.mFragment = alaSquareLiveFragment;
            alaSquareLiveFragment.setPrimary(true);
            getSupportFragmentManager().beginTransaction().add(R.id.container, this.mFragment).commitAllowingStateLoss();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
