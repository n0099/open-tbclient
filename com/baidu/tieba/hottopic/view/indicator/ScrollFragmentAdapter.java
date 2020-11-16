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
/* loaded from: classes20.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int ZV = -1;
    private List<j> jOT;
    private List<p> jOU;
    private List<HotRankView> jTZ;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.jOT = new ArrayList();
        this.jTZ = new ArrayList();
        this.jTZ.add(cNl());
        this.jTZ.add(cNl());
        this.jTZ.add(cNl());
    }

    private HotRankView cNl() {
        return new HotRankView(this.mContext);
    }

    public void dS(List<j> list) {
        if (this.jOT == null) {
            this.jOT = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.jOT.clear();
            this.jOT.addAll(list);
        }
        if (this.jOU == null && !y.isEmpty(this.jOT)) {
            this.jOU = new ArrayList();
            this.jOU.clear();
            this.jOU.addAll(this.jOT.get(0).jQA);
        }
        notifyDataSetChanged();
        cLY();
    }

    private void cLY() {
        String str;
        if (this.ZV >= 0) {
            HotRankView hotRankView = this.jTZ.get(this.ZV % 3);
            j jVar = (j) y.getItem(this.jOT, this.ZV);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.VB();
                p pVar = (p) y.getItem(this.jOU, this.ZV);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.gJM;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cML())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void VB() {
        if (cNm() != null) {
            cNm().VB();
        }
    }

    public void showLoadingView() {
        if (cNm() != null) {
            cNm().D(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void rp(boolean z) {
        if (this.jTZ != null) {
            for (HotRankView hotRankView : this.jTZ) {
                if (hotRankView != null) {
                    hotRankView.rp(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jTZ != null) {
            for (HotRankView hotRankView : this.jTZ) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.jOT == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.jOT.get(0).jQA.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cNm() {
        if (this.ZV == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jTZ, this.ZV % 3);
    }

    public List<j> cNn() {
        return this.jOT;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.jOT);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jTZ) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.ZV != i) {
            this.ZV = i;
            if (!y.isEmpty(this.jOT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.jOT.get(this.ZV);
                HotRankView hotRankView2 = this.jTZ.get(i % this.jTZ.size());
                if (jVar == null || y.isEmpty(jVar.cML())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.D(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cMe();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jTZ.get(i % this.jTZ.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.jOT.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.VB();
        if (this.ZV == -1) {
            str = this.jOU.get(0).gJM;
        } else {
            str = this.jOU.get(this.ZV).gJM;
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
        if (y.isEmpty(this.jOT) || this.jOT.get(0) == null || y.isEmpty(this.jOT.get(0).jQA)) {
            return null;
        }
        return this.jOT.get(0).jQA.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
