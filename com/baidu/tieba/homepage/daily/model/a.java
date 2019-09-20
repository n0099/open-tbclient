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
    private DailyNetModel ggI;
    private boolean ggK;
    private InterfaceC0335a ggc;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b ggJ = new b();
    private DailyNetModel.a ggL = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<m> dataList = a.this.ggJ.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.ggJ.cA(dataRes.banner);
                    dataList.clear();
                    e cB = e.cB(dataRes.topic);
                    if (cB != null) {
                        dataList.add(cB);
                    }
                    boolean z2 = (a.this.ggJ.bwe() == null && cB == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.yB(dailyInfo.tab_name);
                        dVar.yA(dailyInfo.update_time);
                        dVar.lm(z2);
                        dataList.add(dVar);
                    }
                    a.this.ggK = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.Z(list) > 0) {
                    int Z = v.Z(a.this.ggJ.getDataList());
                    if (Z <= 0 || !(dataList.get(Z - 1) instanceof bh)) {
                        str = null;
                    } else {
                        str2 = ((bh) dataList.get(Z - 1)).ago();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.ggK = true;
                            bh bhVar = new bh();
                            bhVar.a(threadInfo);
                            bhVar.dN(true);
                            if (!a.this.a(dataList, str2, bhVar)) {
                                String ago = bhVar.ago();
                                if (str3 == null || ago == null || str3.equals(ago)) {
                                    dataList.add(bhVar);
                                } else {
                                    c cVar = new c();
                                    cVar.yz(ago);
                                    dataList.add(cVar);
                                    dataList.add(bhVar);
                                }
                                str3 = ago;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.ggK && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.ggc != null) {
                    a.this.ggc.a(a.this.ggJ, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            M(-1, a.this.mPageContext.getString(R.string.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void M(int i, String str) {
            if (a.this.ggc != null) {
                a.this.ggc.M(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0335a {
        void M(int i, String str);

        void a(b bVar, boolean z, boolean z2);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ggI = new DailyNetModel(tbPageContext);
        this.ggI.a(this.ggL);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ggI.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<m> list, String str, bh bhVar) {
        if (v.aa(list) || bhVar == null || str == null || !str.equals(bhVar.ago())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            m mVar = list.get(size);
            if (!(mVar instanceof bh)) {
                return false;
            }
            bh bhVar2 = (bh) mVar;
            if (bhVar2.ago() == null || !bhVar2.ago().equals(bhVar.ago())) {
                return false;
            }
            if (bhVar2.getId() != null && bhVar2.getId().equals(bhVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.ggI.refresh();
    }

    public void aJw() {
        this.ggI.aJw();
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.ggc = interfaceC0335a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean bwm() {
        return this.ggK;
    }

    public boolean pQ() {
        return this.ggI.pQ();
    }

    public boolean avf() {
        return this.ggJ.avf();
    }

    public void onDestroy() {
        this.ggI.onDestroy();
    }
}
