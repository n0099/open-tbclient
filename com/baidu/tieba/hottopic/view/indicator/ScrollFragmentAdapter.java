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
/* loaded from: classes7.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int abA = -1;
    private List<j> klf;
    private List<p> klg;
    private List<HotRankView> kqm;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.klf = new ArrayList();
        this.kqm = new ArrayList();
        this.kqm.add(cRP());
        this.kqm.add(cRP());
        this.kqm.add(cRP());
    }

    private HotRankView cRP() {
        return new HotRankView(this.mContext);
    }

    public void ek(List<j> list) {
        if (this.klf == null) {
            this.klf = new ArrayList();
        }
        if (!x.isEmpty(list)) {
            this.klf.clear();
            this.klf.addAll(list);
        }
        if (this.klg == null && !x.isEmpty(this.klf)) {
            this.klg = new ArrayList();
            this.klg.clear();
            this.klg.addAll(this.klf.get(0).kmN);
        }
        notifyDataSetChanged();
        cQC();
    }

    private void cQC() {
        String str;
        if (this.abA >= 0) {
            HotRankView hotRankView = this.kqm.get(this.abA % 3);
            j jVar = (j) x.getItem(this.klf, this.abA);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.Vq();
                p pVar = (p) x.getItem(this.klg, this.abA);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.hag;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || x.isEmpty(jVar.cRp())) {
                    hotRankView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Vq() {
        if (cRQ() != null) {
            cRQ().Vq();
        }
    }

    public void showLoadingView() {
        if (cRQ() != null) {
            cRQ().C(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void sk(boolean z) {
        if (this.kqm != null) {
            for (HotRankView hotRankView : this.kqm) {
                if (hotRankView != null) {
                    hotRankView.sk(z);
                }
            }
        }
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        if (this.kqm != null) {
            for (HotRankView hotRankView : this.kqm) {
                if (hotRankView != null) {
                    hotRankView.h(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.klf == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.klf.get(0).kmN.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cRQ() {
        if (this.abA == -1) {
            return null;
        }
        return (HotRankView) x.getItem(this.kqm, this.abA % 3);
    }

    public List<j> cRR() {
        return this.klf;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.klf);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.kqm) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.abA != i) {
            this.abA = i;
            if (!x.isEmpty(this.klf)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.klf.get(this.abA);
                HotRankView hotRankView2 = this.kqm.get(i % this.kqm.size());
                if (jVar == null || x.isEmpty(jVar.cRp())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.C(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cQI();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.kqm.get(i % this.kqm.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.klf.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.Vq();
        if (this.abA == -1) {
            str = this.klg.get(0).hag;
        } else {
            str = this.klg.get(this.abA).hag;
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
        if (x.isEmpty(this.klf) || this.klf.get(0) == null || x.isEmpty(this.klf.get(0).kmN)) {
            return null;
        }
        return this.klf.get(0).kmN.get(i).tabName;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
