package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
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
    private InterfaceC0324a gdu;
    private DailyNetModel gea;
    private boolean gec;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b geb = new b();
    private DailyNetModel.a ged = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.geb.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.geb.cB(dataRes.banner);
                    dataList.clear();
                    e cC = e.cC(dataRes.topic);
                    if (cC != null) {
                        dataList.add(cC);
                    }
                    boolean z2 = (a.this.geb.bvd() == null && cC == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.yb(dailyInfo.tab_name);
                        dVar.ya(dailyInfo.update_time);
                        dVar.lj(z2);
                        dataList.add(dVar);
                    }
                    a.this.gec = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.Z(list) > 0) {
                    int Z = v.Z(a.this.geb.getDataList());
                    if (Z <= 0 || !(dataList.get(Z - 1) instanceof bg)) {
                        str = null;
                    } else {
                        str2 = ((bg) dataList.get(Z - 1)).agj();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.gec = true;
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            bgVar.dN(true);
                            if (!a.this.a(dataList, str2, bgVar)) {
                                String agj = bgVar.agj();
                                if (str3 == null || agj == null || str3.equals(agj)) {
                                    dataList.add(bgVar);
                                } else {
                                    c cVar = new c();
                                    cVar.xZ(agj);
                                    dataList.add(cVar);
                                    dataList.add(bgVar);
                                }
                                str3 = agj;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.gec && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.gdu != null) {
                    a.this.gdu.a(a.this.geb, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            M(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void M(int i, String str) {
            if (a.this.gdu != null) {
                a.this.gdu.M(i, str);
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
        this.gea = new DailyNetModel(tbPageContext);
        this.gea.a(this.ged);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gea.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bg bgVar) {
        if (v.aa(list) || bgVar == null || str == null || !str.equals(bgVar.agj())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bg)) {
                return false;
            }
            bg bgVar2 = (bg) mVar;
            if (bgVar2.agj() == null || !bgVar2.agj().equals(bgVar.agj())) {
                return false;
            }
            if (bgVar2.getId() != null && bgVar2.getId().equals(bgVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.gea.refresh();
    }

    public void aIQ() {
        this.gea.aIQ();
    }

    public void a(InterfaceC0324a interfaceC0324a) {
        this.gdu = interfaceC0324a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean bvl() {
        return this.gec;
    }

    public boolean pP() {
        return this.gea.pP();
    }

    public boolean auR() {
        return this.geb.auR();
    }

    public void onDestroy() {
        this.gea.onDestroy();
    }
}
