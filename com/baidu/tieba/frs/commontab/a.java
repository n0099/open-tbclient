package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.a.f;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.ag;
import com.baidu.tieba.frs.entelechy.a.ak;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.k;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Item;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private r iYW;
    private boolean isDynamic;
    private FrsCommonTabFragment jbA;
    private k jbB;
    private k jbC;
    private ag jbD;
    private ak jbE;
    private ak jbF;
    private com.baidu.tieba.frs.entelechy.a.c jbG;
    private l jbH;
    private al jbI;
    private g jbJ;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private CustomMessageListener jbK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aey()) && a.this.bnf != null) {
                        ((y) aVar).a(a.this.jbA.getPageContext(), a.this.jbA.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.bnf.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.Yf = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.jbA = frsCommonTabFragment;
        this.jbK.setPriority(1);
        this.jbK.setSelfListener(true);
        this.jbA.registerListener(this.jbK);
        this.jbB = new k(frsCommonTabFragment.getPageContext(), by.eIS, this.jbA.getUniqueId());
        this.jbC = new k(frsCommonTabFragment.getPageContext(), by.eJp, this.jbA.getUniqueId());
        this.jbD = new ag(frsCommonTabFragment.getPageContext(), by.eJv, this.jbA.getUniqueId());
        this.jbE = new ak(frsCommonTabFragment.getPageContext(), by.eJq, this.jbA.getUniqueId());
        this.jbE.jbQ = this.jbA.jbQ;
        this.jbF = new ak(frsCommonTabFragment.getPageContext(), by.eJz, this.jbA.getUniqueId());
        this.jbF.jbQ = this.jbA.jbQ;
        this.iYW = new r(frsCommonTabFragment.getPageContext(), s.iWr);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), by.eJh, frsCommonTabFragment.getUniqueId());
        this.jbG = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), by.eJx, this.jbA.getUniqueId());
        this.jbH = new l(frsCommonTabFragment.getPageContext(), by.eJw, this.jbA.getUniqueId());
        this.jbI = new al(frsCommonTabFragment.getPageContext(), by.eJy, this.jbA.getUniqueId());
        if (!z) {
            this.jbJ = new g(frsCommonTabFragment.getPageContext(), by.eJj, this.jbA.getUniqueId());
            this.jbJ.a(this.Yf);
        }
        this.bnf.add(this.jbB);
        this.bnf.add(this.jbC);
        this.bnf.add(this.jbD);
        this.bnf.add(this.jbE);
        this.bnf.add(this.jbF);
        this.bnf.add(this.iYW);
        this.bnf.add(aVar);
        this.bnf.add(this.jbG);
        this.bnf.add(this.jbH);
        this.bnf.add(this.jbI);
        this.bnf.add(this.jbJ);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jbB.setFrom("c13010");
            this.jbC.setFrom("c13010");
            this.jbD.setFrom("c13010");
            this.jbE.setFrom("c13010");
            this.jbF.setFrom("c13010");
            Fo("page_frs_dynamic");
        }
        this.jbB.wi(frsCommonTabFragment.tabId);
        this.jbC.wi(frsCommonTabFragment.tabId);
        this.jbD.wi(frsCommonTabFragment.tabId);
        this.jbE.wi(frsCommonTabFragment.tabId);
        this.jbF.wi(frsCommonTabFragment.tabId);
        this.jbG.wi(frsCommonTabFragment.tabId);
        this.jbH.wi(frsCommonTabFragment.tabId);
        this.jbI.wi(frsCommonTabFragment.tabId);
        this.jbB.Ax(frsCommonTabFragment.tabType);
        this.jbC.Ax(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jbB.qA(z2);
        this.jbE.qA(z2);
        this.jbD.qA(z2);
        this.jbH.qA(z2);
        this.jbI.qA(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jbA.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jbA.getPageContext(), this.jbA.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bnf != null) {
                this.bnf.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cEG();
        bdTypeRecyclerView.addAdapters(this.bnf);
        cFj();
    }

    public void setData(ArrayList<q> arrayList) {
        cEG();
        this.Yf.setData(aA(arrayList));
    }

    private ArrayList<q> aA(ArrayList<q> arrayList) {
        ArrayList<q> arrayList2 = new ArrayList<>();
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next instanceof by) {
                if (((by) next).bqV() != null) {
                    if (!((by) next).bpS()) {
                        arrayList2.add(next);
                    } else {
                        ((by) next).a((Item) null);
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            } else {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private void cEG() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bnf) && this.jbA != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jbA.getTbPageTag());
                }
            }
        }
    }

    private void cFj() {
        if (this.jbA != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bnf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jtP = this.jbA.jbP;
                        dVar.getStatisticMetaData().jtR = this.jbA.forumId;
                        dVar.getStatisticMetaData().jtS = this.jbA.tabId;
                        dVar.getStatisticMetaData().jtV = this.jbA.tabType;
                        if (this.jbA.tabId == 502) {
                            dVar.getStatisticMetaData().jtU = 10;
                        } else if (this.jbA.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jtU = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Yf.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Fo(String str) {
        if (this.bnf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof f) {
                    ((f) aVar).Fo(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void qx(boolean z) {
        if (this.jbB != null) {
            this.jbB.qz(z);
        }
        if (this.jbC != null) {
            this.jbC.qz(z);
        }
        if (this.jbE != null) {
            this.jbE.qz(z);
        }
        if (this.jbF != null) {
            this.jbF.qz(z);
        }
    }
}
