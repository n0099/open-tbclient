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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.data.p;
import com.baidu.tieba.hottopic.view.HotRankView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    private int YJ = -1;
    private List<j> iCX;
    private List<p> iCY;
    private List<HotRankView> iIf;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.iCX = new ArrayList();
        this.iIf = new ArrayList();
        this.iIf.add(cmn());
        this.iIf.add(cmn());
        this.iIf.add(cmn());
    }

    private HotRankView cmn() {
        return new HotRankView(this.mContext);
    }

    public void de(List<j> list) {
        if (this.iCX == null) {
            this.iCX = new ArrayList();
        }
        if (!w.isEmpty(list)) {
            this.iCX.clear();
            this.iCX.addAll(list);
        }
        if (this.iCY == null && !w.isEmpty(this.iCX)) {
            this.iCY = new ArrayList();
            this.iCY.clear();
            this.iCY.addAll(this.iCX.get(0).iEF);
        }
        notifyDataSetChanged();
        ckY();
    }

    private void ckY() {
        String str;
        if (this.YJ >= 0) {
            HotRankView hotRankView = this.iIf.get(this.YJ % 3);
            j jVar = (j) w.getItem(this.iCX, this.YJ);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.btN();
                p pVar = (p) w.getItem(this.iCY, this.YJ);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.fNu;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || w.isEmpty(jVar.clL())) {
                    hotRankView.aI(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void btN() {
        if (cmo() != null) {
            cmo().btN();
        }
    }

    public void showLoadingView() {
        if (cmo() != null) {
            cmo().A(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void oK(boolean z) {
        if (this.iIf != null) {
            for (HotRankView hotRankView : this.iIf) {
                if (hotRankView != null) {
                    hotRankView.oK(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.iIf != null) {
            for (HotRankView hotRankView : this.iIf) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.iCX == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.iCX.get(0).iEF.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cmo() {
        if (this.YJ == -1) {
            return null;
        }
        return (HotRankView) w.getItem(this.iIf, this.YJ % 3);
    }

    public List<j> cmp() {
        return this.iCX;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return w.getCount(this.iCX);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.iIf) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.YJ != i) {
            this.YJ = i;
            if (!w.isEmpty(this.iCX)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.iCX.get(this.YJ);
                HotRankView hotRankView2 = this.iIf.get(i % this.iIf.size());
                if (jVar == null || w.isEmpty(jVar.clL())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aI(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.A(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cle();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.iIf.get(i % this.iIf.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.iCX.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.btN();
        if (this.YJ == -1) {
            str = this.iCY.get(0).fNu;
        } else {
            str = this.iCY.get(this.YJ).fNu;
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
        if (w.isEmpty(this.iCX) || this.iCX.get(0) == null || w.isEmpty(this.iCX.get(0).iEF)) {
            return null;
        }
        return this.iCX.get(0).iEF.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
