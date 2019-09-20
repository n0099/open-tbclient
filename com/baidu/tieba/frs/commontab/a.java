package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Oo;
    private l fAN;
    private z fDA;
    private z fDB;
    private boolean fDC;
    private FrsCommonTabFragment fDw;
    private com.baidu.tieba.frs.entelechy.a.d fDx;
    private com.baidu.tieba.frs.entelechy.a.d fDy;
    private v fDz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fDD = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).bav()) && a.this.mAdapters != null) {
                        ((y) aVar).a(a.this.fDw.getPageContext(), a.this.fDw.getUniqueId());
                        if (a.this.fDC) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Oo = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fDw = frsCommonTabFragment;
        this.fDD.setPriority(1);
        this.fDD.setSelfListener(true);
        this.fDw.registerListener(this.fDD);
        this.fDx = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.bJM, this.fDw.getUniqueId());
        this.fDx.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fDy = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.bJZ, this.fDw.getUniqueId());
        this.fDy.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fDz = new v(frsCommonTabFragment.getPageContext(), bh.bKe, this.fDw.getUniqueId());
        this.fDA = new z(frsCommonTabFragment.getPageContext(), bh.bKa, this.fDw.getUniqueId());
        this.fDA.fDJ = this.fDw.fDJ;
        this.fDB = new z(frsCommonTabFragment.getPageContext(), bh.bKf, this.fDw.getUniqueId());
        this.fDB.fDJ = this.fDw.fDJ;
        this.fAN = new l(frsCommonTabFragment.getPageContext(), m.fyV);
        this.mAdapters.add(this.fDx);
        this.mAdapters.add(this.fDy);
        this.mAdapters.add(this.fDz);
        this.mAdapters.add(this.fDA);
        this.mAdapters.add(this.fDB);
        this.mAdapters.add(this.fAN);
        if (frsCommonTabFragment.tabId == 89) {
            this.fDC = true;
            this.fDx.setFrom("c13010");
            this.fDy.setFrom("c13010");
            this.fDz.setFrom("c13010");
            this.fDA.setFrom("c13010");
            this.fDB.setFrom("c13010");
            sy("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bpu();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Oo.setData(arrayList);
    }

    private void bpu() {
        if (this.fDw != null && !com.baidu.tbadk.core.util.v.aa(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bpS() != null) {
                        dVar.bpS().fRi = this.fDw.fDI;
                        dVar.bpS().fRk = this.fDw.forumId;
                        dVar.bpS().fRl = this.fDw.tabId;
                        if (this.fDw.tabId == 502) {
                            dVar.bpS().fRn = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Oo.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void sy(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).sy(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void ky(boolean z) {
        if (this.fDx != null) {
            this.fDx.kA(z);
        }
        if (this.fDy != null) {
            this.fDy.kA(z);
        }
        if (this.fDA != null) {
            this.fDA.kA(z);
        }
        if (this.fDB != null) {
            this.fDB.kA(z);
        }
    }
}
