package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import com.baidu.tieba.hottopic.view.HotRankView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int abv = -1;
    private List<j> ktA;
    private List<p> ktB;
    private List<HotRankView> kyH;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.ktA = new ArrayList();
        this.kyH = new ArrayList();
        this.kyH.add(cTV());
        this.kyH.add(cTV());
        this.kyH.add(cTV());
    }

    private HotRankView cTV() {
        return new HotRankView(this.mContext);
    }

    public void ei(List<j> list) {
        if (this.ktA == null) {
            this.ktA = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.ktA.clear();
            this.ktA.addAll(list);
        }
        if (this.ktB == null && !y.isEmpty(this.ktA)) {
            this.ktB = new ArrayList();
            this.ktB.clear();
            this.ktB.addAll(this.ktA.get(0).kvi);
        }
        notifyDataSetChanged();
        cSI();
    }

    private void cSI() {
        String str;
        if (this.abv >= 0) {
            HotRankView hotRankView = this.kyH.get(this.abv % 3);
            j jVar = (j) y.getItem(this.ktA, this.abv);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.WZ();
                p pVar = (p) y.getItem(this.ktB, this.abv);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.hde;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cTv())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void WZ() {
        if (cTW() != null) {
            cTW().WZ();
        }
    }

    public void showLoadingView() {
        if (cTW() != null) {
            cTW().C(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void sx(boolean z) {
        if (this.kyH != null) {
            for (HotRankView hotRankView : this.kyH) {
                if (hotRankView != null) {
                    hotRankView.sx(z);
                }
            }
        }
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        if (this.kyH != null) {
            for (HotRankView hotRankView : this.kyH) {
                if (hotRankView != null) {
                    hotRankView.h(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.ktA == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.ktA.get(0).kvi.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cTW() {
        if (this.abv == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.kyH, this.abv % 3);
    }

    public List<j> cTX() {
        return this.ktA;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.ktA);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.kyH) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.abv != i) {
            this.abv = i;
            if (!y.isEmpty(this.ktA)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.ktA.get(this.abv);
                HotRankView hotRankView2 = this.kyH.get(i % this.kyH.size());
                if (jVar == null || y.isEmpty(jVar.cTv())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.C(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cSO();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.kyH.get(i % this.kyH.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.ktA.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.WZ();
        if (this.abv == -1) {
            str = this.ktB.get(0).hde;
        } else {
            str = this.ktB.get(this.abv).hde;
        }
        hotRankView.b(jVar, str);
        return hotRankView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (y.isEmpty(this.ktA) || this.ktA.get(0) == null || y.isEmpty(this.ktA.get(0).kvi)) {
            return null;
        }
        return this.ktA.get(0).kvi.get(i).tabName;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
