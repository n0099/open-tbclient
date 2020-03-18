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
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment haM;
    private PersonalizeFragment haN;
    private TopicFragment haO;
    private BaseFragment haP;
    private GameVideoFragment haQ;
    private VideoTabFragment haR;
    private ag haS;
    private String haT;
    private String haU;
    private boolean haV;
    private int haW;
    private z haX;
    private a haY;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.haT = "recommendFrsLastReadTabPositionNamespace";
        this.haU = "recommendFrsLastReadTabPositionKey";
        this.haV = false;
        this.haW = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.haY = new a();
        if (this.haY.getPosition(0) != -1) {
            this.haM = new ConcernFragment(context);
            this.haM.setCallback(aVar);
        }
        if (this.haY.getPosition(1) != -1) {
            this.haN = new PersonalizeFragment(context);
            this.haN.setCallback(bVar);
        }
        if (this.haY.getPosition(5) != -1) {
            this.haO = new TopicFragment(context);
        }
        if (this.haY.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.haP = (BaseFragment) runTask.getData();
        }
        if (this.haY.getPosition(7) != -1) {
            this.haQ = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cx("obj_type", "2"));
        }
        if (this.haY.getPosition(8) != -1) {
            this.haR = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.haY.getType(i)) {
            case 0:
                return this.haM;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.haN;
            case 5:
                return this.haO;
            case 6:
                return this.haP;
            case 7:
                return this.haQ;
            case 8:
                return this.haR;
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

    public int vj(int i) {
        return this.haY.getType(i);
    }

    public int bNP() {
        return this.haY.bNV();
    }

    public int vk(int i) {
        return this.haY.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bnm();
    }

    private int bnm() {
        int i = 0;
        if (this.haY.getPosition(0) != -1 && this.haM != null) {
            i = 1;
        }
        if (this.haY.getPosition(1) != -1 && this.haN != null) {
            i++;
        }
        if (this.haY.getPosition(8) != -1 && this.haR != null) {
            i++;
        }
        if (this.haY.getPosition(5) != -1 && this.haO != null) {
            i++;
        }
        if (this.haY.getPosition(6) != -1 && this.haP != null) {
            i++;
        }
        if (this.haY.getPosition(7) != -1 && this.haQ != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.haS instanceof BaseFragment) {
                ((BaseFragment) this.haS).setPrimary(false);
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
                ((PersonalizeFragment) obj).bdw();
            }
            if (obj instanceof ag) {
                ((ag) obj).showFloatingView();
            }
        }
        if (obj instanceof ag) {
            this.haS = (ag) obj;
            this.haS.setRecommendFrsNavigationAnimDispatcher(this.haX);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.haY.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.haS instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aIB(), (BaseFragment) this.haS);
                if (position < 0) {
                    position = vk(1);
                }
                vl(position);
                completePullRefresh();
            }
            ((BaseFragment) this.haS).setPrimary(z);
        }
    }

    public void vl(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cq = com.baidu.tbadk.core.c.a.aEF().cq(NewScrollFragmentAdapter.this.haT, TbadkCoreApplication.getCurrentAccount());
                if (cq != null) {
                    cq.set(NewScrollFragmentAdapter.this.haU, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.haV) {
            this.haV = true;
            dVar.vh(1);
        }
    }

    private void completePullRefresh() {
        if (this.haN != null && this.haS == this.haN) {
            this.haN.completePullRefresh();
        }
        if (this.haM != null && this.haS == this.haM) {
            this.haM.completePullRefresh();
        }
    }

    public boolean bNQ() {
        return this.haM != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.haN != null) {
            this.haN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.haO != null) {
            this.haO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.haM != null) {
            this.haM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.haN != null && this.haS == this.haN) {
            this.haN.aE(str, i);
        }
        if (i2 == 0 && this.haM != null) {
            this.haM.aE(str, i);
        }
    }

    public void bNR() {
        if (this.haN != null) {
            this.haN.bNR();
        }
    }

    public void bNS() {
        if (this.haM != null) {
            this.haM.bNn();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.haN != null) {
            this.haN.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.haM != null) {
            this.haM.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.haS != null) {
            this.haS.aHS();
        }
    }

    public void bNT() {
        if (this.haS != null) {
            this.haS.AJ();
        }
    }

    public void bdw() {
        switch (vj(this.currentIndex)) {
            case 0:
                if (this.haM != null) {
                    this.haM.bdw();
                    return;
                }
                return;
            case 1:
                if (this.haN != null) {
                    this.haN.bdw();
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
                if (this.haO != null) {
                    this.haO.bdw();
                    return;
                }
                return;
            case 6:
                if (this.haP != null) {
                    ((ag) this.haP).AJ();
                    return;
                }
                return;
            case 8:
                if (this.haR != null) {
                    this.haR.AJ();
                    return;
                }
                return;
        }
    }

    public void vm(int i) {
        if (i == 1 && this.haN != null) {
            this.haN.bOO();
        }
    }

    public void vn(int i) {
        if (this.currentIndex == i) {
            this.haW = -1;
        } else {
            this.haW = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.haW == -1 || (i == this.haW && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aIB(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aIB(), i);
            Fragment fragment3 = (Fragment) v.getItem(aIB(), i + 1);
            this.haW = -1;
            if (f == 0.0f) {
                if (fragment instanceof ag) {
                    ((ag) fragment).bcF();
                }
                if (fragment3 instanceof ag) {
                    ((ag) fragment3).bcF();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ag) {
                ((ag) fragment).bcE();
            }
            if (fragment2 instanceof ag) {
                ((ag) fragment2).bcE();
            }
            if (fragment3 instanceof ag) {
                ((ag) fragment3).bcE();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.haS instanceof BaseFragment) {
            return ((BaseFragment) this.haS).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
