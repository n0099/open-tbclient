package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment gTV;
    private PersonalizeFragment gTW;
    private TopicFragment gTX;
    private BaseFragment gTY;
    private GameVideoFragment gTZ;
    private VideoTabFragment gUa;
    private af gUb;
    private String gUc;
    private String gUd;
    private boolean gUe;
    private int gUf;
    private z gUg;
    private a gUh;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.gUc = "recommendFrsLastReadTabPositionNamespace";
        this.gUd = "recommendFrsLastReadTabPositionKey";
        this.gUe = false;
        this.gUf = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gUh = new a();
        if (this.gUh.getPosition(0) != -1) {
            this.gTV = new ConcernFragment(context);
            this.gTV.setCallback(aVar);
        }
        if (this.gUh.getPosition(1) != -1) {
            this.gTW = new PersonalizeFragment(context);
            this.gTW.setCallback(bVar);
        }
        if (this.gUh.getPosition(5) != -1) {
            this.gTX = new TopicFragment(context);
        }
        if (this.gUh.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gTY = (BaseFragment) runTask.getData();
        }
        if (this.gUh.getPosition(7) != -1) {
            this.gTZ = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cp("obj_type", "2"));
        }
        if (this.gUh.getPosition(8) != -1) {
            this.gUa = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gUh.getType(i)) {
            case 0:
                return this.gTV;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.gTW;
            case 5:
                return this.gTX;
            case 6:
                return this.gTY;
            case 7:
                return this.gTZ;
            case 8:
                return this.gUa;
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

    public int uR(int i) {
        return this.gUh.getType(i);
    }

    public int bKQ() {
        return this.gUh.bKW();
    }

    public int uS(int i) {
        return this.gUh.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bkA();
    }

    private int bkA() {
        int i = 0;
        if (this.gUh.getPosition(0) != -1 && this.gTV != null) {
            i = 1;
        }
        if (this.gUh.getPosition(1) != -1 && this.gTW != null) {
            i++;
        }
        if (this.gUh.getPosition(8) != -1 && this.gUa != null) {
            i++;
        }
        if (this.gUh.getPosition(5) != -1 && this.gTX != null) {
            i++;
        }
        if (this.gUh.getPosition(6) != -1 && this.gTY != null) {
            i++;
        }
        if (this.gUh.getPosition(7) != -1 && this.gTZ != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gUb instanceof BaseFragment) {
                ((BaseFragment) this.gUb).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fw = com.baidu.tieba.tbadkCore.voice.b.fw(this.mContext);
            if (fw != null) {
                fw.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).baE();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.gUb = (af) obj;
            this.gUb.setRecommendFrsNavigationAnimDispatcher(this.gUg);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gUh.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gUb instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aFM(), (BaseFragment) this.gUb);
                if (position < 0) {
                    position = uS(1);
                }
                uT(position);
                completePullRefresh();
            }
            ((BaseFragment) this.gUb).setPrimary(z);
        }
    }

    public void uT(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> ci = com.baidu.tbadk.core.c.a.aBV().ci(NewScrollFragmentAdapter.this.gUc, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    ci.set(NewScrollFragmentAdapter.this.gUd, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gUe) {
            this.gUe = true;
            dVar.uP(1);
        }
    }

    private void completePullRefresh() {
        if (this.gTW != null && this.gUb == this.gTW) {
            this.gTW.completePullRefresh();
        }
        if (this.gTV != null && this.gUb == this.gTV) {
            this.gTV.completePullRefresh();
        }
    }

    public boolean bKR() {
        return this.gTV != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gTW != null) {
            this.gTW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gTX != null) {
            this.gTX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gTV != null) {
            this.gTV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.gTW != null && this.gUb == this.gTW) {
            this.gTW.aF(str, i);
        }
        if (i2 == 0 && this.gTV != null) {
            this.gTV.aF(str, i);
        }
    }

    public void bKS() {
        if (this.gTW != null) {
            this.gTW.bKS();
        }
    }

    public void bKT() {
        if (this.gTV != null) {
            this.gTV.bKo();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gTW != null) {
            this.gTW.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gTV != null) {
            this.gTV.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.gUb != null) {
            this.gUb.aFd();
        }
    }

    public void bKU() {
        if (this.gUb != null) {
            this.gUb.xT();
        }
    }

    public void baE() {
        switch (uR(this.currentIndex)) {
            case 0:
                if (this.gTV != null) {
                    this.gTV.baE();
                    return;
                }
                return;
            case 1:
                if (this.gTW != null) {
                    this.gTW.baE();
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 5:
                if (this.gTX != null) {
                    this.gTX.baE();
                    return;
                }
                return;
            case 6:
                if (this.gTY != null) {
                    ((af) this.gTY).xT();
                    return;
                }
                return;
            case 8:
                if (this.gUa != null) {
                    this.gUa.xT();
                    return;
                }
                return;
        }
    }

    public void uU(int i) {
        if (i == 1 && this.gTW != null) {
            this.gTW.bLN();
        }
    }

    public void uV(int i) {
        if (this.currentIndex == i) {
            this.gUf = -1;
        } else {
            this.gUf = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gUf == -1 || (i == this.gUf && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aFM(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aFM(), i);
            Fragment fragment3 = (Fragment) v.getItem(aFM(), i + 1);
            this.gUf = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).aZM();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).aZM();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).aZL();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).aZL();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).aZL();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gUb instanceof BaseFragment) {
            return ((BaseFragment) this.gUb).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
