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
    private static long cLs = 604800000;
    private List<m> enp = new ArrayList();
    private List<m> enq = new ArrayList();
    private List<m> enr = new ArrayList();
    private List<m> ens = new ArrayList();
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
        List<m> bcG = bcG();
        if (!v.isEmpty(bcG)) {
            arrayList.addAll(bcG);
        }
        return arrayList;
    }

    private List<m> bcG() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.ens)) {
            g gVar = new g();
            gVar.erv = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bh(this.ens));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.erv = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enq)) {
                arrayList.addAll(bcH());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.j(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > cLs ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == cLs ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.enr) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.enr)) {
                g gVar = new g();
                gVar.erv = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enr)) {
                for (m mVar : this.enr) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> bcH() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.enq)) {
            int size = this.enq.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.ejJ = (bj) this.enq.get(i);
                cVar.isLeft = true;
                kVar.elV = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.ejJ = (bj) this.enq.get(i + 1);
                    kVar.elW = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.ejH = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.elX = true;
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
                cVar2.ejJ = (bj) list.get(i);
                cVar2.ejL = false;
                cVar.elV = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.ejJ = (bj) list.get(i + 1);
                    cVar3.ejL = false;
                    cVar.enk = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.ejJ = (bj) list.get(i + 2);
                    cVar4.ejL = false;
                    cVar.elW = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.enp)) {
            for (int size = this.enp.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.enp, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.enp.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.enp.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.enq.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.enr.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.ens.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.enp = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> bcI() {
        return this.enp;
    }

    public void clearData() {
        if (this.enq != null) {
            this.enq.clear();
        }
        if (this.enr != null) {
            this.enr.clear();
        }
        if (this.ens != null) {
            this.ens.clear();
        }
        if (this.enp != null) {
            this.enp.clear();
        }
    }
}
