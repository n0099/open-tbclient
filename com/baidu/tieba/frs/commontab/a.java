package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView bRk;
    private l dMl;
    private FrsCommonTabFragment dOC;
    private i dOD;
    private i dOE;
    private com.baidu.tieba.frs.entelechy.a.l dOF;
    private p dOG;
    private com.baidu.tieba.frs.entelechy.a.d dOH;
    private boolean dOI;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dOJ = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof aa) && "FrsHottopicDelegateAdapter".equals(((aa) aVar).apF()) && a.this.mAdapters != null) {
                        ((aa) aVar).a(a.this.dOC.getPageContext(), a.this.dOC.getUniqueId());
                        if (a.this.dOI) {
                            ((aa) aVar).setFrom("c13010");
                        }
                        a.this.mAdapters.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsCommonTabFragment, bdTypeRecyclerView);
        this.bRk = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dOC = frsCommonTabFragment;
        this.dOJ.setPriority(1);
        this.dOJ.setSelfListener(true);
        this.dOC.registerListener(this.dOJ);
        this.dOD = new i(frsCommonTabFragment.getPageContext(), bb.atg, this.dOC.getUniqueId());
        this.dOD.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dOE = new i(frsCommonTabFragment.getPageContext(), bb.ati, this.dOC.getUniqueId());
        this.dOE.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.dOF = new com.baidu.tieba.frs.entelechy.a.l(frsCommonTabFragment.getPageContext(), bb.atn, this.dOC.getUniqueId());
        this.dOG = new p(frsCommonTabFragment.getPageContext(), bb.atj, this.dOC.getUniqueId());
        this.dOG.dOO = this.dOC.dOO;
        this.dOH = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.ato, this.dOC.getUniqueId());
        this.dOH.dOO = this.dOC.dOO;
        this.dMl = new l(frsCommonTabFragment.getPageContext(), m.dKG);
        this.mAdapters.add(this.dOD);
        this.mAdapters.add(this.dOE);
        this.mAdapters.add(this.dOF);
        this.mAdapters.add(this.dOG);
        this.mAdapters.add(this.dOH);
        this.mAdapters.add(this.dMl);
        if (frsCommonTabFragment.tabId == 89) {
            this.dOI = true;
            this.dOD.setFrom("c13010");
            this.dOE.setFrom("c13010");
            this.dOF.setFrom("c13010");
            this.dOG.setFrom("c13010");
            this.dOH.setFrom("c13010");
            jK("page_frs_dynamic");
        }
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aDh();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bRk.setData(arrayList);
    }

    private void aDh() {
        if (this.dOC != null && !v.I(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.aDT() != null) {
                        cVar.aDT().ebm = this.dOC.dON;
                        cVar.aDT().ebo = this.dOC.forumId;
                        cVar.aDT().ebp = this.dOC.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bRk.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    private void jK(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof f) {
                    ((f) aVar).jK(str);
                }
            }
        }
    }
}
