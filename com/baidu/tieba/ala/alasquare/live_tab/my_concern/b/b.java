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
    private static long bUK = 604800000;
    private List<m> dxp = new ArrayList();
    private List<m> dxq = new ArrayList();
    private List<m> dxr = new ArrayList();
    private List<m> dxs = new ArrayList();
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
        List<m> aJs = aJs();
        if (!v.isEmpty(aJs)) {
            arrayList.addAll(aJs);
        }
        return arrayList;
    }

    private List<m> aJs() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dxs)) {
            g gVar = new g();
            gVar.dBl = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bj(this.dxs));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.dBl = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.dxq)) {
                arrayList.addAll(aJt());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.h(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > bUK ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == bUK ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.dxr) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.dxr)) {
                g gVar = new g();
                gVar.dBl = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.dxr)) {
                for (m mVar : this.dxr) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> aJt() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.dxq)) {
            int size = this.dxq.size();
            for (int i = 0; i < size; i += 2) {
                i iVar = new i();
                com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
                bVar.dur = (bh) this.dxq.get(i);
                bVar.isLeft = true;
                iVar.dwA = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.dur = (bh) this.dxq.get(i + 1);
                    iVar.dwB = bVar2;
                    bVar2.isRight = true;
                } else {
                    bVar.isLeft = false;
                    bVar.duu = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    iVar.dwC = true;
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
                bVar.dur = (bh) list.get(i);
                bVar.dut = false;
                cVar.dwA = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.dur = (bh) list.get(i + 1);
                    bVar2.dut = false;
                    cVar.dxk = bVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar3 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar3.dur = (bh) list.get(i + 2);
                    bVar3.dut = false;
                    cVar.dwB = bVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void p(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.dxp)) {
            for (int size = this.dxp.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.dxp, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.dxp.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.dxp.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.dxq.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.dxr.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.dxs.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.dxp = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> aJu() {
        return this.dxp;
    }

    public void clearData() {
        if (this.dxq != null) {
            this.dxq.clear();
        }
        if (this.dxr != null) {
            this.dxr.clear();
        }
        if (this.dxs != null) {
            this.dxs.clear();
        }
        if (this.dxp != null) {
            this.dxp.clear();
        }
    }
}
