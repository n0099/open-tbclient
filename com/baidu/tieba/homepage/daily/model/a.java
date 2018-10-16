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
    private InterfaceC0199a ejA;
    private DailyNetModel eke;
    private boolean ekg;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b ekf = new b();
    private DailyNetModel.a ekh = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.ekf.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.ekf.cg(dataRes.banner);
                    dataList.clear();
                    e ch = e.ch(dataRes.topic);
                    if (ch != null) {
                        dataList.add(ch);
                    }
                    boolean z2 = (a.this.ekf.aJa() == null && ch == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.oI(dailyInfo.tab_name);
                        dVar.oH(dailyInfo.update_time);
                        dVar.hA(z2);
                        dataList.add(dVar);
                    }
                    a.this.ekg = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.I(list) > 0) {
                    int I = v.I(a.this.ekf.getDataList());
                    if (I <= 0 || !(dataList.get(I - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(I - 1)).zZ();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.ekg = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.aN(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String zZ = bbVar.zZ();
                                if (str3 == null || zZ == null || str3.equals(zZ)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.oG(zZ);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = zZ;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.ekg && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.ejA != null) {
                    a.this.ejA.a(a.this.ekf, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            s(-1, a.this.mPageContext.getString(e.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void s(int i, String str) {
            if (a.this.ejA != null) {
                a.this.ejA.s(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0199a {
        void a(b bVar, boolean z, boolean z2);

        void s(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eke = new DailyNetModel(tbPageContext);
        this.eke.a(this.ekh);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eke.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (v.J(list) || bbVar == null || str == null || !str.equals(bbVar.zZ())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.zZ() == null || !bbVar2.zZ().equals(bbVar.zZ())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.eke.refresh();
    }

    public void YK() {
        this.eke.YK();
    }

    public void a(InterfaceC0199a interfaceC0199a) {
        this.ejA = interfaceC0199a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aJi() {
        return this.ekg;
    }

    public boolean DU() {
        return this.eke.DU();
    }

    public boolean Nx() {
        return this.ekf.Nx();
    }

    public void onDestroy() {
        this.eke.onDestroy();
    }
}
