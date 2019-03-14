package com.baidu.tieba.homepage.daily.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0303a fHK;
    private DailyNetModel fIr;
    private boolean fIt;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b fIs = new b();
    private DailyNetModel.a fIu = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.fIs.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.fIs.cv(dataRes.banner);
                    dataList.clear();
                    e cw = e.cw(dataRes.topic);
                    if (cw != null) {
                        dataList.add(cw);
                    }
                    boolean z2 = (a.this.fIs.blE() == null && cw == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.wg(dailyInfo.tab_name);
                        dVar.wf(dailyInfo.update_time);
                        dVar.kj(z2);
                        dataList.add(dVar);
                    }
                    a.this.fIt = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.S(list) > 0) {
                    int S = v.S(a.this.fIs.getDataList());
                    if (S <= 0 || !(dataList.get(S - 1) instanceof bg)) {
                        str = null;
                    } else {
                        str2 = ((bg) dataList.get(S - 1)).aaD();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.fIt = true;
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            bgVar.m18do(true);
                            if (!a.this.a(dataList, str2, bgVar)) {
                                String aaD = bgVar.aaD();
                                if (str3 == null || aaD == null || str3.equals(aaD)) {
                                    dataList.add(bgVar);
                                } else {
                                    c cVar = new c();
                                    cVar.we(aaD);
                                    dataList.add(cVar);
                                    dataList.add(bgVar);
                                }
                                str3 = aaD;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.fIt && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.fHK != null) {
                    a.this.fHK.a(a.this.fIs, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            J(-1, a.this.mPageContext.getString(d.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void J(int i, String str) {
            if (a.this.fHK != null) {
                a.this.fHK.J(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0303a {
        void J(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fIr = new DailyNetModel(tbPageContext);
        this.fIr.a(this.fIu);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIr.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bg bgVar) {
        if (v.T(list) || bgVar == null || str == null || !str.equals(bgVar.aaD())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bg)) {
                return false;
            }
            bg bgVar2 = (bg) mVar;
            if (bgVar2.aaD() == null || !bgVar2.aaD().equals(bgVar.aaD())) {
                return false;
            }
            if (bgVar2.getId() != null && bgVar2.getId().equals(bgVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.fIr.refresh();
    }

    public void aBc() {
        this.fIr.aBc();
    }

    public void a(InterfaceC0303a interfaceC0303a) {
        this.fHK = interfaceC0303a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean blM() {
        return this.fIt;
    }

    public boolean qz() {
        return this.fIr.qz();
    }

    public boolean aoI() {
        return this.fIs.aoI();
    }

    public void onDestroy() {
        this.fIr.onDestroy();
    }
}
