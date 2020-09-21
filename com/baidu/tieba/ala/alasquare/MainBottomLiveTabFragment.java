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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MainBottomLiveTabFragment extends BaseFragment {
    private CustomViewPager ekP;
    private LinearLayout fFA;
    private TextView fFB;
    private NoNetworkView fFC;
    private FragmentAdapter fFD;
    private List<a> fFE = new ArrayList();
    private NoNetworkView.a fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.fFD.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.fFD.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).reload();
                }
            }
        }
    };
    private CustomMessageListener fFG = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new aq("c13703").dF("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.fFG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.fFA = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.fFB = (TextView) inflate.findViewById(R.id.tab_view);
        this.ekP = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.fFC = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        initView();
        return inflate;
    }

    private void initView() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fFA.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.fFC.a(this.fFF);
        this.ekP.setViewPagerScroll(0);
        this.fFD = new FragmentAdapter(getChildFragmentManager());
        this.ekP.setAdapter(this.fFD);
        a aVar = new a();
        aVar.fFI = new AlaLiveTabFragment();
        aVar.title = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.fFE.add(aVar);
        this.fFD.setData(this.fFE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.fFD.getCount() > 0) {
            Fragment item = this.fFD.getItem(0);
            if (item instanceof AlaLiveTabFragment) {
                AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
                if (alaLiveTabFragment.bHl()) {
                    alaLiveTabFragment.setUserVisibleHint(true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.fFB, R.color.cp_cont_b);
        ap.setBackgroundColor(this.fFA, R.color.cp_bg_line_h);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.fFC.onChangeSkinType(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fFG);
    }

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fFE;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fFE = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fFE.clear();
            if (!y.isEmpty(list)) {
                this.fFE.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fFE.get(i);
            if (aVar != null) {
                return aVar.fFI;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fFE.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fFE.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public AlaLiveTabFragment fFI;
        public String title;

        public a() {
        }
    }
}
