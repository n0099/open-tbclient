package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gbK = {"最热", "最新"};
    private int Zf = -1;
    private List<HotTopicView> iXr;
    private c.a iXs;
    private com.baidu.tieba.hottopic.view.c iXt;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.iXs = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iXr = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.iXs);
        hotTopicView2.setScrollCallback(this.iXs);
        this.iXr.add(hotTopicView);
        this.iXr.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dq(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        czs();
    }

    private void czs() {
        if (this.Zf >= 0) {
            HotTopicView hotTopicView = this.iXr.get(this.Zf % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zf);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.bFW();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cAf())) {
                    hotTopicView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bFW() {
        if (czt() != null) {
            czt().bFW();
        }
    }

    public void showLoadingView() {
        if (czt() != null) {
            czt().gS(true);
        }
    }

    public void pV(boolean z) {
        if (this.iXr != null) {
            for (HotTopicView hotTopicView : this.iXr) {
                if (hotTopicView != null) {
                    hotTopicView.pV(z);
                }
            }
        }
    }

    public HotTopicView czt() {
        if (this.Zf == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.iXr, this.Zf % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Zf != i) {
            int i2 = this.Zf;
            this.Zf = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zf);
                if (eVar != null && eVar.czY() != null) {
                    if (this.Zf == 0) {
                        TiebaStatic.log(new aq("c11970").dD("obj_id", eVar.czY().eoj));
                    } else {
                        TiebaStatic.log(new aq("c11971").dD("obj_id", eVar.czY().eoj));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.iXr, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.iXr, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cAf())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.gS(true);
                        this.pageContext.getOrignalPage().czF();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: C */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.iXr.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.iXt);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.bFW();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gbK[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Al(int i) {
        if (!y.isEmpty(this.iXr)) {
            for (HotTopicView hotTopicView : this.iXr) {
                hotTopicView.Ax(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.iXr) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView czt = czt();
        if (czt != null) {
            czt.resume();
        }
    }

    public void pause() {
        HotTopicView czt = czt();
        if (czt != null) {
            czt.pause();
        }
    }

    public void Am(int i) {
        HotTopicView hotTopicView;
        if (this.iXr != null && i < this.iXr.size() && (hotTopicView = this.iXr.get(i)) != null) {
            hotTopicView.bGR();
        }
    }

    public void An(int i) {
        HotTopicView hotTopicView;
        if (this.iXr != null && i < this.iXr.size() && (hotTopicView = this.iXr.get(i)) != null) {
            hotTopicView.bGS();
        }
    }

    public void Ao(int i) {
        HotTopicView hotTopicView;
        if (this.iXr != null && i < this.iXr.size() && (hotTopicView = this.iXr.get(i)) != null) {
            hotTopicView.bGT();
        }
    }

    public void Ap(int i) {
        for (HotTopicView hotTopicView : this.iXr) {
            if (hotTopicView != null && hotTopicView != czt()) {
                hotTopicView.Ay(i);
            }
        }
    }

    public void as(float f) {
        for (HotTopicView hotTopicView : this.iXr) {
            if (hotTopicView != null && hotTopicView != czt()) {
                hotTopicView.at(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.iXt = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.iXr.get(i3);
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
