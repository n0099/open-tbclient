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
/* loaded from: classes8.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int abv = -1;
    private List<j> ktm;
    private List<p> ktn;
    private List<HotRankView> kyt;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.ktm = new ArrayList();
        this.kyt = new ArrayList();
        this.kyt.add(cTO());
        this.kyt.add(cTO());
        this.kyt.add(cTO());
    }

    private HotRankView cTO() {
        return new HotRankView(this.mContext);
    }

    public void ei(List<j> list) {
        if (this.ktm == null) {
            this.ktm = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.ktm.clear();
            this.ktm.addAll(list);
        }
        if (this.ktn == null && !y.isEmpty(this.ktm)) {
            this.ktn = new ArrayList();
            this.ktn.clear();
            this.ktn.addAll(this.ktm.get(0).kuU);
        }
        notifyDataSetChanged();
        cSB();
    }

    private void cSB() {
        String str;
        if (this.abv >= 0) {
            HotRankView hotRankView = this.kyt.get(this.abv % 3);
            j jVar = (j) y.getItem(this.ktm, this.abv);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.WZ();
                p pVar = (p) y.getItem(this.ktn, this.abv);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.hcQ;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cTo())) {
                    hotRankView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void WZ() {
        if (cTP() != null) {
            cTP().WZ();
        }
    }

    public void showLoadingView() {
        if (cTP() != null) {
            cTP().C(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void sx(boolean z) {
        if (this.kyt != null) {
            for (HotRankView hotRankView : this.kyt) {
                if (hotRankView != null) {
                    hotRankView.sx(z);
                }
            }
        }
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        if (this.kyt != null) {
            for (HotRankView hotRankView : this.kyt) {
                if (hotRankView != null) {
                    hotRankView.h(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.ktm == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.ktm.get(0).kuU.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cTP() {
        if (this.abv == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.kyt, this.abv % 3);
    }

    public List<j> cTQ() {
        return this.ktm;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.ktm);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.kyt) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.abv != i) {
            this.abv = i;
            if (!y.isEmpty(this.ktm)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.ktm.get(this.abv);
                HotRankView hotRankView2 = this.kyt.get(i % this.kyt.size());
                if (jVar == null || y.isEmpty(jVar.cTo())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.C(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cSH();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.kyt.get(i % this.kyt.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.ktm.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.WZ();
        if (this.abv == -1) {
            str = this.ktn.get(0).hcQ;
        } else {
            str = this.ktn.get(this.abv).hcQ;
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
        if (y.isEmpty(this.ktm) || this.ktm.get(0) == null || y.isEmpty(this.ktm.get(0).kuU)) {
            return null;
        }
        return this.ktm.get(0).kuU.get(i).tabName;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
