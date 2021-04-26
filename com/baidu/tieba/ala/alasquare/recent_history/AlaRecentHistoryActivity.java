package com.baidu.tieba.ala.alasquare.recent_history;

import android.os.Bundle;
import com.baidu.ala.widget.multicolumn.absView.AbsTabActivity;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaRecentHistoryActivity extends AbsTabActivity {
    public AbsTabPagerAdapter mAdapter = new AlaRecentHistoryAdapter(getSupportFragmentManager());

    /* loaded from: classes4.dex */
    public class a extends AbsTabActivity.CustomOnPageChangeListener {
        public a() {
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3, int i4) {
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageSelected(int i2, int i3) {
            if (100 == i3) {
                TiebaStatic.log("c12650");
            } else if (200 == i3) {
                TiebaStatic.log("c12652");
            }
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public AbsTabPagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void onPreInit() {
        super.onPreInit();
        setOnPagerChangeListener(new a());
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void setNavigationBar(NavigationBar navigationBar) {
        navigationBar.setTitleText(R.string.square_recent_history_title);
    }
}
