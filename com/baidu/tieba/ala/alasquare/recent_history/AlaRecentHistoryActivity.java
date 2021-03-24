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
        public void onPageScrollStateChanged(int i) {
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2, int i3) {
        }

        @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity.CustomOnPageChangeListener
        public void onPageSelected(int i, int i2) {
            if (100 == i2) {
                TiebaStatic.log("c12650");
            } else if (200 == i2) {
                TiebaStatic.log("c12652");
            }
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public AbsTabPagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
