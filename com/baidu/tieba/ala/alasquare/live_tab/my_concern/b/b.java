package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
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
    private static long erc = 604800000;
    private List<q> gfP = new ArrayList();
    private List<q> gfQ = new ArrayList();
    private List<q> gfR = new ArrayList();
    private List<q> gfS = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<q> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<q> b = b(alaLiveTabMyConcernResponse, z);
        if (!y.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<q> b2 = b(alaLiveTabMyConcernResponse);
        if (!y.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<q> bML = bML();
        if (!y.isEmpty(bML)) {
            arrayList.addAll(bML);
        }
        return arrayList;
    }

    private List<q> bML() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gfS)) {
            g gVar = new g();
            gVar.gka = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bS(this.gfS));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gka = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gfQ)) {
                arrayList.addAll(bMM());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > erc ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == erc ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.gfR) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gfR)) {
                g gVar = new g();
                gVar.gka = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gfR)) {
                for (q qVar : this.gfR) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bMM() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gfQ)) {
            int size = this.gfQ.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.gbZ = (bw) this.gfQ.get(i);
                cVar.isLeft = true;
                kVar.gep = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.gbZ = (bw) this.gfQ.get(i + 1);
                    kVar.geq = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.gbX = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.ger = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bS(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.gbZ = (bw) list.get(i);
                cVar2.gcb = false;
                cVar.gep = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.gbZ = (bw) list.get(i + 1);
                    cVar3.gcb = false;
                    cVar.gfK = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.gbZ = (bw) list.get(i + 2);
                    cVar4.gcb = false;
                    cVar.geq = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.gfP)) {
            for (int size = this.gfP.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.gfP, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.gfP.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gfP.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gfQ.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gfR.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gfS.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gfP = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bMN() {
        return this.gfP;
    }

    public void clearData() {
        if (this.gfQ != null) {
            this.gfQ.clear();
        }
        if (this.gfR != null) {
            this.gfR.clear();
        }
        if (this.gfS != null) {
            this.gfS.clear();
        }
        if (this.gfP != null) {
            this.gfP.clear();
        }
    }
}
