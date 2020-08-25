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
    private ConcernFragment iIO;
    private PersonalizeFragment iIP;
    private HotTopicTabFragment iIQ;
    private BaseFragment iIR;
    private GameVideoFragment iIS;
    private VideoTabFragment iIT;
    private aq iIU;
    private String iIV;
    private String iIW;
    private boolean iIX;
    private int iIY;
    private aa iIZ;
    private com.baidu.tieba.homepage.framework.indicator.a iJa;
    private List<a> iJb;
    private Context mContext;

    /* loaded from: classes16.dex */
    public static class a {
        public Fragment fragment;
        public boolean hvJ;
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
            this.hvJ = z;
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
        if (this.iJb != null && list != null && list.size() > 0) {
            this.iJb.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iIV = "recommendFrsLastReadTabPositionNamespace";
        this.iIW = "recommendFrsLastReadTabPositionKey";
        this.iIX = false;
        this.iIY = -1;
        this.currentIndex = -1;
        this.iJb = new ArrayList();
        this.mContext = context;
        if (this.iJa == null) {
            this.iJa = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<w> cwF = this.iJa.cwF();
        ArrayList arrayList = new ArrayList();
        if (this.iIO == null) {
            this.iIO = new ConcernFragment(context);
        }
        this.iIO.setCallback(aVar);
        arrayList.add(b(this.iIO, 0, getString(R.string.tab_name_concern)));
        if (this.iIP == null) {
            this.iIP = new PersonalizeFragment(context);
        }
        this.iIP.setCallback(bVar);
        arrayList.add(b(this.iIP, 1, getString(R.string.tab_name_recommend)));
        for (w wVar : cwF) {
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
                    if (this.iIQ == null) {
                        this.iIQ = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iIQ, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.iIT == null) {
                        this.iIT = new VideoTabFragment();
                        arrayList.add(a(this.iIT, wVar));
                    }
                } else if (i == 6) {
                    if (this.iIR == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.iIR = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.iIR, wVar));
                    }
                } else if (i == 7 && this.iIS == null) {
                    this.iIS = new GameVideoFragment();
                    arrayList.add(a(this.iIS, wVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dD("obj_type", "2"));
                }
            }
        }
        this.iJb.clear();
        db(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.iJb == null || i < 0 || i >= this.iJb.size() || this.iJb.get(i) == null) {
            return null;
        }
        return this.iJb.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.iJb != null) {
            return this.iJb.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (blM() == null || !blM().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.iJb == null || i < 0 || i >= this.iJb.size() || this.iJb.get(i) == null) {
            return null;
        }
        return this.iJb.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int zH(int i) {
        a aVar = (a) y.getItem(this.iJb, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int JD(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iJb.size()) {
                a aVar = this.iJb.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cww();
            }
        }
    }

    public int cww() {
        for (int i = 0; i < this.iJb.size(); i++) {
            if (this.iJb.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cwx() {
        return this.iJa.cwG();
    }

    @Deprecated
    public int zI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iJb.size()) {
                if (this.iJb.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cww();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.iIU instanceof BaseFragment) {
                ((BaseFragment) this.iIU).setPrimary(false);
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
                ((PersonalizeFragment) obj).bGQ();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.iIU = (aq) obj;
            this.iIU.setRecommendFrsNavigationAnimDispatcher(this.iIZ);
        }
    }

    public void setPrimary(boolean z) {
        if (this.iIU instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(blM(), (BaseFragment) this.iIU);
                if (position < 0) {
                    position = zI(1);
                }
                zJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iIU).setPrimary(z);
        }
    }

    public void zJ(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(NewScrollFragmentAdapter.this.iIV, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(NewScrollFragmentAdapter.this.iIW, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.iIX) {
            this.iIX = true;
            dVar.zF(1);
        }
    }

    private void completePullRefresh() {
        if (this.iIP != null && this.iIU == this.iIP) {
            this.iIP.completePullRefresh();
        }
        if (this.iIO != null && this.iIU == this.iIO) {
            this.iIO.completePullRefresh();
        }
    }

    public boolean cwy() {
        return this.iIO != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iIP != null) {
            this.iIP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iIQ != null) {
            this.iIQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iIO != null) {
            this.iIO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.iIP != null && this.iIU == this.iIP) {
            this.iIP.aQ(str, i);
        }
        if (i2 == 0 && this.iIO != null) {
            this.iIO.aQ(str, i);
        }
    }

    public void cwz() {
        if (this.iIP != null) {
            this.iIP.cwz();
        }
    }

    public void cwA() {
        if (this.iIO != null) {
            this.iIO.cvZ();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iIP != null) {
            this.iIP.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iIO != null) {
            this.iIO.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iIU != null) {
            this.iIU.bkF();
        }
    }

    public void cwB() {
        if (this.iIU != null) {
            this.iIU.OA();
        }
    }

    public void bGQ() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).OA();
        }
    }

    public void zK(int i) {
        if (i == 1 && this.iIP != null) {
            this.iIP.cxJ();
        }
    }

    public void zL(int i) {
        if (this.currentIndex == i) {
            this.iIY = -1;
        } else {
            this.iIY = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iIY == -1 || (i == this.iIY && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(blM(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(blM(), i);
            Fragment fragment3 = (Fragment) y.getItem(blM(), i + 1);
            this.iIY = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bFZ();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bFZ();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bFY();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bFY();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bFY();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.iIU instanceof BaseFragment) {
            return ((BaseFragment) this.iIU).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
