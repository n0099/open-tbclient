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
/* loaded from: classes6.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private BdTypeListView gpZ;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a hQv;
    private c hQw;
    private List<q> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.gpZ = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.hQv = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.bnf.add(this.hQv);
        this.hQw = new c(this.mPageContext.getPageActivity());
        this.bnf.add(this.hQw);
        this.gpZ.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.gpZ.setData(list);
            this.mDataList = this.gpZ.getData();
        }
    }

    public void aE(String str, boolean z) {
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

    public void aF(String str, boolean z) {
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

    public void aL(String str, int i) {
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
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            aVar.notifyDataSetChanged();
        }
    }
}
