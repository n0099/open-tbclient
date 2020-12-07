package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
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
/* loaded from: classes21.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int aaR = -1;
    private List<j> kcw;
    private List<p> kcx;
    private List<HotRankView> khD;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.kcw = new ArrayList();
        this.khD = new ArrayList();
        this.khD.add(cSz());
        this.khD.add(cSz());
        this.khD.add(cSz());
    }

    private HotRankView cSz() {
        return new HotRankView(this.mContext);
    }

    public void ed(List<j> list) {
        if (this.kcw == null) {
            this.kcw = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.kcw.clear();
            this.kcw.addAll(list);
        }
        if (this.kcx == null && !y.isEmpty(this.kcw)) {
            this.kcx = new ArrayList();
            this.kcx.clear();
            this.kcx.addAll(this.kcw.get(0).ked);
        }
        notifyDataSetChanged();
        cRm();
    }

    private void cRm() {
        String str;
        if (this.aaR >= 0) {
            HotRankView hotRankView = this.khD.get(this.aaR % 3);
            j jVar = (j) y.getItem(this.kcw, this.aaR);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.Yb();
                p pVar = (p) y.getItem(this.kcx, this.aaR);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.gSX;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cRZ())) {
                    hotRankView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Yb() {
        if (cSA() != null) {
            cSA().Yb();
        }
    }

    public void showLoadingView() {
        if (cSA() != null) {
            cSA().D(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void rR(boolean z) {
        if (this.khD != null) {
            for (HotRankView hotRankView : this.khD) {
                if (hotRankView != null) {
                    hotRankView.rR(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.khD != null) {
            for (HotRankView hotRankView : this.khD) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.kcw == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.kcw.get(0).ked.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cSA() {
        if (this.aaR == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.khD, this.aaR % 3);
    }

    public List<j> cSB() {
        return this.kcw;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.kcw);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.khD) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.aaR != i) {
            this.aaR = i;
            if (!y.isEmpty(this.kcw)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.kcw.get(this.aaR);
                HotRankView hotRankView2 = this.khD.get(i % this.khD.size());
                if (jVar == null || y.isEmpty(jVar.cRZ())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.D(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cRs();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.khD.get(i % this.khD.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.kcw.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.Yb();
        if (this.aaR == -1) {
            str = this.kcx.get(0).gSX;
        } else {
            str = this.kcx.get(this.aaR).gSX;
        }
        hotRankView.b(jVar, str);
        return hotRankView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (y.isEmpty(this.kcw) || this.kcw.get(0) == null || y.isEmpty(this.kcw.get(0).ked)) {
            return null;
        }
        return this.kcw.get(0).ked.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
