package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bg;
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
    private BdTypeRecyclerView Op;
    private FrsCommonTabFragment fAV;
    private com.baidu.tieba.frs.entelechy.a.d fAW;
    private com.baidu.tieba.frs.entelechy.a.d fAX;
    private v fAY;
    private z fAZ;
    private z fBa;
    private boolean fBb;
    private l fyB;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fBc = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aZP()) && a.this.mAdapters != null) {
                        ((y) aVar).a(a.this.fAV.getPageContext(), a.this.fAV.getUniqueId());
                        if (a.this.fBb) {
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
        this.Op = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fAV = frsCommonTabFragment;
        this.fBc.setPriority(1);
        this.fBc.setSelfListener(true);
        this.fAV.registerListener(this.fBc);
        this.fAW = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bJj, this.fAV.getUniqueId());
        this.fAW.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fAX = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bJw, this.fAV.getUniqueId());
        this.fAX.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fAY = new v(frsCommonTabFragment.getPageContext(), bg.bJB, this.fAV.getUniqueId());
        this.fAZ = new z(frsCommonTabFragment.getPageContext(), bg.bJx, this.fAV.getUniqueId());
        this.fAZ.fBi = this.fAV.fBi;
        this.fBa = new z(frsCommonTabFragment.getPageContext(), bg.bJC, this.fAV.getUniqueId());
        this.fBa.fBi = this.fAV.fBi;
        this.fyB = new l(frsCommonTabFragment.getPageContext(), m.fwJ);
        this.mAdapters.add(this.fAW);
        this.mAdapters.add(this.fAX);
        this.mAdapters.add(this.fAY);
        this.mAdapters.add(this.fAZ);
        this.mAdapters.add(this.fBa);
        this.mAdapters.add(this.fyB);
        if (frsCommonTabFragment.tabId == 89) {
            this.fBb = true;
            this.fAW.setFrom("c13010");
            this.fAX.setFrom("c13010");
            this.fAY.setFrom("c13010");
            this.fAZ.setFrom("c13010");
            this.fBa.setFrom("c13010");
            sm("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bow();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Op.setData(arrayList);
    }

    private void bow() {
        if (this.fAV != null && !com.baidu.tbadk.core.util.v.aa(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.boU() != null) {
                        dVar.boU().fOD = this.fAV.fBh;
                        dVar.boU().fOF = this.fAV.forumId;
                        dVar.boU().fOG = this.fAV.tabId;
                        if (this.fAV.tabId == 502) {
                            dVar.boU().fOI = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Op.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void sm(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).sm(str);
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

    public void kv(boolean z) {
        if (this.fAW != null) {
            this.fAW.kx(z);
        }
        if (this.fAX != null) {
            this.fAX.kx(z);
        }
        if (this.fAZ != null) {
            this.fAZ.kx(z);
        }
        if (this.fBa != null) {
            this.fBa.kx(z);
        }
    }
}
