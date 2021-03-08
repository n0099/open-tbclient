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
/* loaded from: classes7.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int acR = -1;
    private List<HotRankView> kAJ;
    private List<j> kvC;
    private List<p> kvD;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        f<?> J = com.baidu.adp.base.j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.kvC = new ArrayList();
        this.kAJ = new ArrayList();
        this.kAJ.add(cUc());
        this.kAJ.add(cUc());
        this.kAJ.add(cUc());
    }

    private HotRankView cUc() {
        return new HotRankView(this.mContext);
    }

    public void ei(List<j> list) {
        if (this.kvC == null) {
            this.kvC = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.kvC.clear();
            this.kvC.addAll(list);
        }
        if (this.kvD == null && !y.isEmpty(this.kvC)) {
            this.kvD = new ArrayList();
            this.kvD.clear();
            this.kvD.addAll(this.kvC.get(0).kxk);
        }
        notifyDataSetChanged();
        cSP();
    }

    private void cSP() {
        String str;
        if (this.acR >= 0) {
            HotRankView hotRankView = this.kAJ.get(this.acR % 3);
            j jVar = (j) y.getItem(this.kvC, this.acR);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.Xc();
                p pVar = (p) y.getItem(this.kvD, this.acR);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.heN;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cTC())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Xc() {
        if (cUd() != null) {
            cUd().Xc();
        }
    }

    public void showLoadingView() {
        if (cUd() != null) {
            cUd().C(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void sx(boolean z) {
        if (this.kAJ != null) {
            for (HotRankView hotRankView : this.kAJ) {
                if (hotRankView != null) {
                    hotRankView.sx(z);
                }
            }
        }
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        if (this.kAJ != null) {
            for (HotRankView hotRankView : this.kAJ) {
                if (hotRankView != null) {
                    hotRankView.h(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.kvC == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.kvC.get(0).kxk.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cUd() {
        if (this.acR == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.kAJ, this.acR % 3);
    }

    public List<j> cUe() {
        return this.kvC;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.kvC);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.kAJ) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.acR != i) {
            this.acR = i;
            if (!y.isEmpty(this.kvC)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.kvC.get(this.acR);
                HotRankView hotRankView2 = this.kAJ.get(i % this.kAJ.size());
                if (jVar == null || y.isEmpty(jVar.cTC())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.C(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cSV();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.kAJ.get(i % this.kAJ.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.kvC.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.Xc();
        if (this.acR == -1) {
            str = this.kvD.get(0).heN;
        } else {
            str = this.kvD.get(this.acR).heN;
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
        if (y.isEmpty(this.kvC) || this.kvC.get(0) == null || y.isEmpty(this.kvC.get(0).kxk)) {
            return null;
        }
        return this.kvC.get(0).kxk.get(i).tabName;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
