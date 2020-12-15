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
/* loaded from: classes21.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gPY = {"最热", "最新"};
    private int aaR = -1;
    private List<HotTopicView> kbO;
    private c.a kbP;
    private com.baidu.tieba.hottopic.view.c kbQ;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.kbP = aVar;
        com.baidu.adp.base.e<?> J = com.baidu.adp.base.i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kbO = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.kbP);
        hotTopicView2.setScrollCallback(this.kbP);
        this.kbO.add(hotTopicView);
        this.kbO.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ed(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cRn();
    }

    private void cRn() {
        if (this.aaR >= 0) {
            HotTopicView hotTopicView = this.kbO.get(this.aaR % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.aaR);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.Yb();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cSa())) {
                    hotTopicView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Yb() {
        if (cRo() != null) {
            cRo().Yb();
        }
    }

    public void showLoadingView() {
        if (cRo() != null) {
            cRo().ib(true);
        }
    }

    public void rR(boolean z) {
        if (this.kbO != null) {
            for (HotTopicView hotTopicView : this.kbO) {
                if (hotTopicView != null) {
                    hotTopicView.rR(z);
                }
            }
        }
    }

    public HotTopicView cRo() {
        if (this.aaR == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.kbO, this.aaR % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aaR != i) {
            int i2 = this.aaR;
            this.aaR = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.aaR);
                if (eVar != null && eVar.cRT() != null) {
                    if (this.aaR == 0) {
                        TiebaStatic.log(new ar("c11970").dY("obj_id", eVar.cRT().eXq));
                    } else {
                        TiebaStatic.log(new ar("c11971").dY("obj_id", eVar.cRT().eXq));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.kbO, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.kbO, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cSa())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.ib(true);
                        this.pageContext.getOrignalPage().cRA();
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
        HotTopicView hotTopicView = this.kbO.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.kbQ);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.Yb();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gPY[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Dl(int i) {
        if (!y.isEmpty(this.kbO)) {
            for (HotTopicView hotTopicView : this.kbO) {
                hotTopicView.Dx(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.kbO) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cRo = cRo();
        if (cRo != null) {
            cRo.resume();
        }
    }

    public void pause() {
        HotTopicView cRo = cRo();
        if (cRo != null) {
            cRo.pause();
        }
    }

    public void Dm(int i) {
        HotTopicView hotTopicView;
        if (this.kbO != null && i < this.kbO.size() && (hotTopicView = this.kbO.get(i)) != null) {
            hotTopicView.XZ();
        }
    }

    public void Dn(int i) {
        HotTopicView hotTopicView;
        if (this.kbO != null && i < this.kbO.size() && (hotTopicView = this.kbO.get(i)) != null) {
            hotTopicView.Ya();
        }
    }

    public void Do(int i) {
        HotTopicView hotTopicView;
        if (this.kbO != null && i < this.kbO.size() && (hotTopicView = this.kbO.get(i)) != null) {
            hotTopicView.bTb();
        }
    }

    public void Dp(int i) {
        for (HotTopicView hotTopicView : this.kbO) {
            if (hotTopicView != null && hotTopicView != cRo()) {
                hotTopicView.Dy(i);
            }
        }
    }

    public void aK(float f) {
        for (HotTopicView hotTopicView : this.kbO) {
            if (hotTopicView != null && hotTopicView != cRo()) {
                hotTopicView.aL(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.kbQ = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.kbO.get(i3);
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
