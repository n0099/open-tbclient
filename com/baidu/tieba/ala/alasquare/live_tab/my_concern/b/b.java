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
    private static long ewV = 604800000;
    private List<q> glE = new ArrayList();
    private List<q> glF = new ArrayList();
    private List<q> glG = new ArrayList();
    private List<q> glH = new ArrayList();
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
        List<q> bPl = bPl();
        if (!y.isEmpty(bPl)) {
            arrayList.addAll(bPl);
        }
        return arrayList;
    }

    private List<q> bPl() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.glH)) {
            g gVar = new g();
            gVar.gpN = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bZ(this.glH));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gpN = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.glF)) {
                arrayList.addAll(bPm());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > ewV ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == ewV ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.glG) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.glG)) {
                g gVar = new g();
                gVar.gpN = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.glG)) {
                for (q qVar : this.glG) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bPm() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.glF)) {
            int size = this.glF.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.ghO = (bw) this.glF.get(i);
                cVar.isLeft = true;
                kVar.gke = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.ghO = (bw) this.glF.get(i + 1);
                    kVar.gkf = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.ghM = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gkg = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bZ(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.ghO = (bw) list.get(i);
                cVar2.ghQ = false;
                cVar.gke = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.ghO = (bw) list.get(i + 1);
                    cVar3.ghQ = false;
                    cVar.glz = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.ghO = (bw) list.get(i + 2);
                    cVar4.ghQ = false;
                    cVar.gkf = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!y.isEmpty(this.glE)) {
            for (int size = this.glE.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.glE, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.glE.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.glE.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.glF.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.glG.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.glH.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.glE = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bPn() {
        return this.glE;
    }

    public void clearData() {
        if (this.glF != null) {
            this.glF.clear();
        }
        if (this.glG != null) {
            this.glG.clear();
        }
        if (this.glH != null) {
            this.glH.clear();
        }
        if (this.glE != null) {
            this.glE.clear();
        }
    }
}
