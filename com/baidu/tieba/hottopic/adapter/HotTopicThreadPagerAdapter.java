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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gGP = {"最热", "最新"};
    private int ZV = -1;
    private List<HotTopicView> jOj;
    private c.a jOk;
    private com.baidu.tieba.hottopic.view.c jOl;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.jOk = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jOj = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.jOk);
        hotTopicView2.setScrollCallback(this.jOk);
        this.jOj.add(hotTopicView);
        this.jOj.add(hotTopicView2);
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
        cLY();
    }

    private void cLY() {
        if (this.ZV >= 0) {
            HotTopicView hotTopicView = this.jOj.get(this.ZV % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZV);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.VB();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cML())) {
                    hotTopicView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void VB() {
        if (cLZ() != null) {
            cLZ().VB();
        }
    }

    public void showLoadingView() {
        if (cLZ() != null) {
            cLZ().hM(true);
        }
    }

    public void rp(boolean z) {
        if (this.jOj != null) {
            for (HotTopicView hotTopicView : this.jOj) {
                if (hotTopicView != null) {
                    hotTopicView.rp(z);
                }
            }
        }
    }

    public HotTopicView cLZ() {
        if (this.ZV == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.jOj, this.ZV % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.ZV != i) {
            int i2 = this.ZV;
            this.ZV = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZV);
                if (eVar != null && eVar.cME() != null) {
                    if (this.ZV == 0) {
                        TiebaStatic.log(new ar("c11970").dR("obj_id", eVar.cME().eQb));
                    } else {
                        TiebaStatic.log(new ar("c11971").dR("obj_id", eVar.cME().eQb));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.jOj, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.jOj, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cML())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.hM(true);
                        this.pageContext.getOrignalPage().cMl();
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
        HotTopicView hotTopicView = this.jOj.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.jOl);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.VB();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gGP[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Cw(int i) {
        if (!y.isEmpty(this.jOj)) {
            for (HotTopicView hotTopicView : this.jOj) {
                hotTopicView.CI(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.jOj) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cLZ = cLZ();
        if (cLZ != null) {
            cLZ.resume();
        }
    }

    public void pause() {
        HotTopicView cLZ = cLZ();
        if (cLZ != null) {
            cLZ.pause();
        }
    }

    public void Cx(int i) {
        HotTopicView hotTopicView;
        if (this.jOj != null && i < this.jOj.size() && (hotTopicView = this.jOj.get(i)) != null) {
            hotTopicView.Vz();
        }
    }

    public void Cy(int i) {
        HotTopicView hotTopicView;
        if (this.jOj != null && i < this.jOj.size() && (hotTopicView = this.jOj.get(i)) != null) {
            hotTopicView.VA();
        }
    }

    public void Cz(int i) {
        HotTopicView hotTopicView;
        if (this.jOj != null && i < this.jOj.size() && (hotTopicView = this.jOj.get(i)) != null) {
            hotTopicView.bPp();
        }
    }

    public void CA(int i) {
        for (HotTopicView hotTopicView : this.jOj) {
            if (hotTopicView != null && hotTopicView != cLZ()) {
                hotTopicView.CJ(i);
            }
        }
    }

    public void aJ(float f) {
        for (HotTopicView hotTopicView : this.jOj) {
            if (hotTopicView != null && hotTopicView != cLZ()) {
                hotTopicView.aK(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.jOl = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.jOj.get(i3);
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
