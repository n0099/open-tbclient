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
/* loaded from: classes8.dex */
public class c {
    private BdTypeListView gAY;
    private b jbT;
    private d jbU;
    private TbPageContext mPageContext;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private final List<n> mListData = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.mPageContext = tbPageContext;
        this.gAY = bdTypeListView;
        a(forumEmotionModel);
    }

    private void a(ForumEmotionModel forumEmotionModel) {
        this.jbT = new b(this.mPageContext, forumEmotionModel.cAz(), com.baidu.tieba.faceshop.forumpackage.data.c.jch);
        this.boS.add(this.jbT);
        this.jbU = new d(this.mPageContext, forumEmotionModel.cAz(), com.baidu.tieba.faceshop.forumpackage.data.a.jcf);
        this.boS.add(this.jbU);
        this.gAY.addAdapters(this.boS);
    }

    public void a(a aVar) {
        this.jbT.a(aVar);
        this.jbU.a(aVar);
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            if (!y.isEmpty(this.mListData)) {
                this.mListData.clear();
            }
            if (this.gAY != null) {
                this.gAY.setData(list);
                this.mListData.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void cv(List<n> list) {
        if (!y.isEmpty(list)) {
            if (this.gAY != null) {
                this.mListData.addAll(list);
                this.gAY.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public int bDI() {
        return this.mListData.size();
    }

    public void a(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData != null && !y.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.faceshop.forumpackage.data.c) && (forumEmotionPackageData2 = ((com.baidu.tieba.faceshop.forumpackage.data.c) nVar).jci) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
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
