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
    private List<n> gCM = new ArrayList();
    private List<n> gCN = new ArrayList();
    private List<n> gCO = new ArrayList();
    private List<n> gCP = new ArrayList();
    private TbPageContext mTbPageContext;

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
        List<n> bRM = bRM();
        if (!y.isEmpty(bRM)) {
            arrayList.addAll(bRM);
        }
        return arrayList;
    }

    private List<n> bRM() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gCP)) {
            g gVar = new g();
            gVar.gHa = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(cf(this.gCP));
        }
        return arrayList;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gHa = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gCN)) {
                arrayList.addAll(bRN());
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
            if (!y.isEmpty(this.gCO) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gCO)) {
                g gVar = new g();
                gVar.gHa = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gCO)) {
                for (n nVar : this.gCO) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    private List<n> bRN() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gCN)) {
            int size = this.gCN.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gyO = (cb) this.gCN.get(i);
                eVar.isLeft = true;
                kVar.gBm = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gyO = (cb) this.gCN.get(i + 1);
                    kVar.gBn = eVar2;
                    eVar2.isRight = true;
                } else {
                    eVar.isLeft = false;
                    eVar.gyM = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gBo = true;
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
                eVar.gyO = (cb) list.get(i);
                eVar.gyX = false;
                cVar.gBm = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gyO = (cb) list.get(i + 1);
                    eVar2.gyX = false;
                    cVar.gCH = eVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar3 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar3.gyO = (cb) list.get(i + 2);
                    eVar3.gyX = false;
                    cVar.gBn = eVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (!y.isEmpty(this.gCM)) {
            for (int size = this.gCM.size() - 1; size >= 0; size--) {
                n nVar = (n) y.getItem(this.gCM, size);
                if (nVar != null && nVar.getClass().equals(cls)) {
                    this.gCM.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gCM.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gCN.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gCO.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gCP.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gCM = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<n> bRO() {
        return this.gCM;
    }

    public void clearData() {
        if (this.gCN != null) {
            this.gCN.clear();
        }
        if (this.gCO != null) {
            this.gCO.clear();
        }
        if (this.gCP != null) {
            this.gCP.clear();
        }
        if (this.gCM != null) {
            this.gCM.clear();
        }
    }
}
