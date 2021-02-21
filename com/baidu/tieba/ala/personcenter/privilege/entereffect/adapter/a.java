package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private BdTypeListView gzp;
    private AlaEnterEffectAdapter icS;
    private AlaEnterEffectCategoryAdapter icT;
    private List<n> mDataList;
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0692a {
    }

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.gzp = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.icS = new AlaEnterEffectAdapter(this.mPageContext.getPageActivity());
        this.bns.add(this.icS);
        this.icT = new AlaEnterEffectCategoryAdapter(this.mPageContext.getPageActivity());
        this.bns.add(this.icT);
        this.gzp.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.gzp.setData(list);
            this.mDataList = this.gzp.getData();
        }
    }

    public void aE(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (n nVar : this.mDataList) {
                if (nVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
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

    public void aF(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (n nVar : this.mDataList) {
                if (nVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                    if (str.equals(alaEnterEffectData.id)) {
                        alaEnterEffectData.isOwn = z;
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    public void aT(String str, int i) {
        if (!StringUtils.isNull(str) && this.mDataList != null) {
            for (n nVar : this.mDataList) {
                if (nVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                    if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                        alaEnterEffectData.downLoadStatus = i;
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            aVar.notifyDataSetChanged();
        }
    }
}
