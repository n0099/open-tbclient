package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
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
    private static long dyQ = 604800000;
    private List<o> fef = new ArrayList();
    private List<o> feg = new ArrayList();
    private List<o> feh = new ArrayList();
    private List<o> fei = new ArrayList();
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private List<o> a(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<o> b = b(alaLiveTabMyConcernResponse, z);
        if (!v.isEmpty(b)) {
            arrayList.addAll(b);
        }
        List<o> b2 = b(alaLiveTabMyConcernResponse);
        if (!v.isEmpty(b2)) {
            arrayList.addAll(b2);
        }
        List<o> bqY = bqY();
        if (!v.isEmpty(bqY)) {
            arrayList.addAll(bqY);
        }
        return arrayList;
    }

    private List<o> bqY() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.fei)) {
            g gVar = new g();
            gVar.fio = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bm(this.fei));
        }
        return arrayList;
    }

    private List<o> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.fio = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.feg)) {
                arrayList.addAll(bqZ());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.k(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > dyQ ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == dyQ ? 0 : -1)) > 0)) ? false : true;
    }

    private List<o> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.feh) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.feh)) {
                g gVar = new g();
                gVar.fio = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.feh)) {
                for (o oVar : this.feh) {
                    arrayList.add(oVar);
                }
            }
        }
        return arrayList;
    }

    private List<o> bqZ() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.feg)) {
            int size = this.feg.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.fay = (bk) this.feg.get(i);
                cVar.isLeft = true;
                kVar.fcN = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.fay = (bk) this.feg.get(i + 1);
                    kVar.fcO = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.faw = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.fcP = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<o> bm(List<o> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.fay = (bk) list.get(i);
                cVar2.faA = false;
                cVar.fcN = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.fay = (bk) list.get(i + 1);
                    cVar3.faA = false;
                    cVar.fea = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.fay = (bk) list.get(i + 2);
                    cVar4.faA = false;
                    cVar.fcO = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.fef)) {
            for (int size = this.fef.size() - 1; size >= 0; size--) {
                o oVar = (o) v.getItem(this.fef, size);
                if (oVar != null && oVar.getClass().equals(cls)) {
                    this.fef.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.fef.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.feg.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.feh.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.fei.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.fef = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<o> bra() {
        return this.fef;
    }

    public void clearData() {
        if (this.feg != null) {
            this.feg.clear();
        }
        if (this.feh != null) {
            this.feh.clear();
        }
        if (this.fei != null) {
            this.fei.clear();
        }
        if (this.fef != null) {
            this.fef.clear();
        }
    }
}
