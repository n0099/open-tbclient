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
    private BdTypeListView gzp;
    private b jak;
    private d jal;
    private TbPageContext mPageContext;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private final List<n> mListData = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.mPageContext = tbPageContext;
        this.gzp = bdTypeListView;
        a(forumEmotionModel);
    }

    private void a(ForumEmotionModel forumEmotionModel) {
        this.jak = new b(this.mPageContext, forumEmotionModel.cAt(), com.baidu.tieba.faceshop.forumpackage.data.c.jay);
        this.bns.add(this.jak);
        this.jal = new d(this.mPageContext, forumEmotionModel.cAt(), com.baidu.tieba.faceshop.forumpackage.data.a.jaw);
        this.bns.add(this.jal);
        this.gzp.addAdapters(this.bns);
    }

    public void a(a aVar) {
        this.jak.a(aVar);
        this.jal.a(aVar);
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            if (!y.isEmpty(this.mListData)) {
                this.mListData.clear();
            }
            if (this.gzp != null) {
                this.gzp.setData(list);
                this.mListData.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void cv(List<n> list) {
        if (!y.isEmpty(list)) {
            if (this.gzp != null) {
                this.mListData.addAll(list);
                this.gzp.setData(this.mListData);
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
                if (nVar != null && (nVar instanceof com.baidu.tieba.faceshop.forumpackage.data.c) && (forumEmotionPackageData2 = ((com.baidu.tieba.faceshop.forumpackage.data.c) nVar).jaz) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                    forumEmotionPackageData2.download = forumEmotionPackageData.download;
                    forumEmotionPackageData2.share = forumEmotionPackageData.share;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzp != null && this.gzp.getAdapter() != null && (this.gzp.getAdapter() instanceof BaseAdapter)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }
}
