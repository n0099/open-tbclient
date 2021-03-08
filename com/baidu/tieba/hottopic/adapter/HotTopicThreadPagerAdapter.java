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
/* loaded from: classes7.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] hbM = {"最热", "最新"};
    private int acR = -1;
    private List<HotTopicView> kuS;
    private c.a kuT;
    private com.baidu.tieba.hottopic.view.c kuU;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.kuT = aVar;
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kuS = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.kuT);
        hotTopicView2.setScrollCallback(this.kuT);
        this.kuS.add(hotTopicView);
        this.kuS.add(hotTopicView2);
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
        cSP();
    }

    private void cSP() {
        if (this.acR >= 0) {
            HotTopicView hotTopicView = this.kuS.get(this.acR % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.acR);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.Xc();
                hotTopicView.c(eVar);
                if (eVar == null || y.isEmpty(eVar.cTC())) {
                    hotTopicView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Xc() {
        if (cSQ() != null) {
            cSQ().Xc();
        }
    }

    public void showLoadingView() {
        if (cSQ() != null) {
            cSQ().ir(true);
        }
    }

    public void sx(boolean z) {
        if (this.kuS != null) {
            for (HotTopicView hotTopicView : this.kuS) {
                if (hotTopicView != null) {
                    hotTopicView.sx(z);
                }
            }
        }
    }

    public HotTopicView cSQ() {
        if (this.acR == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.kuS, this.acR % 2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.acR != i) {
            int i2 = this.acR;
            this.acR = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.acR);
                if (eVar != null && eVar.cTv() != null) {
                    if (this.acR == 0) {
                        TiebaStatic.log(new ar("c11970").dR("obj_id", eVar.cTv().ffX));
                    } else {
                        TiebaStatic.log(new ar("c11971").dR("obj_id", eVar.cTv().ffX));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.kuS, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.kuS, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cTC())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.ir(true);
                        this.pageContext.getOrignalPage().cTc();
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
        HotTopicView hotTopicView = this.kuS.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.kuU);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.Xc();
        hotTopicView.c(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return hbM[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Cn(int i) {
        if (!y.isEmpty(this.kuS)) {
            for (HotTopicView hotTopicView : this.kuS) {
                hotTopicView.Cz(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.kuS) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cSQ = cSQ();
        if (cSQ != null) {
            cSQ.resume();
        }
    }

    public void pause() {
        HotTopicView cSQ = cSQ();
        if (cSQ != null) {
            cSQ.pause();
        }
    }

    public void Co(int i) {
        HotTopicView hotTopicView;
        if (this.kuS != null && i < this.kuS.size() && (hotTopicView = this.kuS.get(i)) != null) {
            hotTopicView.Xa();
        }
    }

    public void Cp(int i) {
        HotTopicView hotTopicView;
        if (this.kuS != null && i < this.kuS.size() && (hotTopicView = this.kuS.get(i)) != null) {
            hotTopicView.Xb();
        }
    }

    public void Cq(int i) {
        HotTopicView hotTopicView;
        if (this.kuS != null && i < this.kuS.size() && (hotTopicView = this.kuS.get(i)) != null) {
            hotTopicView.bSE();
        }
    }

    public void Cr(int i) {
        for (HotTopicView hotTopicView : this.kuS) {
            if (hotTopicView != null && hotTopicView != cSQ()) {
                hotTopicView.CA(i);
            }
        }
    }

    public void aT(float f) {
        for (HotTopicView hotTopicView : this.kuS) {
            if (hotTopicView != null && hotTopicView != cSQ()) {
                hotTopicView.aU(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.kuU = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.kuS.get(i3);
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
