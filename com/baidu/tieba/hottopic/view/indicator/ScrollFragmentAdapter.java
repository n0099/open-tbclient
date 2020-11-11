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
    private List<j> jOj;
    private List<p> jOk;
    private List<HotRankView> jTp;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.jOj = new ArrayList();
        this.jTp = new ArrayList();
        this.jTp.add(cNF());
        this.jTp.add(cNF());
        this.jTp.add(cNF());
    }

    private HotRankView cNF() {
        return new HotRankView(this.mContext);
    }

    public void dS(List<j> list) {
        if (this.jOj == null) {
            this.jOj = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.jOj.clear();
            this.jOj.addAll(list);
        }
        if (this.jOk == null && !y.isEmpty(this.jOj)) {
            this.jOk = new ArrayList();
            this.jOk.clear();
            this.jOk.addAll(this.jOj.get(0).jPQ);
        }
        notifyDataSetChanged();
        cMr();
    }

    private void cMr() {
        String str;
        if (this.ZQ >= 0) {
            HotRankView hotRankView = this.jTp.get(this.ZQ % 3);
            j jVar = (j) y.getItem(this.jOj, this.ZQ);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.Wk();
                p pVar = (p) y.getItem(this.jOk, this.ZQ);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.gKf;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cNe())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Wk() {
        if (cNG() != null) {
            cNG().Wk();
        }
    }

    public void showLoadingView() {
        if (cNG() != null) {
            cNG().D(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void rm(boolean z) {
        if (this.jTp != null) {
            for (HotRankView hotRankView : this.jTp) {
                if (hotRankView != null) {
                    hotRankView.rm(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jTp != null) {
            for (HotRankView hotRankView : this.jTp) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.jOj == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.jOj.get(0).jPQ.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cNG() {
        if (this.ZQ == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jTp, this.ZQ % 3);
    }

    public List<j> cNH() {
        return this.jOj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.jOj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jTp) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.ZQ != i) {
            this.ZQ = i;
            if (!y.isEmpty(this.jOj)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.jOj.get(this.ZQ);
                HotRankView hotRankView2 = this.jTp.get(i % this.jTp.size());
                if (jVar == null || y.isEmpty(jVar.cNe())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.D(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cMx();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jTp.get(i % this.jTp.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.jOj.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.Wk();
        if (this.ZQ == -1) {
            str = this.jOk.get(0).gKf;
        } else {
            str = this.jOk.get(this.ZQ).gKf;
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
        if (y.isEmpty(this.jOj) || this.jOj.get(0) == null || y.isEmpty(this.jOj.get(0).jPQ)) {
            return null;
        }
        return this.jOj.get(0).jPQ.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
