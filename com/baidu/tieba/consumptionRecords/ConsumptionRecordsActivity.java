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
/* loaded from: classes9.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    private NavigationBar iCP;
    private SigleRecordsFragment iCQ;
    private SigleRecordsFragment iCR;
    private SigleRecordsFragment iCS;
    private FragmentTabHost mTabHost;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.consumption_records_activity_layout);
        this.iCP = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iCP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iCP.setCenterTextTitle(getResources().getString(R.string.consumption_records));
        cts();
    }

    private void cts() {
        this.mTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iCQ = new SigleRecordsFragment();
        this.iCQ.setType(1);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = this.iCQ;
        cVar.textResId = R.string.expenditure_records;
        a(cVar, gf(getPageContext().getPageActivity()), null);
        this.iCR = new SigleRecordsFragment();
        this.iCR.setType(2);
        com.baidu.tbadk.mainTab.c cVar2 = new com.baidu.tbadk.mainTab.c();
        cVar2.frag = this.iCR;
        cVar2.textResId = R.string.income_records;
        a(cVar2, gf(getPageContext().getPageActivity()), null);
        this.iCS = new SigleRecordsFragment();
        this.iCS.setType(3);
        com.baidu.tbadk.mainTab.c cVar3 = new com.baidu.tbadk.mainTab.c();
        cVar3.frag = this.iCS;
        cVar3.textResId = R.string.recharge_records;
        a(cVar3, gf(getPageContext().getPageActivity()), null);
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTab(xf(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
    }

    private int xf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return i == 3 ? 2 : 0;
    }

    private FragmentTabIndicator gf(Context context) {
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
            bVar.eZk = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iCP.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        this.mTabHost.onChangeSkinType(i);
    }
}
