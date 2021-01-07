package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    private BdUniqueId ahE;
    private ArrayList<com.baidu.tieba.ala.livecard.holder.a> hnp = new ArrayList<>();
    private List<bz> mDataList = new ArrayList();
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.ahE = bdUniqueId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void a(List<bz> list, com.baidu.tieba.ala.livecard.vc.c cVar) {
        com.baidu.tieba.ala.livecard.holder.a aVar;
        if (list != null && !list.isEmpty()) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            int size = this.hnp.size();
            int size2 = this.mDataList.size();
            if (size > size2) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2; i < size; i++) {
                    arrayList.add(this.hnp.get(i));
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    com.baidu.tieba.ala.livecard.holder.a aVar2 = (com.baidu.tieba.ala.livecard.holder.a) arrayList.get(i2);
                    if (aVar2.getRootView() != null && aVar2.getRootView().getParent() != null) {
                        ((ViewGroup) aVar2.getRootView().getParent()).removeView(aVar2.getRootView());
                    }
                    this.hnp.remove(aVar2);
                }
                arrayList.clear();
            }
            for (int i3 = 0; i3 < size2; i3++) {
                if (i3 >= size) {
                    com.baidu.tieba.ala.livecard.holder.a cbG = cbG();
                    cbG.o(this.mPageContext.getUniqueId());
                    cbG.a(cVar);
                    this.hnp.add(cbG);
                    aVar = cbG;
                } else {
                    aVar = this.hnp.get(i3);
                }
                if (this.mDataList.get(i3) != null && aVar != null) {
                    aVar.k(this.mDataList.get(i3), this.mForumName);
                }
            }
            notifyDataSetChanged();
        }
    }

    private com.baidu.tieba.ala.livecard.holder.a cbG() {
        return new com.baidu.tieba.ala.livecard.holder.a(this.mPageContext, this.ahE);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.hnp);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.hnp.get(i).getRootView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hnp == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.ala.livecard.holder.a aVar = (com.baidu.tieba.ala.livecard.holder.a) x.getItem(this.hnp, i);
        if (aVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (aVar.getRootView().getParent() == null) {
            viewGroup.addView(aVar.getRootView(), new ViewGroup.LayoutParams(-2, -2));
        }
        aVar.refreshView();
        aVar.getRootView().setTag(Integer.valueOf(i));
        return aVar.getRootView();
    }
}
