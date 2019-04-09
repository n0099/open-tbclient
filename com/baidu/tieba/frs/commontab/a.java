package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.y;
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
    private BdTypeRecyclerView Qr;
    private l fdq;
    private FrsCommonTabFragment ffL;
    private com.baidu.tieba.frs.entelechy.a.d ffM;
    private com.baidu.tieba.frs.entelechy.a.d ffN;
    private u ffO;
    private y ffP;
    private y ffQ;
    private boolean ffR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener ffS = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof com.baidu.tieba.card.y) && "FrsHottopicDelegateAdapter".equals(((com.baidu.tieba.card.y) aVar).aQF()) && a.this.mAdapters != null) {
                        ((com.baidu.tieba.card.y) aVar).a(a.this.ffL.getPageContext(), a.this.ffL.getUniqueId());
                        if (a.this.ffR) {
                            ((com.baidu.tieba.card.y) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.Qr = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.ffL = frsCommonTabFragment;
        this.ffS.setPriority(1);
        this.ffS.setSelfListener(true);
        this.ffL.registerListener(this.ffS);
        this.ffM = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bAU, this.ffL.getUniqueId());
        this.ffM.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.ffN = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bg.bBg, this.ffL.getUniqueId());
        this.ffN.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.ffO = new u(frsCommonTabFragment.getPageContext(), bg.bBl, this.ffL.getUniqueId());
        this.ffP = new y(frsCommonTabFragment.getPageContext(), bg.bBh, this.ffL.getUniqueId());
        this.ffP.ffY = this.ffL.ffY;
        this.ffQ = new y(frsCommonTabFragment.getPageContext(), bg.bBm, this.ffL.getUniqueId());
        this.ffQ.ffY = this.ffL.ffY;
        this.fdq = new l(frsCommonTabFragment.getPageContext(), m.fbw);
        this.mAdapters.add(this.ffM);
        this.mAdapters.add(this.ffN);
        this.mAdapters.add(this.ffO);
        this.mAdapters.add(this.ffP);
        this.mAdapters.add(this.ffQ);
        this.mAdapters.add(this.fdq);
        if (frsCommonTabFragment.tabId == 89) {
            this.ffR = true;
            this.ffM.setFrom("c13010");
            this.ffN.setFrom("c13010");
            this.ffO.setFrom("c13010");
            this.ffP.setFrom("c13010");
            this.ffQ.setFrom("c13010");
            qM("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        bfa();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.Qr.setData(arrayList);
    }

    private void bfa() {
        if (this.ffL != null && !v.T(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bfx() != null) {
                        dVar.bfx().fsM = this.ffL.ffX;
                        dVar.bfx().fsO = this.ffL.forumId;
                        dVar.bfx().fsP = this.ffL.tabId;
                        if (this.ffL.tabId == 502) {
                            dVar.bfx().fsR = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Qr.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void qM(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).qM(str);
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
}
