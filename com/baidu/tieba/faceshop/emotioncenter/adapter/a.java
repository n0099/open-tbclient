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
/* loaded from: classes9.dex */
public class a {
    private f eXW;
    private BdTypeListView gAY;
    private EmotionCategoryAdapter iXc;
    private EmotionHorizontalAdapter iXd;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private List<n> mListData = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eXW = tbPageContext;
        this.gAY = bdTypeListView;
        MT();
    }

    private void MT() {
        this.iXc = new EmotionCategoryAdapter((TbPageContext) this.eXW, com.baidu.tieba.faceshop.emotioncenter.data.a.iXf);
        this.iXd = new EmotionHorizontalAdapter((TbPageContext) this.eXW, b.iXg);
        this.boM.add(this.iXc);
        this.boM.add(this.iXd);
        this.gAY.addAdapters(this.boM);
    }

    public void setDatas(List<n> list) {
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

    public void cJ(List<n> list) {
        if (!x.isEmpty(list)) {
            if (this.gAY != null) {
                this.mListData.addAll(list);
                this.gAY.setData(this.mListData);
            }
            notifyDataSetChanged();
        }
    }

    public void a(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData != null && !x.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.iXh) != null && emotionPackageData2.id == emotionPackageData.id) {
                    emotionPackageData2.download = emotionPackageData.download;
                    emotionPackageData2.share = emotionPackageData.share;
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
