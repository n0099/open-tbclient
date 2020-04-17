package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private BdTypeListView eOe;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a gcE;
    private c gcF;
    private List<m> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.eOe = bdTypeListView;
        BC();
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.gcE = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.aMd.add(this.gcE);
        this.gcF = new c(this.mPageContext.getPageActivity());
        this.aMd.add(this.gcF);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.eOe.setData(list);
            this.mDataList = this.eOe.getData();
        }
    }

    public void ag(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (m mVar : this.mDataList) {
                if (mVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) mVar;
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

    public void ah(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (m mVar : this.mDataList) {
                if (mVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) mVar;
                    if (str.equals(alaEnterEffectData.id)) {
                        alaEnterEffectData.isOwn = z;
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    public void aF(String str, int i) {
        if (!StringUtils.isNull(str) && this.mDataList != null) {
            for (m mVar : this.mDataList) {
                if (mVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) mVar;
                    if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                        alaEnterEffectData.downLoadStatus = i;
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            aVar.notifyDataSetChanged();
        }
    }
}
