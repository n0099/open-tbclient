package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static long cHc = 604800000;
    private List<m> eir = new ArrayList();
    private List<m> eis = new ArrayList();
    private List<m> eit = new ArrayList();
    private List<m> eiu = new ArrayList();
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
        List<m> aZQ = aZQ();
        if (!v.isEmpty(aZQ)) {
            arrayList.addAll(aZQ);
        }
        return arrayList;
    }

    private List<m> aZQ() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eiu)) {
            g gVar = new g();
            gVar.emj = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bi(this.eiu));
        }
        return arrayList;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.emj = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eis)) {
                arrayList.addAll(aZR());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.j(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > cHc ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == cHc ? 0 : -1)) > 0)) ? false : true;
    }

    private List<m> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!v.isEmpty(this.eit) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!v.isEmpty(this.eit)) {
                g gVar = new g();
                gVar.emj = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!v.isEmpty(this.eit)) {
                for (m mVar : this.eit) {
                    arrayList.add(mVar);
                }
            }
        }
        return arrayList;
    }

    private List<m> aZR() {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(this.eis)) {
            int size = this.eis.size();
            for (int i = 0; i < size; i += 2) {
                i iVar = new i();
                com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
                bVar.eft = (bj) this.eis.get(i);
                bVar.isLeft = true;
                iVar.ehC = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.eft = (bj) this.eis.get(i + 1);
                    iVar.ehD = bVar2;
                    bVar2.isRight = true;
                } else {
                    bVar.isLeft = false;
                    bVar.efw = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    iVar.ehE = true;
                }
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    private List<m> bi(List<m> list) {
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                c cVar = new c();
                com.baidu.tieba.ala.alasquare.a.b bVar = new com.baidu.tieba.ala.alasquare.a.b();
                bVar.eft = (bj) list.get(i);
                bVar.efv = false;
                cVar.ehC = bVar;
                if (i + 1 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar2 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar2.eft = (bj) list.get(i + 1);
                    bVar2.efv = false;
                    cVar.eim = bVar2;
                }
                if (i + 2 < size) {
                    com.baidu.tieba.ala.alasquare.a.b bVar3 = new com.baidu.tieba.ala.alasquare.a.b();
                    bVar3.eft = (bj) list.get(i + 2);
                    bVar3.efv = false;
                    cVar.ehD = bVar3;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (!v.isEmpty(this.eir)) {
            for (int size = this.eir.size() - 1; size >= 0; size--) {
                m mVar = (m) v.getItem(this.eir, size);
                if (mVar != null && mVar.getClass().equals(cls)) {
                    this.eir.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.eir.clear();
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.eis.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.eit.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!v.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.eiu.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.eir = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<m> aZS() {
        return this.eir;
    }

    public void clearData() {
        if (this.eis != null) {
            this.eis.clear();
        }
        if (this.eit != null) {
            this.eit.clear();
        }
        if (this.eiu != null) {
            this.eiu.clear();
        }
        if (this.eir != null) {
            this.eir.clear();
        }
    }
}
