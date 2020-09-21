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
    private static long dWC = 604800000;
    private List<q> fJu = new ArrayList();
    private List<q> fJv = new ArrayList();
    private List<q> fJw = new ArrayList();
    private List<q> fJx = new ArrayList();
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
        List<q> bHx = bHx();
        if (!y.isEmpty(bHx)) {
            arrayList.addAll(bHx);
        }
        return arrayList;
    }

    private List<q> bHx() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fJx)) {
            g gVar = new g();
            gVar.fNE = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bF(this.fJx));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fNE = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fJv)) {
                arrayList.addAll(bHy());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dWC ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dWC ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.fJw) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.fJw)) {
                g gVar = new g();
                gVar.fNE = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fJw)) {
                for (q qVar : this.fJw) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bHy() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fJv)) {
            int size = this.fJv.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.fFN = (bw) this.fJv.get(i);
                cVar.isLeft = true;
                kVar.fIb = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.fFN = (bw) this.fJv.get(i + 1);
                    kVar.fIc = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.fFL = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fId = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bF(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.fFN = (bw) list.get(i);
                cVar2.fFP = false;
                cVar.fIb = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.fFN = (bw) list.get(i + 1);
                    cVar3.fFP = false;
                    cVar.fJp = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.fFN = (bw) list.get(i + 2);
                    cVar4.fFP = false;
                    cVar.fIc = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.fJu)) {
            for (int size = this.fJu.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.fJu, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fJu.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fJu.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fJv.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fJw.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fJx.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fJu = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bHz() {
        return this.fJu;
    }

    public void clearData() {
        if (this.fJv != null) {
            this.fJv.clear();
        }
        if (this.fJw != null) {
            this.fJw.clear();
        }
        if (this.fJx != null) {
            this.fJx.clear();
        }
        if (this.fJu != null) {
            this.fJu.clear();
        }
    }
}
