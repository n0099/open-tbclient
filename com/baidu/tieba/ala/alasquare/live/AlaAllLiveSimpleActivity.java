package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class AlaAllLiveSimpleActivity extends BaseFragmentActivity {
    private AlaSquareLiveFragment efx;
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
            this.efx = new AlaSquareLiveFragment(true);
            this.efx.setPrimary(true);
            getSupportFragmentManager().beginTransaction().add(R.id.container, this.efx).commitAllowingStateLoss();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.efx != null) {
            this.efx.changeSkinType(i);
        }
    }
}
