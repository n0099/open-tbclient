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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import com.baidu.tieba.hottopic.view.HotRankView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int abC = -1;
    private List<j> kpK;
    private List<p> kpL;
    private List<HotRankView> kuR;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.kpK = new ArrayList();
        this.kuR = new ArrayList();
        this.kuR.add(cVG());
        this.kuR.add(cVG());
        this.kuR.add(cVG());
    }

    private HotRankView cVG() {
        return new HotRankView(this.mContext);
    }

    public void ek(List<j> list) {
        if (this.kpK == null) {
            this.kpK = new ArrayList();
        }
        if (!x.isEmpty(list)) {
            this.kpK.clear();
            this.kpK.addAll(list);
        }
        if (this.kpL == null && !x.isEmpty(this.kpK)) {
            this.kpL = new ArrayList();
            this.kpL.clear();
            this.kpL.addAll(this.kpK.get(0).krs);
        }
        notifyDataSetChanged();
        cUt();
    }

    private void cUt() {
        String str;
        if (this.abC >= 0) {
            HotRankView hotRankView = this.kuR.get(this.abC % 3);
            j jVar = (j) x.getItem(this.kpK, this.abC);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.Zi();
                p pVar = (p) x.getItem(this.kpL, this.abC);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.heM;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || x.isEmpty(jVar.cVg())) {
                    hotRankView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Zi() {
        if (cVH() != null) {
            cVH().Zi();
        }
    }

    public void showLoadingView() {
        if (cVH() != null) {
            cVH().C(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void so(boolean z) {
        if (this.kuR != null) {
            for (HotRankView hotRankView : this.kuR) {
                if (hotRankView != null) {
                    hotRankView.so(z);
                }
            }
        }
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        if (this.kuR != null) {
            for (HotRankView hotRankView : this.kuR) {
                if (hotRankView != null) {
                    hotRankView.h(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.kpK == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.kpK.get(0).krs.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cVH() {
        if (this.abC == -1) {
            return null;
        }
        return (HotRankView) x.getItem(this.kuR, this.abC % 3);
    }

    public List<j> cVI() {
        return this.kpK;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.kpK);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.kuR) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.abC != i) {
            this.abC = i;
            if (!x.isEmpty(this.kpK)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.kpK.get(this.abC);
                HotRankView hotRankView2 = this.kuR.get(i % this.kuR.size());
                if (jVar == null || x.isEmpty(jVar.cVg())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.C(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cUz();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.kuR.get(i % this.kuR.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.kpK.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.Zi();
        if (this.abC == -1) {
            str = this.kpL.get(0).heM;
        } else {
            str = this.kpL.get(this.abC).heM;
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
        if (x.isEmpty(this.kpK) || this.kpK.get(0) == null || x.isEmpty(this.kpK.get(0).krs)) {
            return null;
        }
        return this.kpK.get(0).krs.get(i).tabName;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
