package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private BdTypeListView fml;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a gEC;
    private c gED;
    private List<q> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.fml = bdTypeListView;
        Dz();
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.gEC = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.aUP.add(this.gEC);
        this.gED = new c(this.mPageContext.getPageActivity());
        this.aUP.add(this.gED);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        if (!w.isEmpty(list)) {
            this.fml.setData(list);
            this.mDataList = this.fml.getData();
        }
    }

    public void av(String str, boolean z) {
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

    public void aw(String str, boolean z) {
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

    public void aF(String str, int i) {
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
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            aVar.notifyDataSetChanged();
        }
    }
}
