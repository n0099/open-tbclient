package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private static long eKO = 604800000;
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
        List<n> b = b(alaLiveTabMyConcernResponse, z);
        if (!y.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<n> b2 = b(alaLiveTabMyConcernResponse);
        if (!y.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<n> bRS = bRS();
        if (!y.isEmpty(bRS)) {
            arrayList.addAll(bRS);
        }
        return arrayList;
    }

    private List<n> bRS() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gEy)) {
            g gVar = new g();
            gVar.gIJ = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(cf(this.gEy));
        }
        return arrayList;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gIJ = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gEw)) {
                arrayList.addAll(bRT());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eKO ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eKO ? 0 : -1)) > 0)) ? false : true;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.gEx) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gEx)) {
                g gVar = new g();
                gVar.gIJ = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gEx)) {
                for (n nVar : this.gEx) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    private List<n> bRT() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gEw)) {
            int size = this.gEw.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gAx = (cb) this.gEw.get(i);
                eVar.isLeft = true;
                kVar.gCV = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gAx = (cb) this.gEw.get(i + 1);
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

    private List<n> cf(List<n> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                c cVar = new c();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gAx = (cb) list.get(i);
                eVar.gAG = false;
                cVar.gCV = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gAx = (cb) list.get(i + 1);
                    eVar2.gAG = false;
                    cVar.gEq = eVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar3 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar3.gAx = (cb) list.get(i + 2);
                    eVar3.gAG = false;
                    cVar.gCW = eVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (!y.isEmpty(this.gEv)) {
            for (int size = this.gEv.size() - 1; size >= 0; size--) {
                n nVar = (n) y.getItem(this.gEv, size);
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
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gEw.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gEx.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gEy.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gEv = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<n> bRU() {
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
