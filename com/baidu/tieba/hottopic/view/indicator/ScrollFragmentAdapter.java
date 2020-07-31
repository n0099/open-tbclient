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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import com.baidu.tieba.hottopic.view.HotRankView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int Yz = -1;
    private List<j> iJb;
    private List<p> iJc;
    private List<HotRankView> iOk;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.iJb = new ArrayList();
        this.iOk = new ArrayList();
        this.iOk.add(cpO());
        this.iOk.add(cpO());
        this.iOk.add(cpO());
    }

    private HotRankView cpO() {
        return new HotRankView(this.mContext);
    }

    public void dj(List<j> list) {
        if (this.iJb == null) {
            this.iJb = new ArrayList();
        }
        if (!x.isEmpty(list)) {
            this.iJb.clear();
            this.iJb.addAll(list);
        }
        if (this.iJc == null && !x.isEmpty(this.iJb)) {
            this.iJc = new ArrayList();
            this.iJc.clear();
            this.iJc.addAll(this.iJb.get(0).iKJ);
        }
        notifyDataSetChanged();
        coz();
    }

    private void coz() {
        String str;
        if (this.Yz >= 0) {
            HotRankView hotRankView = this.iOk.get(this.Yz % 3);
            j jVar = (j) x.getItem(this.iJb, this.Yz);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.bwX();
                p pVar = (p) x.getItem(this.iJc, this.Yz);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.fSN;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || x.isEmpty(jVar.cpm())) {
                    hotRankView.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bwX() {
        if (cpP() != null) {
            cpP().bwX();
        }
    }

    public void showLoadingView() {
        if (cpP() != null) {
            cpP().A(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void pp(boolean z) {
        if (this.iOk != null) {
            for (HotRankView hotRankView : this.iOk) {
                if (hotRankView != null) {
                    hotRankView.pp(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.iOk != null) {
            for (HotRankView hotRankView : this.iOk) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.iJb == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.iJb.get(0).iKJ.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cpP() {
        if (this.Yz == -1) {
            return null;
        }
        return (HotRankView) x.getItem(this.iOk, this.Yz % 3);
    }

    public List<j> cpQ() {
        return this.iJb;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return x.getCount(this.iJb);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.iOk) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.Yz != i) {
            this.Yz = i;
            if (!x.isEmpty(this.iJb)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.iJb.get(this.Yz);
                HotRankView hotRankView2 = this.iOk.get(i % this.iOk.size());
                if (jVar == null || x.isEmpty(jVar.cpm())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.A(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).coF();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.iOk.get(i % this.iOk.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.iJb.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.bwX();
        if (this.Yz == -1) {
            str = this.iJc.get(0).fSN;
        } else {
            str = this.iJc.get(this.Yz).fSN;
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
        if (x.isEmpty(this.iJb) || this.iJb.get(0) == null || x.isEmpty(this.iJb.get(0).iKJ)) {
            return null;
        }
        return this.iJb.get(0).iKJ.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
