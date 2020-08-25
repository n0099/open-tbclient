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
    private static long dUo = 604800000;
    private List<q> fGe = new ArrayList();
    private List<q> fGf = new ArrayList();
    private List<q> fGg = new ArrayList();
    private List<q> fGh = new ArrayList();
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
        List<q> bGg = bGg();
        if (!y.isEmpty(bGg)) {
            arrayList.addAll(bGg);
        }
        return arrayList;
    }

    private List<q> bGg() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fGh)) {
            g gVar = new g();
            gVar.fKm = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bA(this.fGh));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fKm = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fGf)) {
                arrayList.addAll(bGh());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dUo ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dUo ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.fGg) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.fGg)) {
                g gVar = new g();
                gVar.fKm = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fGg)) {
                for (q qVar : this.fGg) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bGh() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fGf)) {
            int size = this.fGf.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.fCx = (bw) this.fGf.get(i);
                cVar.isLeft = true;
                kVar.fEL = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.fCx = (bw) this.fGf.get(i + 1);
                    kVar.fEM = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.fCv = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fEN = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bA(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.fCx = (bw) list.get(i);
                cVar2.fCz = false;
                cVar.fEL = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.fCx = (bw) list.get(i + 1);
                    cVar3.fCz = false;
                    cVar.fFZ = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.fCx = (bw) list.get(i + 2);
                    cVar4.fCz = false;
                    cVar.fEM = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.fGe)) {
            for (int size = this.fGe.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.fGe, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fGe.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fGe.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fGf.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fGg.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fGh.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fGe = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bGi() {
        return this.fGe;
    }

    public void clearData() {
        if (this.fGf != null) {
            this.fGf.clear();
        }
        if (this.fGg != null) {
            this.fGg.clear();
        }
        if (this.fGh != null) {
            this.fGh.clear();
        }
        if (this.fGe != null) {
            this.fGe.clear();
        }
    }
}
