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
    private DailyNetModel evS;
    private boolean evU;
    private InterfaceC0236a evo;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b evT = new b();
    private DailyNetModel.a evV = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.evT.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.evT.ck(dataRes.banner);
                    dataList.clear();
                    e cl = e.cl(dataRes.topic);
                    if (cl != null) {
                        dataList.add(cl);
                    }
                    boolean z2 = (a.this.evT.aLC() == null && cl == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.pE(dailyInfo.tab_name);
                        dVar.pD(dailyInfo.update_time);
                        dVar.hP(z2);
                        dataList.add(dVar);
                    }
                    a.this.evU = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.H(list) > 0) {
                    int H = v.H(a.this.evT.getDataList());
                    if (H <= 0 || !(dataList.get(H - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(H - 1)).Bx();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.evU = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.bf(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String Bx = bbVar.Bx();
                                if (str3 == null || Bx == null || str3.equals(Bx)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.pC(Bx);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = Bx;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.evU && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.evo != null) {
                    a.this.evo.a(a.this.evT, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            t(-1, a.this.mPageContext.getString(e.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void t(int i, String str) {
            if (a.this.evo != null) {
                a.this.evo.t(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0236a {
        void a(b bVar, boolean z, boolean z2);

        void t(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.evS = new DailyNetModel(tbPageContext);
        this.evS.a(this.evV);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.evS.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (v.I(list) || bbVar == null || str == null || !str.equals(bbVar.Bx())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.Bx() == null || !bbVar2.Bx().equals(bbVar.Bx())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.evS.refresh();
    }

    public void aaA() {
        this.evS.aaA();
    }

    public void a(InterfaceC0236a interfaceC0236a) {
        this.evo = interfaceC0236a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aLK() {
        return this.evU;
    }

    public boolean Fv() {
        return this.evS.Fv();
    }

    public boolean Pd() {
        return this.evT.Pd();
    }

    public void onDestroy() {
        this.evS.onDestroy();
    }
}
