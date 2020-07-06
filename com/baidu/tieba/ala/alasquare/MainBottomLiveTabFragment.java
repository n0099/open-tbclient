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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MainBottomLiveTabFragment extends BaseFragment {
    private CustomViewPager dSy;
    private LinearLayout flG;
    private TextView flH;
    private NoNetworkView flI;
    private FragmentAdapter flJ;
    private List<a> flK = new ArrayList();
    private NoNetworkView.a flL = new NoNetworkView.a() { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.flJ.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.flJ.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).reload();
                }
            }
        }
    };
    private CustomMessageListener flM = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new ao("c13703").dk("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.flM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.flG = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.flH = (TextView) inflate.findViewById(R.id.tab_view);
        this.dSy = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.flI = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        initView();
        return inflate;
    }

    private void initView() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.flG.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.flI.a(this.flL);
        this.dSy.setViewPagerScroll(0);
        this.flJ = new FragmentAdapter(getChildFragmentManager());
        this.dSy.setAdapter(this.flJ);
        a aVar = new a();
        aVar.flO = new AlaLiveTabFragment();
        aVar.title = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.flK.add(aVar);
        this.flJ.setData(this.flK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.flJ.getCount() > 0) {
            Fragment item = this.flJ.getItem(0);
            if (item instanceof AlaLiveTabFragment) {
                AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
                if (alaLiveTabFragment.btM()) {
                    alaLiveTabFragment.setUserVisibleHint(true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setViewTextColor(this.flH, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.flG, R.color.cp_bg_line_h);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.flI.onChangeSkinType(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.flM);
    }

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> flK;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.flK = new ArrayList();
        }

        public void setData(List<a> list) {
            this.flK.clear();
            if (!w.isEmpty(list)) {
                this.flK.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.flK.get(i);
            if (aVar != null) {
                return aVar.flO;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.flK.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.flK.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public AlaLiveTabFragment flO;
        public String title;

        public a() {
        }
    }
}
