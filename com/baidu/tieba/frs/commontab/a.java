package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private l fAb;
    private FrsCommonTabFragment fCN;
    private com.baidu.tieba.frs.entelechy.a.d fCO;
    private com.baidu.tieba.frs.entelechy.a.d fCP;
    private v fCQ;
    private z fCR;
    private z fCS;
    private boolean fCT;
    private BdTypeRecyclerView zj;
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private CustomMessageListener fCU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).bay()) && a.this.agQ != null) {
                        ((y) aVar).a(a.this.fCN.getPageContext(), a.this.fCN.getUniqueId());
                        if (a.this.fCT) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.agQ.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData);
        this.zj = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData) {
        this.fCN = frsCommonTabFragment;
        this.fCU.setPriority(1);
        this.fCU.setSelfListener(true);
        this.fCN.registerListener(this.fCU);
        this.fCO = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.cbu, this.fCN.getUniqueId());
        this.fCO.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fCP = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bh.cbH, this.fCN.getUniqueId());
        this.fCP.setVoiceManager(frsCommonTabFragment.getVoiceManager());
        this.fCQ = new v(frsCommonTabFragment.getPageContext(), bh.cbM, this.fCN.getUniqueId());
        this.fCR = new z(frsCommonTabFragment.getPageContext(), bh.cbI, this.fCN.getUniqueId());
        this.fCR.fDa = this.fCN.fDa;
        this.fCS = new z(frsCommonTabFragment.getPageContext(), bh.cbN, this.fCN.getUniqueId());
        this.fCS.fDa = this.fCN.fDa;
        this.fAb = new l(frsCommonTabFragment.getPageContext(), m.fyi);
        this.agQ.add(this.fCO);
        this.agQ.add(this.fCP);
        this.agQ.add(this.fCQ);
        this.agQ.add(this.fCR);
        this.agQ.add(this.fCS);
        this.agQ.add(this.fAb);
        if (frsCommonTabFragment.tabId == 89) {
            this.fCT = true;
            this.fCO.setFrom("c13010");
            this.fCP.setFrom("c13010");
            this.fCQ.setFrom("c13010");
            this.fCR.setFrom("c13010");
            this.fCS.setFrom("c13010");
            rh("page_frs_dynamic");
        }
        if (frsCommonTabFragment.tabId == 502) {
            b(frsViewData);
        }
        bdTypeRecyclerView.addAdapters(this.agQ);
        bmz();
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.zj.setData(arrayList);
    }

    private void bmz() {
        if (this.fCN != null && !com.baidu.tbadk.core.util.v.isEmpty(this.agQ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.bmX() != null) {
                        dVar.bmX().fQB = this.fCN.fCZ;
                        dVar.bmX().fQD = this.fCN.forumId;
                        dVar.bmX().fQE = this.fCN.tabId;
                        if (this.fCN.tabId == 502) {
                            dVar.bmX().fQG = 10;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.zj.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    private void rh(String str) {
        if (this.agQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof f) {
                    ((f) aVar).rh(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof h) {
                    ((h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void kl(boolean z) {
        if (this.fCO != null) {
            this.fCO.kn(z);
        }
        if (this.fCP != null) {
            this.fCP.kn(z);
        }
        if (this.fCR != null) {
            this.fCR.kn(z);
        }
        if (this.fCS != null) {
            this.fCS.kn(z);
        }
    }
}
