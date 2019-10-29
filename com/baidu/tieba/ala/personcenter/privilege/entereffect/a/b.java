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
/* loaded from: classes6.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private BdTypeListView dvB;
    private com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a eAQ;
    private c eAR;
    private List<m> mDataList;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
    }

    public b(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.dvB = bdTypeListView;
        sX();
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.eAQ = new com.baidu.tieba.ala.personcenter.privilege.entereffect.a.a(this.mPageContext.getPageActivity());
        this.agQ.add(this.eAQ);
        this.eAR = new c(this.mPageContext.getPageActivity());
        this.agQ.add(this.eAR);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.dvB.setData(list);
            this.mDataList = this.dvB.getData();
        }
    }

    public void W(String str, boolean z) {
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

    public void X(String str, boolean z) {
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

    public void an(String str, int i) {
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
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            aVar.notifyDataSetChanged();
        }
    }
}
