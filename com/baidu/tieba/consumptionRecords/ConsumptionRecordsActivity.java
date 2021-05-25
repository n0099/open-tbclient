package com.baidu.tieba.consumptionRecords;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.m0.e0.c;
/* loaded from: classes4.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    public SigleRecordsFragment expenditureFragment;
    public SigleRecordsFragment incomeFragment;
    public NavigationBar mNavigationbar;
    public FragmentTabHost mTabHost;
    public SigleRecordsFragment rechargeFragment;

    private void createAndAddTabSpec(c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.f12151c = cVar.f49334a;
        fragmentTabIndicator.setText(cVar.f49335b);
        if (!TextUtils.isEmpty(str)) {
            fragmentTabIndicator.setText(str);
        }
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        bVar.f12150b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private int getIndexByType(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        return i2 == 3 ? 2 : 0;
    }

    private FragmentTabIndicator getTabIndicator(Context context) {
        return (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
    }

    private void initTabs() {
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
        this.mTabHost = fragmentTabHost;
        fragmentTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        SigleRecordsFragment sigleRecordsFragment = new SigleRecordsFragment();
        this.expenditureFragment = sigleRecordsFragment;
        sigleRecordsFragment.U0(1);
        c cVar = new c();
        cVar.f49334a = this.expenditureFragment;
        cVar.f49335b = R.string.expenditure_records;
        createAndAddTabSpec(cVar, getTabIndicator(getPageContext().getPageActivity()), null);
        SigleRecordsFragment sigleRecordsFragment2 = new SigleRecordsFragment();
        this.incomeFragment = sigleRecordsFragment2;
        sigleRecordsFragment2.U0(2);
        c cVar2 = new c();
        cVar2.f49334a = this.incomeFragment;
        cVar2.f49335b = R.string.income_records;
        createAndAddTabSpec(cVar2, getTabIndicator(getPageContext().getPageActivity()), null);
        SigleRecordsFragment sigleRecordsFragment3 = new SigleRecordsFragment();
        this.rechargeFragment = sigleRecordsFragment3;
        sigleRecordsFragment3.U0(3);
        c cVar3 = new c();
        cVar3.f49334a = this.rechargeFragment;
        cVar3.f49335b = R.string.recharge_records;
        createAndAddTabSpec(cVar3, getTabIndicator(getPageContext().getPageActivity()), null);
        this.mTabHost.k(3);
        this.mTabHost.setCurrentTab(getIndexByType(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mNavigationbar.onChangeSkinType(getPageContext(), i2);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        this.mTabHost.o(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.consumption_records_activity_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationbar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationbar.setCenterTextTitle(getResources().getString(R.string.consumption_records));
        initTabs();
    }
}
