package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
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
    private static long dyQ = 604800000;
    private List<o> feq = new ArrayList();
    private List<o> fer = new ArrayList();
    private List<o> fes = new ArrayList();
    private List<o> fet = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<o> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<o> b = b(alaLiveTabMyConcernResponse, z);
        if (!v.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<o> b2 = b(alaLiveTabMyConcernResponse);
        if (!v.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<o> bra = bra();
        if (!v.isEmpty(bra)) {
            arrayList.addAll(bra);
        }
        return arrayList;
    }

    private List<o> bra() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.fet)) {
            g gVar = new g();
            gVar.fiA = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bm(this.fet));
        }
        return arrayList;
    }

    private List<o> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fiA = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.fer)) {
                arrayList.addAll(brb());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.k(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dyQ ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dyQ ? 0 : -1)) > 0)) ? false : true;
    }

    private List<o> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.fes) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.fes)) {
                g gVar = new g();
                gVar.fiA = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.fes)) {
                for (o oVar : this.fes) {
                    arrayList.add(oVar);
                }
            }
        }
        return arrayList;
    }

    private List<o> brb() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.fer)) {
            int size = this.fer.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.faJ = (bk) this.fer.get(i);
                cVar.isLeft = true;
                kVar.fcY = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.faJ = (bk) this.fer.get(i + 1);
                    kVar.fcZ = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.faH = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fda = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<o> bm(List<o> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.faJ = (bk) list.get(i);
                cVar2.faL = false;
                cVar.fcY = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.faJ = (bk) list.get(i + 1);
                    cVar3.faL = false;
                    cVar.fel = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.faJ = (bk) list.get(i + 2);
                    cVar4.faL = false;
                    cVar.fcZ = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.feq)) {
            for (int size = this.feq.size() - 1; size >= 0; size--) {
                o oVar = (o) v.getItem(this.feq, size);
                if (oVar != null && oVar.getClass().equals(cls)) {
                    this.feq.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.feq.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fer.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fes.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fet.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.feq = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<o> brc() {
        return this.feq;
    }

    public void clearData() {
        if (this.fer != null) {
            this.fer.clear();
        }
        if (this.fes != null) {
            this.fes.clear();
        }
        if (this.fet != null) {
            this.fet.clear();
        }
        if (this.feq != null) {
            this.feq.clear();
        }
    }
}
