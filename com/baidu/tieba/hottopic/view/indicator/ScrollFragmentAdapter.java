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
    private int ZP = -1;
    private List<HotRankView> jAT;
    private List<j> jvM;
    private List<p> jvN;
    private Context mContext;
    private TbPageContext<?> pageContext;

    public ScrollFragmentAdapter(Context context) {
        this.mContext = context;
        e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.jvM = new ArrayList();
        this.jAT = new ArrayList();
        this.jAT.add(cHX());
        this.jAT.add(cHX());
        this.jAT.add(cHX());
    }

    private HotRankView cHX() {
        return new HotRankView(this.mContext);
    }

    public void dB(List<j> list) {
        if (this.jvM == null) {
            this.jvM = new ArrayList();
        }
        if (!y.isEmpty(list)) {
            this.jvM.clear();
            this.jvM.addAll(list);
        }
        if (this.jvN == null && !y.isEmpty(this.jvM)) {
            this.jvN = new ArrayList();
            this.jvN.clear();
            this.jvN.addAll(this.jvM.get(0).jxt);
        }
        notifyDataSetChanged();
        cGJ();
    }

    private void cGJ() {
        String str;
        if (this.ZP >= 0) {
            HotRankView hotRankView = this.jAT.get(this.ZP % 3);
            j jVar = (j) y.getItem(this.jvM, this.ZP);
            if (hotRankView != null) {
                hotRankView.hideLoadingView();
                hotRankView.SK();
                p pVar = (p) y.getItem(this.jvN, this.ZP);
                if (pVar == null) {
                    str = "";
                } else {
                    str = pVar.guo;
                }
                hotRankView.b(jVar, str);
                if (jVar == null || y.isEmpty(jVar.cHw())) {
                    hotRankView.aO(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void SK() {
        if (cHY() != null) {
            cHY().SK();
        }
    }

    public void showLoadingView() {
        if (cHY() != null) {
            cHY().D(true, l.getDimens(this.pageContext.getPageActivity(), R.dimen.ds500));
        }
    }

    public void qL(boolean z) {
        if (this.jAT != null) {
            for (HotRankView hotRankView : this.jAT) {
                if (hotRankView != null) {
                    hotRankView.qL(z);
                }
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (this.jAT != null) {
            for (HotRankView hotRankView : this.jAT) {
                if (hotRankView != null) {
                    hotRankView.f(view, i, i2, i3, i4);
                }
            }
        }
    }

    public int b(p pVar) {
        if (this.jvM == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            p pVar2 = this.jvM.get(0).jxt.get(i);
            if (pVar2 != null && pVar2.tabName != null && pVar2.tabName.equals(pVar.tabName)) {
                return i;
            }
        }
        return -1;
    }

    private HotRankView cHY() {
        if (this.ZP == -1) {
            return null;
        }
        return (HotRankView) y.getItem(this.jAT, this.ZP % 3);
    }

    public List<j> cHZ() {
        return this.jvM;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.jvM);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        for (HotRankView hotRankView : this.jAT) {
            if (hotRankView != null) {
                hotRankView.onChangeSkinType();
            }
        }
        if (this.ZP != i) {
            this.ZP = i;
            if (!y.isEmpty(this.jvM)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                j jVar = this.jvM.get(this.ZP);
                HotRankView hotRankView2 = this.jAT.get(i % this.jAT.size());
                if (jVar == null || y.isEmpty(jVar.cHw())) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        hotRankView2.aO(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                        return;
                    }
                    hotRankView2.D(true, 0);
                    ((HotRanklistActivity) this.pageContext.getOrignalPage()).cGP();
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        String str;
        HotRankView hotRankView = this.jAT.get(i % this.jAT.size());
        if (hotRankView.getParent() != null) {
            viewGroup.removeView(hotRankView);
        }
        j jVar = this.jvM.get(i);
        viewGroup.addView(hotRankView);
        hotRankView.hideLoadingView();
        hotRankView.SK();
        if (this.ZP == -1) {
            str = this.jvN.get(0).guo;
        } else {
            str = this.jvN.get(this.ZP).guo;
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
        if (y.isEmpty(this.jvM) || this.jvM.get(0) == null || y.isEmpty(this.jvM.get(0).jxt)) {
            return null;
        }
        return this.jvM.get(0).jxt.get(i).tabName;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }
}
