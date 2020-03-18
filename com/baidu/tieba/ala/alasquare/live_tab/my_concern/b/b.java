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
    private static long cLE = 604800000;
    private List<m> enU = new ArrayList();
    private List<m> enV = new ArrayList();
    private List<m> enW = new ArrayList();
    private List<m> enX = new ArrayList();
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
        List<m> bcL = bcL();
        if (!v.isEmpty(bcL)) {
            arrayList.addAll(bcL);
        }
        return arrayList;
    }

    private List<m> bcL() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.enX)) {
            g gVar = new g();
            gVar.ese = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bh(this.enX));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.ese = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enV)) {
                arrayList.addAll(bcM());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.j(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > cLE ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == cLE ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.enW) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.enW)) {
                g gVar = new g();
                gVar.ese = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.enW)) {
                for (m mVar : this.enW) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> bcM() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.enV)) {
            int size = this.enV.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.ekm = (bj) this.enV.get(i);
                cVar.isLeft = true;
                kVar.emz = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.ekm = (bj) this.enV.get(i + 1);
                    kVar.emA = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.ekk = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.emB = true;
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
                cVar2.ekm = (bj) list.get(i);
                cVar2.eko = false;
                cVar.emz = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.ekm = (bj) list.get(i + 1);
                    cVar3.eko = false;
                    cVar.enP = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.ekm = (bj) list.get(i + 2);
                    cVar4.eko = false;
                    cVar.emA = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.enU)) {
            for (int size = this.enU.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.enU, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.enU.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.enU.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.enV.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.enW.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.enX.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.enU = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> bcN() {
        return this.enU;
    }

    public void clearData() {
        if (this.enV != null) {
            this.enV.clear();
        }
        if (this.enW != null) {
            this.enW.clear();
        }
        if (this.enX != null) {
            this.enX.clear();
        }
        if (this.enU != null) {
            this.enU.clear();
        }
    }
}
