package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
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
/* loaded from: classes10.dex */
public class MainBottomLiveTabFragment extends BaseFragment {
    private CustomViewPager eZd;
    private LinearLayout gyi;
    private TextView gyj;
    private NoNetworkView gyk;
    private FragmentAdapter gyl;
    private List<a> gym = new ArrayList();
    private NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.gyl.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.gyl.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).reload();
                }
            }
        }
    };
    private CustomMessageListener gyo = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.ala.alasquare.MainBottomLiveTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new ar("c13703").dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gyo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.gyi = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.gyj = (TextView) inflate.findViewById(R.id.tab_view);
        this.eZd = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.gyk = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        initView();
        return inflate;
    }

    private void initView() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gyi.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.gyk.a(this.gyn);
        this.eZd.setViewPagerScroll(0);
        this.gyl = new FragmentAdapter(getChildFragmentManager());
        this.eZd.setAdapter(this.gyl);
        a aVar = new a();
        aVar.gyq = new AlaLiveTabFragment();
        aVar.title = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.gym.add(aVar);
        this.gyl.setData(this.gym);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.gyl.getCount() > 0) {
            Fragment item = this.gyl.getItem(0);
            if (item instanceof AlaLiveTabFragment) {
                AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
                if (alaLiveTabFragment.bRA()) {
                    alaLiveTabFragment.setUserVisibleHint(true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setViewTextColor(this.gyj, R.color.CAM_X0105);
        ap.setBackgroundColor(this.gyi, R.color.CAM_X0207);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.gyk.onChangeSkinType(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gyo);
    }

    /* loaded from: classes10.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gym;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gym = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gym.clear();
            if (!y.isEmpty(list)) {
                this.gym.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gym.get(i);
            if (aVar != null) {
                return aVar.gyq;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gym.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gym.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public AlaLiveTabFragment gyq;
        public String title;

        public a() {
        }
    }
}
