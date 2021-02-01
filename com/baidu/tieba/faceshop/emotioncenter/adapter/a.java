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
    private BdTypeListView gzb;
    private EmotionCategoryAdapter iYc;
    private EmotionHorizontalAdapter iYd;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private List<n> mListData = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eVB = tbPageContext;
        this.gzb = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.iYc = new EmotionCategoryAdapter((TbPageContext) this.eVB, com.baidu.tieba.faceshop.emotioncenter.data.a.iYf);
        this.iYd = new EmotionHorizontalAdapter((TbPageContext) this.eVB, b.iYg);
        this.bns.add(this.iYc);
        this.bns.add(this.iYd);
        this.gzb.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
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

    public void cE(List<n> list) {
        if (!y.isEmpty(list)) {
            if (this.gzb != null) {
                this.mListData.addAll(list);
                this.gzb.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public void a(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData != null && !y.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.iYh) != null && emotionPackageData2.id == emotionPackageData.id) {
                    emotionPackageData2.download = emotionPackageData.download;
                    emotionPackageData2.share = emotionPackageData.share;
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
