package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment iIU;
    private PersonalizeFragment iIV;
    private HotTopicTabFragment iIW;
    private BaseFragment iIX;
    private GameVideoFragment iIY;
    private VideoTabFragment iIZ;
    private aq iJa;
    private String iJb;
    private String iJc;
    private boolean iJd;
    private int iJe;
    private aa iJf;
    private com.baidu.tieba.homepage.framework.indicator.a iJg;
    private List<a> iJh;
    private Context mContext;

    /* loaded from: classes16.dex */
    public static class a {
        public Fragment fragment;
        public boolean hvP;
        public String tabName;
        public String title;
        public int type;

        public a(Fragment fragment, int i, String str) {
            this.fragment = fragment;
            this.type = i;
            this.title = str;
            this.tabName = str;
        }

        public a(Fragment fragment, int i, String str, boolean z) {
            this.fragment = fragment;
            this.type = i;
            this.title = str;
            this.tabName = str;
            this.hvP = z;
        }
    }

    public a a(Fragment fragment, w wVar) {
        return new a(fragment, wVar.tabType, wVar.tabName);
    }

    public a b(Fragment fragment, int i, String str) {
        return new a(fragment, i, str);
    }

    public a a(Fragment fragment, int i, String str, boolean z) {
        return new a(fragment, i, str, z);
    }

    public void db(List<a> list) {
        if (this.iJh != null && list != null && list.size() > 0) {
            this.iJh.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iJb = "recommendFrsLastReadTabPositionNamespace";
        this.iJc = "recommendFrsLastReadTabPositionKey";
        this.iJd = false;
        this.iJe = -1;
        this.currentIndex = -1;
        this.iJh = new ArrayList();
        this.mContext = context;
        if (this.iJg == null) {
            this.iJg = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<w> cwG = this.iJg.cwG();
        ArrayList arrayList = new ArrayList();
        if (this.iIU == null) {
            this.iIU = new ConcernFragment(context);
        }
        this.iIU.setCallback(aVar);
        arrayList.add(b(this.iIU, 0, getString(R.string.tab_name_concern)));
        if (this.iIV == null) {
            this.iIV = new PersonalizeFragment(context);
        }
        this.iIV.setCallback(bVar);
        arrayList.add(b(this.iIV, 1, getString(R.string.tab_name_recommend)));
        for (w wVar : cwG) {
            int i = wVar.tabType;
            String str = wVar.tabName;
            String str2 = wVar.tabCode;
            boolean z = wVar.isShowRedDot;
            if (!wVar.isDirtyData()) {
                if (i == 101) {
                    HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(a(homePageTabFeedFragment, wVar));
                } else if (i == 5) {
                    if (this.iIW == null) {
                        this.iIW = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iIW, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.iIZ == null) {
                        this.iIZ = new VideoTabFragment();
                        arrayList.add(a(this.iIZ, wVar));
                    }
                } else if (i == 6) {
                    if (this.iIX == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.iIX = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.iIX, wVar));
                    }
                } else if (i == 7 && this.iIY == null) {
                    this.iIY = new GameVideoFragment();
                    arrayList.add(a(this.iIY, wVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dD("obj_type", "2"));
                }
            }
        }
        this.iJh.clear();
        db(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.iJh == null || i < 0 || i >= this.iJh.size() || this.iJh.get(i) == null) {
            return null;
        }
        return this.iJh.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.iJh != null) {
            return this.iJh.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (blM() == null || !blM().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.iJh == null || i < 0 || i >= this.iJh.size() || this.iJh.get(i) == null) {
            return null;
        }
        return this.iJh.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int zH(int i) {
        a aVar = (a) y.getItem(this.iJh, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int JE(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iJh.size()) {
                a aVar = this.iJh.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cwx();
            }
        }
    }

    public int cwx() {
        for (int i = 0; i < this.iJh.size(); i++) {
            if (this.iJh.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cwy() {
        return this.iJg.cwH();
    }

    @Deprecated
    public int zI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iJh.size()) {
                if (this.iJh.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cwx();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.iJa instanceof BaseFragment) {
                ((BaseFragment) this.iJa).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fH = com.baidu.tieba.tbadkCore.voice.b.fH(this.mContext);
            if (fH != null) {
                fH.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bGR();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.iJa = (aq) obj;
            this.iJa.setRecommendFrsNavigationAnimDispatcher(this.iJf);
        }
    }

    public void setPrimary(boolean z) {
        if (this.iJa instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(blM(), (BaseFragment) this.iJa);
                if (position < 0) {
                    position = zI(1);
                }
                zJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iJa).setPrimary(z);
        }
    }

    public void zJ(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(NewScrollFragmentAdapter.this.iJb, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(NewScrollFragmentAdapter.this.iJc, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.iJd) {
            this.iJd = true;
            dVar.zF(1);
        }
    }

    private void completePullRefresh() {
        if (this.iIV != null && this.iJa == this.iIV) {
            this.iIV.completePullRefresh();
        }
        if (this.iIU != null && this.iJa == this.iIU) {
            this.iIU.completePullRefresh();
        }
    }

    public boolean cwz() {
        return this.iIU != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iIV != null) {
            this.iIV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iIW != null) {
            this.iIW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iIU != null) {
            this.iIU.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.iIV != null && this.iJa == this.iIV) {
            this.iIV.aQ(str, i);
        }
        if (i2 == 0 && this.iIU != null) {
            this.iIU.aQ(str, i);
        }
    }

    public void cwA() {
        if (this.iIV != null) {
            this.iIV.cwA();
        }
    }

    public void cwB() {
        if (this.iIU != null) {
            this.iIU.cwa();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iIV != null) {
            this.iIV.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iIU != null) {
            this.iIU.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iJa != null) {
            this.iJa.bkF();
        }
    }

    public void cwC() {
        if (this.iJa != null) {
            this.iJa.OA();
        }
    }

    public void bGR() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).OA();
        }
    }

    public void zK(int i) {
        if (i == 1 && this.iIV != null) {
            this.iIV.cxK();
        }
    }

    public void zL(int i) {
        if (this.currentIndex == i) {
            this.iJe = -1;
        } else {
            this.iJe = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iJe == -1 || (i == this.iJe && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(blM(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(blM(), i);
            Fragment fragment3 = (Fragment) y.getItem(blM(), i + 1);
            this.iJe = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bGa();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bGa();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bFZ();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bFZ();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bFZ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.iJa instanceof BaseFragment) {
            return ((BaseFragment) this.iJa).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
