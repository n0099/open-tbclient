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
/* loaded from: classes2.dex */
public class b {
    private static long cHo = 604800000;
    private List<m> ejf = new ArrayList();
    private List<m> ejg = new ArrayList();
    private List<m> ejh = new ArrayList();
    private List<m> eji = new ArrayList();
    private TbPageContext mTbPageContext;

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
        List<m> bap = bap();
        if (!v.isEmpty(bap)) {
            arrayList.addAll(bap);
        }
        return arrayList;
    }

    private List<m> bap() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eji)) {
            g gVar = new g();
            gVar.enh = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bh(this.eji));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.enh = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.ejg)) {
                arrayList.addAll(baq());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.j(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > cHo ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == cHo ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.ejh) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.ejh)) {
                g gVar = new g();
                gVar.enh = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.ejh)) {
                for (m mVar : this.ejh) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> baq() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.ejg)) {
            int size = this.ejg.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.efE = (bj) this.ejg.get(i);
                cVar.isLeft = true;
                kVar.ehP = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.efE = (bj) this.ejg.get(i + 1);
                    kVar.ehQ = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.efC = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.ehR = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<m> bh(List<m> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.efE = (bj) list.get(i);
                cVar2.efG = false;
                cVar.ehP = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.efE = (bj) list.get(i + 1);
                    cVar3.efG = false;
                    cVar.eja = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.efE = (bj) list.get(i + 2);
                    cVar4.efG = false;
                    cVar.ehQ = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.ejf)) {
            for (int size = this.ejf.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.ejf, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.ejf.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.ejf.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.ejg.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.ejh.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.eji.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.ejf = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> bar() {
        return this.ejf;
    }

    public void clearData() {
        if (this.ejg != null) {
            this.ejg.clear();
        }
        if (this.ejh != null) {
            this.ejh.clear();
        }
        if (this.eji != null) {
            this.eji.clear();
        }
        if (this.ejf != null) {
            this.ejf.clear();
        }
    }
}
