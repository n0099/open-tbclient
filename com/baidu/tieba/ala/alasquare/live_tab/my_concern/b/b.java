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
    private static long cLr = 604800000;
    private List<m> eno = new ArrayList();
    private List<m> enp = new ArrayList();
    private List<m> enq = new ArrayList();
    private List<m> enr = new ArrayList();
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
        List<m> bcE = bcE();
        if (!v.isEmpty(bcE)) {
            arrayList.addAll(bcE);
        }
        return arrayList;
    }

    private List<m> bcE() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.enr)) {
            g gVar = new g();
            gVar.eru = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bh(this.enr));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.eru = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enp)) {
                arrayList.addAll(bcF());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.j(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > cLr ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == cLr ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.enq) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.enq)) {
                g gVar = new g();
                gVar.eru = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enq)) {
                for (m mVar : this.enq) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> bcF() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.enp)) {
            int size = this.enp.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.ejI = (bj) this.enp.get(i);
                cVar.isLeft = true;
                kVar.elU = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.ejI = (bj) this.enp.get(i + 1);
                    kVar.elV = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.ejG = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.elW = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<m> bh(List<m> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.ejI = (bj) list.get(i);
                cVar2.ejK = false;
                cVar.elU = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.ejI = (bj) list.get(i + 1);
                    cVar3.ejK = false;
                    cVar.enj = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.ejI = (bj) list.get(i + 2);
                    cVar4.ejK = false;
                    cVar.elV = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.eno)) {
            for (int size = this.eno.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.eno, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.eno.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.eno.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.enp.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.enq.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.enr.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.eno = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> bcG() {
        return this.eno;
    }

    public void clearData() {
        if (this.enp != null) {
            this.enp.clear();
        }
        if (this.enq != null) {
            this.enq.clear();
        }
        if (this.enr != null) {
            this.enr.clear();
        }
        if (this.eno != null) {
            this.eno.clear();
        }
    }
}
