package com.baidu.tieba.hottopic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.HotTopicView;
import com.baidu.tieba.hottopic.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicThreadPagerAdapter extends PagerAdapter {
    private static String[] gXf = {"最热", "最新"};
    private int abA = -1;
    private List<HotTopicView> kkv;
    private c.a kkw;
    private com.baidu.tieba.hottopic.view.c kkx;
    private List<com.baidu.tieba.hottopic.data.e> mHotTopicDataList;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicThreadPagerAdapter(Context context, c.a aVar) {
        this.kkw = aVar;
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mHotTopicDataList = new ArrayList();
        this.kkv = new ArrayList();
        HotTopicView hotTopicView = new HotTopicView(context);
        HotTopicView hotTopicView2 = new HotTopicView(context);
        hotTopicView.setScrollCallback(this.kkw);
        hotTopicView2.setScrollCallback(this.kkw);
        this.kkv.add(hotTopicView);
        this.kkv.add(hotTopicView2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.mHotTopicDataList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ek(List<com.baidu.tieba.hottopic.data.e> list) {
        if (!x.isEmpty(list)) {
            this.mHotTopicDataList.clear();
            this.mHotTopicDataList.addAll(list);
        }
        notifyDataSetChanged();
        cQC();
    }

    private void cQC() {
        if (this.abA >= 0) {
            HotTopicView hotTopicView = this.kkv.get(this.abA % 2);
            com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.abA);
            if (hotTopicView != null) {
                hotTopicView.hideLoadingView();
                hotTopicView.Vq();
                hotTopicView.c(eVar);
                if (eVar == null || x.isEmpty(eVar.cRp())) {
                    hotTopicView.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                }
            }
        }
    }

    public void Vq() {
        if (cQD() != null) {
            cQD().Vq();
        }
    }

    public void showLoadingView() {
        if (cQD() != null) {
            cQD().ip(true);
        }
    }

    public void sk(boolean z) {
        if (this.kkv != null) {
            for (HotTopicView hotTopicView : this.kkv) {
                if (hotTopicView != null) {
                    hotTopicView.sk(z);
                }
            }
        }
    }

    public HotTopicView cQD() {
        if (this.abA == -1) {
            return null;
        }
        return (HotTopicView) x.getItem(this.kkv, this.abA % 2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.abA != i) {
            int i2 = this.abA;
            this.abA = i;
            if (!x.isEmpty(this.mHotTopicDataList)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                com.baidu.tieba.hottopic.data.e eVar = (com.baidu.tieba.hottopic.data.e) x.getItem(this.mHotTopicDataList, this.abA);
                if (eVar != null && eVar.cRi() != null) {
                    if (this.abA == 0) {
                        TiebaStatic.log(new aq("c11970").dW("obj_id", eVar.cRi().fci));
                    } else {
                        TiebaStatic.log(new aq("c11971").dW("obj_id", eVar.cRi().fci));
                    }
                }
                HotTopicView hotTopicView = (HotTopicView) x.getItem(this.kkv, i2 % 2);
                if (hotTopicView != null) {
                    hotTopicView.pause();
                }
                HotTopicView hotTopicView2 = (HotTopicView) x.getItem(this.kkv, i % 2);
                if (hotTopicView2 != null) {
                    if (eVar == null || x.isEmpty(eVar.cRp())) {
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            hotTopicView2.aR(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                            return;
                        }
                        hotTopicView2.ip(true);
                        this.pageContext.getOrignalPage().cQP();
                        return;
                    }
                    hotTopicView2.resume();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: K */
    public HotTopicView instantiateItem(ViewGroup viewGroup, int i) {
        HotTopicView hotTopicView = this.kkv.get(i % 2);
        if (hotTopicView.getParent() != null) {
            viewGroup.removeView(hotTopicView);
        }
        hotTopicView.setMainView(this.kkx);
        viewGroup.addView(hotTopicView);
        hotTopicView.hideLoadingView();
        hotTopicView.Vq();
        hotTopicView.c(this.mHotTopicDataList.get(i));
        return hotTopicView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return gXf[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void BT(int i) {
        if (!x.isEmpty(this.kkv)) {
            for (HotTopicView hotTopicView : this.kkv) {
                hotTopicView.Cf(i);
            }
        }
    }

    public void destroy() {
        for (HotTopicView hotTopicView : this.kkv) {
            if (hotTopicView != null) {
                hotTopicView.destroy();
            }
        }
    }

    public void resume() {
        HotTopicView cQD = cQD();
        if (cQD != null) {
            cQD.resume();
        }
    }

    public void pause() {
        HotTopicView cQD = cQD();
        if (cQD != null) {
            cQD.pause();
        }
    }

    public void BU(int i) {
        HotTopicView hotTopicView;
        if (this.kkv != null && i < this.kkv.size() && (hotTopicView = this.kkv.get(i)) != null) {
            hotTopicView.Vo();
        }
    }

    public void BV(int i) {
        HotTopicView hotTopicView;
        if (this.kkv != null && i < this.kkv.size() && (hotTopicView = this.kkv.get(i)) != null) {
            hotTopicView.Vp();
        }
    }

    public void BW(int i) {
        HotTopicView hotTopicView;
        if (this.kkv != null && i < this.kkv.size() && (hotTopicView = this.kkv.get(i)) != null) {
            hotTopicView.bRO();
        }
    }

    public void BX(int i) {
        for (HotTopicView hotTopicView : this.kkv) {
            if (hotTopicView != null && hotTopicView != cQD()) {
                hotTopicView.Cg(i);
            }
        }
    }

    public void aM(float f) {
        for (HotTopicView hotTopicView : this.kkv) {
            if (hotTopicView != null && hotTopicView != cQD()) {
                hotTopicView.aN(f);
            }
        }
    }

    public void setMainView(com.baidu.tieba.hottopic.view.c cVar) {
        this.kkx = cVar;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHotTopicDataList.size()) {
                HotTopicView hotTopicView = this.kkv.get(i3);
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
