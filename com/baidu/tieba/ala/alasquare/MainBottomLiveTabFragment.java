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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MainBottomLiveTabFragment extends BaseFragment {
    private CustomViewPager eRw;
    private LinearLayout gpu;
    private TextView gpv;
    private NoNetworkView gpw;
    private FragmentAdapter gpx;
    private List<a> gpy = new ArrayList();
    private NoNetworkView.a gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.gpx.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.gpx.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).reload();
                }
            }
        }
    };
    private CustomMessageListener gpA = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new ar("c13703").dY("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gpA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.gpu = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.gpv = (TextView) inflate.findViewById(R.id.tab_view);
        this.eRw = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.gpw = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        initView();
        return inflate;
    }

    private void initView() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gpu.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.gpw.a(this.gpz);
        this.eRw.setViewPagerScroll(0);
        this.gpx = new FragmentAdapter(getChildFragmentManager());
        this.eRw.setAdapter(this.gpx);
        a aVar = new a();
        aVar.gpC = new AlaLiveTabFragment();
        aVar.title = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.gpy.add(aVar);
        this.gpx.setData(this.gpy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.gpx.getCount() > 0) {
            Fragment item = this.gpx.getItem(0);
            if (item instanceof AlaLiveTabFragment) {
                AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
                if (alaLiveTabFragment.bSe()) {
                    alaLiveTabFragment.setUserVisibleHint(true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.gpv, (int) R.color.CAM_X0105);
        ap.setBackgroundColor(this.gpu, R.color.CAM_X0207);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.gpw.onChangeSkinType(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    /* loaded from: classes6.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gpy;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gpy = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gpy.clear();
            if (!y.isEmpty(list)) {
                this.gpy.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gpy.get(i);
            if (aVar != null) {
                return aVar.gpC;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.gpy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gpy.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public AlaLiveTabFragment gpC;
        public String title;

        public a() {
        }
    }
}
