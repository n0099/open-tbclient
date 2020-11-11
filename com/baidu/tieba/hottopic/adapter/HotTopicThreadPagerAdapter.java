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
/* loaded from: classes21.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gHi = {"最热", "最新"};
    private int ZQ = -1;
    private c.a jNA;
    private com.baidu.tieba.hottopic.view.c jNB;
    private List<HotTopicView> jNz;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.jNA = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jNz = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.jNA);
        hotTopicView2.setScrollCallback(this.jNA);
        this.jNz.add(hotTopicView);
        this.jNz.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dS(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cMr();
    }

    private void cMr() {
        if (this.ZQ >= 0) {
            HotTopicView hotTopicView = this.jNz.get(this.ZQ % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZQ);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.Wk();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cNe())) {
                    hotTopicView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Wk() {
        if (cMs() != null) {
            cMs().Wk();
        }
    }

    public void showLoadingView() {
        if (cMs() != null) {
            cMs().hJ(true);
        }
    }

    public void rm(boolean z) {
        if (this.jNz != null) {
            for (HotTopicView hotTopicView : this.jNz) {
                if (hotTopicView != null) {
                    hotTopicView.rm(z);
                }
            }
        }
    }

    public HotTopicView cMs() {
        if (this.ZQ == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.jNz, this.ZQ % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.ZQ != i) {
            int i2 = this.ZQ;
            this.ZQ = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZQ);
                if (eVar != null && eVar.cMX() != null) {
                    if (this.ZQ == 0) {
                        TiebaStatic.log(new aq("c11970").dR("obj_id", eVar.cMX().eRa));
                    } else {
                        TiebaStatic.log(new aq("c11971").dR("obj_id", eVar.cMX().eRa));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.jNz, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.jNz, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cNe())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.hJ(true);
                        this.pageContext.getOrignalPage().cME();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: G */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.jNz.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.jNB);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.Wk();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gHi[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void BY(int i) {
        if (!y.isEmpty(this.jNz)) {
            for (HotTopicView hotTopicView : this.jNz) {
                hotTopicView.Ck(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.jNz) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cMs = cMs();
        if (cMs != null) {
            cMs.resume();
        }
    }

    public void pause() {
        HotTopicView cMs = cMs();
        if (cMs != null) {
            cMs.pause();
        }
    }

    public void BZ(int i) {
        HotTopicView hotTopicView;
        if (this.jNz != null && i < this.jNz.size() && (hotTopicView = this.jNz.get(i)) != null) {
            hotTopicView.Wi();
        }
    }

    public void Ca(int i) {
        HotTopicView hotTopicView;
        if (this.jNz != null && i < this.jNz.size() && (hotTopicView = this.jNz.get(i)) != null) {
            hotTopicView.Wj();
        }
    }

    public void Cb(int i) {
        HotTopicView hotTopicView;
        if (this.jNz != null && i < this.jNz.size() && (hotTopicView = this.jNz.get(i)) != null) {
            hotTopicView.bPW();
        }
    }

    public void Cc(int i) {
        for (HotTopicView hotTopicView : this.jNz) {
            if (hotTopicView != null && hotTopicView != cMs()) {
                hotTopicView.Cl(i);
            }
        }
    }

    public void aC(float f) {
        for (HotTopicView hotTopicView : this.jNz) {
            if (hotTopicView != null && hotTopicView != cMs()) {
                hotTopicView.aD(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.jNB = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.jNz.get(i3);
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
