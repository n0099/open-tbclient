package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.b.c;
import com.baidu.tieba.homepage.daily.b.d;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.homepage.daily.model.DailyNetModel;
import java.util.List;
import tbclient.DailyInfo;
import tbclient.DailyPage.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    private DailyNetModel dUX;
    private boolean dUZ;
    private InterfaceC0163a dUt;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b dUY = new b();
    private DailyNetModel.a dVa = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.dUY.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.dUY.bP(dataRes.banner);
                    dataList.clear();
                    e bQ = e.bQ(dataRes.topic);
                    if (bQ != null) {
                        dataList.add(bQ);
                    }
                    boolean z2 = (a.this.dUY.aDy() == null && bQ == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.nx(dailyInfo.tab_name);
                        dVar.nw(dailyInfo.update_time);
                        dVar.gK(z2);
                        dataList.add(dVar);
                    }
                    a.this.dUZ = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (w.y(list) > 0) {
                    int y = w.y(a.this.dUY.getDataList());
                    if (y <= 0 || !(dataList.get(y - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(y - 1)).wK();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.dUZ = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.at(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String wK = bbVar.wK();
                                if (str3 == null || wK == null || str3.equals(wK)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.nv(wK);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = wK;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.dUZ && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.dUt != null) {
                    a.this.dUt.a(a.this.dUY, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            s(-1, a.this.mPageContext.getString(d.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void s(int i, String str) {
            if (a.this.dUt != null) {
                a.this.dUt.s(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0163a {
        void a(b bVar, boolean z, boolean z2);

        void s(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.dUX = new DailyNetModel(tbPageContext);
        this.dUX.a(this.dVa);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dUX.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (w.z(list) || bbVar == null || str == null || !str.equals(bbVar.wK())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.wK() == null || !bbVar2.wK().equals(bbVar.wK())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.dUX.refresh();
    }

    public void Tn() {
        this.dUX.Tn();
    }

    public void a(InterfaceC0163a interfaceC0163a) {
        this.dUt = interfaceC0163a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aDG() {
        return this.dUZ;
    }

    public boolean AE() {
        return this.dUX.AE();
    }

    public boolean Kf() {
        return this.dUY.Kf();
    }

    public void onDestroy() {
        this.dUX.onDestroy();
    }
}
