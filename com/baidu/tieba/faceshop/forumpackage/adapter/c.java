package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView gAY;
    private b iYW;
    private d iYX;
    private TbPageContext mPageContext;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private final List<n> mListData = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        a(forumEmotionModel);
    }

    private void a(ForumEmotionModel forumEmotionModel) {
        this.iYW = new b(this.mPageContext, forumEmotionModel.cCT(), com.baidu.tieba.faceshop.forumpackage.data.c.iZk);
        this.boM.add(this.iYW);
        this.iYX = new d(this.mPageContext, forumEmotionModel.cCT(), com.baidu.tieba.faceshop.forumpackage.data.a.iZi);
        this.boM.add(this.iYX);
        this.gAY.addAdapters(this.boM);
    }

    public void a(a aVar) {
        this.iYW.a(aVar);
        this.iYX.a(aVar);
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            if (!x.isEmpty(this.mListData)) {
                this.mListData.clear();
            }
            if (this.gAY != null) {
                this.gAY.setData(list);
                this.mListData.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void cA(List<n> list) {
        if (!x.isEmpty(list)) {
            if (this.gAY != null) {
                this.mListData.addAll(list);
                this.gAY.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public int bHg() {
        return this.mListData.size();
    }

    public void a(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData != null && !x.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.faceshop.forumpackage.data.c) && (forumEmotionPackageData2 = ((com.baidu.tieba.faceshop.forumpackage.data.c) nVar).iZl) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                    forumEmotionPackageData2.download = forumEmotionPackageData.download;
                    forumEmotionPackageData2.share = forumEmotionPackageData.share;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && this.gAY.getAdapter() != null && (this.gAY.getAdapter() instanceof BaseAdapter)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
