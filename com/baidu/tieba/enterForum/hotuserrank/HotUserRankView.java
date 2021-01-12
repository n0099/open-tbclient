package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankView {
    private CustomViewPager eWN;
    private TbTabLayout gcC;
    private String iEC;
    private BaseFragmentActivity iEK;
    private View iEL;
    private View iEM;
    private FragmentAdapter iEN;
    private b iEO;
    private View iEP;
    private TextView iEQ;
    private View iER;
    private TextView iES;
    private View iET;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> gvo = new ArrayList();
    private Runnable iEU = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eWN.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.iEP) {
                HotUserRankView.this.iEK.finish();
            } else if (view == HotUserRankView.this.iEQ) {
                if (TextUtils.isEmpty(HotUserRankView.this.iEC)) {
                    HotUserRankView.this.iEK.showToast(R.string.load_error_retry);
                    return;
                }
                be.bsB().b(HotUserRankView.this.iEK.getPageContext(), new String[]{HotUserRankView.this.iEC});
                if (HotUserRankView.this.gcC.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.an("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.an("obj_locate", 1);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.gvo.get(i) != null && ((a) HotUserRankView.this.gvo.get(i)).iEX != null && ((a) HotUserRankView.this.gvo.get(i)).iEX.cvj() != null) {
                HotUserRankView.this.iEO.b(((a) HotUserRankView.this.gvo.get(i)).iEX.cvj().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dW("resource_id", ((a) HotUserRankView.this.gvo.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener iEV = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.iEK.getUniqueId())) {
                c cVar = (c) customResponsedMessage.getData();
                if (cVar.iFC != null) {
                    HotUserRankView.this.iEO.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.iEK = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.iEK).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.iEP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iEP.setOnClickListener(this.mOnClickListener);
        this.iEQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iEK.getString(R.string.hot_user_rank_rule));
        this.iEQ.setOnClickListener(this.mOnClickListener);
        this.gcC = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.gcC.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.iEL = this.mRootView.findViewById(R.id.tab_cover_left);
        this.iEM = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eWN = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eWN.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eWN.setViewPagerScroll(0);
        this.iEN = new FragmentAdapter(this.iEK.getSupportFragmentManager());
        this.eWN.setAdapter(this.iEN);
        this.gcC.setupWithViewPager(this.eWN);
        this.iEO = new b(this.iEK.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.iEK.registerListener(this.iEV);
        this.iER = this.mRootView.findViewById(R.id.update_tip);
        this.iES = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.iET = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.iEC = str;
        if (!x.isEmpty(list) || j > 0) {
            this.gvo.clear();
            if (x.isEmpty(list)) {
                this.gcC.setVisibility(8);
                a aVar = new a();
                aVar.iEX = new HotUserRankFragment();
                aVar.iEX.setForumId(j);
                this.gvo.add(aVar);
                this.iEN.setData(this.gvo);
                this.iEO.xy(1);
                return;
            }
            for (d dVar : list) {
                this.gcC.a(this.gcC.qN());
                a aVar2 = new a();
                aVar2.iEX = new HotUserRankFragment();
                aVar2.iEX.setCategory(dVar.category);
                aVar2.iEX.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.gvo.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.iEK.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.iEK.getString(R.string.all_hot_user_rank));
            }
            this.iEN.setData(this.gvo);
            this.iEO.xy(2);
            if (i != 0) {
                this.eWN.setCurrentItem(i);
            }
            e.mB().postDelayed(this.iEU, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes2.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> gvo;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.gvo = new ArrayList();
        }

        public void setData(List<a> list) {
            this.gvo.clear();
            if (!x.isEmpty(list)) {
                this.gvo.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.gvo.get(i);
            if (aVar != null) {
                return aVar.iEX;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gvo.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.gvo.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public HotUserRankFragment iEX;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iEK.getPageContext(), i);
        this.gcC.setTabTextColors(ao.getColor(R.color.CAM_X0108), ao.getColor(R.color.CAM_X0105));
        this.gcC.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0302));
        ao.setBackgroundColor(this.gcC, R.color.CAM_X0207);
        ao.k(this.iEQ, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.iEO.onChangeSkinType(i);
        Drawable a2 = SvgManager.bsx().a(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.iEK, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.iEK, R.dimen.tbds2);
        if (a2 != null) {
            a2.setBounds(0, dimens2, dimens, dimens + dimens2);
            this.iES.setCompoundDrawables(a2, null, null, null);
        }
        this.iES.setCompoundDrawablePadding(l.getDimens(this.iEK, R.dimen.tbds9));
        com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0901).oX(R.color.CAM_X0804).oV(4369).oY(l.getDimens(this.iEK, R.dimen.tbds21)).oZ(0).pa(0).bz(this.iER);
        ao.setBackgroundResource(this.iEL, R.drawable.hot_user_rank_tab_cover_left);
        ao.setBackgroundResource(this.iEM, R.drawable.hot_user_rank_tab_cover_right);
        this.iET.setVisibility(i != 0 ? 8 : 0);
    }

    public void xx(int i) {
        this.iER.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mB().removeCallbacks(this.iEU);
    }
}
