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
/* loaded from: classes8.dex */
public class c {
    private BdTypeListView gwr;
    private b iUp;
    private d iUq;
    private TbPageContext mPageContext;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private final List<n> mListData = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.mPageContext = tbPageContext;
        this.gwr = bdTypeListView;
        a(forumEmotionModel);
    }

    private void a(ForumEmotionModel forumEmotionModel) {
        this.iUp = new b(this.mPageContext, forumEmotionModel.czb(), com.baidu.tieba.faceshop.forumpackage.data.c.iUD);
        this.bjZ.add(this.iUp);
        this.iUq = new d(this.mPageContext, forumEmotionModel.czb(), com.baidu.tieba.faceshop.forumpackage.data.a.iUB);
        this.bjZ.add(this.iUq);
        this.gwr.addAdapters(this.bjZ);
    }

    public void a(a aVar) {
        this.iUp.a(aVar);
        this.iUq.a(aVar);
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            if (!x.isEmpty(this.mListData)) {
                this.mListData.clear();
            }
            if (this.gwr != null) {
                this.gwr.setData(list);
                this.mListData.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void cA(List<n> list) {
        if (!x.isEmpty(list)) {
            if (this.gwr != null) {
                this.mListData.addAll(list);
                this.gwr.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public int bDn() {
        return this.mListData.size();
    }

    public void a(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData != null && !x.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.faceshop.forumpackage.data.c) && (forumEmotionPackageData2 = ((com.baidu.tieba.faceshop.forumpackage.data.c) nVar).iUE) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                    forumEmotionPackageData2.download = forumEmotionPackageData.download;
                    forumEmotionPackageData2.share = forumEmotionPackageData.share;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr != null && this.gwr.getAdapter() != null && (this.gwr.getAdapter() instanceof BaseAdapter)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}
