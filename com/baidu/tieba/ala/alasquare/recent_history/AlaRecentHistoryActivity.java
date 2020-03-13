package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import com.baidu.ala.widget.multicolumn.absView.AbsTabActivity;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaRecentHistoryActivity extends AbsTabActivity {
    private AbsTabPagerAdapter eqg = new AlaRecentHistoryAdapter(getSupportFragmentManager());

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void onPreInit() {
        super.onPreInit();
        setOnPagerChangeListener(new AbsTabActivity.CustomOnPageChangeListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity.1
            @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
            public void onPageScrolled(int i, float f, int i2, int i3) {
            }

            @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
            public void onPageSelected(int i, int i2) {
                if (100 == i2) {
                    TiebaStatic.log("c12650");
                } else if (200 == i2) {
                    TiebaStatic.log("c12652");
                }
            }

            @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    protected void setNavigationBar(NavigationBar navigationBar) {
        navigationBar.setTitleText(R.string.square_recent_history_title);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    protected AbsTabPagerAdapter getAdapter() {
        return this.eqg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }
}
