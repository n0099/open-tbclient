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
    private static String[] gbO = {"最热", "最新"};
    private int Zh = -1;
    private List<HotTopicView> iXx;
    private c.a iXy;
    private com.baidu.tieba.hottopic.view.c iXz;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.iXy = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iXx = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.iXy);
        hotTopicView2.setScrollCallback(this.iXy);
        this.iXx.add(hotTopicView);
        this.iXx.add(hotTopicView2);
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
        czt();
    }

    private void czt() {
        if (this.Zh >= 0) {
            HotTopicView hotTopicView = this.iXx.get(this.Zh % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zh);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.bFX();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cAg())) {
                    hotTopicView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bFX() {
        if (czu() != null) {
            czu().bFX();
        }
    }

    public void showLoadingView() {
        if (czu() != null) {
            czu().gT(true);
        }
    }

    public void pX(boolean z) {
        if (this.iXx != null) {
            for (HotTopicView hotTopicView : this.iXx) {
                if (hotTopicView != null) {
                    hotTopicView.pX(z);
                }
            }
        }
    }

    public HotTopicView czu() {
        if (this.Zh == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.iXx, this.Zh % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Zh != i) {
            int i2 = this.Zh;
            this.Zh = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zh);
                if (eVar != null && eVar.czZ() != null) {
                    if (this.Zh == 0) {
                        TiebaStatic.log(new aq("c11970").dD("obj_id", eVar.czZ().eon));
                    } else {
                        TiebaStatic.log(new aq("c11971").dD("obj_id", eVar.czZ().eon));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.iXx, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.iXx, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cAg())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.gT(true);
                        this.pageContext.getOrignalPage().czG();
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
        HotTopicView hotTopicView = this.iXx.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.iXz);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.bFX();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gbO[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Al(int i) {
        if (!y.isEmpty(this.iXx)) {
            for (HotTopicView hotTopicView : this.iXx) {
                hotTopicView.Ax(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.iXx) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView czu = czu();
        if (czu != null) {
            czu.resume();
        }
    }

    public void pause() {
        HotTopicView czu = czu();
        if (czu != null) {
            czu.pause();
        }
    }

    public void Am(int i) {
        HotTopicView hotTopicView;
        if (this.iXx != null && i < this.iXx.size() && (hotTopicView = this.iXx.get(i)) != null) {
            hotTopicView.bGS();
        }
    }

    public void An(int i) {
        HotTopicView hotTopicView;
        if (this.iXx != null && i < this.iXx.size() && (hotTopicView = this.iXx.get(i)) != null) {
            hotTopicView.bGT();
        }
    }

    public void Ao(int i) {
        HotTopicView hotTopicView;
        if (this.iXx != null && i < this.iXx.size() && (hotTopicView = this.iXx.get(i)) != null) {
            hotTopicView.bGU();
        }
    }

    public void Ap(int i) {
        for (HotTopicView hotTopicView : this.iXx) {
            if (hotTopicView != null && hotTopicView != czu()) {
                hotTopicView.Ay(i);
            }
        }
    }

    public void as(float f) {
        for (HotTopicView hotTopicView : this.iXx) {
            if (hotTopicView != null && hotTopicView != czu()) {
                hotTopicView.at(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.iXz = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.iXx.get(i3);
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
