package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int cpH;
    private com.baidu.tieba.homepage.concern.b dai;
    private com.baidu.tieba.homepage.personalize.a daj;
    private BaseFragment dak;
    private ah dal;
    private String dam;
    private String dan;
    private List<com.baidu.tieba.homepage.b.a.a> dao;
    private boolean dap;
    private int daq;
    private r dar;
    private b das;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.dam = "recommendFrsLastReadTabPositionNamespace";
        this.dan = "recommendFrsLastReadTabPositionKey";
        this.dap = false;
        this.daq = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.das = new b();
        if (this.das.le(0) != -1) {
            this.dai = new com.baidu.tieba.homepage.concern.b(context);
            this.dai.setCallback(aVar);
        }
        if (this.das.le(1) != -1) {
            this.daj = new com.baidu.tieba.homepage.personalize.a(context);
            this.daj.setCallback(bVar);
        }
        if (this.das.le(2) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dak = (BaseFragment) runTask.getData();
        }
    }

    public void bx(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!v.v(list)) {
            this.dao = new ArrayList(list);
        }
    }

    private Fragment aqs() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent kW(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) v.c(this.dao, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.ddR;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("name", str);
        intent.putExtra("from", "main_tab");
        return intent;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.das.getType(i)) {
            case 0:
                return this.dai;
            case 1:
                return this.daj;
            case 2:
                return this.dak;
            default:
                Fragment aqs = aqs();
                if (aqs instanceof ah) {
                    ((ah) aqs).N(kW(i));
                    return aqs;
                }
                return aqs;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public int kX(int i) {
        return this.das.getType(i);
    }

    public int kY(int i) {
        return this.das.le(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.das.getTabCount();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aqB().daT != i) {
            if (this.dal instanceof BaseFragment) {
                ((BaseFragment) this.dal).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aqB().daT = i;
            VoiceManager ca = com.baidu.tieba.tbadkCore.voice.b.ca(this.mContext);
            if (ca != null) {
                ca.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).apW();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.dal = (ah) obj;
            this.dal.setHeaderViewHeight(this.cpH);
            this.dal.setRecommendFrsNavigationAnimDispatcher(this.dar);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.das.r(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dal instanceof BaseFragment) {
            if (!z) {
                int a = v.a(xt(), (BaseFragment) this.dal);
                if (a < 0) {
                    a = kY(1);
                }
                kZ(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dal).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        this.dar = rVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cpH != i2) {
            this.cpH = i2;
            Iterator<Fragment> it = xt().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.cpH);
                }
            }
        }
    }

    public void kZ(final int i) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.tk().O(a.this.dam, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(a.this.dan, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dap) {
            this.dap = true;
            dVar.kU(1);
        }
    }

    private void completePullRefresh() {
        if (this.daj != null && this.dal == this.daj) {
            this.daj.completePullRefresh();
        }
        if (this.dai != null && this.dal == this.dai) {
            this.dai.completePullRefresh();
        }
    }

    public boolean aqt() {
        return this.dai != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.daj != null) {
            this.daj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void h(String str, int i, int i2) {
        if (i2 == 1 && this.daj != null && this.dal == this.daj) {
            this.daj.N(str, i);
        }
        if (i2 == 0 && this.dai != null) {
            this.dai.N(str, i);
        }
    }

    public void apX() {
        if (this.daj != null) {
            this.daj.apX();
        }
        if (this.dai != null) {
            this.dai.apX();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.daj != null) {
            this.daj.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dai != null) {
            this.dai.a(dataRes, z);
        }
    }

    public void du(int i) {
        if (this.dal != null) {
            this.dal.xc();
        }
    }

    public void aqu() {
        if (this.dal != null) {
            this.dal.ahj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void la(int i) {
        Fragment fragment = (Fragment) v.c(xt(), kY(i));
        if (fragment != null && (fragment instanceof ah)) {
            ((ah) fragment).ahj();
        }
    }

    public ah getCurrentFragment() {
        return this.dal;
    }

    public void apW() {
        switch (kX(com.baidu.tieba.homepage.framework.a.a.aqB().daT)) {
            case 0:
                if (this.dai != null) {
                    this.dai.apW();
                    return;
                }
                return;
            case 1:
                if (this.daj != null) {
                    this.daj.apW();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lb(int i) {
        if (i == 1 && this.daj != null) {
            this.daj.aqC();
        }
    }

    public void lc(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aqB().daT == i) {
            this.daq = -1;
        } else {
            this.daq = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.daq == -1 || (i == this.daq && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(xt(), i - 1);
            Fragment fragment2 = (Fragment) v.c(xt(), i);
            Fragment fragment3 = (Fragment) v.c(xt(), i + 1);
            this.daq = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).agV();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).agV();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).agU();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).agU();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).agU();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dal instanceof BaseFragment) {
            return ((BaseFragment) this.dal).getCurrentPageKey();
        }
        return null;
    }
}
