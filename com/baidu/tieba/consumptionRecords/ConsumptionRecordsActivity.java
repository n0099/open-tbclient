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
    private SigleRecordsFragment iBA;
    private SigleRecordsFragment iBB;
    private NavigationBar iBy;
    private SigleRecordsFragment iBz;
    private FragmentTabHost mTabHost;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.consumption_records_activity_layout);
        this.iBy = (NavigationBar) findViewById(R.id.navigation_bar);
        this.iBy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iBy.setCenterTextTitle(getResources().getString(R.string.consumption_records));
        cvR();
    }

    private void cvR() {
        this.mTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
        this.mTabHost.setup(getSupportFragmentManager());
        this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iBz = new SigleRecordsFragment();
        this.iBz.setType(1);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = this.iBz;
        cVar.textResId = R.string.expenditure_records;
        a(cVar, gg(getPageContext().getPageActivity()), null);
        this.iBA = new SigleRecordsFragment();
        this.iBA.setType(2);
        com.baidu.tbadk.mainTab.c cVar2 = new com.baidu.tbadk.mainTab.c();
        cVar2.frag = this.iBA;
        cVar2.textResId = R.string.income_records;
        a(cVar2, gg(getPageContext().getPageActivity()), null);
        this.iBB = new SigleRecordsFragment();
        this.iBB.setType(3);
        com.baidu.tbadk.mainTab.c cVar3 = new com.baidu.tbadk.mainTab.c();
        cVar3.frag = this.iBB;
        cVar3.textResId = R.string.recharge_records;
        a(cVar3, gg(getPageContext().getPageActivity()), null);
        this.mTabHost.initViewPager(3);
        this.mTabHost.setCurrentTab(yC(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
    }

    private int yC(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return i == 3 ? 2 : 0;
    }

    private FragmentTabIndicator gg(Context context) {
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
            bVar.fbC = fragmentTabIndicator;
            this.mTabHost.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iBy.onChangeSkinType(getPageContext(), i);
        this.mTabHost.setNeedShowThemeStyle(false);
        this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
        this.mTabHost.onChangeSkinType(i);
    }
}
