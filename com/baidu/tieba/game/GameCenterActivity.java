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
    private View aGI;
    private NavigationBar aGJ;
    private FragmentTabWidget aGK;
    private GameCenterPager aGL;
    private bi aGM;
    private ao aGN;

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameCenterActivityConfig.class, GameCenterActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rY();
    }

    private void rY() {
        setContentView(com.baidu.tieba.w.game_center_activity);
        this.aGI = findViewById(com.baidu.tieba.v.parent);
        Hf();
        initViewPager();
        Hg();
    }

    private void Hf() {
        this.aGJ = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.aGJ.setTitleText(com.baidu.tieba.y.game_center);
        this.aGJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
        this.aGJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_gift, (View.OnClickListener) null).setOnClickListener(new h(this));
        this.aGJ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_search, (View.OnClickListener) null).setOnClickListener(new i(this));
    }

    private void initViewPager() {
        this.aGL = (GameCenterPager) findViewById(com.baidu.tieba.v.fragment_pager);
        this.aGL.setOnPageChangeListener(this);
        this.aGL.setAdapter(new k(this, getSupportFragmentManager()));
    }

    private void Hg() {
        this.aGK = (FragmentTabWidget) findViewById(com.baidu.tieba.v.tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this);
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.y.game_tab_good));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(this);
        fragmentTabIndicator2.VN = com.baidu.tieba.s.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.t.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.y.game_tab_light));
        this.aGK.addView(fragmentTabIndicator);
        this.aGK.addView(fragmentTabIndicator2);
        if (Hh()) {
            this.aGL.setCurrentItem(0);
            this.aGK.d(0, true);
        } else {
            this.aGL.setCurrentItem(1);
            this.aGK.d(1, true);
        }
        this.aGK.setTabSelectionListener(new j(this));
    }

    private boolean Hh() {
        Game Hj = l.Hi().Hj();
        if (Hj == null || Hj.gameEnter == null || Hj.gameEnter.rateList == null || Hj.gameEnter.rateList.rate == null || Hj.gameEnter.rateList.rate.size() == 0) {
            return true;
        }
        Integer num = Hj.gameEnter.rateList.rate.get(0);
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
            this.aGL.setCurrentItem(i);
        }
    }

    public int getCurrentPosition() {
        return this.aGL.getCurrentItem();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        getLayoutMode().h(this.aGI);
        this.aGJ.onChangeSkinType(i);
        this.aGK.onChangeSkinType(i);
        if (this.aGM != null) {
            this.aGM.onChangeSkinType(i);
        }
        if (this.aGN != null) {
            this.aGN.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.aGK.a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 0) {
            TiebaStatic.eventStat(this, "gamecenter_select", "click");
        }
        this.aGK.d(i, true);
        fa(i);
    }

    private void fa(int i) {
        if (i == 0) {
            if (this.aGM != null) {
                this.aGM.Hw();
            }
        } else if (i == 1 && this.aGN != null) {
            this.aGN.Hw();
        }
    }
}
