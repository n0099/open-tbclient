package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private static long dkM = 604800000;
    private List<m> eRs = new ArrayList();
    private List<m> eRt = new ArrayList();
    private List<m> eRu = new ArrayList();
    private List<m> eRv = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<m> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<m> b = b(alaLiveTabMyConcernResponse, z);
        if (!v.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<m> b2 = b(alaLiveTabMyConcernResponse);
        if (!v.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<m> blC = blC();
        if (!v.isEmpty(blC)) {
            arrayList.addAll(blC);
        }
        return arrayList;
    }

    private List<m> blC() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eRv)) {
            g gVar = new g();
            gVar.eVA = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(br(this.eRv));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.eVA = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eRt)) {
                arrayList.addAll(blD());
            } else if (z) {
                e eVar = new e();
                eVar.followStatus = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    private boolean a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        if (alaLiveTabMyConcernResponse == null) {
            return false;
        }
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dkM ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dkM ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.eRu) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.eRu)) {
                g gVar = new g();
                gVar.eVA = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eRu)) {
                for (m mVar : this.eRu) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> blD() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eRt)) {
            int size = this.eRt.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.eNM = (bj) this.eRt.get(i);
                cVar.isLeft = true;
                kVar.ePZ = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.eNM = (bj) this.eRt.get(i + 1);
                    kVar.eQa = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.eNK = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.eQb = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<m> br(List<m> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.eNM = (bj) list.get(i);
                cVar2.eNO = false;
                cVar.ePZ = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.eNM = (bj) list.get(i + 1);
                    cVar3.eNO = false;
                    cVar.eRn = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.eNM = (bj) list.get(i + 2);
                    cVar4.eNO = false;
                    cVar.eQa = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.eRs)) {
            for (int size = this.eRs.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.eRs, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.eRs.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.eRs.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.eRt.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.eRu.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.eRv.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.eRs = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> blE() {
        return this.eRs;
    }

    public void clearData() {
        if (this.eRt != null) {
            this.eRt.clear();
        }
        if (this.eRu != null) {
            this.eRu.clear();
        }
        if (this.eRv != null) {
            this.eRv.clear();
        }
        if (this.eRs != null) {
            this.eRs.clear();
        }
    }
}
