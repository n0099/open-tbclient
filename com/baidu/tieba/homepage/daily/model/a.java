package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.b.c;
import com.baidu.tieba.homepage.daily.b.d;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.homepage.daily.model.DailyNetModel;
import java.util.List;
import tbclient.DailyInfo;
import tbclient.DailyPage.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    private DailyNetModel geR;
    private boolean geT;
    private InterfaceC0324a gek;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b geS = new b();
    private DailyNetModel.a geU = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.geS.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.geS.cA(dataRes.banner);
                    dataList.clear();
                    e cB = e.cB(dataRes.topic);
                    if (cB != null) {
                        dataList.add(cB);
                    }
                    boolean z2 = (a.this.geS.bvq() == null && cB == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.yc(dailyInfo.tab_name);
                        dVar.yb(dailyInfo.update_time);
                        dVar.lj(z2);
                        dataList.add(dVar);
                    }
                    a.this.geT = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.Z(list) > 0) {
                    int Z = v.Z(a.this.geS.getDataList());
                    if (Z <= 0 || !(dataList.get(Z - 1) instanceof bh)) {
                        str = null;
                    } else {
                        str2 = ((bh) dataList.get(Z - 1)).agk();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.geT = true;
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            bhVar.dN(true);
                            if (!a.this.a(dataList, str2, bhVar)) {
                                String agk = bhVar.agk();
                                if (str3 == null || agk == null || str3.equals(agk)) {
                                    dataList.add(bhVar);
                                } else {
                                    c cVar = new c();
                                    cVar.ya(agk);
                                    dataList.add(cVar);
                                    dataList.add(bhVar);
                                }
                                str3 = agk;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.geT && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.gek != null) {
                    a.this.gek.a(a.this.geS, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            M(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void M(int i, String str) {
            if (a.this.gek != null) {
                a.this.gek.M(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0324a {
        void M(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.geR = new DailyNetModel(tbPageContext);
        this.geR.a(this.geU);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.geR.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bh bhVar) {
        if (v.aa(list) || bhVar == null || str == null || !str.equals(bhVar.agk())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bh)) {
                return false;
            }
            bh bhVar2 = (bh) mVar;
            if (bhVar2.agk() == null || !bhVar2.agk().equals(bhVar.agk())) {
                return false;
            }
            if (bhVar2.getId() != null && bhVar2.getId().equals(bhVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.geR.refresh();
    }

    public void aIS() {
        this.geR.aIS();
    }

    public void a(InterfaceC0324a interfaceC0324a) {
        this.gek = interfaceC0324a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean bvy() {
        return this.geT;
    }

    public boolean pP() {
        return this.geR.pP();
    }

    public boolean auT() {
        return this.geS.auT();
    }

    public void onDestroy() {
        this.geR.onDestroy();
    }
}
