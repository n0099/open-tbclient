package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    private BdUniqueId agC;
    private ArrayList<com.baidu.tieba.ala.livecard.holder.a> hnk = new ArrayList<>();
    private List<cb> mDataList = new ArrayList();
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.agC = bdUniqueId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void a(List<cb> list, com.baidu.tieba.ala.livecard.vc.c cVar) {
        com.baidu.tieba.ala.livecard.holder.a aVar;
        if (list != null && !list.isEmpty()) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            int size = this.hnk.size();
            int size2 = this.mDataList.size();
            if (size > size2) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2; i < size; i++) {
                    arrayList.add(this.hnk.get(i));
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    com.baidu.tieba.ala.livecard.holder.a aVar2 = (com.baidu.tieba.ala.livecard.holder.a) arrayList.get(i2);
                    if (aVar2.getRootView() != null && aVar2.getRootView().getParent() != null) {
                        ((ViewGroup) aVar2.getRootView().getParent()).removeView(aVar2.getRootView());
                    }
                    this.hnk.remove(aVar2);
                }
                arrayList.clear();
            }
            for (int i3 = 0; i3 < size2; i3++) {
                if (i3 >= size) {
                    com.baidu.tieba.ala.livecard.holder.a bYT = bYT();
                    bYT.o(this.mPageContext.getUniqueId());
                    bYT.a(cVar);
                    this.hnk.add(bYT);
                    aVar = bYT;
                } else {
                    aVar = this.hnk.get(i3);
                }
                if (this.mDataList.get(i3) != null && aVar != null) {
                    aVar.k(this.mDataList.get(i3), this.mForumName);
                }
            }
            notifyDataSetChanged();
        }
    }

    private com.baidu.tieba.ala.livecard.holder.a bYT() {
        return new com.baidu.tieba.ala.livecard.holder.a(this.mPageContext, this.agC);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.hnk);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.hnk.get(i).getRootView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hnk == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.ala.livecard.holder.a aVar = (com.baidu.tieba.ala.livecard.holder.a) y.getItem(this.hnk, i);
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
