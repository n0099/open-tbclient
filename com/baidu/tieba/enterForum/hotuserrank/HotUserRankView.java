package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class HotUserRankView {
    private CustomViewPager eiw;
    private String hwI;
    private BaseFragmentActivity hwQ;
    private TbTabLayout hwR;
    private View hwS;
    private View hwT;
    private FragmentAdapter hwU;
    private b hwV;
    private View hwW;
    private TextView hwX;
    private View hwY;
    private TextView hwZ;
    private View hxa;
    private boolean isGod;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<a> fCo = new ArrayList();
    private Runnable hxb = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.eiw.setViewPagerScroll();
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.hwW) {
                HotUserRankView.this.hwQ.finish();
            } else if (view == HotUserRankView.this.hwX) {
                if (TextUtils.isEmpty(HotUserRankView.this.hwI)) {
                    HotUserRankView.this.hwQ.showToast(R.string.load_error_retry);
                    return;
                }
                be.bju().b(HotUserRankView.this.hwQ.getPageContext(), new String[]{HotUserRankView.this.hwI});
                if (HotUserRankView.this.hwR.getVisibility() == 0) {
                    aq aqVar = new aq("c13658");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.ai("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13669");
                aqVar2.ai("obj_locate", 1);
                TiebaStatic.log(aqVar2);
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.fCo.get(i) != null && ((a) HotUserRankView.this.fCo.get(i)).hxe != null && ((a) HotUserRankView.this.fCo.get(i)).hxe.cfS() != null) {
                HotUserRankView.this.hwV.b(((a) HotUserRankView.this.fCo.get(i)).hxe.cfS().getPageData());
                aq aqVar = new aq("c13657");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dD("resource_id", ((a) HotUserRankView.this.fCo.get(i)).title);
                TiebaStatic.log(aqVar);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hxc = new CustomMessageListener(2921447) { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankView.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.hotuserrank.a.c) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() != null && customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.hwQ.getUniqueId())) {
                com.baidu.tieba.enterForum.hotuserrank.a.c cVar = (com.baidu.tieba.enterForum.hotuserrank.a.c) customResponsedMessage.getData();
                if (cVar.hxL != null) {
                    HotUserRankView.this.hwV.b(cVar);
                }
            }
        }
    };

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.hwQ = baseFragmentActivity;
        this.mRootView = LayoutInflater.from(this.hwQ).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.hwW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hwW.setOnClickListener(this.mOnClickListener);
        this.hwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hwQ.getString(R.string.hot_user_rank_rule));
        this.hwX.setOnClickListener(this.mOnClickListener);
        this.hwR = (TbTabLayout) this.mRootView.findViewById(R.id.tablayout);
        this.hwR.setTabTextSize(l.getDimens(baseFragmentActivity, R.dimen.tbds46));
        this.hwS = this.mRootView.findViewById(R.id.tab_cover_left);
        this.hwT = this.mRootView.findViewById(R.id.tab_cover_right);
        this.eiw = (CustomViewPager) this.mRootView.findViewById(R.id.viewpager);
        this.eiw.addOnPageChangeListener(this.mOnPageChangeListener);
        this.eiw.setViewPagerScroll(0);
        this.hwU = new FragmentAdapter(this.hwQ.getSupportFragmentManager());
        this.eiw.setAdapter(this.hwU);
        this.hwR.setupWithViewPager(this.eiw);
        this.hwV = new b(this.hwQ.getPageContext(), this.mRootView.findViewById(R.id.bottom_view));
        this.hwQ.registerListener(this.hxc);
        this.hwY = this.mRootView.findViewById(R.id.update_tip);
        this.hwZ = (TextView) this.mRootView.findViewById(R.id.update_tip_text);
        this.hxa = this.mRootView.findViewById(R.id.bottom_view_top_line);
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(List<d> list, long j, int i, String str) {
        this.hwI = str;
        if (!y.isEmpty(list) || j > 0) {
            this.fCo.clear();
            if (y.isEmpty(list)) {
                this.hwR.setVisibility(8);
                a aVar = new a();
                aVar.hxe = new HotUserRankFragment();
                aVar.hxe.setForumId(j);
                this.fCo.add(aVar);
                this.hwU.setData(this.fCo);
                this.hwV.wd(1);
                return;
            }
            for (d dVar : list) {
                this.hwR.a(this.hwR.re());
                a aVar2 = new a();
                aVar2.hxe = new HotUserRankFragment();
                aVar2.hxe.setCategory(dVar.category);
                aVar2.hxe.setIsGod(this.isGod);
                aVar2.title = dVar.name;
                this.fCo.add(aVar2);
            }
            if (this.isGod) {
                this.mNavigationBar.setCenterTextTitle(this.hwQ.getString(R.string.all_god_user_rank));
            } else {
                this.mNavigationBar.setCenterTextTitle(this.hwQ.getString(R.string.all_hot_user_rank));
            }
            this.hwU.setData(this.fCo);
            this.hwV.wd(2);
            if (i != 0) {
                this.eiw.setCurrentItem(i);
            }
            e.mS().postDelayed(this.hxb, 100L);
        }
    }

    public void setTitle(String str) {
        this.mNavigationBar.setCenterTextTitle(str);
    }

    /* loaded from: classes16.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<a> fCo;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.fCo = new ArrayList();
        }

        public void setData(List<a> list) {
            this.fCo.clear();
            if (!y.isEmpty(list)) {
                this.fCo.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            a aVar = this.fCo.get(i);
            if (aVar != null) {
                return aVar.hxe;
            }
            return null;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fCo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            a aVar = this.fCo.get(i);
            return aVar != null ? aVar.title : "";
        }
    }

    /* loaded from: classes16.dex */
    public class a {
        public HotUserRankFragment hxe;
        public String title;

        public a() {
        }
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hwQ.getPageContext(), i);
        this.hwR.setTabTextColors(ap.getColor(R.color.cp_cont_c), ap.getColor(R.color.cp_cont_b));
        this.hwR.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundColor(this.hwR, R.color.cp_bg_line_h);
        ap.e(this.hwX, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        this.hwV.onChangeSkinType(i);
        Drawable a2 = SvgManager.bjq().a(R.drawable.svg_icon_pure_toast_complete24, R.color.cp_link_tip_a, (SvgManager.SvgResourceStateType) null);
        int dimens = l.getDimens(this.hwQ, R.dimen.tbds63);
        int dimens2 = l.getDimens(this.hwQ, R.dimen.tbds2);
        a2.setBounds(0, dimens2, dimens, dimens + dimens2);
        this.hwZ.setCompoundDrawablePadding(l.getDimens(this.hwQ, R.dimen.tbds9));
        this.hwZ.setCompoundDrawables(a2, null, null, null);
        com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_btn_a).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.hwQ, R.dimen.tbds21)).os(0).ot(0).aZ(this.hwY);
        ap.setBackgroundResource(this.hwS, R.drawable.hot_user_rank_tab_cover_left);
        ap.setBackgroundResource(this.hwT, R.drawable.hot_user_rank_tab_cover_right);
        this.hxa.setVisibility(i != 0 ? 8 : 0);
    }

    public void wc(int i) {
        this.hwY.setVisibility(i);
    }

    public void setIsGod(boolean z) {
        this.isGod = z;
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.hxb);
    }
}
