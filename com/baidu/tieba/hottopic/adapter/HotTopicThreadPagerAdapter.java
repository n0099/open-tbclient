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
    private static String[] gBu = {"最热", "最新"};
    private int ZQ = -1;
    private List<HotTopicView> jHB;
    private c.a jHC;
    private com.baidu.tieba.hottopic.view.c jHD;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.jHC = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jHB = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.jHC);
        hotTopicView2.setScrollCallback(this.jHC);
        this.jHB.add(hotTopicView);
        this.jHB.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dK(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cJQ();
    }

    private void cJQ() {
        if (this.ZQ >= 0) {
            HotTopicView hotTopicView = this.jHB.get(this.ZQ % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZQ);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.TK();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cKD())) {
                    hotTopicView.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void TK() {
        if (cJR() != null) {
            cJR().TK();
        }
    }

    public void showLoadingView() {
        if (cJR() != null) {
            cJR().hA(true);
        }
    }

    public void rd(boolean z) {
        if (this.jHB != null) {
            for (HotTopicView hotTopicView : this.jHB) {
                if (hotTopicView != null) {
                    hotTopicView.rd(z);
                }
            }
        }
    }

    public HotTopicView cJR() {
        if (this.ZQ == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.jHB, this.ZQ % 2);
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
                if (eVar != null && eVar.cKw() != null) {
                    if (this.ZQ == 0) {
                        TiebaStatic.log(new aq("c11970").dR("obj_id", eVar.cKw().eLl));
                    } else {
                        TiebaStatic.log(new aq("c11971").dR("obj_id", eVar.cKw().eLl));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.jHB, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.jHB, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cKD())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aQ(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.hA(true);
                        this.pageContext.getOrignalPage().cKd();
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
        HotTopicView hotTopicView = this.jHB.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.jHD);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.TK();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gBu[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void BL(int i) {
        if (!y.isEmpty(this.jHB)) {
            for (HotTopicView hotTopicView : this.jHB) {
                hotTopicView.BX(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.jHB) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cJR = cJR();
        if (cJR != null) {
            cJR.resume();
        }
    }

    public void pause() {
        HotTopicView cJR = cJR();
        if (cJR != null) {
            cJR.pause();
        }
    }

    public void BM(int i) {
        HotTopicView hotTopicView;
        if (this.jHB != null && i < this.jHB.size() && (hotTopicView = this.jHB.get(i)) != null) {
            hotTopicView.TI();
        }
    }

    public void BN(int i) {
        HotTopicView hotTopicView;
        if (this.jHB != null && i < this.jHB.size() && (hotTopicView = this.jHB.get(i)) != null) {
            hotTopicView.TJ();
        }
    }

    public void BO(int i) {
        HotTopicView hotTopicView;
        if (this.jHB != null && i < this.jHB.size() && (hotTopicView = this.jHB.get(i)) != null) {
            hotTopicView.bNw();
        }
    }

    public void BP(int i) {
        for (HotTopicView hotTopicView : this.jHB) {
            if (hotTopicView != null && hotTopicView != cJR()) {
                hotTopicView.BY(i);
            }
        }
    }

    public void aA(float f) {
        for (HotTopicView hotTopicView : this.jHB) {
            if (hotTopicView != null && hotTopicView != cJR()) {
                hotTopicView.aB(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.jHD = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.jHB.get(i3);
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
