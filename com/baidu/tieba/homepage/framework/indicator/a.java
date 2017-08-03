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
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private com.baidu.tieba.homepage.concern.b cQn;
    private com.baidu.tieba.homepage.personalize.a cQo;
    private BaseFragment cQp;
    private ah cQq;
    private String cQr;
    private String cQs;
    private List<com.baidu.tieba.homepage.b.a.a> cQt;
    private boolean cQu;
    private int cQv;
    private r cQw;
    private String[] cQx;
    private int ciu;
    private int mChildCount;
    private Context mContext;
    public static int cQy = 0;
    public static int cQz = 1;
    public static int cQA = 2;
    public static int cQB = cQz;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        this.cQr = "recommendFrsLastReadTabPositionNamespace";
        this.cQs = "recommendFrsLastReadTabPositionKey";
        this.cQu = false;
        this.cQv = -1;
        this.mChildCount = 0;
        this.cQx = new String[]{"关注", "推荐", "发现"};
        this.mContext = context;
        this.cQn = new com.baidu.tieba.homepage.concern.b(context);
        this.cQn.setCallback(aVar);
        this.cQo = new com.baidu.tieba.homepage.personalize.a(context);
        this.cQo.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.cQp = (BaseFragment) runTask.getData();
        }
    }

    public void bq(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!u.v(list)) {
            this.cQt = new ArrayList(list);
        }
    }

    private Fragment anX() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent ky(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cQt, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cTS;
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
        if (i == cQy) {
            return this.cQn;
        }
        if (i == cQz) {
            return this.cQo;
        }
        if (i == cQA) {
            return this.cQp;
        }
        Fragment anX = anX();
        if (anX instanceof ah) {
            ((ah) anX).L(ky(i));
            return anX;
        }
        return anX;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cQx.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aoe().cQY != i) {
            if (this.cQq instanceof BaseFragment) {
                ((BaseFragment) this.cQq).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aoe().cQY = i;
            VoiceManager bQ = com.baidu.tieba.tbadkCore.voice.b.bQ(this.mContext);
            if (bQ != null) {
                bQ.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).anA();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.cQq = (ah) obj;
            this.cQq.setHeaderViewHeight(this.ciu);
            this.cQq.setRecommendFrsNavigationAnimDispatcher(this.cQw);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cQx[i];
    }

    public void setPrimary(boolean z) {
        if (this.cQq instanceof BaseFragment) {
            if (!z) {
                int a = u.a(xj(), (BaseFragment) this.cQq);
                if (a < 0) {
                    a = cQB;
                }
                kz(a);
                completePullRefresh();
            }
            ((BaseFragment) this.cQq).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        this.cQw = rVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.ciu != i2) {
            this.ciu = i2;
            Iterator<Fragment> it = xj().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.ciu);
                }
            }
        }
    }

    public void kz(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.td().M(a.this.cQr, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.cQs, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.cQu) {
            this.cQu = true;
            dVar.kw(cQB);
        }
    }

    private void completePullRefresh() {
        if (this.cQo != null && this.cQq == this.cQo) {
            this.cQo.completePullRefresh();
        }
        if (this.cQn != null && this.cQq == this.cQn) {
            this.cQn.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cQo != null) {
            this.cQo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == cQz && this.cQo != null && this.cQq == this.cQo) {
            this.cQo.N(str, i);
        }
        if (i2 == cQy && this.cQn != null) {
            this.cQn.N(str, i);
        }
    }

    public void anB() {
        if (this.cQo != null) {
            this.cQo.anB();
        }
        if (this.cQn != null) {
            this.cQn.anB();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cQo != null) {
            this.cQo.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cQn != null) {
            this.cQn.a(dataRes, z);
        }
    }

    public void dr(int i) {
        if (this.cQq != null) {
            this.cQq.wV();
        }
    }

    public void anY() {
        if (this.cQq != null) {
            this.cQq.afp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kA(int i) {
        Fragment fragment = (Fragment) u.c(xj(), i);
        if (fragment != null && (fragment instanceof ah)) {
            ((ah) fragment).afp();
        }
    }

    public ah getCurrentFragment() {
        return this.cQq;
    }

    public void anA() {
        int i = com.baidu.tieba.homepage.framework.a.a.aoe().cQY;
        if (i == cQz) {
            if (this.cQo != null) {
                this.cQo.anA();
            }
        } else if (i == cQy && this.cQn != null) {
            this.cQn.anA();
        }
    }

    public void kB(int i) {
        if (i == cQz && this.cQo != null) {
            this.cQo.aof();
        }
    }

    public void kC(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aoe().cQY == i) {
            this.cQv = -1;
        } else {
            this.cQv = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cQv == -1 || (i == this.cQv && f == 0.0f)) {
            Fragment fragment = (Fragment) u.c(xj(), i - 1);
            Fragment fragment2 = (Fragment) u.c(xj(), i);
            Fragment fragment3 = (Fragment) u.c(xj(), i + 1);
            this.cQv = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).afc();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).afc();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).afb();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).afb();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).afb();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cQq instanceof BaseFragment) {
            return ((BaseFragment) this.cQq).getCurrentPageKey();
        }
        return null;
    }
}
