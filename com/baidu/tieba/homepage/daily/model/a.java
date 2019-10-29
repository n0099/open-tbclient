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
    private InterfaceC0424a gfz;
    private DailyNetModel ggf;
    private boolean ggh;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b ggg = new b();
    private DailyNetModel.a ggi = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.ggg.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.ggg.cN(dataRes.banner);
                    dataList.clear();
                    e cO = e.cO(dataRes.topic);
                    if (cO != null) {
                        dataList.add(cO);
                    }
                    boolean z2 = (a.this.ggg.btj() == null && cO == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.wU(dailyInfo.tab_name);
                        dVar.wT(dailyInfo.update_time);
                        dVar.la(z2);
                        dataList.add(dVar);
                    }
                    a.this.ggh = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.getCount(list) > 0) {
                    int count = v.getCount(a.this.ggg.getDataList());
                    if (count <= 0 || !(dataList.get(count - 1) instanceof bh)) {
                        str = null;
                    } else {
                        str2 = ((bh) dataList.get(count - 1)).akr();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.ggh = true;
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            bhVar.ed(true);
                            if (!a.this.a(dataList, str2, bhVar)) {
                                String akr = bhVar.akr();
                                if (str3 == null || akr == null || str3.equals(akr)) {
                                    dataList.add(bhVar);
                                } else {
                                    c cVar = new c();
                                    cVar.wS(akr);
                                    dataList.add(cVar);
                                    dataList.add(bhVar);
                                }
                                str3 = akr;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.ggh && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.gfz != null) {
                    a.this.gfz.a(a.this.ggg, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            P(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void P(int i, String str) {
            if (a.this.gfz != null) {
                a.this.gfz.P(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0424a {
        void P(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ggf = new DailyNetModel(tbPageContext);
        this.ggf.a(this.ggi);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ggf.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bh bhVar) {
        if (v.isEmpty(list) || bhVar == null || str == null || !str.equals(bhVar.akr())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bh)) {
                return false;
            }
            bh bhVar2 = (bh) mVar;
            if (bhVar2.akr() == null || !bhVar2.akr().equals(bhVar.akr())) {
                return false;
            }
            if (bhVar2.getId() != null && bhVar2.getId().equals(bhVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.ggf.refresh();
    }

    public void aIW() {
        this.ggf.aIW();
    }

    public void a(InterfaceC0424a interfaceC0424a) {
        this.gfz = interfaceC0424a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean btr() {
        return this.ggh;
    }

    public boolean isLoading() {
        return this.ggf.isLoading();
    }

    public boolean wd() {
        return this.ggg.wd();
    }

    public void onDestroy() {
        this.ggf.onDestroy();
    }
}
