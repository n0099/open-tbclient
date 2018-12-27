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
    private InterfaceC0236a euH;
    private DailyNetModel evl;
    private boolean evn;
    private boolean mHasMore;
    private TbPageContext mPageContext;
    private b evm = new b();
    private DailyNetModel.a evo = new DailyNetModel.a() { // from class: com.baidu.tieba.homepage.daily.model.a.1
        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void a(DataRes dataRes, boolean z) {
            String str;
            String str2 = null;
            if (dataRes != null) {
                List<h> dataList = a.this.evm.getDataList();
                DailyInfo dailyInfo = dataRes.daily_info;
                if (z) {
                    a.this.evm.cj(dataRes.banner);
                    dataList.clear();
                    e ck = e.ck(dataRes.topic);
                    if (ck != null) {
                        dataList.add(ck);
                    }
                    boolean z2 = (a.this.evm.aLe() == null && ck == null) ? false : true;
                    if (dailyInfo != null) {
                        d dVar = new d();
                        dVar.po(dailyInfo.tab_name);
                        dVar.pn(dailyInfo.update_time);
                        dVar.hP(z2);
                        dataList.add(dVar);
                    }
                    a.this.evn = false;
                }
                List<ThreadInfo> list = dailyInfo != null ? dailyInfo.thread_list : null;
                if (v.H(list) > 0) {
                    int H = v.H(a.this.evm.getDataList());
                    if (H <= 0 || !(dataList.get(H - 1) instanceof bb)) {
                        str = null;
                    } else {
                        str2 = ((bb) dataList.get(H - 1)).Bk();
                        str = str2;
                    }
                    String str3 = str;
                    for (ThreadInfo threadInfo : list) {
                        if (threadInfo != null) {
                            a.this.evn = true;
                            bb bbVar = new bb();
                            bbVar.a(threadInfo);
                            bbVar.be(true);
                            if (!a.this.a(dataList, str2, bbVar)) {
                                String Bk = bbVar.Bk();
                                if (str3 == null || Bk == null || str3.equals(Bk)) {
                                    dataList.add(bbVar);
                                } else {
                                    c cVar = new c();
                                    cVar.pm(Bk);
                                    dataList.add(cVar);
                                    dataList.add(bbVar);
                                }
                                str3 = Bk;
                            }
                        }
                    }
                }
                int size = dataList.size();
                if (z && !a.this.evn && size > 0 && (dataList.get(size - 1) instanceof d)) {
                    dataList.remove(size - 1);
                }
                if (dailyInfo != null) {
                    a.this.mHasMore = dailyInfo.has_more.intValue() == 1;
                }
                if (a.this.euH != null) {
                    a.this.euH.a(a.this.evm, z, a.this.mHasMore);
                    return;
                }
                return;
            }
            r(-1, a.this.mPageContext.getString(e.j.data_load_error));
        }

        @Override // com.baidu.tieba.homepage.daily.model.DailyNetModel.a
        public void r(int i, String str) {
            if (a.this.euH != null) {
                a.this.euH.r(i, str);
            }
        }
    };

    /* renamed from: com.baidu.tieba.homepage.daily.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0236a {
        void a(b bVar, boolean z, boolean z2);

        void r(int i, String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.evl = new DailyNetModel(tbPageContext);
        this.evl.a(this.evo);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.evl.setUniqueId(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<h> list, String str, bb bbVar) {
        if (v.I(list) || bbVar == null || str == null || !str.equals(bbVar.Bk())) {
            return false;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h hVar = list.get(size);
            if (!(hVar instanceof bb)) {
                return false;
            }
            bb bbVar2 = (bb) hVar;
            if (bbVar2.Bk() == null || !bbVar2.Bk().equals(bbVar.Bk())) {
                return false;
            }
            if (bbVar2.getId() != null && bbVar2.getId().equals(bbVar.getId())) {
                return true;
            }
        }
        return false;
    }

    public void refresh() {
        this.evl.refresh();
    }

    public void aad() {
        this.evl.aad();
    }

    public void a(InterfaceC0236a interfaceC0236a) {
        this.euH = interfaceC0236a;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean aLm() {
        return this.evn;
    }

    public boolean Fi() {
        return this.evl.Fi();
    }

    public boolean OL() {
        return this.evm.OL();
    }

    public void onDestroy() {
        this.evl.onDestroy();
    }
}
