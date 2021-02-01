package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView gzb;
    private b iZW;
    private d iZX;
    private TbPageContext mPageContext;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private final List<n> mListData = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.mPageContext = tbPageContext;
        this.gzb = bdTypeListView;
        a(forumEmotionModel);
    }

    private void a(ForumEmotionModel forumEmotionModel) {
        this.iZW = new b(this.mPageContext, forumEmotionModel.cAm(), com.baidu.tieba.faceshop.forumpackage.data.c.jak);
        this.bns.add(this.iZW);
        this.iZX = new d(this.mPageContext, forumEmotionModel.cAm(), com.baidu.tieba.faceshop.forumpackage.data.a.jai);
        this.bns.add(this.iZX);
        this.gzb.addAdapters(this.bns);
    }

    public void a(a aVar) {
        this.iZW.a(aVar);
        this.iZX.a(aVar);
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            if (!y.isEmpty(this.mListData)) {
                this.mListData.clear();
            }
            if (this.gzb != null) {
                this.gzb.setData(list);
                this.mListData.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void cv(List<n> list) {
        if (!y.isEmpty(list)) {
            if (this.gzb != null) {
                this.mListData.addAll(list);
                this.gzb.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public int bDF() {
        return this.mListData.size();
    }

    public void a(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData != null && !y.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.faceshop.forumpackage.data.c) && (forumEmotionPackageData2 = ((com.baidu.tieba.faceshop.forumpackage.data.c) nVar).jal) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                    forumEmotionPackageData2.download = forumEmotionPackageData.download;
                    forumEmotionPackageData2.share = forumEmotionPackageData.share;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzb != null && this.gzb.getAdapter() != null && (this.gzb.getAdapter() instanceof BaseAdapter)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}
