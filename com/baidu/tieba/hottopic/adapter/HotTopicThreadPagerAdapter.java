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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] fKq = {"最热", "最新"};
    private int YJ = -1;
    private List<HotTopicView> iCn;
    private c.a iCo;
    private com.baidu.tieba.hottopic.view.c iCp;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.iCo = aVar;
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iCn = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.iCo);
        hotTopicView2.setScrollCallback(this.iCo);
        this.iCn.add(hotTopicView);
        this.iCn.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return w.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void de(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!w.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        ckZ();
    }

    private void ckZ() {
        if (this.YJ >= 0) {
            HotTopicView hotTopicView = this.iCn.get(this.YJ % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) w.getItem(this.mHotTopicDataList, this.YJ);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.btO();
                hotTopicView.d(eVar);
                if (eVar == null || w.isEmpty(eVar.clM())) {
                    hotTopicView.aI(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void btO() {
        if (cla() != null) {
            cla().btO();
        }
    }

    public void showLoadingView() {
        if (cla() != null) {
            cla().ga(true);
        }
    }

    public void oK(boolean z) {
        if (this.iCn != null) {
            for (HotTopicView hotTopicView : this.iCn) {
                if (hotTopicView != null) {
                    hotTopicView.oK(z);
                }
            }
        }
    }

    public HotTopicView cla() {
        if (this.YJ == -1) {
            return null;
        }
        return (HotTopicView) w.getItem(this.iCn, this.YJ % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.YJ != i) {
            int i2 = this.YJ;
            this.YJ = i;
            if (!w.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) w.getItem(this.mHotTopicDataList, this.YJ);
                if (eVar != null && eVar.clF() != null) {
                    if (this.YJ == 0) {
                        TiebaStatic.log(new ao("c11970").dk("obj_id", eVar.clF().dYw));
                    } else {
                        TiebaStatic.log(new ao("c11971").dk("obj_id", eVar.clF().dYw));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) w.getItem(this.iCn, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) w.getItem(this.iCn, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || w.isEmpty(eVar.clM())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aI(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.ga(true);
                        this.pageContext.getOrignalPage().clm();
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
        HotTopicView hotTopicView = this.iCn.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.iCp);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.btO();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return fKq[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void xz(int i) {
        if (!w.isEmpty(this.iCn)) {
            for (HotTopicView hotTopicView : this.iCn) {
                hotTopicView.xL(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.iCn) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cla = cla();
        if (cla != null) {
            cla.resume();
        }
    }

    public void pause() {
        HotTopicView cla = cla();
        if (cla != null) {
            cla.pause();
        }
    }

    public void xA(int i) {
        HotTopicView hotTopicView;
        if (this.iCn != null && i < this.iCn.size() && (hotTopicView = this.iCn.get(i)) != null) {
            hotTopicView.buJ();
        }
    }

    public void xB(int i) {
        HotTopicView hotTopicView;
        if (this.iCn != null && i < this.iCn.size() && (hotTopicView = this.iCn.get(i)) != null) {
            hotTopicView.buK();
        }
    }

    public void xC(int i) {
        HotTopicView hotTopicView;
        if (this.iCn != null && i < this.iCn.size() && (hotTopicView = this.iCn.get(i)) != null) {
            hotTopicView.buL();
        }
    }

    public void xD(int i) {
        for (HotTopicView hotTopicView : this.iCn) {
            if (hotTopicView != null && hotTopicView != cla()) {
                hotTopicView.xM(i);
            }
        }
    }

    public void am(float f) {
        for (HotTopicView hotTopicView : this.iCn) {
            if (hotTopicView != null && hotTopicView != cla()) {
                hotTopicView.an(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.iCp = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.iCn.get(i3);
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
