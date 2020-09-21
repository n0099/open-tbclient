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
    private int Zz = -1;
    private List<j> jgN;
    private List<p> jgO;
    private List<HotRankView> jlV;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.jgN = new ArrayList();
        this.jlV = new ArrayList();
        this.jlV.add(cEo());
        this.jlV.add(cEo());
        this.jlV.add(cEo());
    }

    private HotRankView cEo() {
        return new HotRankView(this.mContext);
    }

    public void dy(List<j> list) {
        if (this.jgN == null) {
            this.jgN = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.jgN.clear();
            this.jgN.addAll(list);
        }
        if (this.jgO == null && !y.isEmpty(this.jgN)) {
            this.jgO = new ArrayList();
            this.jgO.clear();
            this.jgO.addAll(this.jgN.get(0).jiv);
        }
        notifyDataSetChanged();
        cDa();
    }

    private void cDa() {
        String str;
        if (this.Zz >= 0) {
            HotRankView hotRankView = this.jlV.get(this.Zz % 3);
            j jVar = (j) y.getItem(this.jgN, this.Zz);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.bHn();
                p pVar = (p) y.getItem(this.jgO, this.Zz);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.gia;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cDN())) {
                    hotRankView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bHn() {
        if (cEp() != null) {
            cEp().bHn();
        }
    }

    public void showLoadingView() {
        if (cEp() != null) {
            cEp().A(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void qf(boolean z) {
        if (this.jlV != null) {
            for (HotRankView hotRankView : this.jlV) {
                if (hotRankView != null) {
                    hotRankView.qf(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jlV != null) {
            for (HotRankView hotRankView : this.jlV) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.jgN == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.jgN.get(0).jiv.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cEp() {
        if (this.Zz == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jlV, this.Zz % 3);
    }

    public List<j> cEq() {
        return this.jgN;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.jgN);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jlV) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.Zz != i) {
            this.Zz = i;
            if (!y.isEmpty(this.jgN)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.jgN.get(this.Zz);
                HotRankView hotRankView2 = this.jlV.get(i % this.jlV.size());
                if (jVar == null || y.isEmpty(jVar.cDN())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.A(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cDg();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jlV.get(i % this.jlV.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.jgN.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.bHn();
        if (this.Zz == -1) {
            str = this.jgO.get(0).gia;
        } else {
            str = this.jgO.get(this.Zz).gia;
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
        if (y.isEmpty(this.jgN) || this.jgN.get(0) == null || y.isEmpty(this.jgN.get(0).jiv)) {
            return null;
        }
        return this.jgN.get(0).jiv.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
