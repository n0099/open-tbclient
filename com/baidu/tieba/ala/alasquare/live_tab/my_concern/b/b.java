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
    private static long dUs = 604800000;
    private List<q> fGi = new ArrayList();
    private List<q> fGj = new ArrayList();
    private List<q> fGk = new ArrayList();
    private List<q> fGl = new ArrayList();
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
        List<q> bGh = bGh();
        if (!y.isEmpty(bGh)) {
            arrayList.addAll(bGh);
        }
        return arrayList;
    }

    private List<q> bGh() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fGl)) {
            g gVar = new g();
            gVar.fKq = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bA(this.fGl));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fKq = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fGj)) {
                arrayList.addAll(bGi());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dUs ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dUs ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.fGk) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.fGk)) {
                g gVar = new g();
                gVar.fKq = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.fGk)) {
                for (q qVar : this.fGk) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bGi() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.fGj)) {
            int size = this.fGj.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.fCB = (bw) this.fGj.get(i);
                cVar.isLeft = true;
                kVar.fEP = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.fCB = (bw) this.fGj.get(i + 1);
                    kVar.fEQ = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.fCz = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fER = true;
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
                cVar2.fCB = (bw) list.get(i);
                cVar2.fCD = false;
                cVar.fEP = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.fCB = (bw) list.get(i + 1);
                    cVar3.fCD = false;
                    cVar.fGd = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.fCB = (bw) list.get(i + 2);
                    cVar4.fCD = false;
                    cVar.fEQ = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.fGi)) {
            for (int size = this.fGi.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.fGi, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.fGi.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fGi.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.fGj.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.fGk.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fGl.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fGi = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bGj() {
        return this.fGi;
    }

    public void clearData() {
        if (this.fGj != null) {
            this.fGj.clear();
        }
        if (this.fGk != null) {
            this.fGk.clear();
        }
        if (this.fGl != null) {
            this.fGl.clear();
        }
        if (this.fGi != null) {
            this.fGi.clear();
        }
    }
}
