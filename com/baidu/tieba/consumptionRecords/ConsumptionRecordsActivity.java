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
    private NavigationBar iwR;
    private SigleRecordsFragment iwS;
    private SigleRecordsFragment iwT;
    private SigleRecordsFragment iwU;
    private FragmentTabHost mTabHost;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.consumption_records_activity_layout);
        this.iwR = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iwR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iwR.setCenterTextTitle(getResources().getString(R.string.consumption_records));
        crZ();
    }

    private void crZ() {
        this.mTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iwS = new SigleRecordsFragment();
        this.iwS.setType(1);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = this.iwS;
        cVar.textResId = R.string.expenditure_records;
        a(cVar, ge(getPageContext().getPageActivity()), null);
        this.iwT = new SigleRecordsFragment();
        this.iwT.setType(2);
        com.baidu.tbadk.mainTab.c cVar2 = new com.baidu.tbadk.mainTab.c();
        cVar2.frag = this.iwT;
        cVar2.textResId = R.string.income_records;
        a(cVar2, ge(getPageContext().getPageActivity()), null);
        this.iwU = new SigleRecordsFragment();
        this.iwU.setType(3);
        com.baidu.tbadk.mainTab.c cVar3 = new com.baidu.tbadk.mainTab.c();
        cVar3.frag = this.iwU;
        cVar3.textResId = R.string.recharge_records;
        a(cVar3, ge(getPageContext().getPageActivity()), null);
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTab(wV(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
    }

    private int wV(int i) {
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
            bVar.eWU = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iwR.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        this.mTabHost.onChangeSkinType(i);
    }
}
