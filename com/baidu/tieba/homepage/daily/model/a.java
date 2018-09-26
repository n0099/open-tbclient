package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
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
    private InterfaceC0165a ebH;
    private DailyNetModel ecl;
    private boolean ecn;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b ecm = new b();
    private DailyNetModel.a eco = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.ecm.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.ecm.bQ(dataRes.banner);
                    dataList.clear();
                    e bR = e.bR(dataRes.topic);
                    if (bR != null) {
                        dataList.add(bR);
                    }
                    boolean z2 = (a.this.ecm.aFI() == null && bR == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.oe(dailyInfo.tab_name);
                        dVar.od(dailyInfo.update_time);
                        dVar.hi(z2);
                        dataList.add(dVar);
                    }
                    a.this.ecn = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.y(list) > 0) {
                    int y = v.y(a.this.ecm.getDataList());
                    if (y <= 0 || !(dataList.get(y - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(y - 1)).xQ();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.ecn = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.aD(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String xQ = bbVar.xQ();
                                if (str3 == null || xQ == null || str3.equals(xQ)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.oc(xQ);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = xQ;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.ecn && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.ebH != null) {
                    a.this.ebH.a(a.this.ecm, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            s(-1, a.this.mPageContext.getString(e.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void s(int i, String str) {
            if (a.this.ebH != null) {
                a.this.ebH.s(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0165a {
        void a(b bVar, boolean z, boolean z2);

        void s(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ecl = new DailyNetModel(tbPageContext);
        this.ecl.a(this.eco);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ecl.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (v.z(list) || bbVar == null || str == null || !str.equals(bbVar.xQ())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.xQ() == null || !bbVar2.xQ().equals(bbVar.xQ())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.ecl.refresh();
    }

    public void Vd() {
        this.ecl.Vd();
    }

    public void a(InterfaceC0165a interfaceC0165a) {
        this.ebH = interfaceC0165a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aFQ() {
        return this.ecn;
    }

    public boolean BO() {
        return this.ecl.BO();
    }

    public boolean Lz() {
        return this.ecm.Lz();
    }

    public void onDestroy() {
        this.ecl.onDestroy();
    }
}
