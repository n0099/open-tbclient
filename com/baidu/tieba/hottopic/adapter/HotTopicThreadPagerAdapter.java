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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gZP = {"最热", "最新"};
    private int abv = -1;
    private List<HotTopicView> ksC;
    private c.a ksD;
    private com.baidu.tieba.hottopic.view.c ksE;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.ksD = aVar;
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mHotTopicDataList = new ArrayList();
        this.ksC = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.ksD);
        hotTopicView2.setScrollCallback(this.ksD);
        this.ksC.add(hotTopicView);
        this.ksC.add(hotTopicView2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ei(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cSB();
    }

    private void cSB() {
        if (this.abv >= 0) {
            HotTopicView hotTopicView = this.ksC.get(this.abv % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.abv);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.WZ();
                hotTopicView.c(eVar);
                if (eVar == null || y.isEmpty(eVar.cTo())) {
                    hotTopicView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void WZ() {
        if (cSC() != null) {
            cSC().WZ();
        }
    }

    public void showLoadingView() {
        if (cSC() != null) {
            cSC().ir(true);
        }
    }

    public void sx(boolean z) {
        if (this.ksC != null) {
            for (HotTopicView hotTopicView : this.ksC) {
                if (hotTopicView != null) {
                    hotTopicView.sx(z);
                }
            }
        }
    }

    public HotTopicView cSC() {
        if (this.abv == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.ksC, this.abv % 2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.abv != i) {
            int i2 = this.abv;
            this.abv = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.abv);
                if (eVar != null && eVar.cTh() != null) {
                    if (this.abv == 0) {
                        TiebaStatic.log(new ar("c11970").dR("obj_id", eVar.cTh().fey));
                    } else {
                        TiebaStatic.log(new ar("c11971").dR("obj_id", eVar.cTh().fey));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.ksC, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.ksC, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cTo())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.ir(true);
                        this.pageContext.getOrignalPage().cSO();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: L */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.ksC.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.ksE);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.WZ();
        hotTopicView.c(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gZP[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Ck(int i) {
        if (!y.isEmpty(this.ksC)) {
            for (HotTopicView hotTopicView : this.ksC) {
                hotTopicView.Cw(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.ksC) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cSC = cSC();
        if (cSC != null) {
            cSC.resume();
        }
    }

    public void pause() {
        HotTopicView cSC = cSC();
        if (cSC != null) {
            cSC.pause();
        }
    }

    public void Cl(int i) {
        HotTopicView hotTopicView;
        if (this.ksC != null && i < this.ksC.size() && (hotTopicView = this.ksC.get(i)) != null) {
            hotTopicView.WX();
        }
    }

    public void Cm(int i) {
        HotTopicView hotTopicView;
        if (this.ksC != null && i < this.ksC.size() && (hotTopicView = this.ksC.get(i)) != null) {
            hotTopicView.WY();
        }
    }

    public void Cn(int i) {
        HotTopicView hotTopicView;
        if (this.ksC != null && i < this.ksC.size() && (hotTopicView = this.ksC.get(i)) != null) {
            hotTopicView.bSr();
        }
    }

    public void Co(int i) {
        for (HotTopicView hotTopicView : this.ksC) {
            if (hotTopicView != null && hotTopicView != cSC()) {
                hotTopicView.Cx(i);
            }
        }
    }

    public void aP(float f) {
        for (HotTopicView hotTopicView : this.ksC) {
            if (hotTopicView != null && hotTopicView != cSC()) {
                hotTopicView.aQ(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.ksE = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.ksC.get(i3);
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
