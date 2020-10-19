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
    private static long eiE = 604800000;
    private List<q> fVL = new ArrayList();
    private List<q> fVM = new ArrayList();
    private List<q> fVN = new ArrayList();
    private List<q> fVO = new ArrayList();
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
        List<q> bKj = bKj();
        if (!y.isEmpty(bKj)) {
            arrayList.addAll(bKj);
        }
        return arrayList;
    }

    private List<q> bKj() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fVO)) {
            g gVar = new g();
            gVar.fZV = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bI(this.fVO));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fZV = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fVM)) {
                arrayList.addAll(bKk());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eiE ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eiE ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.fVN) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.fVN)) {
                g gVar = new g();
                gVar.fZV = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fVN)) {
                for (q qVar : this.fVN) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bKk() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fVM)) {
            int size = this.fVM.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.fRW = (bw) this.fVM.get(i);
                cVar.isLeft = true;
                kVar.fUl = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.fRW = (bw) this.fVM.get(i + 1);
                    kVar.fUm = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.fRU = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fUn = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bI(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.fRW = (bw) list.get(i);
                cVar2.fRY = false;
                cVar.fUl = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.fRW = (bw) list.get(i + 1);
                    cVar3.fRY = false;
                    cVar.fVG = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.fRW = (bw) list.get(i + 2);
                    cVar4.fRY = false;
                    cVar.fUm = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.fVL)) {
            for (int size = this.fVL.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.fVL, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fVL.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fVL.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fVM.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fVN.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fVO.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fVL = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bKl() {
        return this.fVL;
    }

    public void clearData() {
        if (this.fVM != null) {
            this.fVM.clear();
        }
        if (this.fVN != null) {
            this.fVN.clear();
        }
        if (this.fVO != null) {
            this.fVO.clear();
        }
        if (this.fVL != null) {
            this.fVL.clear();
        }
    }
}
