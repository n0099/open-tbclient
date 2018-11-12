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
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0225a ekV;
    private boolean elB;
    private DailyNetModel elz;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b elA = new b();
    private DailyNetModel.a elC = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.elA.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.elA.ce(dataRes.banner);
                    dataList.clear();
                    e cf = e.cf(dataRes.topic);
                    if (cf != null) {
                        dataList.add(cf);
                    }
                    boolean z2 = (a.this.elA.aIy() == null && cf == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.oJ(dailyInfo.tab_name);
                        dVar.oI(dailyInfo.update_time);
                        dVar.hK(z2);
                        dataList.add(dVar);
                    }
                    a.this.elB = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.H(list) > 0) {
                    int H = v.H(a.this.elA.getDataList());
                    if (H <= 0 || !(dataList.get(H - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(H - 1)).Ag();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.elB = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.bd(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String Ag = bbVar.Ag();
                                if (str3 == null || Ag == null || str3.equals(Ag)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.oH(Ag);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = Ag;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.elB && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.ekV != null) {
                    a.this.ekV.a(a.this.elA, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            r(-1, a.this.mPageContext.getString(e.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void r(int i, String str) {
            if (a.this.ekV != null) {
                a.this.ekV.r(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0225a {
        void a(b bVar, boolean z, boolean z2);

        void r(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.elz = new DailyNetModel(tbPageContext);
        this.elz.a(this.elC);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.elz.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (v.I(list) || bbVar == null || str == null || !str.equals(bbVar.Ag())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.Ag() == null || !bbVar2.Ag().equals(bbVar.Ag())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.elz.refresh();
    }

    public void YV() {
        this.elz.YV();
    }

    public void a(InterfaceC0225a interfaceC0225a) {
        this.ekV = interfaceC0225a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aIG() {
        return this.elB;
    }

    public boolean Ee() {
        return this.elz.Ee();
    }

    public boolean NG() {
        return this.elA.NG();
    }

    public void onDestroy() {
        this.elz.onDestroy();
    }
}
