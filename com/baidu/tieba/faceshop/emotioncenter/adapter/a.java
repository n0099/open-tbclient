package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.widget.BaseAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private f eTl;
    private BdTypeListView gwr;
    private EmotionCategoryAdapter iSv;
    private EmotionHorizontalAdapter iSw;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private List<n> mListData = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eTl = tbPageContext;
        this.gwr = bdTypeListView;
        IY();
    }

    private void IY() {
        this.iSv = new EmotionCategoryAdapter((TbPageContext) this.eTl, com.baidu.tieba.faceshop.emotioncenter.data.a.iSy);
        this.iSw = new EmotionHorizontalAdapter((TbPageContext) this.eTl, b.iSz);
        this.bjZ.add(this.iSv);
        this.bjZ.add(this.iSw);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setDatas(List<n> list) {
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

    public void cJ(List<n> list) {
        if (!x.isEmpty(list)) {
            if (this.gwr != null) {
                this.mListData.addAll(list);
                this.gwr.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public void a(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData != null && !x.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.iSA) != null && emotionPackageData2.id == emotionPackageData.id) {
                    emotionPackageData2.download = emotionPackageData.download;
                    emotionPackageData2.share = emotionPackageData.share;
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
