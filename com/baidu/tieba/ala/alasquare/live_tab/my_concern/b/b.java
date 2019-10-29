package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private static long bVB = 604800000;
    private List<m> dyg = new ArrayList();
    private List<m> dyh = new ArrayList();
    private List<m> dyi = new ArrayList();
    private List<m> dyj = new ArrayList();
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
        List<m> aJu = aJu();
        if (!v.isEmpty(aJu)) {
            arrayList.addAll(aJu);
        }
        return arrayList;
    }

    private List<m> aJu() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dyj)) {
            g gVar = new g();
            gVar.dCc = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bj(this.dyj));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.dCc = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.dyh)) {
                arrayList.addAll(aJv());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.h(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > bVB ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == bVB ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.dyi) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.dyi)) {
                g gVar = new g();
                gVar.dCc = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.dyi)) {
                for (m mVar : this.dyi) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> aJv() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dyh)) {
            int size = this.dyh.size();
            for (int i = 0; i < size; i += 2) {
                i iVar = new i();
                com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
                bVar.dvi = (bh) this.dyh.get(i);
                bVar.isLeft = true;
                iVar.dxr = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.dvi = (bh) this.dyh.get(i + 1);
                    iVar.dxs = bVar2;
                    bVar2.isRight = true;
                } else {
                    bVar.isLeft = false;
                    bVar.dvl = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    iVar.dxt = true;
                }
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    private List<m> bj(List<m> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                c cVar = new c();
                com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
                bVar.dvi = (bh) list.get(i);
                bVar.dvk = false;
                cVar.dxr = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.dvi = (bh) list.get(i + 1);
                    bVar2.dvk = false;
                    cVar.dyb = bVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar3 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar3.dvi = (bh) list.get(i + 2);
                    bVar3.dvk = false;
                    cVar.dxs = bVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void p(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.dyg)) {
            for (int size = this.dyg.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.dyg, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.dyg.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.dyg.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.dyh.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.dyi.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.dyj.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.dyg = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> aJw() {
        return this.dyg;
    }

    public void clearData() {
        if (this.dyh != null) {
            this.dyh.clear();
        }
        if (this.dyi != null) {
            this.dyi.clear();
        }
        if (this.dyj != null) {
            this.dyj.clear();
        }
        if (this.dyg != null) {
            this.dyg.clear();
        }
    }
}
