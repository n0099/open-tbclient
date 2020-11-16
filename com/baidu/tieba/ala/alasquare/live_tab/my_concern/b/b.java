package com.baidu.tieba.ala.alasquare.live_tab.my_concern.b;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes4.dex */
public class b {
    private static long evm = 604800000;
    private List<q> gll = new ArrayList();
    private List<q> glm = new ArrayList();
    private List<q> gln = new ArrayList();
    private List<q> glo = new ArrayList();
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
        List<q> bOE = bOE();
        if (!y.isEmpty(bOE)) {
            arrayList.addAll(bOE);
        }
        return arrayList;
    }

    private List<q> bOE() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.glo)) {
            g gVar = new g();
            gVar.gpu = this.mTbPageContext.getResources().getString(R.string.live_tab_recommend_title_txt);
            arrayList.add(gVar);
            arrayList.addAll(bZ(this.glo));
        }
        return arrayList;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse != null) {
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                g gVar = new g();
                gVar.gpu = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_online_title, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.glm)) {
                arrayList.addAll(bOF());
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
        return (alaLiveTabMyConcernResponse.followStatus == 1 || a.m(this.mTbPageContext) || !(((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) > evm ? 1 : ((System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L)) == evm ? 0 : -1)) > 0)) ? false : true;
    }

    private List<q> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        ArrayList arrayList = new ArrayList();
        if (alaLiveTabMyConcernResponse == null) {
            return arrayList;
        }
        if (alaLiveTabMyConcernResponse.followStatus != 1) {
            if (!y.isEmpty(this.gln) && a(alaLiveTabMyConcernResponse)) {
                arrayList.add(new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a());
            }
            if (!y.isEmpty(this.gln)) {
                g gVar = new g();
                gVar.gpu = this.mTbPageContext.getResources().getString(R.string.live_sub_tab_offline_title, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                arrayList.add(gVar);
            }
            if (!y.isEmpty(this.gln)) {
                for (q qVar : this.gln) {
                    arrayList.add(qVar);
                }
            }
        }
        return arrayList;
    }

    private List<q> bOF() {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(this.glm)) {
            int size = this.glm.size();
            for (int i = 0; i < size; i += 2) {
                k kVar = new k();
                c cVar = new c();
                cVar.ghv = (bx) this.glm.get(i);
                cVar.isLeft = true;
                kVar.gjL = cVar;
                if (i + 1 < size) {
                    c cVar2 = new c();
                    cVar2.ghv = (bx) this.glm.get(i + 1);
                    kVar.gjM = cVar2;
                    cVar2.isRight = true;
                } else {
                    cVar.isLeft = false;
                    cVar.ght = true;
                }
                if ((size % 2 == 0 && i == size - 2) || (size % 2 != 0 && i == size - 1)) {
                    kVar.gjN = true;
                }
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }

    private List<q> bZ(List<q> list) {
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i += 3) {
                com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c cVar = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.c();
                c cVar2 = new c();
                cVar2.ghv = (bx) list.get(i);
                cVar2.ghx = false;
                cVar.gjL = cVar2;
                if (i + 1 < size) {
                    c cVar3 = new c();
                    cVar3.ghv = (bx) list.get(i + 1);
                    cVar3.ghx = false;
                    cVar.glg = cVar3;
                }
                if (i + 2 < size) {
                    c cVar4 = new c();
                    cVar4.ghv = (bx) list.get(i + 2);
                    cVar4.ghx = false;
                    cVar.gjM = cVar4;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void x(Class<? extends BaseCardInfo> cls) {
        if (!y.isEmpty(this.gll)) {
            for (int size = this.gll.size() - 1; size >= 0; size--) {
                q qVar = (q) y.getItem(this.gll, size);
                if (qVar != null && qVar.getClass().equals(cls)) {
                    this.gll.remove(size);
                }
            }
        }
    }

    public void c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        if (alaLiveTabMyConcernResponse != null) {
            if (z) {
                this.gll.clear();
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followList)) {
                this.glm.addAll(alaLiveTabMyConcernResponse.followList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
                this.gln.addAll(alaLiveTabMyConcernResponse.followCloseList);
            }
            if (!y.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
                this.glo.addAll(alaLiveTabMyConcernResponse.recommendList);
            }
            this.gll = a(alaLiveTabMyConcernResponse, z);
        }
    }

    public List<q> bOG() {
        return this.gll;
    }

    public void clearData() {
        if (this.glm != null) {
            this.glm.clear();
        }
        if (this.gln != null) {
            this.gln.clear();
        }
        if (this.glo != null) {
            this.glo.clear();
        }
        if (this.gll != null) {
            this.gll.clear();
        }
    }
}
