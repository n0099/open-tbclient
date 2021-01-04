package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] hbL = {"最热", "最新"};
    private int abC = -1;
    private List<HotTopicView> kpa;
    private c.a kpb;
    private com.baidu.tieba.hottopic.view.c kpc;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.kpb = aVar;
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kpa = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.kpb);
        hotTopicView2.setScrollCallback(this.kpb);
        this.kpa.add(hotTopicView);
        this.kpa.add(hotTopicView2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.mHotTopicDataList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ek(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!x.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cUt();
    }

    private void cUt() {
        if (this.abC >= 0) {
            HotTopicView hotTopicView = this.kpa.get(this.abC % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.abC);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.Zi();
                hotTopicView.c(eVar);
                if (eVar == null || x.isEmpty(eVar.cVg())) {
                    hotTopicView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Zi() {
        if (cUu() != null) {
            cUu().Zi();
        }
    }

    public void showLoadingView() {
        if (cUu() != null) {
            cUu().it(true);
        }
    }

    public void so(boolean z) {
        if (this.kpa != null) {
            for (HotTopicView hotTopicView : this.kpa) {
                if (hotTopicView != null) {
                    hotTopicView.so(z);
                }
            }
        }
    }

    public HotTopicView cUu() {
        if (this.abC == -1) {
            return null;
        }
        return (HotTopicView) x.getItem(this.kpa, this.abC % 2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.abC != i) {
            int i2 = this.abC;
            this.abC = i;
            if (!x.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.abC);
                if (eVar != null && eVar.cUZ() != null) {
                    if (this.abC == 0) {
                        TiebaStatic.log(new aq("c11970").dX("obj_id", eVar.cUZ().fgR));
                    } else {
                        TiebaStatic.log(new aq("c11971").dX("obj_id", eVar.cUZ().fgR));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) x.getItem(this.kpa, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) x.getItem(this.kpa, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || x.isEmpty(eVar.cVg())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.it(true);
                        this.pageContext.getOrignalPage().cUG();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: K */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.kpa.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.kpc);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.Zi();
        hotTopicView.c(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return hbL[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Dz(int i) {
        if (!x.isEmpty(this.kpa)) {
            for (HotTopicView hotTopicView : this.kpa) {
                hotTopicView.DL(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.kpa) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cUu = cUu();
        if (cUu != null) {
            cUu.resume();
        }
    }

    public void pause() {
        HotTopicView cUu = cUu();
        if (cUu != null) {
            cUu.pause();
        }
    }

    public void DA(int i) {
        HotTopicView hotTopicView;
        if (this.kpa != null && i < this.kpa.size() && (hotTopicView = this.kpa.get(i)) != null) {
            hotTopicView.Zg();
        }
    }

    public void DB(int i) {
        HotTopicView hotTopicView;
        if (this.kpa != null && i < this.kpa.size() && (hotTopicView = this.kpa.get(i)) != null) {
            hotTopicView.Zh();
        }
    }

    public void DC(int i) {
        HotTopicView hotTopicView;
        if (this.kpa != null && i < this.kpa.size() && (hotTopicView = this.kpa.get(i)) != null) {
            hotTopicView.bVF();
        }
    }

    public void DD(int i) {
        for (HotTopicView hotTopicView : this.kpa) {
            if (hotTopicView != null && hotTopicView != cUu()) {
                hotTopicView.DM(i);
            }
        }
    }

    public void aM(float f) {
        for (HotTopicView hotTopicView : this.kpa) {
            if (hotTopicView != null && hotTopicView != cUu()) {
                hotTopicView.aN(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.kpc = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.kpa.get(i3);
                if (hotTopicView != null) {
                    hotTopicView.onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
