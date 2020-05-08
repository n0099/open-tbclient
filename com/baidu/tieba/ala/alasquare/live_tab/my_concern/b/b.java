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
    private static long dkQ = 604800000;
    private TbPageContext mTbPageContext;
    private List<m> eRx = new ArrayList();
    private List<m> eRy = new ArrayList();
    private List<m> eRz = new ArrayList();
    private List<m> eRA = new ArrayList();

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
        List<m> blA = blA();
        if (!v.isEmpty(blA)) {
            arrayList.addAll(blA);
        }
        return arrayList;
    }

    private List<m> blA() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eRA)) {
            g gVar = new g();
            gVar.eVF = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(br(this.eRA));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.eVF = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eRy)) {
                arrayList.addAll(blB());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dkQ ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dkQ ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.eRz) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.eRz)) {
                g gVar = new g();
                gVar.eVF = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eRz)) {
                for (m mVar : this.eRz) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> blB() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eRy)) {
            int size = this.eRy.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.eNR = (bj) this.eRy.get(i);
                cVar.isLeft = true;
                kVar.eQe = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.eNR = (bj) this.eRy.get(i + 1);
                    kVar.eQf = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.eNP = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.eQg = true;
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
                cVar2.eNR = (bj) list.get(i);
                cVar2.eNT = false;
                cVar.eQe = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.eNR = (bj) list.get(i + 1);
                    cVar3.eNT = false;
                    cVar.eRs = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.eNR = (bj) list.get(i + 2);
                    cVar4.eNT = false;
                    cVar.eQf = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.eRx)) {
            for (int size = this.eRx.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.eRx, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.eRx.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.eRx.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.eRy.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.eRz.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.eRA.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.eRx = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> blC() {
        return this.eRx;
    }

    public void clearData() {
        if (this.eRy != null) {
            this.eRy.clear();
        }
        if (this.eRz != null) {
            this.eRz.clear();
        }
        if (this.eRA != null) {
            this.eRA.clear();
        }
        if (this.eRx != null) {
            this.eRx.clear();
        }
    }
}
