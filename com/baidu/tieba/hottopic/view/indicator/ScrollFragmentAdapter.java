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
    private int Zh = -1;
    private List<j> iYh;
    private List<p> iYi;
    private List<HotRankView> jdp;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.iYh = new ArrayList();
        this.jdp = new ArrayList();
        this.jdp.add(cAH());
        this.jdp.add(cAH());
        this.jdp.add(cAH());
    }

    private HotRankView cAH() {
        return new HotRankView(this.mContext);
    }

    public void dq(List<j> list) {
        if (this.iYh == null) {
            this.iYh = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.iYh.clear();
            this.iYh.addAll(list);
        }
        if (this.iYi == null && !y.isEmpty(this.iYh)) {
            this.iYi = new ArrayList();
            this.iYi.clear();
            this.iYi.addAll(this.iYh.get(0).iZP);
        }
        notifyDataSetChanged();
        czt();
    }

    private void czt() {
        String str;
        if (this.Zh >= 0) {
            HotRankView hotRankView = this.jdp.get(this.Zh % 3);
            j jVar = (j) y.getItem(this.iYh, this.Zh);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.bFX();
                p pVar = (p) y.getItem(this.iYi, this.Zh);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.geQ;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cAg())) {
                    hotRankView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bFX() {
        if (cAI() != null) {
            cAI().bFX();
        }
    }

    public void showLoadingView() {
        if (cAI() != null) {
            cAI().A(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void pX(boolean z) {
        if (this.jdp != null) {
            for (HotRankView hotRankView : this.jdp) {
                if (hotRankView != null) {
                    hotRankView.pX(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jdp != null) {
            for (HotRankView hotRankView : this.jdp) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.iYh == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.iYh.get(0).iZP.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cAI() {
        if (this.Zh == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jdp, this.Zh % 3);
    }

    public List<j> cAJ() {
        return this.iYh;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.iYh);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jdp) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.Zh != i) {
            this.Zh = i;
            if (!y.isEmpty(this.iYh)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.iYh.get(this.Zh);
                HotRankView hotRankView2 = this.jdp.get(i % this.jdp.size());
                if (jVar == null || y.isEmpty(jVar.cAg())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.A(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).czz();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jdp.get(i % this.jdp.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.iYh.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.bFX();
        if (this.Zh == -1) {
            str = this.iYi.get(0).geQ;
        } else {
            str = this.iYi.get(this.Zh).geQ;
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
        if (y.isEmpty(this.iYh) || this.iYh.get(0) == null || y.isEmpty(this.iYh.get(0).iZP)) {
            return null;
        }
        return this.iYh.get(0).iZP.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
