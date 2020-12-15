package com.baidu.tieba.ala.livecard.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsAlaStageLiveViewItemAdapter extends PagerAdapter {
    private BdUniqueId ajD;
    private ArrayList<com.baidu.tieba.ala.livecard.a.d> hbD = new ArrayList<>();
    private List<by> mDataList = new ArrayList();
    private String mForumName;
    private TbPageContext<?> mPageContext;

    public FrsAlaStageLiveViewItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.ajD = bdUniqueId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void a(List<by> list, com.baidu.tieba.ala.livecard.vc.c cVar) {
        com.baidu.tieba.ala.livecard.a.d dVar;
        if (list != null && !list.isEmpty()) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            int size = this.hbD.size();
            int size2 = this.mDataList.size();
            if (size > size2) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2; i < size; i++) {
                    arrayList.add(this.hbD.get(i));
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    com.baidu.tieba.ala.livecard.a.d dVar2 = (com.baidu.tieba.ala.livecard.a.d) arrayList.get(i2);
                    if (dVar2.getRootView() != null && dVar2.getRootView().getParent() != null) {
                        ((ViewGroup) dVar2.getRootView().getParent()).removeView(dVar2.getRootView());
                    }
                    this.hbD.remove(dVar2);
                }
                arrayList.clear();
            }
            for (int i3 = 0; i3 < size2; i3++) {
                if (i3 >= size) {
                    com.baidu.tieba.ala.livecard.a.d bYY = bYY();
                    bYY.o(this.mPageContext.getUniqueId());
                    bYY.a(cVar);
                    this.hbD.add(bYY);
                    dVar = bYY;
                } else {
                    dVar = this.hbD.get(i3);
                }
                if (this.mDataList.get(i3) != null && dVar != null) {
                    dVar.k(this.mDataList.get(i3), this.mForumName);
                }
            }
            notifyDataSetChanged();
        }
    }

    private com.baidu.tieba.ala.livecard.a.d bYY() {
        return new com.baidu.tieba.ala.livecard.a.d(this.mPageContext, this.ajD);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.hbD);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.hbD.get(i).getRootView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hbD == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.ala.livecard.a.d dVar = (com.baidu.tieba.ala.livecard.a.d) y.getItem(this.hbD, i);
        if (dVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (dVar.getRootView().getParent() == null) {
            viewGroup.addView(dVar.getRootView(), new ViewGroup.LayoutParams(-2, -2));
        }
        dVar.refreshView();
        dVar.getRootView().setTag(Integer.valueOf(i));
        return dVar.getRootView();
    }
}
