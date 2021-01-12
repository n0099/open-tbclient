package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private BdTypeListView gwr;
    private AlaEnterEffectAdapter hYk;
    private AlaEnterEffectCategoryAdapter hYl;
    private List<n> mDataList;
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0691a {
    }

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.gwr = bdTypeListView;
        IY();
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.hYk = new AlaEnterEffectAdapter(this.mPageContext.getPageActivity());
        this.bjZ.add(this.hYk);
        this.hYl = new AlaEnterEffectCategoryAdapter(this.mPageContext.getPageActivity());
        this.bjZ.add(this.hYl);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            this.gwr.setData(list);
            this.mDataList = this.gwr.getData();
        }
    }

    public void aF(String str, boolean z) {
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

    public void aG(String str, boolean z) {
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            aVar.notifyDataSetChanged();
        }
    }
}
