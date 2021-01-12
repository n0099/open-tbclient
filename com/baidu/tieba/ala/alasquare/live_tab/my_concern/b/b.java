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
/* loaded from: classes9.dex */
public class b {
    private static long eHh = 604800000;
    private List<n> gzO = new ArrayList();
    private List<n> gzP = new ArrayList();
    private List<n> gzQ = new ArrayList();
    private List<n> gzR = new ArrayList();
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
        List<n> bRb = bRb();
        if (!x.isEmpty(bRb)) {
            arrayList.addAll(bRb);
        }
        return arrayList;
    }

    private List<n> bRb() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.gzR)) {
            g gVar = new g();
            gVar.gEc = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(ck(this.gzR));
        }
        return arrayList;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gEc = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.gzP)) {
                arrayList.addAll(bRc());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eHh ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eHh ? 0 : -1)) > 0)) ? false : true;
    }

    private List<n> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!x.isEmpty(this.gzQ) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!x.isEmpty(this.gzQ)) {
                g gVar = new g();
                gVar.gEc = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!x.isEmpty(this.gzQ)) {
                for (n nVar : this.gzQ) {
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    private List<n> bRc() {
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(this.gzP)) {
            int size = this.gzP.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                com.baidu.tieba.ala.alasquare.a.e eVar = new com.baidu.tieba.ala.alasquare.a.e();
                eVar.gvQ = (bz) this.gzP.get(i);
                eVar.isLeft = true;
                kVar.gyo = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gvQ = (bz) this.gzP.get(i + 1);
                    kVar.gyp = eVar2;
                    eVar2.isRight = true;
                } else {
                    eVar.isLeft = false;
                    eVar.gvO = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gyq = true;
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
                eVar.gvQ = (bz) list.get(i);
                eVar.gvZ = false;
                cVar.gyo = eVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar2 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar2.gvQ = (bz) list.get(i + 1);
                    eVar2.gvZ = false;
                    cVar.gzJ = eVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.e eVar3 = new com.baidu.tieba.ala.alasquare.a.e();
                    eVar3.gvQ = (bz) list.get(i + 2);
                    eVar3.gvZ = false;
                    cVar.gyp = eVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (!x.isEmpty(this.gzO)) {
            for (int size = this.gzO.size() - 1; size >= 0; size--) {
                n nVar = (n) x.getItem(this.gzO, size);
                if (nVar != null && nVar.getClass().equals(cls)) {
                    this.gzO.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gzO.clear();
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gzP.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gzQ.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!x.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gzR.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gzO = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<n> bRd() {
        return this.gzO;
    }

    public void clearData() {
        if (this.gzP != null) {
            this.gzP.clear();
        }
        if (this.gzQ != null) {
            this.gzQ.clear();
        }
        if (this.gzR != null) {
            this.gzR.clear();
        }
        if (this.gzO != null) {
            this.gzO.clear();
        }
    }
}
