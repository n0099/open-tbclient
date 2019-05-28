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
    private InterfaceC0321a fYv;
    private DailyNetModel fZb;
    private boolean fZd;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b fZc = new b();
    private DailyNetModel.a fZe = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.fZc.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.fZc.cA(dataRes.banner);
                    dataList.clear();
                    e cB = e.cB(dataRes.topic);
                    if (cB != null) {
                        dataList.add(cB);
                    }
                    boolean z2 = (a.this.fZc.bta() == null && cB == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.xu(dailyInfo.tab_name);
                        dVar.xt(dailyInfo.update_time);
                        dVar.kY(z2);
                        dataList.add(dVar);
                    }
                    a.this.fZd = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.Z(list) > 0) {
                    int Z = v.Z(a.this.fZc.getDataList());
                    if (Z <= 0 || !(dataList.get(Z - 1) instanceof bg)) {
                        str = null;
                    } else {
                        str2 = ((bg) dataList.get(Z - 1)).afh();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.fZd = true;
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
                if (z && !a.this.fZd && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.fYv != null) {
                    a.this.fYv.a(a.this.fZc, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            M(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void M(int i, String str) {
            if (a.this.fYv != null) {
                a.this.fYv.M(i, str);
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
        this.fZb = new DailyNetModel(tbPageContext);
        this.fZb.a(this.fZe);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fZb.setUniqueId(bdUniqueId);
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
        this.fZb.refresh();
    }

    public void aHt() {
        this.fZb.aHt();
    }

    public void a(InterfaceC0321a interfaceC0321a) {
        this.fYv = interfaceC0321a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean bti() {
        return this.fZd;
    }

    public boolean pu() {
        return this.fZb.pu();
    }

    public boolean atJ() {
        return this.fZc.atJ();
    }

    public void onDestroy() {
        this.fZb.onDestroy();
    }
}
