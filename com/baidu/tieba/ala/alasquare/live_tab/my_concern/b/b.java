package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static long dLg = 604800000;
    private List<q> fuL = new ArrayList();
    private List<q> fuM = new ArrayList();
    private List<q> fuN = new ArrayList();
    private List<q> fuO = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<q> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<q> b = b(alaLiveTabMyConcernResponse, z);
        if (!x.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<q> b2 = b(alaLiveTabMyConcernResponse);
        if (!x.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<q> bxh = bxh();
        if (!x.isEmpty(bxh)) {
            arrayList.addAll(bxh);
        }
        return arrayList;
    }

    private List<q> bxh() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.fuO)) {
            g gVar = new g();
            gVar.fyU = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bz(this.fuO));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fyU = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.fuM)) {
                arrayList.addAll(bxi());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dLg ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dLg ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!x.isEmpty(this.fuN) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!x.isEmpty(this.fuN)) {
                g gVar = new g();
                gVar.fyU = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.fuN)) {
                for (q qVar : this.fuN) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bxi() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.fuM)) {
            int size = this.fuM.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.frb = (bv) this.fuM.get(i);
                cVar.isLeft = true;
                kVar.fts = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.frb = (bv) this.fuM.get(i + 1);
                    kVar.ftt = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.fqZ = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.ftu = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bz(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.frb = (bv) list.get(i);
                cVar2.fre = false;
                cVar.fts = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.frb = (bv) list.get(i + 1);
                    cVar3.fre = false;
                    cVar.fuG = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.frb = (bv) list.get(i + 2);
                    cVar4.fre = false;
                    cVar.ftt = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!x.isEmpty(this.fuL)) {
            for (int size = this.fuL.size() - 1; size >= 0; size--) {
                q qVar = (q) x.getItem(this.fuL, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fuL.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fuL.clear();
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fuM.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fuN.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fuO.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fuL = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bxj() {
        return this.fuL;
    }

    public void clearData() {
        if (this.fuM != null) {
            this.fuM.clear();
        }
        if (this.fuN != null) {
            this.fuN.clear();
        }
        if (this.fuO != null) {
            this.fuO.clear();
        }
        if (this.fuL != null) {
            this.fuL.clear();
        }
    }
}
