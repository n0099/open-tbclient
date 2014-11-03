package com.baidu.tieba.game;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.game.view.GameCenterPager;
import java.util.Random;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
public class GameCenterActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    private View aGS;
    private NavigationBar aGT;
    private FragmentTabWidget aGU;
    private GameCenterPager aGV;
    private bj aGW;
    private ao aGX;

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameCenterActivityConfig.class, GameCenterActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sa();
    }

    private void sa() {
        setContentView(com.baidu.tieba.w.game_center_activity);
        this.aGS = findViewById(com.baidu.tieba.v.parent);
        Hh();
        initViewPager();
        Hi();
    }

    private void Hh() {
        this.aGT = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.aGT.setTitleText(com.baidu.tieba.y.game_center);
        this.aGT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.aGT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_gift, (View.OnClickListener) null).setOnClickListener(new h(this));
        this.aGT.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null).setOnClickListener(new i(this));
    }

    private void initViewPager() {
        this.aGV = (GameCenterPager) findViewById(com.baidu.tieba.v.fragment_pager);
        this.aGV.setOnPageChangeListener(this);
        this.aGV.setAdapter(new k(this, getSupportFragmentManager()));
    }

    private void Hi() {
        this.aGU = (FragmentTabWidget) findViewById(com.baidu.tieba.v.tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.game_tab_good));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.VR = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.game_tab_light));
        this.aGU.addView(fragmentTabIndicator);
        this.aGU.addView(fragmentTabIndicator2);
        if (Hj()) {
            this.aGV.setCurrentItem(0);
            this.aGU.d(0, true);
        } else {
            this.aGV.setCurrentItem(1);
            this.aGU.d(1, true);
        }
        this.aGU.setTabSelectionListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.aGX != null) {
            this.aGX.Hy();
        }
        if (this.aGW != null) {
            this.aGW.Hy();
        }
        super.onDestroy();
    }

    private boolean Hj() {
        Game Hl = l.Hk().Hl();
        if (Hl == null || Hl.gameEnter == null || Hl.gameEnter.rateList == null || Hl.gameEnter.rateList.rate == null || Hl.gameEnter.rateList.rate.size() == 0) {
            return true;
        }
        Integer num = Hl.gameEnter.rateList.rate.get(0);
        if (num == null) {
            return true;
        }
        if (num.intValue() > 0 && new Random().nextInt(101) <= num.intValue()) {
            return true;
        }
        return false;
    }

    public void eZ(int i) {
        if (i < 2) {
            this.aGV.setCurrentItem(i);
        }
    }

    public int getCurrentPosition() {
        return this.aGV.getCurrentItem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().h(this.aGS);
        this.aGT.onChangeSkinType(i);
        this.aGU.onChangeSkinType(i);
        if (this.aGW != null) {
            this.aGW.onChangeSkinType(i);
        }
        if (this.aGX != null) {
            this.aGX.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.aGU.a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 0) {
            TiebaStatic.eventStat(this, "gamecenter_select", "click");
        }
        this.aGU.d(i, true);
        fa(i);
    }

    private void fa(int i) {
        if (i == 0) {
            if (this.aGX != null) {
                this.aGX.Hx();
            }
            if (this.aGW != null) {
                this.aGW.Hz();
            }
        } else if (i == 1) {
            if (this.aGW != null) {
                this.aGW.Hx();
            }
            if (this.aGX != null) {
                this.aGX.Hz();
            }
        }
    }
}
