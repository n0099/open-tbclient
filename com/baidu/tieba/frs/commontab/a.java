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
    private BdTypeRecyclerView NZ;
    private l ftE;
    private FrsCommonTabFragment fvY;
    private com.baidu.tieba.frs.entelechy.a.d fvZ;
    private com.baidu.tieba.frs.entelechy.a.d fwa;
    private v fwb;
    private z fwc;
    private z fwd;
    private boolean fwe;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener fwf = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aXO()) && a.this.mAdapters != null) {
                        ((y) aVar).a(a.this.fvY.getPageContext(), a.this.fvY.getUniqueId());
                        if (a.this.fwe) {
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
        this.NZ = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fvY = frsCommonTabFragment;
        this.fwf.setPriority(1);
        this.fwf.setSelfListener(true);
        this.fvY.registerListener(this.fwf);
        this.fvZ = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bIi, this.fvY.getUniqueId());
        this.fvZ.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fwa = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bIv, this.fvY.getUniqueId());
        this.fwa.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fwb = new v(frsCommonTabFragment.getPageContext(), bg.bIA, this.fvY.getUniqueId());
        this.fwc = new z(frsCommonTabFragment.getPageContext(), bg.bIw, this.fvY.getUniqueId());
        this.fwc.fwl = this.fvY.fwl;
        this.fwd = new z(frsCommonTabFragment.getPageContext(), bg.bIB, this.fvY.getUniqueId());
        this.fwd.fwl = this.fvY.fwl;
        this.ftE = new l(frsCommonTabFragment.getPageContext(), m.frL);
        this.mAdapters.add(this.fvZ);
        this.mAdapters.add(this.fwa);
        this.mAdapters.add(this.fwb);
        this.mAdapters.add(this.fwc);
        this.mAdapters.add(this.fwd);
        this.mAdapters.add(this.ftE);
        if (frsCommonTabFragment.tabId == 89) {
            this.fwe = true;
            this.fvZ.setFrom("c13010");
            this.fwa.setFrom("c13010");
            this.fwb.setFrom("c13010");
            this.fwc.setFrom("c13010");
            this.fwd.setFrom("c13010");
            rV("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bms();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.NZ.setData(arrayList);
    }

    private void bms() {
        if (this.fvY != null && !com.baidu.tbadk.core.util.v.aa(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bmQ() != null) {
                        dVar.bmQ().fJC = this.fvY.fwk;
                        dVar.bmQ().fJE = this.fvY.forumId;
                        dVar.bmQ().fJF = this.fvY.tabId;
                        if (this.fvY.tabId == 502) {
                            dVar.bmQ().fJH = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.NZ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void rV(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).rV(str);
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
        if (this.fvZ != null) {
            this.fvZ.kn(z);
        }
        if (this.fwa != null) {
            this.fwa.kn(z);
        }
        if (this.fwc != null) {
            this.fwc.kn(z);
        }
        if (this.fwd != null) {
            this.fwd.kn(z);
        }
    }
}
