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
    private static String[] grq = {"最热", "最新"};
    private int ZP = -1;
    private List<HotTopicView> jvc;
    private c.a jvd;
    private com.baidu.tieba.hottopic.view.c jve;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.jvd = aVar;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mHotTopicDataList = new ArrayList();
        this.jvc = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.jvd);
        hotTopicView2.setScrollCallback(this.jvd);
        this.jvc.add(hotTopicView);
        this.jvc.add(hotTopicView2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mHotTopicDataList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void dB(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!y.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cGJ();
    }

    private void cGJ() {
        if (this.ZP >= 0) {
            HotTopicView hotTopicView = this.jvc.get(this.ZP % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZP);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.SK();
                hotTopicView.d(eVar);
                if (eVar == null || y.isEmpty(eVar.cHw())) {
                    hotTopicView.aO(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void SK() {
        if (cGK() != null) {
            cGK().SK();
        }
    }

    public void showLoadingView() {
        if (cGK() != null) {
            cGK().hn(true);
        }
    }

    public void qL(boolean z) {
        if (this.jvc != null) {
            for (HotTopicView hotTopicView : this.jvc) {
                if (hotTopicView != null) {
                    hotTopicView.qL(z);
                }
            }
        }
    }

    public HotTopicView cGK() {
        if (this.ZP == -1) {
            return null;
        }
        return (HotTopicView) y.getItem(this.jvc, this.ZP % 2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.ZP != i) {
            int i2 = this.ZP;
            this.ZP = i;
            if (!y.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) y.getItem(this.mHotTopicDataList, this.ZP);
                if (eVar != null && eVar.cHp() != null) {
                    if (this.ZP == 0) {
                        TiebaStatic.log(new aq("c11970").dK("obj_id", eVar.cHp().eCP));
                    } else {
                        TiebaStatic.log(new aq("c11971").dK("obj_id", eVar.cHp().eCP));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) y.getItem(this.jvc, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) y.getItem(this.jvc, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || y.isEmpty(eVar.cHw())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aO(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.hn(true);
                        this.pageContext.getOrignalPage().cGW();
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
        HotTopicView hotTopicView = this.jvc.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.jve);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.SK();
        hotTopicView.d(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return grq[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void Bs(int i) {
        if (!y.isEmpty(this.jvc)) {
            for (HotTopicView hotTopicView : this.jvc) {
                hotTopicView.BE(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.jvc) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cGK = cGK();
        if (cGK != null) {
            cGK.resume();
        }
    }

    public void pause() {
        HotTopicView cGK = cGK();
        if (cGK != null) {
            cGK.pause();
        }
    }

    public void Bt(int i) {
        HotTopicView hotTopicView;
        if (this.jvc != null && i < this.jvc.size() && (hotTopicView = this.jvc.get(i)) != null) {
            hotTopicView.SI();
        }
    }

    public void Bu(int i) {
        HotTopicView hotTopicView;
        if (this.jvc != null && i < this.jvc.size() && (hotTopicView = this.jvc.get(i)) != null) {
            hotTopicView.SJ();
        }
    }

    public void Bv(int i) {
        HotTopicView hotTopicView;
        if (this.jvc != null && i < this.jvc.size() && (hotTopicView = this.jvc.get(i)) != null) {
            hotTopicView.bKU();
        }
    }

    public void Bw(int i) {
        for (HotTopicView hotTopicView : this.jvc) {
            if (hotTopicView != null && hotTopicView != cGK()) {
                hotTopicView.BF(i);
            }
        }
    }

    public void ay(float f) {
        for (HotTopicView hotTopicView : this.jvc) {
            if (hotTopicView != null && hotTopicView != cGK()) {
                hotTopicView.az(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.jve = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.jvc.get(i3);
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
