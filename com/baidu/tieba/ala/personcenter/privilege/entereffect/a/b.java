package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private BdTypeListView fbb;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a grO;
    private c grP;
    private List<o> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.fbb = bdTypeListView;
        CY();
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.grO = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.aSj.add(this.grO);
        this.grP = new c(this.mPageContext.getPageActivity());
        this.aSj.add(this.grP);
        this.fbb.addAdapters(this.aSj);
    }

    public void setData(List<o> list) {
        if (!v.isEmpty(list)) {
            this.fbb.setData(list);
            this.mDataList = this.fbb.getData();
        }
    }

    public void at(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (o oVar : this.mDataList) {
                if (oVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) oVar;
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

    public void au(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mDataList != null) {
            for (o oVar : this.mDataList) {
                if (oVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) oVar;
                    if (str.equals(alaEnterEffectData.id)) {
                        alaEnterEffectData.isOwn = z;
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    public void aG(String str, int i) {
        if (!StringUtils.isNull(str) && this.mDataList != null) {
            for (o oVar : this.mDataList) {
                if (oVar instanceof AlaEnterEffectData) {
                    AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) oVar;
                    if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                        alaEnterEffectData.downLoadStatus = i;
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            aVar.notifyDataSetChanged();
        }
    }
}
