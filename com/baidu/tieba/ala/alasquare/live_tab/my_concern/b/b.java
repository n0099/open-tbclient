package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private static long eLS = 604800000;
    private List<n> gEv = new ArrayList();
    private List<n> gEw = new ArrayList();
    private List<n> gEx = new ArrayList();
    private List<n> gEy = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<n> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<n> b2 = b(alaLiveTabMyConcernResponse, z);
        if (!x.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<n> b3 = b(alaLiveTabMyConcernResponse);
        if (!x.isEmpty(b3)) {
            arrayList.addAll(b3);
        }
        List<n> bUT = bUT();
        if (!x.isEmpty(bUT)) {
            arrayList.addAll(bUT);
        }
        return arrayList;
    }

    private List<n> bUT() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.gEy)) {
            g gVar = new g();
            gVar.gII = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(ck(this.gEy));
        }
        return arrayList;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gII = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.gEw)) {
                arrayList.addAll(bUU());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eLS ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eLS ? 0 : -1)) > 0)) ? false : true;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!x.isEmpty(this.gEx) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!x.isEmpty(this.gEx)) {
                g gVar = new g();
                gVar.gII = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.gEx)) {
                for (n nVar : this.gEx) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    private List<n> bUU() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.gEw)) {
            int size = this.gEw.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gAx = (bz) this.gEw.get(i);
                eVar.isLeft = true;
                kVar.gCV = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gAx = (bz) this.gEw.get(i + 1);
                    kVar.gCW = eVar2;
                    eVar2.isRight = true;
                } else {
                    eVar.isLeft = false;
                    eVar.gAv = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gCX = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<n> ck(List<n> list) {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                c cVar = new c();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gAx = (bz) list.get(i);
                eVar.gAG = false;
                cVar.gCV = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gAx = (bz) list.get(i + 1);
                    eVar2.gAG = false;
                    cVar.gEq = eVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar3 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar3.gAx = (bz) list.get(i + 2);
                    eVar3.gAG = false;
                    cVar.gCW = eVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (!x.isEmpty(this.gEv)) {
            for (int size = this.gEv.size() - 1; size >= 0; size--) {
                n nVar = (n) x.getItem(this.gEv, size);
                if (nVar != null && nVar.getClass().equals(cls)) {
                    this.gEv.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gEv.clear();
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gEw.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gEx.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gEy.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gEv = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<n> bUV() {
        return this.gEv;
    }

    public void clearData() {
        if (this.gEw != null) {
            this.gEw.clear();
        }
        if (this.gEx != null) {
            this.gEx.clear();
        }
        if (this.gEy != null) {
            this.gEy.clear();
        }
        if (this.gEv != null) {
            this.gEv.clear();
        }
    }
}
