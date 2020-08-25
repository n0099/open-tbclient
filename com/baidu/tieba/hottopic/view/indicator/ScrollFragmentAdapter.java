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
/* loaded from: classes15.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int Zf = -1;
    private List<j> iYb;
    private List<p> iYc;
    private List<HotRankView> jdj;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.iYb = new ArrayList();
        this.jdj = new ArrayList();
        this.jdj.add(cAG());
        this.jdj.add(cAG());
        this.jdj.add(cAG());
    }

    private HotRankView cAG() {
        return new HotRankView(this.mContext);
    }

    public void dq(List<j> list) {
        if (this.iYb == null) {
            this.iYb = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.iYb.clear();
            this.iYb.addAll(list);
        }
        if (this.iYc == null && !y.isEmpty(this.iYb)) {
            this.iYc = new ArrayList();
            this.iYc.clear();
            this.iYc.addAll(this.iYb.get(0).iZJ);
        }
        notifyDataSetChanged();
        czs();
    }

    private void czs() {
        String str;
        if (this.Zf >= 0) {
            HotRankView hotRankView = this.jdj.get(this.Zf % 3);
            j jVar = (j) y.getItem(this.iYb, this.Zf);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.bFW();
                p pVar = (p) y.getItem(this.iYc, this.Zf);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.geM;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cAf())) {
                    hotRankView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bFW() {
        if (cAH() != null) {
            cAH().bFW();
        }
    }

    public void showLoadingView() {
        if (cAH() != null) {
            cAH().A(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void pV(boolean z) {
        if (this.jdj != null) {
            for (HotRankView hotRankView : this.jdj) {
                if (hotRankView != null) {
                    hotRankView.pV(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jdj != null) {
            for (HotRankView hotRankView : this.jdj) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.iYb == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.iYb.get(0).iZJ.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cAH() {
        if (this.Zf == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jdj, this.Zf % 3);
    }

    public List<j> cAI() {
        return this.iYb;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.iYb);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jdj) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.Zf != i) {
            this.Zf = i;
            if (!y.isEmpty(this.iYb)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.iYb.get(this.Zf);
                HotRankView hotRankView2 = this.jdj.get(i % this.jdj.size());
                if (jVar == null || y.isEmpty(jVar.cAf())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.A(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).czy();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jdj.get(i % this.jdj.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.iYb.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.bFW();
        if (this.Zf == -1) {
            str = this.iYc.get(0).geM;
        } else {
            str = this.iYc.get(this.Zf).geM;
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
        if (y.isEmpty(this.iYb) || this.iYb.get(0) == null || y.isEmpty(this.iYb.get(0).iZJ)) {
            return null;
        }
        return this.iYb.get(0).iZJ.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
