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
/* loaded from: classes10.dex */
public class b {
    private static long eJn = 604800000;
    private TbPageContext mTbPageContext;
    private List<n> gCy = new ArrayList();
    private List<n> gCz = new ArrayList();
    private List<n> gCA = new ArrayList();
    private List<n> gCB = new ArrayList();

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<n> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<n> b2 = b(alaLiveTabMyConcernResponse, z);
        if (!y.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<n> b3 = b(alaLiveTabMyConcernResponse);
        if (!y.isEmpty(b3)) {
            arrayList.addAll(b3);
        }
        List<n> bRF = bRF();
        if (!y.isEmpty(bRF)) {
            arrayList.addAll(bRF);
        }
        return arrayList;
    }

    private List<n> bRF() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gCB)) {
            g gVar = new g();
            gVar.gGM = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(cf(this.gCB));
        }
        return arrayList;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gGM = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gCz)) {
                arrayList.addAll(bRG());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eJn ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eJn ? 0 : -1)) > 0)) ? false : true;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.gCA) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gCA)) {
                g gVar = new g();
                gVar.gGM = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gCA)) {
                for (n nVar : this.gCA) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    private List<n> bRG() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gCz)) {
            int size = this.gCz.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gyA = (cb) this.gCz.get(i);
                eVar.isLeft = true;
                kVar.gAY = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gyA = (cb) this.gCz.get(i + 1);
                    kVar.gAZ = eVar2;
                    eVar2.isRight = true;
                } else {
                    eVar.isLeft = false;
                    eVar.gyy = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gBa = true;
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
                eVar.gyA = (cb) list.get(i);
                eVar.gyJ = false;
                cVar.gAY = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gyA = (cb) list.get(i + 1);
                    eVar2.gyJ = false;
                    cVar.gCt = eVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar3 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar3.gyA = (cb) list.get(i + 2);
                    eVar3.gyJ = false;
                    cVar.gAZ = eVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (!y.isEmpty(this.gCy)) {
            for (int size = this.gCy.size() - 1; size >= 0; size--) {
                n nVar = (n) y.getItem(this.gCy, size);
                if (nVar != null && nVar.getClass().equals(cls)) {
                    this.gCy.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gCy.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gCz.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gCA.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gCB.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gCy = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<n> bRH() {
        return this.gCy;
    }

    public void clearData() {
        if (this.gCz != null) {
            this.gCz.clear();
        }
        if (this.gCA != null) {
            this.gCA.clear();
        }
        if (this.gCB != null) {
            this.gCB.clear();
        }
        if (this.gCy != null) {
            this.gCy.clear();
        }
    }
}
