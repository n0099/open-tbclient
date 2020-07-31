package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MainBottomLiveTabFragment extends BaseFragment {
    private CustomViewPager dYQ;
    private LinearLayout fqO;
    private TextView fqP;
    private NoNetworkView fqQ;
    private FragmentAdapter fqR;
    private List<a> fqS = new ArrayList();
    private NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.fqR.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.fqR.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).reload();
                }
            }
        }
    };
    private CustomMessageListener fqU = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new ap("c13703").dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fqU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.fqO = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.fqP = (TextView) inflate.findViewById(R.id.tab_view);
        this.dYQ = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.fqQ = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        initView();
        return inflate;
    }

    private void initView() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fqO.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.fqQ.a(this.fqT);
        this.dYQ.setViewPagerScroll(0);
        this.fqR = new FragmentAdapter(getChildFragmentManager());
        this.dYQ.setAdapter(this.fqR);
        a aVar = new a();
        aVar.fqW = new AlaLiveTabFragment();
        aVar.title = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.fqS.add(aVar);
        this.fqR.setData(this.fqS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.fqR.getCount() > 0) {
            Fragment item = this.fqR.getItem(0);
            if (item instanceof AlaLiveTabFragment) {
                AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
                if (alaLiveTabFragment.bwV()) {
                    alaLiveTabFragment.setUserVisibleHint(true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setViewTextColor(this.fqP, R.color.cp_cont_b);
        ao.setBackgroundColor(this.fqO, R.color.cp_bg_line_h);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.fqQ.onChangeSkinType(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fqU);
    }

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fqS;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fqS = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fqS.clear();
            if (!x.isEmpty(list)) {
                this.fqS.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fqS.get(i);
            if (aVar != null) {
                return aVar.fqW;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fqS.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fqS.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public AlaLiveTabFragment fqW;
        public String title;

        public a() {
        }
    }
}
