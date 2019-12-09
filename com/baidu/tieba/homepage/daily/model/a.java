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
    private InterfaceC0419a geI;
    private DailyNetModel gfo;
    private boolean gfq;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b gfp = new b();
    private DailyNetModel.a gfr = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.gfp.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.gfp.cN(dataRes.banner);
                    dataList.clear();
                    e cO = e.cO(dataRes.topic);
                    if (cO != null) {
                        dataList.add(cO);
                    }
                    boolean z2 = (a.this.gfp.bth() == null && cO == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.wU(dailyInfo.tab_name);
                        dVar.wT(dailyInfo.update_time);
                        dVar.la(z2);
                        dataList.add(dVar);
                    }
                    a.this.gfq = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.getCount(list) > 0) {
                    int count = v.getCount(a.this.gfp.getDataList());
                    if (count <= 0 || !(dataList.get(count - 1) instanceof bh)) {
                        str = null;
                    } else {
                        str2 = ((bh) dataList.get(count - 1)).akp();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.gfq = true;
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            bhVar.ed(true);
                            if (!a.this.a(dataList, str2, bhVar)) {
                                String akp = bhVar.akp();
                                if (str3 == null || akp == null || str3.equals(akp)) {
                                    dataList.add(bhVar);
                                } else {
                                    c cVar = new c();
                                    cVar.wS(akp);
                                    dataList.add(cVar);
                                    dataList.add(bhVar);
                                }
                                str3 = akp;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.gfq && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.geI != null) {
                    a.this.geI.a(a.this.gfp, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            O(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void O(int i, String str) {
            if (a.this.geI != null) {
                a.this.geI.O(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0419a {
        void O(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gfo = new DailyNetModel(tbPageContext);
        this.gfo.a(this.gfr);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gfo.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bh bhVar) {
        if (v.isEmpty(list) || bhVar == null || str == null || !str.equals(bhVar.akp())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bh)) {
                return false;
            }
            bh bhVar2 = (bh) mVar;
            if (bhVar2.akp() == null || !bhVar2.akp().equals(bhVar.akp())) {
                return false;
            }
            if (bhVar2.getId() != null && bhVar2.getId().equals(bhVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.gfo.refresh();
    }

    public void aIU() {
        this.gfo.aIU();
    }

    public void a(InterfaceC0419a interfaceC0419a) {
        this.geI = interfaceC0419a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean btp() {
        return this.gfq;
    }

    public boolean isLoading() {
        return this.gfo.isLoading();
    }

    public boolean we() {
        return this.gfp.we();
    }

    public void onDestroy() {
        this.gfo.onDestroy();
    }
}
