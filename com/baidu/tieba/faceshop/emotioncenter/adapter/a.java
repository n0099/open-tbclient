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
/* loaded from: classes8.dex */
public class a {
    private f eXa;
    private BdTypeListView gAY;
    private EmotionCategoryAdapter iZZ;
    private EmotionHorizontalAdapter jaa;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private List<n> mListData = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eXa = tbPageContext;
        this.gAY = bdTypeListView;
        Kz();
    }

    private void Kz() {
        this.iZZ = new EmotionCategoryAdapter((TbPageContext) this.eXa, com.baidu.tieba.faceshop.emotioncenter.data.a.jac);
        this.jaa = new EmotionHorizontalAdapter((TbPageContext) this.eXa, b.jad);
        this.boS.add(this.iZZ);
        this.boS.add(this.jaa);
        this.gAY.addAdapters(this.boS);
    }

    public void setDatas(List<n> list) {
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

    public void cE(List<n> list) {
        if (!y.isEmpty(list)) {
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
        if (emotionPackageData != null && !y.isEmpty(this.mListData)) {
            for (n nVar : this.mListData) {
                if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.jae) != null && emotionPackageData2.id == emotionPackageData.id) {
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
