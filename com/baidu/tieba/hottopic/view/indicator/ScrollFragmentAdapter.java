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
    private int ZQ = -1;
    private List<j> jIl;
    private List<p> jIm;
    private List<HotRankView> jNs;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.jIl = new ArrayList();
        this.jNs = new ArrayList();
        this.jNs.add(cLe());
        this.jNs.add(cLe());
        this.jNs.add(cLe());
    }

    private HotRankView cLe() {
        return new HotRankView(this.mContext);
    }

    public void dK(List<j> list) {
        if (this.jIl == null) {
            this.jIl = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.jIl.clear();
            this.jIl.addAll(list);
        }
        if (this.jIm == null && !y.isEmpty(this.jIl)) {
            this.jIm = new ArrayList();
            this.jIm.clear();
            this.jIm.addAll(this.jIl.get(0).jJS);
        }
        notifyDataSetChanged();
        cJQ();
    }

    private void cJQ() {
        String str;
        if (this.ZQ >= 0) {
            HotRankView hotRankView = this.jNs.get(this.ZQ % 3);
            j jVar = (j) y.getItem(this.jIl, this.ZQ);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.TK();
                p pVar = (p) y.getItem(this.jIm, this.ZQ);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.gEs;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cKD())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void TK() {
        if (cLf() != null) {
            cLf().TK();
        }
    }

    public void showLoadingView() {
        if (cLf() != null) {
            cLf().D(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void rd(boolean z) {
        if (this.jNs != null) {
            for (HotRankView hotRankView : this.jNs) {
                if (hotRankView != null) {
                    hotRankView.rd(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jNs != null) {
            for (HotRankView hotRankView : this.jNs) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.jIl == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.jIl.get(0).jJS.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cLf() {
        if (this.ZQ == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jNs, this.ZQ % 3);
    }

    public List<j> cLg() {
        return this.jIl;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.jIl);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jNs) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.ZQ != i) {
            this.ZQ = i;
            if (!y.isEmpty(this.jIl)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.jIl.get(this.ZQ);
                HotRankView hotRankView2 = this.jNs.get(i % this.jNs.size());
                if (jVar == null || y.isEmpty(jVar.cKD())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.D(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cJW();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jNs.get(i % this.jNs.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.jIl.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.TK();
        if (this.ZQ == -1) {
            str = this.jIm.get(0).gEs;
        } else {
            str = this.jIm.get(this.ZQ).gEs;
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
        if (y.isEmpty(this.jIl) || this.jIl.get(0) == null || y.isEmpty(this.jIl.get(0).jJS)) {
            return null;
        }
        return this.jIl.get(0).jJS.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
