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
/* loaded from: classes8.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    private SigleRecordsFragment iEA;
    private SigleRecordsFragment iEB;
    private NavigationBar iEy;
    private SigleRecordsFragment iEz;
    private FragmentTabHost mTabHost;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.consumption_records_activity_layout);
        this.iEy = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iEy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iEy.setCenterTextTitle(getResources().getString(R.string.consumption_records));
        cty();
    }

    private void cty() {
        this.mTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iEz = new SigleRecordsFragment();
        this.iEz.setType(1);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = this.iEz;
        cVar.textResId = R.string.expenditure_records;
        a(cVar, ge(getPageContext().getPageActivity()), null);
        this.iEA = new SigleRecordsFragment();
        this.iEA.setType(2);
        com.baidu.tbadk.mainTab.c cVar2 = new com.baidu.tbadk.mainTab.c();
        cVar2.frag = this.iEA;
        cVar2.textResId = R.string.income_records;
        a(cVar2, ge(getPageContext().getPageActivity()), null);
        this.iEB = new SigleRecordsFragment();
        this.iEB.setType(3);
        com.baidu.tbadk.mainTab.c cVar3 = new com.baidu.tbadk.mainTab.c();
        cVar3.frag = this.iEB;
        cVar3.textResId = R.string.recharge_records;
        a(cVar3, ge(getPageContext().getPageActivity()), null);
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTab(xg(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
    }

    private int xg(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return i == 3 ? 2 : 0;
    }

    private FragmentTabIndicator ge(Context context) {
        return (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
    }

    private void a(com.baidu.tbadk.mainTab.c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        if (cVar != null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            bVar.mContentFragment = cVar.frag;
            fragmentTabIndicator.setText(cVar.textResId);
            if (!TextUtils.isEmpty(str)) {
                fragmentTabIndicator.setText(str);
            }
            fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.ds32));
            fragmentTabIndicator.dayTextColorResId = R.color.s_actionbar_text_color;
            bVar.faJ = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iEy.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        this.mTabHost.onChangeSkinType(i);
    }
}
