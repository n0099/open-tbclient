package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.widget.BaseAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private f eVB;
    private BdTypeListView gzp;
    private EmotionCategoryAdapter iYq;
    private EmotionHorizontalAdapter iYr;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private List<n> mListData = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eVB = tbPageContext;
        this.gzp = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.iYq = new EmotionCategoryAdapter((TbPageContext) this.eVB, com.baidu.tieba.faceshop.emotioncenter.data.a.iYt);
        this.iYr = new EmotionHorizontalAdapter((TbPageContext) this.eVB, b.iYu);
        this.bns.add(this.iYq);
        this.bns.add(this.iYr);
        this.gzp.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
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

    public void cE(List<n> list) {
        if (!y.isEmpty(list)) {
            if (this.gzp != null) {
                this.mListData.addAll(list);
                this.gzp.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public void a(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData != null && !y.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.iYv) != null && emotionPackageData2.id == emotionPackageData.id) {
                    emotionPackageData2.download = emotionPackageData.download;
                    emotionPackageData2.share = emotionPackageData.share;
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
