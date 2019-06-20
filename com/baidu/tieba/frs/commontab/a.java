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
    private BdTypeRecyclerView NY;
    private l ftF;
    private FrsCommonTabFragment fvZ;
    private com.baidu.tieba.frs.entelechy.a.d fwa;
    private com.baidu.tieba.frs.entelechy.a.d fwb;
    private v fwc;
    private z fwd;
    private z fwe;
    private boolean fwf;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fwg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aXR()) && a.this.mAdapters != null) {
                        ((y) aVar).a(a.this.fvZ.getPageContext(), a.this.fvZ.getUniqueId());
                        if (a.this.fwf) {
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
        this.NY = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fvZ = frsCommonTabFragment;
        this.fwg.setPriority(1);
        this.fwg.setSelfListener(true);
        this.fvZ.registerListener(this.fwg);
        this.fwa = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bIj, this.fvZ.getUniqueId());
        this.fwa.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fwb = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bIw, this.fvZ.getUniqueId());
        this.fwb.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fwc = new v(frsCommonTabFragment.getPageContext(), bg.bIB, this.fvZ.getUniqueId());
        this.fwd = new z(frsCommonTabFragment.getPageContext(), bg.bIx, this.fvZ.getUniqueId());
        this.fwd.fwm = this.fvZ.fwm;
        this.fwe = new z(frsCommonTabFragment.getPageContext(), bg.bIC, this.fvZ.getUniqueId());
        this.fwe.fwm = this.fvZ.fwm;
        this.ftF = new l(frsCommonTabFragment.getPageContext(), m.frM);
        this.mAdapters.add(this.fwa);
        this.mAdapters.add(this.fwb);
        this.mAdapters.add(this.fwc);
        this.mAdapters.add(this.fwd);
        this.mAdapters.add(this.fwe);
        this.mAdapters.add(this.ftF);
        if (frsCommonTabFragment.tabId == 89) {
            this.fwf = true;
            this.fwa.setFrom("c13010");
            this.fwb.setFrom("c13010");
            this.fwc.setFrom("c13010");
            this.fwd.setFrom("c13010");
            this.fwe.setFrom("c13010");
            rU("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bmv();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.NY.setData(arrayList);
    }

    private void bmv() {
        if (this.fvZ != null && !com.baidu.tbadk.core.util.v.aa(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bmT() != null) {
                        dVar.bmT().fJF = this.fvZ.fwl;
                        dVar.bmT().fJH = this.fvZ.forumId;
                        dVar.bmT().fJI = this.fvZ.tabId;
                        if (this.fvZ.tabId == 502) {
                            dVar.bmT().fJK = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.NY.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void rU(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).rU(str);
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

    public void kl(boolean z) {
        if (this.fwa != null) {
            this.fwa.kn(z);
        }
        if (this.fwb != null) {
            this.fwb.kn(z);
        }
        if (this.fwd != null) {
            this.fwd.kn(z);
        }
        if (this.fwe != null) {
            this.fwe.kn(z);
        }
    }
}
