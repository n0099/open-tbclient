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
    private r iYY;
    private boolean isDynamic;
    private FrsCommonTabFragment jbC;
    private k jbD;
    private k jbE;
    private ag jbF;
    private ak jbG;
    private ak jbH;
    private com.baidu.tieba.frs.entelechy.a.c jbI;
    private l jbJ;
    private al jbK;
    private g jbL;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private CustomMessageListener jbM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).aey()) && a.this.bnf != null) {
                        ((y) aVar).a(a.this.jbC.getPageContext(), a.this.jbC.getUniqueId());
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
        this.jbC = frsCommonTabFragment;
        this.jbM.setPriority(1);
        this.jbM.setSelfListener(true);
        this.jbC.registerListener(this.jbM);
        this.jbD = new k(frsCommonTabFragment.getPageContext(), by.eIS, this.jbC.getUniqueId());
        this.jbE = new k(frsCommonTabFragment.getPageContext(), by.eJp, this.jbC.getUniqueId());
        this.jbF = new ag(frsCommonTabFragment.getPageContext(), by.eJv, this.jbC.getUniqueId());
        this.jbG = new ak(frsCommonTabFragment.getPageContext(), by.eJq, this.jbC.getUniqueId());
        this.jbG.jbS = this.jbC.jbS;
        this.jbH = new ak(frsCommonTabFragment.getPageContext(), by.eJz, this.jbC.getUniqueId());
        this.jbH.jbS = this.jbC.jbS;
        this.iYY = new r(frsCommonTabFragment.getPageContext(), s.iWt);
        com.baidu.tieba.frs.entelechy.a.a aVar = new com.baidu.tieba.frs.entelechy.a.a(frsCommonTabFragment.getPageContext(), by.eJh, frsCommonTabFragment.getUniqueId());
        this.jbI = new com.baidu.tieba.frs.entelechy.a.c(frsCommonTabFragment.getPageContext(), by.eJx, this.jbC.getUniqueId());
        this.jbJ = new l(frsCommonTabFragment.getPageContext(), by.eJw, this.jbC.getUniqueId());
        this.jbK = new al(frsCommonTabFragment.getPageContext(), by.eJy, this.jbC.getUniqueId());
        if (!z) {
            this.jbL = new g(frsCommonTabFragment.getPageContext(), by.eJj, this.jbC.getUniqueId());
            this.jbL.a(this.Yf);
        }
        this.bnf.add(this.jbD);
        this.bnf.add(this.jbE);
        this.bnf.add(this.jbF);
        this.bnf.add(this.jbG);
        this.bnf.add(this.jbH);
        this.bnf.add(this.iYY);
        this.bnf.add(aVar);
        this.bnf.add(this.jbI);
        this.bnf.add(this.jbJ);
        this.bnf.add(this.jbK);
        this.bnf.add(this.jbL);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jbD.setFrom("c13010");
            this.jbE.setFrom("c13010");
            this.jbF.setFrom("c13010");
            this.jbG.setFrom("c13010");
            this.jbH.setFrom("c13010");
            Fo("page_frs_dynamic");
        }
        this.jbD.wi(frsCommonTabFragment.tabId);
        this.jbE.wi(frsCommonTabFragment.tabId);
        this.jbF.wi(frsCommonTabFragment.tabId);
        this.jbG.wi(frsCommonTabFragment.tabId);
        this.jbH.wi(frsCommonTabFragment.tabId);
        this.jbI.wi(frsCommonTabFragment.tabId);
        this.jbJ.wi(frsCommonTabFragment.tabId);
        this.jbK.wi(frsCommonTabFragment.tabId);
        this.jbD.Ax(frsCommonTabFragment.tabType);
        this.jbE.Ax(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jbD.qA(z2);
        this.jbG.qA(z2);
        this.jbF.qA(z2);
        this.jbJ.qA(z2);
        this.jbK.qA(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jbC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jbC.getPageContext(), this.jbC.getUniqueId());
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
        cEH();
        bdTypeRecyclerView.addAdapters(this.bnf);
        cFk();
    }

    public void setData(ArrayList<q> arrayList) {
        cEH();
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

    private void cEH() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bnf) && this.jbC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jbC.getTbPageTag());
                }
            }
        }
    }

    private void cFk() {
        if (this.jbC != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bnf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.d.d) {
                    com.baidu.tieba.frs.d.d dVar = (com.baidu.tieba.frs.d.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jtR = this.jbC.jbR;
                        dVar.getStatisticMetaData().jtT = this.jbC.forumId;
                        dVar.getStatisticMetaData().jtU = this.jbC.tabId;
                        dVar.getStatisticMetaData().jtX = this.jbC.tabType;
                        if (this.jbC.tabId == 502) {
                            dVar.getStatisticMetaData().jtW = 10;
                        } else if (this.jbC.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jtW = 12;
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
        if (this.jbD != null) {
            this.jbD.qz(z);
        }
        if (this.jbE != null) {
            this.jbE.qz(z);
        }
        if (this.jbG != null) {
            this.jbG.qz(z);
        }
        if (this.jbH != null) {
            this.jbH.qz(z);
        }
    }
}
