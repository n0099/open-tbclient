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
    private InterfaceC0321a fYu;
    private DailyNetModel fZa;
    private boolean fZc;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b fZb = new b();
    private DailyNetModel.a fZd = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.fZb.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.fZb.cA(dataRes.banner);
                    dataList.clear();
                    e cB = e.cB(dataRes.topic);
                    if (cB != null) {
                        dataList.add(cB);
                    }
                    boolean z2 = (a.this.fZb.bsX() == null && cB == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.xu(dailyInfo.tab_name);
                        dVar.xt(dailyInfo.update_time);
                        dVar.kY(z2);
                        dataList.add(dVar);
                    }
                    a.this.fZc = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.Z(list) > 0) {
                    int Z = v.Z(a.this.fZb.getDataList());
                    if (Z <= 0 || !(dataList.get(Z - 1) instanceof bg)) {
                        str = null;
                    } else {
                        str2 = ((bg) dataList.get(Z - 1)).afh();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.fZc = true;
                            bg bgVar = new bg();
                            bgVar.a(threadInfo);
                            bgVar.dJ(true);
                            if (!a.this.a(dataList, str2, bgVar)) {
                                String afh = bgVar.afh();
                                if (str3 == null || afh == null || str3.equals(afh)) {
                                    dataList.add(bgVar);
                                } else {
                                    c cVar = new c();
                                    cVar.xs(afh);
                                    dataList.add(cVar);
                                    dataList.add(bgVar);
                                }
                                str3 = afh;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.fZc && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.fYu != null) {
                    a.this.fYu.a(a.this.fZb, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            M(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void M(int i, String str) {
            if (a.this.fYu != null) {
                a.this.fYu.M(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0321a {
        void M(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fZa = new DailyNetModel(tbPageContext);
        this.fZa.a(this.fZd);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fZa.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bg bgVar) {
        if (v.aa(list) || bgVar == null || str == null || !str.equals(bgVar.afh())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bg)) {
                return false;
            }
            bg bgVar2 = (bg) mVar;
            if (bgVar2.afh() == null || !bgVar2.afh().equals(bgVar.afh())) {
                return false;
            }
            if (bgVar2.getId() != null && bgVar2.getId().equals(bgVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.fZa.refresh();
    }

    public void aHq() {
        this.fZa.aHq();
    }

    public void a(InterfaceC0321a interfaceC0321a) {
        this.fYu = interfaceC0321a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean btf() {
        return this.fZc;
    }

    public boolean pu() {
        return this.fZa.pu();
    }

    public boolean atJ() {
        return this.fZb.atJ();
    }

    public void onDestroy() {
        this.fZa.onDestroy();
    }
}
