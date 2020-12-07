package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.c;
import com.baidu.tieba.ala.alasquare.live_tab.b.k;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private static long eCo = 604800000;
    private List<q> gtu = new ArrayList();
    private List<q> gtv = new ArrayList();
    private List<q> gtw = new ArrayList();
    private List<q> gtx = new ArrayList();
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
        List<q> bSp = bSp();
        if (!y.isEmpty(bSp)) {
            arrayList.addAll(bSp);
        }
        return arrayList;
    }

    private List<q> bSp() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gtx)) {
            g gVar = new g();
            gVar.gxD = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(cd(this.gtx));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gxD = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gtv)) {
                arrayList.addAll(bSq());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > eCo ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == eCo ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.gtw) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gtw)) {
                g gVar = new g();
                gVar.gxD = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gtw)) {
                for (q qVar : this.gtw) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bSq() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.gtv)) {
            int size = this.gtv.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.gpF = (by) this.gtv.get(i);
                cVar.isLeft = true;
                kVar.grU = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.gpF = (by) this.gtv.get(i + 1);
                    kVar.grV = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.gpD = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.grW = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> cd(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.gpF = (by) list.get(i);
                cVar2.gpH = false;
                cVar.grU = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.gpF = (by) list.get(i + 1);
                    cVar3.gpH = false;
                    cVar.gtp = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.gpF = (by) list.get(i + 2);
                    cVar4.gpH = false;
                    cVar.grV = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends BaseCardInfo> cls) {
        if (!y.isEmpty(this.gtu)) {
            for (int size = this.gtu.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.gtu, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.gtu.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gtu.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.gtv.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gtw.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.gtx.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gtu = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bSr() {
        return this.gtu;
    }

    public void clearData() {
        if (this.gtv != null) {
            this.gtv.clear();
        }
        if (this.gtw != null) {
            this.gtw.clear();
        }
        if (this.gtx != null) {
            this.gtx.clear();
        }
        if (this.gtu != null) {
            this.gtu.clear();
        }
    }
}
