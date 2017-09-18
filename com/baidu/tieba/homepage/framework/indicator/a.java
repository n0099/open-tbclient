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
    private int cqz;
    private com.baidu.tieba.homepage.concern.b dbe;
    private com.baidu.tieba.homepage.personalize.a dbf;
    private BaseFragment dbg;
    private ah dbh;
    private String dbi;
    private String dbj;
    private List<com.baidu.tieba.homepage.b.a.a> dbk;
    private boolean dbl;
    private int dbm;
    private r dbn;
    private b dbo;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.dbi = "recommendFrsLastReadTabPositionNamespace";
        this.dbj = "recommendFrsLastReadTabPositionKey";
        this.dbl = false;
        this.dbm = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.dbo = new b();
        if (this.dbo.lg(0) != -1) {
            this.dbe = new com.baidu.tieba.homepage.concern.b(context);
            this.dbe.setCallback(aVar);
        }
        if (this.dbo.lg(1) != -1) {
            this.dbf = new com.baidu.tieba.homepage.personalize.a(context);
            this.dbf.setCallback(bVar);
        }
        if (this.dbo.lg(2) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dbg = (BaseFragment) runTask.getData();
        }
    }

    public void by(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!v.v(list)) {
            this.dbk = new ArrayList(list);
        }
    }

    private Fragment aqD() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent kY(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) v.c(this.dbk, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.deN;
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
        switch (this.dbo.getType(i)) {
            case 0:
                return this.dbe;
            case 1:
                return this.dbf;
            case 2:
                return this.dbg;
            default:
                Fragment aqD = aqD();
                if (aqD instanceof ah) {
                    ((ah) aqD).M(kY(i));
                    return aqD;
                }
                return aqD;
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

    public int kZ(int i) {
        return this.dbo.getType(i);
    }

    public int la(int i) {
        return this.dbo.lg(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dbo.getTabCount();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aqM().dbN != i) {
            if (this.dbh instanceof BaseFragment) {
                ((BaseFragment) this.dbh).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aqM().dbN = i;
            VoiceManager cb = com.baidu.tieba.tbadkCore.voice.b.cb(this.mContext);
            if (cb != null) {
                cb.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aqh();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.dbh = (ah) obj;
            this.dbh.setHeaderViewHeight(this.cqz);
            this.dbh.setRecommendFrsNavigationAnimDispatcher(this.dbn);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dbo.q(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dbh instanceof BaseFragment) {
            if (!z) {
                int a = v.a(xt(), (BaseFragment) this.dbh);
                if (a < 0) {
                    a = la(1);
                }
                lb(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dbh).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        this.dbn = rVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cqz != i2) {
            this.cqz = i2;
            Iterator<Fragment> it = xt().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.cqz);
                }
            }
        }
    }

    public void lb(final int i) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.tk().O(a.this.dbi, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(a.this.dbj, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dbl) {
            this.dbl = true;
            dVar.kW(1);
        }
    }

    private void completePullRefresh() {
        if (this.dbf != null && this.dbh == this.dbf) {
            this.dbf.completePullRefresh();
        }
        if (this.dbe != null && this.dbh == this.dbe) {
            this.dbe.completePullRefresh();
        }
    }

    public boolean aqE() {
        return this.dbe != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dbf != null) {
            this.dbf.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void h(String str, int i, int i2) {
        if (i2 == 1 && this.dbf != null && this.dbh == this.dbf) {
            this.dbf.N(str, i);
        }
        if (i2 == 0 && this.dbe != null) {
            this.dbe.N(str, i);
        }
    }

    public void aqi() {
        if (this.dbf != null) {
            this.dbf.aqi();
        }
        if (this.dbe != null) {
            this.dbe.aqi();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dbf != null) {
            this.dbf.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dbe != null) {
            this.dbe.a(dataRes, z);
        }
    }

    public void du(int i) {
        if (this.dbh != null) {
            this.dbh.xc();
        }
    }

    public void aqF() {
        if (this.dbh != null) {
            this.dbh.ahu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lc(int i) {
        Fragment fragment = (Fragment) v.c(xt(), la(i));
        if (fragment != null && (fragment instanceof ah)) {
            ((ah) fragment).ahu();
        }
    }

    public ah getCurrentFragment() {
        return this.dbh;
    }

    public void aqh() {
        switch (kZ(com.baidu.tieba.homepage.framework.a.a.aqM().dbN)) {
            case 0:
                if (this.dbe != null) {
                    this.dbe.aqh();
                    return;
                }
                return;
            case 1:
                if (this.dbf != null) {
                    this.dbf.aqh();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void ld(int i) {
        if (i == 1 && this.dbf != null) {
            this.dbf.aqN();
        }
    }

    public void le(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aqM().dbN == i) {
            this.dbm = -1;
        } else {
            this.dbm = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dbm == -1 || (i == this.dbm && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(xt(), i - 1);
            Fragment fragment2 = (Fragment) v.c(xt(), i);
            Fragment fragment3 = (Fragment) v.c(xt(), i + 1);
            this.dbm = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).ahg();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).ahg();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).ahf();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).ahf();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).ahf();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dbh instanceof BaseFragment) {
            return ((BaseFragment) this.dbh).getCurrentPageKey();
        }
        return null;
    }
}
