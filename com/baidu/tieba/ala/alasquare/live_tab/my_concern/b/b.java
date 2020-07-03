package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
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
    private static long dFj = 604800000;
    private List<q> fpB = new ArrayList();
    private List<q> fpC = new ArrayList();
    private List<q> fpD = new ArrayList();
    private List<q> fpE = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<q> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<q> b = b(alaLiveTabMyConcernResponse, z);
        if (!w.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<q> b2 = b(alaLiveTabMyConcernResponse);
        if (!w.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<q> btX = btX();
        if (!w.isEmpty(btX)) {
            arrayList.addAll(btX);
        }
        return arrayList;
    }

    private List<q> btX() {
        ArrayList arrayList = new ArrayList();
        if (!w.isEmpty(this.fpE)) {
            g gVar = new g();
            gVar.ftN = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bv(this.fpE));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.ftN = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!w.isEmpty(this.fpC)) {
                arrayList.addAll(btY());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.n(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dFj ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dFj ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!w.isEmpty(this.fpD) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!w.isEmpty(this.fpD)) {
                g gVar = new g();
                gVar.ftN = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!w.isEmpty(this.fpD)) {
                for (q qVar : this.fpD) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> btY() {
        ArrayList arrayList = new ArrayList();
        if (!w.isEmpty(this.fpC)) {
            int size = this.fpC.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.flT = (bu) this.fpC.get(i);
                cVar.isLeft = true;
                kVar.foi = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.flT = (bu) this.fpC.get(i + 1);
                    kVar.foj = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.flR = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fok = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bv(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!w.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.flT = (bu) list.get(i);
                cVar2.flV = false;
                cVar.foi = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.flT = (bu) list.get(i + 1);
                    cVar3.flV = false;
                    cVar.fpw = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.flT = (bu) list.get(i + 2);
                    cVar4.flV = false;
                    cVar.foj = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!w.isEmpty(this.fpB)) {
            for (int size = this.fpB.size() - 1; size >= 0; size--) {
                q qVar = (q) w.getItem(this.fpB, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fpB.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fpB.clear();
            }
            if (!w.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fpC.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!w.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fpD.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!w.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fpE.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fpB = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> btZ() {
        return this.fpB;
    }

    public void clearData() {
        if (this.fpC != null) {
            this.fpC.clear();
        }
        if (this.fpD != null) {
            this.fpD.clear();
        }
        if (this.fpE != null) {
            this.fpE.clear();
        }
        if (this.fpB != null) {
            this.fpB.clear();
        }
    }
}
