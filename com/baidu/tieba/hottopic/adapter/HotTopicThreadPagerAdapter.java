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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] fPL = {"最热", "最新"};
    private int Yz = -1;
    private List<HotTopicView> iIr;
    private c.a iIs;
    private com.baidu.tieba.hottopic.view.c iIt;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.iIs = aVar;
        com.baidu.adp.base.e<?> G = com.baidu.adp.base.i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.mHotTopicDataList = new ArrayList();
        this.iIr = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.iIs);
        hotTopicView2.setScrollCallback(this.iIs);
        this.iIr.add(hotTopicView);
        this.iIr.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return x.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dj(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!x.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        coz();
    }

    private void coz() {
        if (this.Yz >= 0) {
            HotTopicView hotTopicView = this.iIr.get(this.Yz % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.Yz);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.bwX();
                hotTopicView.d(eVar);
                if (eVar == null || x.isEmpty(eVar.cpm())) {
                    hotTopicView.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void bwX() {
        if (coA() != null) {
            coA().bwX();
        }
    }

    public void showLoadingView() {
        if (coA() != null) {
            coA().gw(true);
        }
    }

    public void pp(boolean z) {
        if (this.iIr != null) {
            for (HotTopicView hotTopicView : this.iIr) {
                if (hotTopicView != null) {
                    hotTopicView.pp(z);
                }
            }
        }
    }

    public HotTopicView coA() {
        if (this.Yz == -1) {
            return null;
        }
        return (HotTopicView) x.getItem(this.iIr, this.Yz % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Yz != i) {
            int i2 = this.Yz;
            this.Yz = i;
            if (!x.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.Yz);
                if (eVar != null && eVar.cpf() != null) {
                    if (this.Yz == 0) {
                        TiebaStatic.log(new ap("c11970").dn("obj_id", eVar.cpf().eeI));
                    } else {
                        TiebaStatic.log(new ap("c11971").dn("obj_id", eVar.cpf().eeI));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) x.getItem(this.iIr, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) x.getItem(this.iIr, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || x.isEmpty(eVar.cpm())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aG(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.gw(true);
                        this.pageContext.getOrignalPage().coM();
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
        HotTopicView hotTopicView = this.iIr.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.iIt);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.bwX();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return fPL[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void xR(int i) {
        if (!x.isEmpty(this.iIr)) {
            for (HotTopicView hotTopicView : this.iIr) {
                hotTopicView.yd(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.iIr) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView coA = coA();
        if (coA != null) {
            coA.resume();
        }
    }

    public void pause() {
        HotTopicView coA = coA();
        if (coA != null) {
            coA.pause();
        }
    }

    public void xS(int i) {
        HotTopicView hotTopicView;
        if (this.iIr != null && i < this.iIr.size() && (hotTopicView = this.iIr.get(i)) != null) {
            hotTopicView.bxS();
        }
    }

    public void xT(int i) {
        HotTopicView hotTopicView;
        if (this.iIr != null && i < this.iIr.size() && (hotTopicView = this.iIr.get(i)) != null) {
            hotTopicView.bxT();
        }
    }

    public void xU(int i) {
        HotTopicView hotTopicView;
        if (this.iIr != null && i < this.iIr.size() && (hotTopicView = this.iIr.get(i)) != null) {
            hotTopicView.bxU();
        }
    }

    public void xV(int i) {
        for (HotTopicView hotTopicView : this.iIr) {
            if (hotTopicView != null && hotTopicView != coA()) {
                hotTopicView.ye(i);
            }
        }
    }

    public void am(float f) {
        for (HotTopicView hotTopicView : this.iIr) {
            if (hotTopicView != null && hotTopicView != coA()) {
                hotTopicView.an(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.iIt = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.iIr.get(i3);
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
