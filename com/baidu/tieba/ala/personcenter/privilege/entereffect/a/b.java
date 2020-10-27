package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private BdTypeListView gcr;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a hBi;
    private c hBj;
    private List<q> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.gcr = bdTypeListView;
        Ly();
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.hBi = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.bje.add(this.hBi);
        this.hBj = new c(this.mPageContext.getPageActivity());
        this.bje.add(this.hBj);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.gcr.setData(list);
            this.mDataList = this.gcr.getData();
        }
    }

    public void aD(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (q qVar : this.mDataList) {
                if (qVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                    if (str.equals(alaEnterEffectData.id)) {
                        alaEnterEffectData.use_status = z ? 1 : 0;
                    } else {
                        alaEnterEffectData.use_status = 0;
                    }
                    notifyDataSetChanged();
                }
            }
        }
    }

    public void aE(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (q qVar : this.mDataList) {
                if (qVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                    if (str.equals(alaEnterEffectData.id)) {
                        alaEnterEffectData.isOwn = z;
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    public void aJ(String str, int i) {
        if (!StringUtils.isNull(str) && this.mDataList != null) {
            for (q qVar : this.mDataList) {
                if (qVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) qVar;
                    if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                        alaEnterEffectData.downLoadStatus = i;
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            aVar.notifyDataSetChanged();
        }
    }
}
