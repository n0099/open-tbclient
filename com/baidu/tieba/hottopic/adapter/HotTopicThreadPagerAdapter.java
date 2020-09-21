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
/* loaded from: classes20.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gfb = {"最热", "最新"};
    private int Zz = -1;
    private List<HotTopicView> jgd;
    private c.a jge;
    private com.baidu.tieba.hottopic.view.c jgf;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.jge = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jgd = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.jge);
        hotTopicView2.setScrollCallback(this.jge);
        this.jgd.add(hotTopicView);
        this.jgd.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dy(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cDa();
    }

    private void cDa() {
        if (this.Zz >= 0) {
            HotTopicView hotTopicView = this.jgd.get(this.Zz % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zz);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.bHn();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cDN())) {
                    hotTopicView.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bHn() {
        if (cDb() != null) {
            cDb().bHn();
        }
    }

    public void showLoadingView() {
        if (cDb() != null) {
            cDb().gR(true);
        }
    }

    public void qf(boolean z) {
        if (this.jgd != null) {
            for (HotTopicView hotTopicView : this.jgd) {
                if (hotTopicView != null) {
                    hotTopicView.qf(z);
                }
            }
        }
    }

    public HotTopicView cDb() {
        if (this.Zz == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.jgd, this.Zz % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Zz != i) {
            int i2 = this.Zz;
            this.Zz = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.Zz);
                if (eVar != null && eVar.cDG() != null) {
                    if (this.Zz == 0) {
                        TiebaStatic.log(new aq("c11970").dF("obj_id", eVar.cDG().eqD));
                    } else {
                        TiebaStatic.log(new aq("c11971").dF("obj_id", eVar.cDG().eqD));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.jgd, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.jgd, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cDN())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aK(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.gR(true);
                        this.pageContext.getOrignalPage().cDn();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: E */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.jgd.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.jgf);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.bHn();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gfb[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void AM(int i) {
        if (!y.isEmpty(this.jgd)) {
            for (HotTopicView hotTopicView : this.jgd) {
                hotTopicView.AY(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.jgd) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cDb = cDb();
        if (cDb != null) {
            cDb.resume();
        }
    }

    public void pause() {
        HotTopicView cDb = cDb();
        if (cDb != null) {
            cDb.pause();
        }
    }

    public void AN(int i) {
        HotTopicView hotTopicView;
        if (this.jgd != null && i < this.jgd.size() && (hotTopicView = this.jgd.get(i)) != null) {
            hotTopicView.bIi();
        }
    }

    public void AO(int i) {
        HotTopicView hotTopicView;
        if (this.jgd != null && i < this.jgd.size() && (hotTopicView = this.jgd.get(i)) != null) {
            hotTopicView.bIj();
        }
    }

    public void AP(int i) {
        HotTopicView hotTopicView;
        if (this.jgd != null && i < this.jgd.size() && (hotTopicView = this.jgd.get(i)) != null) {
            hotTopicView.bIk();
        }
    }

    public void AQ(int i) {
        for (HotTopicView hotTopicView : this.jgd) {
            if (hotTopicView != null && hotTopicView != cDb()) {
                hotTopicView.AZ(i);
            }
        }
    }

    public void as(float f) {
        for (HotTopicView hotTopicView : this.jgd) {
            if (hotTopicView != null && hotTopicView != cDb()) {
                hotTopicView.at(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.jgf = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.jgd.get(i3);
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
