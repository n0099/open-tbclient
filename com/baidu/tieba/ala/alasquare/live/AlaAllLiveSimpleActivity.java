package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AlaAllLiveSimpleActivity extends BaseFragmentActivity {
    private AlaSquareLiveFragment gyM;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.square_simple_live_activity);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.nav_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.all_live_act_title);
        if (bundle == null) {
            this.gyM = new AlaSquareLiveFragment(true);
            this.gyM.setPrimary(true);
            getSupportFragmentManager().beginTransaction().add(R.id.container, this.gyM).commitAllowingStateLoss();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.gyM != null) {
            this.gyM.changeSkinType(i);
        }
    }
}
