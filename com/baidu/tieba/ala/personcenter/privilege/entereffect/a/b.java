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
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private BdTypeListView fGf;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a ham;
    private c han;
    private List<q> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.fGf = bdTypeListView;
        JZ();
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.ham = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.bdV.add(this.ham);
        this.han = new c(this.mPageContext.getPageActivity());
        this.bdV.add(this.han);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.fGf.setData(list);
            this.mDataList = this.fGf.getData();
        }
    }

    public void ax(String str, boolean z) {
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

    public void ay(String str, boolean z) {
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

    public void aH(String str, int i) {
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            aVar.notifyDataSetChanged();
        }
    }
}
